

package reporter;

import com.aventstack.extentreports.model.Attribute;
import gherkin.pickles.PickleCell;
import gherkin.pickles.PickleRow;
import gherkin.pickles.PickleTable;
import gherkin.pickles.PickleString;
import gherkin.pickles.Argument;
import com.aventstack.extentreports.GherkinKeyword;
import gherkin.ast.ScenarioDefinition;
import java.util.function.Function;
import gherkin.pickles.PickleTag;
import com.aventstack.extentreports.gherkin.model.Scenario;
import gherkin.ast.TableCell;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import java.util.Collection;
import gherkin.ast.TableRow;
import gherkin.ast.Node;
import gherkin.ast.DataTable;
import gherkin.ast.DocString;
import gherkin.ast.Step;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.ArrayList;
import gherkin.ast.Tag;
import java.util.List;
import com.aventstack.extentreports.gherkin.model.Feature;
import cucumber.api.TestCase;
import java.nio.file.Paths;
import cucumber.runtime.CucumberException;
import java.io.OutputStream;
import java.net.URL;
import java.io.IOException;
import java.net.URISyntaxException;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.io.File;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.service.LogService;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.service.TestService;
import cucumber.api.Result;
import cucumber.api.PickleStepTestStep;
import com.aventstack.extentreports.gherkin.model.Asterisk;
import cucumber.api.HookTestStep;
import cucumber.api.event.EventPublisher;
//import com.aventstack.extentreports.service.ExtentService;
import cucumber.api.event.Event;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.WriteEvent;
import cucumber.api.event.EmbedEvent;
import cucumber.api.event.TestStepFinished;
import cucumber.api.event.TestStepStarted;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestSourceRead;
import cucumber.api.event.EventHandler;
import gherkin.ast.Examples;
import gherkin.ast.ScenarioOutline;
import java.util.concurrent.atomic.AtomicInteger;
import com.aventstack.extentreports.ExtentTest;
import java.util.Map;
import cucumber.api.event.ConcurrentEventListener;

public class ExtentCucumberAdapter implements ConcurrentEventListener
{
    private static final String SCREENSHOT_DIR_PROPERTY = "screenshot.dir";
    private static final String SCREENSHOT_REL_PATH_PROPERTY = "screenshot.rel.path";
    private static Map<String, ExtentTest> featureMap;
    private static ThreadLocal<ExtentTest> featureTestThreadLocal;
    private static Map<String, ExtentTest> scenarioOutlineMap;
    private static ThreadLocal<ExtentTest> scenarioOutlineThreadLocal;
    private static ThreadLocal<ExtentTest> scenarioThreadLocal;
    private static ThreadLocal<Boolean> isHookThreadLocal;
    private static ThreadLocal<ExtentTest> stepTestThreadLocal;
    private String screenshotDir;
    private String screenshotRelPath;
    private static final Map<String, String> MIME_TYPES_EXTENSIONS;
    private static final AtomicInteger EMBEDDED_INT;
    private final TestSourcesModel testSources;
    private ThreadLocal<String> currentFeatureFile;
    private ThreadLocal<ScenarioOutline> currentScenarioOutline;
    private ThreadLocal<Examples> currentExamples;
    private EventHandler<TestSourceRead> testSourceReadHandler;
    private EventHandler<TestCaseStarted> caseStartedHandler;
    private EventHandler<TestStepStarted> stepStartedHandler;
    private EventHandler<TestStepFinished> stepFinishedHandler;
    private EventHandler<EmbedEvent> embedEventhandler;
    private EventHandler<WriteEvent> writeEventhandler;
    private EventHandler<TestRunFinished> runFinishedHandler;
    
    static {
        ExtentCucumberAdapter.featureMap = new ConcurrentHashMap<String, ExtentTest>();
        ExtentCucumberAdapter.featureTestThreadLocal = new InheritableThreadLocal<ExtentTest>();
        ExtentCucumberAdapter.scenarioOutlineMap = new ConcurrentHashMap<String, ExtentTest>();
        ExtentCucumberAdapter.scenarioOutlineThreadLocal = new InheritableThreadLocal<ExtentTest>();
        ExtentCucumberAdapter.scenarioThreadLocal = new InheritableThreadLocal<ExtentTest>();
        ExtentCucumberAdapter.isHookThreadLocal = new InheritableThreadLocal<Boolean>();
        ExtentCucumberAdapter.stepTestThreadLocal = new InheritableThreadLocal<ExtentTest>();
        MIME_TYPES_EXTENSIONS = new HashMap<String, String>() {
            {
                this.put("image/bmp", "bmp");
                this.put("image/gif", "gif");
                this.put("image/jpeg", "jpg");
                this.put("image/png", "png");
                this.put("image/svg+xml", "svg");
                this.put("video/ogg", "ogg");
            }
        };
        EMBEDDED_INT = new AtomicInteger(0);
    }
    
    public ExtentCucumberAdapter(final String arg) {
        this.testSources = new TestSourcesModel();
        this.currentFeatureFile = new ThreadLocal<String>();
        this.currentScenarioOutline = new InheritableThreadLocal<ScenarioOutline>();
        this.currentExamples = new InheritableThreadLocal<Examples>();
        this.testSourceReadHandler = (EventHandler<TestSourceRead>)new EventHandler<TestSourceRead>() {
            public void receive(final TestSourceRead event) {
                ExtentCucumberAdapter.this.handleTestSourceRead(event);
            }
        };
        this.caseStartedHandler = (EventHandler<TestCaseStarted>)new EventHandler<TestCaseStarted>() {
            public void receive(final TestCaseStarted event) {
                ExtentCucumberAdapter.this.handleTestCaseStarted(event);
            }
        };
        this.stepStartedHandler = (EventHandler<TestStepStarted>)new EventHandler<TestStepStarted>() {
            public void receive(final TestStepStarted event) {
                ExtentCucumberAdapter.this.handleTestStepStarted(event);
            }
        };
        this.stepFinishedHandler = (EventHandler<TestStepFinished>)new EventHandler<TestStepFinished>() {
            public void receive(final TestStepFinished event) {
                ExtentCucumberAdapter.this.handleTestStepFinished(event);
            }
        };
        this.embedEventhandler = (EventHandler<EmbedEvent>)new EventHandler<EmbedEvent>() {
            public void receive(final EmbedEvent event) {
                ExtentCucumberAdapter.this.handleEmbed(event);
            }
        };
        this.writeEventhandler = (EventHandler<WriteEvent>)new EventHandler<WriteEvent>() {
            public void receive(final WriteEvent event) {
                ExtentCucumberAdapter.this.handleWrite(event);
            }
        };
        this.runFinishedHandler = (EventHandler<TestRunFinished>)new EventHandler<TestRunFinished>() {
            public void receive(final TestRunFinished event) {
                ExtentCucumberAdapter.this.finishReport();
            }
        };
        ExtentService.getInstance();
        Object prop = ExtentService.getProperty("screenshot.dir");
        this.screenshotDir = ((prop == null) ? "test-output/" : String.valueOf(prop));
        prop = ExtentService.getProperty("screenshot.rel.path");
        this.screenshotRelPath = ((prop == null || String.valueOf(prop).isEmpty()) ? this.screenshotDir : String.valueOf(prop));
        this.screenshotRelPath = ((this.screenshotRelPath == null) ? "" : this.screenshotRelPath);
    }
    
    public void setEventPublisher(final EventPublisher publisher) {
        publisher.registerHandlerFor((Class)TestSourceRead.class, (EventHandler)this.testSourceReadHandler);
        publisher.registerHandlerFor((Class)TestCaseStarted.class, (EventHandler)this.caseStartedHandler);
        publisher.registerHandlerFor((Class)TestStepStarted.class, (EventHandler)this.stepStartedHandler);
        publisher.registerHandlerFor((Class)TestStepFinished.class, (EventHandler)this.stepFinishedHandler);
        publisher.registerHandlerFor((Class)EmbedEvent.class, (EventHandler)this.embedEventhandler);
        publisher.registerHandlerFor((Class)WriteEvent.class, (EventHandler)this.writeEventhandler);
        publisher.registerHandlerFor((Class)TestRunFinished.class, (EventHandler)this.runFinishedHandler);
    }
    
    private void handleTestSourceRead(final TestSourceRead event) {
        this.testSources.addTestSourceReadEvent(event.uri, event);
    }
    
    private synchronized void handleTestCaseStarted(final TestCaseStarted event) {
        this.handleStartOfFeature(event.testCase);
        this.handleScenarioOutline(event.testCase);
        this.createTestCase(event.testCase);
        this.testSources.hasBackground(this.currentFeatureFile.get(), event.testCase.getLine());
    }
    
    private synchronized void handleTestStepStarted(final TestStepStarted event) {
        ExtentCucumberAdapter.isHookThreadLocal.set(false);
        if (event.testStep instanceof HookTestStep) {
            final ExtentTest t = ExtentCucumberAdapter.scenarioThreadLocal.get().createNode((Class)Asterisk.class, event.testStep.getCodeLocation());
            ExtentCucumberAdapter.stepTestThreadLocal.set(t);
            ExtentCucumberAdapter.isHookThreadLocal.set(true);
        }
        if (event.testStep instanceof PickleStepTestStep) {
            final PickleStepTestStep testStep = (PickleStepTestStep)event.testStep;
            this.createTestStep(testStep);
        }
    }
    
    private synchronized void handleTestStepFinished(final TestStepFinished event) {
        this.updateResult(event.result);
    }
    
    private synchronized void updateResult(final Result result) {
        final String lowerCaseName;
        switch (lowerCaseName = result.getStatus().lowerCaseName()) {
            case "failed": {
                ExtentCucumberAdapter.stepTestThreadLocal.get().fail(result.getError());
                return;
            }
            case "passed": {
                if (ExtentCucumberAdapter.stepTestThreadLocal.get() != null && ExtentCucumberAdapter.stepTestThreadLocal.get().getModel().getLogContext().isEmpty() && !ExtentCucumberAdapter.isHookThreadLocal.get()) {
                    ExtentCucumberAdapter.stepTestThreadLocal.get().pass("");
                }
                if (ExtentCucumberAdapter.stepTestThreadLocal.get() == null) {
                    return;
                }
                final Boolean hasLog = TestService.testHasLog(ExtentCucumberAdapter.stepTestThreadLocal.get().getModel());
                final Boolean hasScreenCapture = hasLog && LogService.logHasScreenCapture((Log)ExtentCucumberAdapter.stepTestThreadLocal.get().getModel().getLogContext().getFirst());
                if (ExtentCucumberAdapter.isHookThreadLocal.get() && !hasLog && !hasScreenCapture) {
                    ExtentService.getInstance().removeTest((ExtentTest)ExtentCucumberAdapter.stepTestThreadLocal.get());
                }
                return;
            }
            case "pending": {
                break;
            }
            case "skipped": {
                break;
            }
        }
        final Boolean currentEndingEventSkipped = ExtentCucumberAdapter.stepTestThreadLocal.get().getModel().getLogContext() != null && !ExtentCucumberAdapter.stepTestThreadLocal.get().getModel().getLogContext().isEmpty() && ((Log)ExtentCucumberAdapter.stepTestThreadLocal.get().getModel().getLogContext().getLast()).getStatus() == Status.SKIP;
        if (result.getError() != null) {
            ExtentCucumberAdapter.stepTestThreadLocal.get().skip(result.getError());
        }
        else if (!currentEndingEventSkipped) {
            final String details = (result.getErrorMessage() == null) ? "Step skipped" : result.getErrorMessage();
            ExtentCucumberAdapter.stepTestThreadLocal.get().skip(details);
        }
    }
    
    private synchronized void handleEmbed(final EmbedEvent event) {
        final String mimeType = event.mimeType;
        final String extension = ExtentCucumberAdapter.MIME_TYPES_EXTENSIONS.get(mimeType);
        if (extension != null) {
            final StringBuilder fileName = new StringBuilder("embedded").append(ExtentCucumberAdapter.EMBEDDED_INT.incrementAndGet()).append(".").append(extension);
            try {
                final URL url = this.toUrl(fileName.toString());
                writeBytesToURL(event.data, url);
                try {
                    final File f = new File(url.toURI());
                    if (ExtentCucumberAdapter.stepTestThreadLocal.get() == null) {
                        final ExtentTest t = ExtentCucumberAdapter.scenarioThreadLocal.get().createNode((Class)Asterisk.class, "Embed");
                        ExtentCucumberAdapter.stepTestThreadLocal.set(t);
                    }
                    ExtentCucumberAdapter.stepTestThreadLocal.get().info("", MediaEntityBuilder.createScreenCaptureFromPath(String.valueOf(this.screenshotRelPath) + f.getName()).build());
                }
                catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    private static void writeBytesToURL(final byte[] buf, final URL url) throws IOException {
        final OutputStream out = createReportFileOutputStream(url);
        try {
            out.write(buf);
        }
        catch (IOException e) {
            throw new IOException("Unable to write to report file item: ", e);
        }
    }
    
    private static OutputStream createReportFileOutputStream(final URL url) {
        try {
            return new URLOutputStream(url);
        }
        catch (IOException e) {
            throw new CucumberException((Throwable)e);
        }
    }
    
    private URL toUrl(final String fileName) {
        try {
            final URL url = Paths.get(this.screenshotDir, fileName).toUri().toURL();
            return url;
        }
        catch (IOException e) {
            throw new CucumberException((Throwable)e);
        }
    }
    
    private void handleWrite(final WriteEvent event) {
        final String text = event.text;
        if (text != null && !text.isEmpty()) {
            ExtentCucumberAdapter.stepTestThreadLocal.get().info(text);
        }
    }
    
    private void finishReport() {
        ExtentService.getInstance().flush();
    }
    
    private synchronized void handleStartOfFeature(final TestCase testCase) {
        if (this.currentFeatureFile == null || !this.currentFeatureFile.equals(testCase.getUri())) {
            this.currentFeatureFile.set(testCase.getUri());
            this.createFeature(testCase);
        }
    }
    
    private synchronized void createFeature(final TestCase testCase) {
        final gherkin.ast.Feature feature = this.testSources.getFeature(testCase.getUri());
        if (feature != null) {
            if (ExtentCucumberAdapter.featureMap.containsKey(feature.getName())) {
                ExtentCucumberAdapter.featureTestThreadLocal.set(ExtentCucumberAdapter.featureMap.get(feature.getName()));
                return;
            }
            if (ExtentCucumberAdapter.featureTestThreadLocal.get() != null && ExtentCucumberAdapter.featureTestThreadLocal.get().getModel().getName().equals(feature.getName())) {
                return;
            }
            final ExtentTest t = ExtentService.getInstance().createTest((Class)Feature.class, feature.getName(), feature.getDescription());
            ExtentCucumberAdapter.featureTestThreadLocal.set(t);
            ExtentCucumberAdapter.featureMap.put(feature.getName(), t);
            final List<String> tagList = this.createTagsList(feature.getTags());
            tagList.forEach( arg0 -> ExtentCucumberAdapter.featureTestThreadLocal.get().assignCategory(new String[] {  arg0 }));
        }
    }
    
    private List<String> createTagsList(final List<Tag> tags) {
        final List<String> tagList = new ArrayList<String>();
        for (final Tag tag : tags) {
            tagList.add(tag.getName());
        }
        return tagList;
    }
    
    private synchronized void handleScenarioOutline(final TestCase testCase) {
        final TestSourcesModel.AstNode astNode = this.testSources.getAstNode(this.currentFeatureFile.get(), testCase.getLine());
        if (TestSourcesModel.isScenarioOutlineScenario(astNode)) {
            final ScenarioOutline scenarioOutline = (ScenarioOutline)TestSourcesModel.getScenarioDefinition(astNode);
            if (this.currentScenarioOutline.get() == null || !this.currentScenarioOutline.get().getName().equals(scenarioOutline.getName())) {
                ExtentCucumberAdapter.scenarioOutlineThreadLocal.set(null);
                this.createScenarioOutline(scenarioOutline);
                this.currentScenarioOutline.set(scenarioOutline);
                this.addOutlineStepsToReport(scenarioOutline);
            }
            final Examples examples = (Examples)astNode.parent.node;
            if (this.currentExamples.get() == null || !this.currentExamples.get().equals(examples)) {
                this.currentExamples.set(examples);
                this.createExamples(examples);
            }
        }
        else {
            ExtentCucumberAdapter.scenarioOutlineThreadLocal.set(null);
            this.currentScenarioOutline.set(null);
            this.currentExamples.set(null);
        }
    }
    
    private synchronized void createScenarioOutline(final ScenarioOutline scenarioOutline) {
        if (ExtentCucumberAdapter.scenarioOutlineMap.containsKey(scenarioOutline.getName())) {
            ExtentCucumberAdapter.scenarioOutlineThreadLocal.set(ExtentCucumberAdapter.scenarioOutlineMap.get(scenarioOutline.getName()));
            return;
        }
        if (ExtentCucumberAdapter.scenarioOutlineThreadLocal.get() == null) {
            final ExtentTest t = ExtentCucumberAdapter.featureTestThreadLocal.get().createNode((Class)com.aventstack.extentreports.gherkin.model.ScenarioOutline.class, scenarioOutline.getName(), scenarioOutline.getDescription());
            ExtentCucumberAdapter.scenarioOutlineThreadLocal.set(t);
            ExtentCucumberAdapter.scenarioOutlineMap.put(scenarioOutline.getName(), t);
            final List<String> featureTags = (List<String>)ExtentCucumberAdapter.scenarioOutlineThreadLocal.get().getModel().getParent().getCategoryContext().getAll().stream().map(x -> x.getName()).collect(Collectors.toList());
            scenarioOutline.getTags().stream().map(x -> x.getName()).filter(x -> !featureTags.contains(x)).forEach( arg0 -> ExtentCucumberAdapter.scenarioOutlineThreadLocal.get().assignCategory(new String[] {  arg0 }));
        }
    }
    
    private synchronized void addOutlineStepsToReport(final ScenarioOutline scenarioOutline) {
        for (final Step step : scenarioOutline.getSteps()) {
            if (step.getArgument() != null) {
                final Node argument = step.getArgument();
                if (argument instanceof DocString) {
                    this.createDocStringMap((DocString)argument);
                }
                else {
                    final boolean b = argument instanceof DataTable;
                }
            }
        }
    }
    
    private Map<String, Object> createDocStringMap(final DocString docString) {
        final Map<String, Object> docStringMap = new HashMap<String, Object>();
        docStringMap.put("value", docString.getContent());
        return docStringMap;
    }
    
    private void createExamples(final Examples examples) {
        final List<TableRow> rows = new ArrayList<TableRow>();
        rows.add(examples.getTableHeader());
        rows.addAll(examples.getTableBody());
        final String[][] data = this.getTable(rows);
        String markup = MarkupHelper.createTable(data).getMarkup();
        if (examples.getName() != null && !examples.getName().isEmpty()) {
            markup = String.valueOf(examples.getName()) + markup;
        }
        markup = String.valueOf(ExtentCucumberAdapter.scenarioOutlineThreadLocal.get().getModel().getDescription()) + markup;
        ExtentCucumberAdapter.scenarioOutlineThreadLocal.get().getModel().setDescription(markup);
    }
    
    private String[][] getTable(final List<TableRow> rows) {
        String[][] data = null;
        for (int rowSize = rows.size(), i = 0; i < rowSize; ++i) {
            final TableRow row = rows.get(i);
            final List<TableCell> cells = (List<TableCell>)row.getCells();
            final int cellSize = cells.size();
            if (data == null) {
                data = new String[rowSize][cellSize];
            }
            for (int j = 0; j < cellSize; ++j) {
                data[i][j] = cells.get(j).getValue();
            }
        }
        return data;
    }
    
    private synchronized void createTestCase(final TestCase testCase) {
        final TestSourcesModel.AstNode astNode = this.testSources.getAstNode(this.currentFeatureFile.get(), testCase.getLine());
        if (astNode != null) {
            final ScenarioDefinition scenarioDefinition = TestSourcesModel.getScenarioDefinition(astNode);
            final ExtentTest parent = (ExtentCucumberAdapter.scenarioOutlineThreadLocal.get() != null) ? ExtentCucumberAdapter.scenarioOutlineThreadLocal.get() : ExtentCucumberAdapter.featureTestThreadLocal.get();
            final ExtentTest t = parent.createNode((Class)Scenario.class, scenarioDefinition.getName(), scenarioDefinition.getDescription());
            ExtentCucumberAdapter.scenarioThreadLocal.set(t);
        }
        if (!testCase.getTags().isEmpty()) {
            testCase.getTags().stream().map(PickleTag::getName).forEach( arg0 -> ExtentCucumberAdapter.scenarioThreadLocal.get().assignCategory(new String[] {  arg0 }));
        }
    }
    
    private synchronized void createTestStep(final PickleStepTestStep testStep) {
        final String stepName = testStep.getStepText();
        final TestSourcesModel.AstNode astNode = this.testSources.getAstNode(this.currentFeatureFile.get(), testStep.getStepLine());
        if (astNode != null) {
            final Step step = (Step)astNode.node;
            try {
                final String name = (stepName == null || stepName.isEmpty()) ? step.getText().replace("<", "&lt;").replace(">", "&gt;") : stepName;
                final ExtentTest t = ExtentCucumberAdapter.scenarioThreadLocal.get().createNode(new GherkinKeyword(step.getKeyword().trim()), String.valueOf(step.getKeyword()) + name, testStep.getCodeLocation());
                ExtentCucumberAdapter.stepTestThreadLocal.set(t);
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (!testStep.getStepArgument().isEmpty()) {
            final Argument argument = testStep.getStepArgument().get(0);
            if (argument instanceof PickleString) {
                this.createDocStringMap((PickleString)argument);
            }
            else if (argument instanceof PickleTable) {
                final List<PickleRow> rows = (List<PickleRow>)((PickleTable)argument).getRows();
                ExtentCucumberAdapter.stepTestThreadLocal.get().pass(MarkupHelper.createTable(this.getPickleTable(rows)).getMarkup());
            }
        }
    }
    
    private String[][] getPickleTable(final List<PickleRow> rows) {
        String[][] data = null;
        for (int rowSize = rows.size(), i = 0; i < rowSize; ++i) {
            final PickleRow row = rows.get(i);
            final List<PickleCell> cells = (List<PickleCell>)row.getCells();
            final int cellSize = cells.size();
            if (data == null) {
                data = new String[rowSize][cellSize];
            }
            for (int j = 0; j < cellSize; ++j) {
                data[i][j] = cells.get(j).getValue();
            }
        }
        return data;
    }
    
    private Map<String, Object> createDocStringMap(final PickleString docString) {
        final Map<String, Object> docStringMap = new HashMap<String, Object>();
        docStringMap.put("value", docString.getContent());
        return docStringMap;
    }
    
    public static synchronized void addTestStepLog(final String message) {
        ExtentCucumberAdapter.stepTestThreadLocal.get().info(message);
    }
    
    public static synchronized void addTestStepScreenCaptureFromPath(final String imagePath) throws IOException {
        ExtentCucumberAdapter.stepTestThreadLocal.get().addScreenCaptureFromPath(imagePath);
    }
    
    public static synchronized void addTestStepScreenCaptureFromPath(final String imagePath, final String title) throws IOException {
        ExtentCucumberAdapter.stepTestThreadLocal.get().addScreenCaptureFromPath(imagePath, title);
    }
    
    public static ExtentTest getCurrentStep() {
        return ExtentCucumberAdapter.stepTestThreadLocal.get();
    }
}
