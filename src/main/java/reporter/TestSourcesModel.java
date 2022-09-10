 

package reporter;

import gherkin.ast.ScenarioOutline;
import gherkin.ast.Step;
import gherkin.ParserException;
import gherkin.TokenMatcher;
import gherkin.Parser;
import gherkin.AstBuilder;
import java.util.Iterator;
import gherkin.GherkinDialect;
import gherkin.GherkinDialectProvider;
import gherkin.ast.Node;
import gherkin.ast.Examples;
import gherkin.ast.TableRow;
import gherkin.ast.ScenarioDefinition;
import gherkin.ast.Background;
import gherkin.ast.Feature;
import java.util.HashMap;
import gherkin.ast.GherkinDocument;
import cucumber.api.event.TestSourceRead;
import java.util.Map;

final class TestSourcesModel
{
    private final Map<String, TestSourceRead> pathToReadEventMap;
    private final Map<String, GherkinDocument> pathToAstMap;
    private final Map<String, Map<Integer, AstNode>> pathToNodeMap;
    
    TestSourcesModel() {
        this.pathToReadEventMap = new HashMap<String, TestSourceRead>();
        this.pathToAstMap = new HashMap<String, GherkinDocument>();
        this.pathToNodeMap = new HashMap<String, Map<Integer, AstNode>>();
    }
    
    static Feature getFeatureForTestCase(AstNode astNode) {
        while (astNode.parent != null) {
            astNode = astNode.parent;
        }
        return (Feature)astNode.node;
    }
    
    static Background getBackgroundForTestCase(final AstNode astNode) {
        final Feature feature = getFeatureForTestCase(astNode);
        final ScenarioDefinition backgound = feature.getChildren().get(0);
        if (backgound instanceof Background) {
            return (Background)backgound;
        }
        return null;
    }
    
    static ScenarioDefinition getScenarioDefinition(final AstNode astNode) {
        return (astNode.node instanceof ScenarioDefinition) ? (ScenarioDefinition) astNode.node : ((ScenarioDefinition)astNode.parent.parent.node);
    }
    
    static boolean isScenarioOutlineScenario(final AstNode astNode) {
        return !(astNode.node instanceof ScenarioDefinition);
    }
    
    static boolean isBackgroundStep(final AstNode astNode) {
        return astNode.parent.node instanceof Background;
    }
    
    static String calculateId(final AstNode astNode) {
        final Node node = astNode.node;
        if (node instanceof ScenarioDefinition) {
            return String.valueOf(calculateId(astNode.parent)) + ";" + convertToId(((ScenarioDefinition)node).getName());
        }
        if (node instanceof ExamplesRowWrapperNode) {
            return String.valueOf(calculateId(astNode.parent)) + ";" + Integer.toString(((ExamplesRowWrapperNode)node).bodyRowIndex + 2);
        }
        if (node instanceof TableRow) {
            return String.valueOf(calculateId(astNode.parent)) + ";" + Integer.toString(1);
        }
        if (node instanceof Examples) {
            return String.valueOf(calculateId(astNode.parent)) + ";" + convertToId(((Examples)node).getName());
        }
        if (node instanceof Feature) {
            return convertToId(((Feature)node).getName());
        }
        return "";
    }
    
    static String convertToId(final String name) {
        return name.replaceAll("[\\s'_,!]", "-").toLowerCase();
    }
    
    void addTestSourceReadEvent(final String path, final TestSourceRead event) {
        this.pathToReadEventMap.put(path, event);
    }
    
    Feature getFeature(final String path) {
        if (!this.pathToAstMap.containsKey(path)) {
            this.parseGherkinSource(path);
        }
        if (this.pathToAstMap.containsKey(path)) {
            return this.pathToAstMap.get(path).getFeature();
        }
        return null;
    }
    
    ScenarioDefinition getScenarioDefinition(final String path, final int line) {
        return getScenarioDefinition(this.getAstNode(path, line));
    }
    
    AstNode getAstNode(final String path, final int line) {
        if (!this.pathToNodeMap.containsKey(path)) {
            this.parseGherkinSource(path);
        }
        if (this.pathToNodeMap.containsKey(path)) {
            return this.pathToNodeMap.get(path).get(line);
        }
        return null;
    }
    
    boolean hasBackground(final String path, final int line) {
        if (!this.pathToNodeMap.containsKey(path)) {
            this.parseGherkinSource(path);
        }
        if (this.pathToNodeMap.containsKey(path)) {
            final AstNode astNode = this.pathToNodeMap.get(path).get(line);
            return getBackgroundForTestCase(astNode) != null;
        }
        return false;
    }
    
    String getKeywordFromSource(final String uri, final int stepLine) {
        final Feature feature = this.getFeature(uri);
        if (feature != null) {
            final TestSourceRead event = this.getTestSourceReadEvent(uri);
            final String trimmedSourceLine = event.source.split("\n")[stepLine - 1].trim();
            final GherkinDialect dialect = new GherkinDialectProvider(feature.getLanguage()).getDefaultDialect();
            for (final String keyword : dialect.getStepKeywords()) {
                if (trimmedSourceLine.startsWith(keyword)) {
                    return keyword;
                }
            }
        }
        return "";
    }
    
    private TestSourceRead getTestSourceReadEvent(final String uri) {
        if (this.pathToReadEventMap.containsKey(uri)) {
            return this.pathToReadEventMap.get(uri);
        }
        return null;
    }
    
    String getFeatureName(final String uri) {
        final Feature feature = this.getFeature(uri);
        if (feature != null) {
            return feature.getName();
        }
        return "";
    }
    
    private void parseGherkinSource(final String path) {
        if (!this.pathToReadEventMap.containsKey(path)) {
            return;
        }
        final Parser<GherkinDocument> parser = (Parser<GherkinDocument>)new Parser((Parser.Builder)new AstBuilder());
        final TokenMatcher matcher = new TokenMatcher();
        try {
            final GherkinDocument gherkinDocument = (GherkinDocument)parser.parse(this.pathToReadEventMap.get(path).source, (Parser.ITokenMatcher)matcher);
            this.pathToAstMap.put(path, gherkinDocument);
            final Map<Integer, AstNode> nodeMap = new HashMap<Integer, AstNode>();
            final AstNode currentParent = new AstNode((Node)gherkinDocument.getFeature(), null);
            for (final ScenarioDefinition child : gherkinDocument.getFeature().getChildren()) {
                this.processScenarioDefinition(nodeMap, child, currentParent);
            }
            this.pathToNodeMap.put(path, nodeMap);
        }
        catch (ParserException ex) {}
    }
    
    private void processScenarioDefinition(final Map<Integer, AstNode> nodeMap, final ScenarioDefinition child, final AstNode currentParent) {
        final AstNode childNode = new AstNode((Node)child, currentParent);
        nodeMap.put(child.getLocation().getLine(), childNode);
        for (final Step step : child.getSteps()) {
            nodeMap.put(step.getLocation().getLine(), new AstNode((Node)step, childNode));
        }
        if (child instanceof ScenarioOutline) {
            this.processScenarioOutlineExamples(nodeMap, (ScenarioOutline)child, childNode);
        }
    }
    
    private void processScenarioOutlineExamples(final Map<Integer, AstNode> nodeMap, final ScenarioOutline scenarioOutline, final AstNode childNode) {
        for (final Examples examples : scenarioOutline.getExamples()) {
            final AstNode examplesNode = new AstNode((Node)examples, childNode);
            final TableRow headerRow = examples.getTableHeader();
            final AstNode headerNode = new AstNode((Node)headerRow, examplesNode);
            nodeMap.put(headerRow.getLocation().getLine(), headerNode);
            for (int i = 0; i < examples.getTableBody().size(); ++i) {
                final TableRow examplesRow = examples.getTableBody().get(i);
                final Node rowNode = new ExamplesRowWrapperNode((Node)examplesRow, i);
                final AstNode expandedScenarioNode = new AstNode(rowNode, examplesNode);
                nodeMap.put(examplesRow.getLocation().getLine(), expandedScenarioNode);
            }
        }
    }
    
    class ExamplesRowWrapperNode extends Node
    {
        final int bodyRowIndex;
        
        ExamplesRowWrapperNode(final Node examplesRow, final int bodyRowIndex) {
            super(examplesRow.getLocation());
            this.bodyRowIndex = bodyRowIndex;
        }
    }
    
    class AstNode
    {
        final Node node;
        final AstNode parent;
        
        AstNode(final Node node, final AstNode parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
