package testNGxml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


//Suite class is used to create <suite> in XML
@XmlRootElement
@XmlType(name = "SuiteType")
public class Suite 
{
	//name parallel and threadcount are the attributes of suite tag
	String name,parallel,threadcount;
	
	
	//Setting the the getter and setter methods for Test Tag inside Suite tag
	ArrayList<Test> test;

	public ArrayList<Test> getTest() {
		return test;
	}

	public void setTest(ArrayList<Test> test) {
		this.test = test;
	}
	
	
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getParallel() {
		return parallel;
	}
	@XmlAttribute
	public void setParallel(String parallel) {
		this.parallel = parallel;
	}

	public String getThreadcount() {
		return threadcount;
	}
	@XmlAttribute(name="thread-count")
	public void setThreadcount(String threadcount) {
		this.threadcount = threadcount;
	}
	 	
}


//Test class is used to create <test> in XML inside <suite>
@XmlRootElement
@XmlType(name = "TestType",propOrder={"parameter","cobj"})
//@XmlType(propOrder={"parameter","cobj"})
class Test 
{
	//name and verbose are are the attributes of Test tag
	String name;
	String verbose;
	
	Classes cobj;
	
	ArrayList<Parameter> parameter;
	
	@XmlAttribute
	public String getVerbose() {
		return verbose;
	}

	 @XmlAttribute
	  public String getName() 
	 {
	        return name;
	 }

	 public void setVerbose(String verbose) {
			this.verbose = verbose;
		}

		public void setName(String name) {
			this.name = name;
		}

	//Setting the the getter and setter methods for Classes Tag inside Test tag
	public Classes getCobj() {
		return cobj;
	}
	     
	@XmlElement(name="classes")
	public void setCobj(Classes cobj) {
		this.cobj = cobj;
	}
	//Setting the getter and setter methods for Parameter Tag inside Test tag
	public ArrayList<Parameter> getParameter() {
		return parameter;
	}

	public void setParameter(ArrayList<Parameter> parameter) {
		this.parameter = parameter;
	}
}


//Parameter class is used to create <parameter> in XML inside <test>
@XmlType(name = "parameterType")
class Parameter {

	//name and value are the attributes of <parameter> tag
    private String name;
    
  //Setting the getter and setter methods for name and value attributes for <parameter> tag
    public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;

    @XmlAttribute
    public String getName() {
        return name;
    }

    @XmlAttribute
    public String getValue() {
        return value;
    }

}

//Classes class is used to create <classes> in XML inside <test>
@XmlRootElement
class Classes 
{
	
	Myclass myobj;
	
	//setting up the getter and setter methods for <class> tag
	public Myclass getMyobj() {
		return myobj;
	}
	@XmlElement(name="class")
	public void setMyobj(Myclass myobj) {
		this.myobj = myobj;
	}
}

//MyClass is used to create <class> inside <classes> 
@XmlRootElement
@XmlType(name = "ClassType")
class Myclass 
{
	//name is the attribute of <class> inside <classes>
	String name;

	//setting up the getter and setter methods for name attribute
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
}


