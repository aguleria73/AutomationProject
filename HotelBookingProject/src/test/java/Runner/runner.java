package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class runner {

	public static void main(String[] args) {
		TestNG testNG = new TestNG();
		XmlSuite mysuite = new XmlSuite();
		mysuite.setName("My suite");
		List<XmlSuite> allsuites = new ArrayList<XmlSuite>();
		allsuites.add(mysuite);
		testNG.setXmlSuites(allsuites);
		
		XmlTest test = new XmlTest(mysuite);
		test.setName("Login Test");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("testcase.Login"));
		test.setXmlClasses(classes);
		testNG.run();
		
	}

}
