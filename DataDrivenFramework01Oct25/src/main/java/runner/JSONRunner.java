package runner;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONRunner {

	public static void main(String[] args) throws IOException, ParseException {
		Map<String, String> classMethods = new DataUtil().loadClassMethods();
		System.out.println("classMethods " + classMethods);
		String path = System.getProperty("user.dir") + "/src/test/resources/jsons/testconfig.json";
//		System.out.println(path);
		FileReader reader = new FileReader(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(reader);
		String parallelSuites = (String) json.get("parallelsuites");
		

		JSONArray testSuites = (JSONArray) json.get("testsuites");
		TestNGRunner testNG = new TestNGRunner(testSuites.size()+1);
		for (int testSuitesId = 0; testSuitesId < testSuites.size(); testSuitesId++) 
		{
			JSONObject testDetailJSON = (JSONObject) testSuites.get(testSuitesId);
			String runmode = (String) testDetailJSON.get("runmode");
			String name = (String) testDetailJSON.get("name");
			// uncomment below when getting data from json file
//			String testdatajsonfile = System.getProperty("user.dir") + "/src/test/resources/jsons/" + (String) testDetailJSON.get("testdatajsonfile");
			
			// Use when extracting data from excel 
			String testdatajsonfile = System.getProperty("user.dir") + "/src/test/resources/jsons/" + (String) testDetailJSON.get("testdataxlsfile");
			System.out.println("testdatajsonfile:- "+ testdatajsonfile);
			
			String suitfilename = (String) testDetailJSON.get("suitfilename");
//			System.out.println("suitfilename:- " + suitfilename);
			String paralleltests = (String) testDetailJSON.get("paralleltests");
//			System.out.println("paralleltests:- " + paralleltests);
			if (runmode.equals("Y")) 
			{
				boolean pTests = false;
				if (paralleltests.equals("Y")) 
				{
					pTests = true;
				}
				testNG.createSuite(name, pTests);
				testNG.addListener("listener.MyTestNGListener");

				String suitePath = System.getProperty("user.dir") + "/src/test/resources/jsons/" + suitfilename;
//				System.out.println("suitePath:- " + suitePath);
				FileReader readerSuite = new FileReader(suitePath);
				JSONParser suiteParser = new JSONParser();
				JSONObject suiteJson = (JSONObject) suiteParser.parse(readerSuite);
//				System.out.println("suiteJson");
//				System.out.println(suiteJson.toJSONString());

				JSONArray suiteTestCases = (JSONArray) suiteJson.get("testcases");
				for (int sTID = 0; sTID < suiteTestCases.size(); sTID++) 
				{
					JSONObject suiteTestCase = (JSONObject) suiteTestCases.get(sTID);

					String tName = (String) suiteTestCase.get("name");
					JSONArray parameterNames = (JSONArray) suiteTestCase.get("parameternames");
					JSONArray executions = (JSONArray) suiteTestCase.get("executions");
					for (int eId = 0; eId<executions.size(); eId++) 
					{
						JSONObject testCase = (JSONObject) executions.get(eId);
						String executionname = (String) testCase.get("executionname");
						String tRunMode = (String) testCase.get("runmode");
						String dataflag = (String) testCase.get("dataflag");
						System.out.println("dataflag:- " + dataflag);
//						testNG.addTestParameter("dataflag", dataflag);
						
						// Uncomment when reading data from json file
//						int dataSets = new DataUtil().getTestDataSets(testdatajsonfile, dataflag);
						
						// uncomment when reading data from excel file
						int dataSets = new ReadingXLS().getTestDataSetsXls(testdatajsonfile, dataflag, name.replaceAll(" ", ""));
						System.out.println("dataSets:- " + dataSets);
						
						if (tRunMode != null && tRunMode.equals("Y")) 
						{
							for(int dSId=0; dSId<dataSets; dSId++)
							{
								JSONArray parametervalues = (JSONArray) testCase.get("parametervalues");
								JSONArray methods = (JSONArray) testCase.get("methods");

								// add to testNG
//									testNG.addTest(tName + " - " + executionname + "It." +(dSId+1));
								testNG.addTest(tName + " - " + executionname + "It." + (dSId+1));
								for (int pId = 0; pId < parameterNames.size(); pId++) 
								{
									testNG.addTestParameter((String) parameterNames.get(pId), (String) parametervalues.get(pId));
								}
								testNG.addTestParameter("dataflag", dataflag);
								testNG.addTestParameter("datafilepath", testdatajsonfile);
								testNG.addTestParameter("iteration", String.valueOf(dSId));
//								testNG.addTestParameter("suitename", name); // only for when we read data from json file
								testNG.addTestParameter("suitename", name.replaceAll(" ", "")); // Only for Excel sheet name
								

								List<String> includedMethods = new ArrayList<String>();
								for (int mId = 0; mId < methods.size(); mId++) 
								{
									String method = (String) methods.get(mId);
									String methodClass = classMethods.get(method);
									System.out.println("++ " + method + " - " + methodClass);
									if (mId == methods.size() - 1 || !((String) classMethods.get((String) methods.get(mId + 1))).equals(methodClass)) {
										// if it comes here this means that method is from different class
										includedMethods.add(method);
										testNG.addTestClass(methodClass, includedMethods);
										includedMethods = new ArrayList<String>();
									} else 
									{
										// if it comes here this means that method is from same class
										includedMethods.add(method);
									}
								}
							}

						}

					}

				}
				 testNG.run();
			}
		}
	}

}
