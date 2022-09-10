package testNGxml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.testng.TestNG;

import util.Xls_Reader;


/**
 * This class is to create TestNg XML during runtime by reading the TestConfig sheet
 * 
 *
 */

public class GenerateTestNGXML2 
{
	
	ArrayList<String> keyList=new  ArrayList<String>();
	
	private static GenerateTestNGXML2 xmlobj;
	Map<String,String> getParamAttr=new HashMap<String,String>();
	
	 public GenerateTestNGXML2()
	 { 
	 }
	 
	 public static GenerateTestNGXML2 getInstance()
	 {
	        if(xmlobj == null){
	        	xmlobj = new GenerateTestNGXML2();
	        }
	        return xmlobj;
	 }
	
	//This method is used to create Test Tag in Testng.xml file
	//This Test Tag contains Parameters Tag and Classes Tag
	public static Test createTesttag(String testName,Map<String, String> paramAttr,
			String platformtype, Properties prop, String className)
	{
		//Environment.settingPaths();
		
		Test tobj=new Test();//test tag in xml starts
		//test tag attribute
		tobj.setName(testName);//setting test name attribute
		tobj.setVerbose(prop.getProperty("VerboseAttr"));//setting test verbose attribute 
		
		Classes cls=new Classes(); //creating classes tag 
		
		Myclass cobj=new Myclass(); //creating class tag 
		
		cobj.setName(className); //setting class name attribute 
		
		cls.setMyobj(cobj);  //adding class tag inside classes tag
		
		tobj.setCobj(cls); //adding classes tag inside test tag
				
		
		
		ArrayList<Parameter> myparam=new ArrayList<Parameter>(); //creating parameters tag
		
		//when platform type is Android
		if(platformtype.equals("Android_Web")||platformtype.equals("Android_App")||platformtype.equals("Windows")||platformtype.equals("Mobile"))
		{
	
			Parameter nodeparam=new Parameter(); //adding node name and value in parameter tag
			nodeparam.setName("os_version"); //setting name attribute for parameter tag
			nodeparam.setValue(paramAttr.get("os_version"));
			Parameter browparam=new Parameter();
			browparam.setName("device");//setting name attribute for parameter tag
			browparam.setValue(paramAttr.get("device"));
			Parameter platparam = new Parameter();
			platparam.setName("real_mobile");
			platparam.setValue(paramAttr.get("real_mobile"));
			Parameter tsuiteparam = new Parameter();
			tsuiteparam.setName("project");
			tsuiteparam.setValue(paramAttr.get("project"));
			Parameter sceanrios = new Parameter();
			sceanrios.setName("build");
			sceanrios.setValue(paramAttr.get("build"));
			Parameter name_br = new Parameter();
			name_br.setName("name");
			name_br.setValue(paramAttr.get("name"));
			Parameter browserstack_debug_br = new Parameter();
			browserstack_debug_br.setName("browserstack_debug");
			browserstack_debug_br.setValue(paramAttr.get("browserstack.debug"));
			Parameter browserstack_local_br = new Parameter();
			browserstack_local_br.setName("browserstack_local");
			browserstack_local_br.setValue(paramAttr.get("browserstack.local"));
			Parameter browserstack_networkLogs_br = new Parameter();
			browserstack_networkLogs_br.setName("browserstack_networkLogs");
			browserstack_networkLogs_br.setValue(paramAttr.get("browserstack.networkLogs"));
			Parameter SuiteName_br = new Parameter();
			SuiteName_br.setName("SuiteName");
			SuiteName_br.setValue(paramAttr.get("SuiteName"));
			Parameter platformType_br = new Parameter();
			platformType_br.setName("platformType");
			platformType_br.setValue(paramAttr.get("platformType"));
			Parameter browser_br = new Parameter();
			browser_br.setName("browser");
			browser_br.setValue("text");
			
			Parameter UserName = new Parameter();
			UserName.setName("UserName");
			UserName.setValue(paramAttr.get("UserName"));
			
			Parameter AccessKey = new Parameter();
			AccessKey.setName("AccessKey");
			AccessKey.setValue(paramAttr.get("AccessKey"));
			
			myparam.add(name_br);
			myparam.add(browserstack_debug_br);
			myparam.add(browserstack_local_br);
			myparam.add(browserstack_networkLogs_br);
			myparam.add(SuiteName_br);
			myparam.add(platformType_br);
			myparam.add(browser_br);
			myparam.add(nodeparam);
			myparam.add(browparam);
			myparam.add(platparam);
			myparam.add(tsuiteparam);
			myparam.add(sceanrios);
			myparam.add(UserName);
			myparam.add(AccessKey);
			tobj.setParameter(myparam);//adding both node parameter tag inside test tag
		}
		
		return tobj;
	}
		
	//Method Used to Read the First Header Row from  Test Config Xls and use it to create Test NG XML
	public ArrayList<String> getKey(Xls_Reader suiteXLS) 
	{
		String os_version = null, device = null, real_mobile = null, project = null,build = null,name=null,
				browserstack_local=null,browserstack_debug= null,browserstack_networkLogs=null,UserName=null,
						SuiteName=null,browser=null,platformType=null, AccessKey=null;
		//Xls_Reader suiteXLS = new Xls_Reader("D:\\SanthoshWorkSpace3\\SampleBancPay_TestNG\\Suite\\Loader_And_Routing-Org.xls");
		try 
		{
			for (int i = 2; i <=suiteXLS.getRowCount("TestConfig"); i++) 
			{
				os_version = "os_version";
				keyList.add(os_version);
				device = "device";
				keyList.add(device);
				real_mobile = "real_mobile";
				keyList.add(real_mobile);
				project = "project";
				keyList.add(project);
				build = "build";
				keyList.add(build);
				name = "name";
				keyList.add(name);
				browserstack_local = "browserstack.debug";
				keyList.add(browserstack_local);
				browserstack_debug = "browserstack.local";
				keyList.add(browserstack_debug);
				browserstack_networkLogs = "browserstack.networkLogs";
				keyList.add(browserstack_networkLogs);
				SuiteName = "SuiteName";
				keyList.add(SuiteName);
				platformType = "platformType";
				keyList.add(platformType);
				browser="browser";
				keyList.add(browser);
				UserName="UserName";
				keyList.add(UserName);
				AccessKey="AccessKey";
				keyList.add(AccessKey);
				break;
			}
			System.out.println(keyList);
	
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return keyList;
	}
		
	//This method is used to create tetsng.xml file in the specified location 
	public void createXML(Xls_Reader suiteXLS, Properties prop) 
	{
		try
		{
		Suite sobj = new Suite();
		ArrayList<Test> myTests = new ArrayList<Test>();
		ArrayList<String> key = getKey(suiteXLS);
		// Read the excel data to create xml
		//Environment.settingPaths();
		//TestSuite residing path + Suite file Name
		//Xls_Reader suiteXLS = new Xls_Reader("D:\\SanthoshWorkSpace3\\SampleBancPay_TestNG\\Suite\\Loader_And_Routing-Org.xls");
		for (int i = 2; i <=suiteXLS.getRowCount("TestConfig"); i++) 
		{
				String tSuiteName = suiteXLS.getCellData("TestConfig", "SuiteName", i);
				String tSuiteRunMode = suiteXLS.getCellData("TestConfig", "RunMode", i);
				
				  String platformType = suiteXLS.getCellData("TestConfig", "platformType", i);
				 String tBrowser = suiteXLS.getCellData("TestConfig", "Browser", i); 
				 /* remoteUrl = suiteXLS.getCellData("TestConfig", "NodeUrl", i);
				 */
				 // String remoteUrl = suiteXLS.getCellData("TestConfig", "NodeUrl", i);
				//String scenarios = suiteXLS.getCellData("TestConfig", "NumberOfScenarios", i);
				
				String os_version = suiteXLS.getCellData("TestConfig", "os_version", i);
				String device = suiteXLS.getCellData("TestConfig", "device", i);
				String real_mobile = suiteXLS.getCellData("TestConfig", "real_mobile", i);
				String project = suiteXLS.getCellData("TestConfig", "project", i);
				
				String build = suiteXLS.getCellData("TestConfig", "build", i);
				String name = suiteXLS.getCellData("TestConfig", "name", i);
				String browserstack_local = suiteXLS.getCellData("TestConfig", "browserstack.local", i);
				String browserstack_debug = suiteXLS.getCellData("TestConfig", "browserstack.debug", i);
				String browserstack_networkLogs = suiteXLS.getCellData("TestConfig", "browserstack.networkLogs", i);
				String SlNo = suiteXLS.getCellData("TestConfig", "SlNo", i);
				String UserName = suiteXLS.getCellData("TestConfig", "UserName", i);
				String AccessKey = suiteXLS.getCellData("TestConfig", "AccessKey", i);
				
				// adding the name and value attribute of parameter tag into a
				// map
				getParamAttr.put(key.get(0), os_version);
				getParamAttr.put(key.get(1), device);
				getParamAttr.put(key.get(2), real_mobile);
				getParamAttr.put(key.get(3), project);
				getParamAttr.put(key.get(4), build);
				getParamAttr.put(key.get(5), name);
				getParamAttr.put(key.get(6), browserstack_debug);
				getParamAttr.put(key.get(7), browserstack_local);
				getParamAttr.put(key.get(8), browserstack_networkLogs);
				//getParamAttr.put(key.get(9), scenarios);
				getParamAttr.put(key.get(9), tSuiteName);
				getParamAttr.put(key.get(10), platformType);
				//getParamAttr.put(key.get(12), remoteUrl);
				getParamAttr.put(key.get(11), tBrowser);
				getParamAttr.put(key.get(12), UserName);
				getParamAttr.put(key.get(13), AccessKey);
								
										
				if(tSuiteRunMode.equalsIgnoreCase("Yes"))
				{
					myTests.add(createTesttag("test" + i, getParamAttr, platformType, prop,"runner.Runner"+SlNo));
				}
			}
	
			sobj.setTest(myTests);
			sobj.setName(prop.getProperty("SuiteName"));
			sobj.setParallel(prop.getProperty("ParallelAttr"));
			sobj.setThreadcount(prop.getProperty("Threadcount"));
	
			File file = new File(System.getProperty("user.dir")+"\\" + "testng.xml"); // creating
																		// testng.xml
																		// file
																		// in a
																		// specified
																		// location
			JAXBContext jaxbContext = JAXBContext.newInstance(Suite.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
			jaxbMarshaller.marshal(sobj, file);
			jaxbMarshaller.marshal(sobj, System.out);
	
		}
	
		catch (JAXBException e) 
		{
			e.printStackTrace();
		}
	
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
	}
		
		
	//This method is used to Run the created Testng.xml file using TestNG Listener
	public void runtestNgXML() 
	{
		try
		{
		TestNG runner = new TestNG();
	
		// Create a list of String
		List<String> suitefiles = new ArrayList<String>();
	
		// Add xml file which you have to execute
		suitefiles.add(System.getProperty("user.dir")+"\\" + "testng.xml");
	
		// now set xml file for execution
		runner.setTestSuites(suitefiles);
	
		// finally execute the runner using run method
		runner.run();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
