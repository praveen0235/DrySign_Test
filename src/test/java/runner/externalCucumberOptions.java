package runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import config.PropertyFileReader;
import framework.GenericActions;
import testNGxml.GenerateTestNGXML;
import util.PathHelper;
import util.Xls_Reader;


public class externalCucumberOptions {

	public static util.Xls_Reader suiteXLS; //common suite 
	public static Properties CONFIG;
	public static void loadPropertiesFile() throws IOException{
		PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
		PropertyFileReader prop = new PropertyFileReader();
	    }
	public static String createAndGetCucumberOption(){       
	     StringBuilder sb = new StringBuilder();
	     String featureFilesPath = 
	    PropertyFileReader.properties.getProperty("cucumber.options.feature");
	     sb.append(featureFilesPath);
	     return sb.toString();
	    }

	 public static void setOptions(){
	   String value = createAndGetCucumberOption();
	   System.setProperty("cucumber.options", value);
	   }

	public static void main( String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
			
			System.out.println("Execution process Started....");
			

			GenericActions.hitoryReports();
			GenericActions.filesDeletion();
			loadPropertiesFile();
			try
			{			
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\PropertiesFile\\config.properties");
		        CONFIG= new Properties();
		        CONFIG.load(fs);
		        Path src = Paths.get(System.getProperty("user.dir")+"\\"+ "DevicesConfiguration.xlsx"); 
		        suiteXLS = new util.Xls_Reader(src.toString());
		        GenerateTestNGXML genXml = new GenerateTestNGXML();
		        genXml.createXML(suiteXLS, CONFIG);
		        genXml.runtestNgXML();
		        
		        Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")+"\\"+ "DevicesConfiguration.xlsx");
				int rowCount = xl.getRowCount("TestConfig");
				for(int i=2;i<=rowCount;i++)
				{
					if(i!=rowCount)
					{
					if(xl.getCellData("TestConfig", "RunMode", i).equalsIgnoreCase("Yes"))
					{
						xl.setCellData("TestConfig", "RunMode", i, "No");
						xl.setCellData("TestConfig", "RunMode", i+1, "Yes");
						break;
					}
					}else
					{
						xl.setCellData("TestConfig", "RunMode", i, "No");
						xl.setCellData("TestConfig", "RunMode", 2, "Yes");
						break;
					}
				}

			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			  //EmailUtil.sendEmailAfterLogs();
			 
			System.out.println("Execution process Completed");
	}

}
