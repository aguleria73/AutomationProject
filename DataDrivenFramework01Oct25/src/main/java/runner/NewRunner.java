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

public class NewRunner {

	public static void main(String[] args) throws IOException, ParseException {
		Map<String, String> classMethods = new DataUtil().loadClassMethods();
		String path = System.getProperty("user.dir") + "/src/test/resources/jsons/testconfig.json";
		FileReader reader = new FileReader(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(reader);
		String parallelSuites = (String) json.get("parallelsuites");
		TestNGRunner testNG = new TestNGRunner(Integer.parseInt(parallelSuites));
		JSONArray testSuites = (JSONArray) json.get("testsuites");
		for (int i = 0; i < testSuites.size(); i++) {
			JSONObject testDetailJSON = (JSONObject) testSuites.get(i);
			String runmode = (String) testDetailJSON.get("runmode");
			if (runmode.equals("Y")) {
				String name = (String) testDetailJSON.get("name");

//uncomment below in case of getting data from json
				String testdatajsonfile = System.getProperty("user.dir") + "/src/test/resources/jsons/"
						+ (String) testDetailJSON.get("testdatajsonfile");

//				String testdatajsonfile = System.getProperty("user.dir") + "/src/test/resources/jsons/"
//						+ (String) testDetailJSON.get("testdataxlsfile");

				String suitfilename = (String) testDetailJSON.get("suitfilename");
				String paralleltests = (String) testDetailJSON.get("paralleltests");
				boolean pTests = false;
				if (paralleltests.equals("Y")) {
					pTests = true;
				}

				testNG.createSuite(name, pTests);
				testNG.addListener("listener.MyTestNGListener");

				String suitePath = System.getProperty("user.dir") + "/src/test/resources/jsons/" + suitfilename;
// System.out.println(suitePath);
				FileReader readerSuite = new FileReader(suitePath);
				JSONParser suiteParser = new JSONParser();
				JSONObject suiteJson = (JSONObject) suiteParser.parse(readerSuite);
// System.out.println(suiteJson.toJSONString());
				JSONArray suiteTestCases = (JSONArray) suiteJson.get("testcases");
				for (int sTID = 0; sTID < suiteTestCases.size(); sTID++) {
					JSONObject suiteTestCase = (JSONObject) suiteTestCases.get(sTID);
					String tName = (String) suiteTestCase.get("name");
					JSONArray parameternames = (JSONArray) suiteTestCase.get("parameternames");
// System.out.println("parameternames: "+parameternames);
					JSONArray executions = (JSONArray) suiteTestCase.get("executions");
					for (int eId = 0; eId < executions.size(); eId++) {
						JSONObject testCase = (JSONObject) executions.get(eId);
						String executionname = (String) testCase.get("executionname");
						String tRunmode = (String) testCase.get("runmode");
						String dataflag = (String) testCase.get("dataflag");
						int dataSets = new DataUtil().getTestDataSets(testdatajsonfile, dataflag);
// System.out.println("dataSets: "+dataSets);

//						int dataSets = new ReadingXLS().getTestDataSets(testdatajsonfile, dataflag,
//								name.replaceAll(" ", ""));
						System.out.println("dataSets: " + dataSets);

						if (tRunmode != null && tRunmode.equals("Y")) {
							for (int dSId = 0; dSId < dataSets; dSId++) {

								JSONArray parametervalues = (JSONArray) testCase.get("parametervalues");

								JSONArray methods = (JSONArray) testCase.get("methods");

//add to testNG
								testNG.addTest(tName + " - " + executionname + "It." + (dSId + 1));

								for (int pId = 0; pId < parameternames.size(); pId++) {
									testNG.addTestParameter((String) parameternames.get(pId),
											(String) parametervalues.get(pId));
								}

								testNG.addTestParameter("datafilepath", testdatajsonfile);
								testNG.addTestParameter("iteration", String.valueOf(dSId));
								testNG.addTestParameter("dataflag", dataflag);
								testNG.addTestParameter("suitename", name);
//								testNG.addTestParameter("suitename", name.replaceAll(" ", ""));
								System.out.println(executionname + " -- " + dataflag + " -- " + parametervalues + " -- "
										+ methods);

// int dataSets = new DataUtil().getTestDataSets(testdatajsonfile, ,dataflag);
// System.out.println("dataSets: "+dataSets);

								List<String> includedMethods = new ArrayList<String>();
								for (int mId = 0; mId < methods.size(); mId++) {
									String method = (String) methods.get(mId);
									String methodClass = classMethods.get(method);
									System.out.println(method + "  - " + methodClass);
									if (mId == methods.size() - 1
											|| !((String) classMethods.get((String) methods.get(mId + 1)))
													.equals(methodClass)) {
//if it comes here this means that method is from different class
										includedMethods.add(method);
										testNG.addTestClass(methodClass, includedMethods);
										includedMethods = new ArrayList<String>();
									} else {
//if it comes here this means that method is from same class
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
