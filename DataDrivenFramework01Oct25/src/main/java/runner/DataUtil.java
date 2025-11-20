package runner;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataUtil {
	
	public Map<String, String> loadClassMethods() throws IOException, ParseException
	{
		Map<String, String> classMethodsMap = new HashMap<String, String>();
		String path = System.getProperty("user.dir")+"/src/test/resources/jsons/classmethods.json";
		FileReader reader = new FileReader(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(reader);
		JSONArray classDetails = (JSONArray) json.get("classdetails");
		for(int i =0; i<classDetails.size(); i++) 
		{
			JSONObject classDetail = (JSONObject)classDetails.get(i);
			String className = (String) classDetail.get("class");
			JSONArray methods = (JSONArray) classDetail.get("methods");
			for(int y =0; y<methods.size();y++) 
			{
				String methodName = (String) methods.get(y);
				classMethodsMap.put(methodName, className);
			}
		}
		return classMethodsMap;
	}
	
	public int getTestDataSets(String filePath, String dataFlag) throws IOException, ParseException 
	{
		int dataSets=0;
		FileReader reader = new FileReader(filePath);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(reader);
		JSONArray dataDetails = (JSONArray) json.get("testdata");
		for(int dSetId=0; dSetId<dataDetails.size(); dSetId++) 
		{
			JSONObject testData = (JSONObject) dataDetails.get(dSetId);
			String flag = (String) testData.get("flag");
			if(flag.equals(dataFlag)) 
			{
				JSONArray dataSet = (JSONArray) testData.get("data");
				dataSets= dataSet.size();
				return dataSets;
			}
		}
		
		return dataSets;
	}
	
	public int getTestDataSetsXls(String xlsFilePath, String flagName, String sheetName ) throws IOException, ParseException 
	{
		System.out.println("-----------getTestDataSetsXls----------");
		Xls_Reader xls = new Xls_Reader(xlsFilePath);
		
		int flagRowNum = 0;
		for (int i = 1; i <= xls.getRowCount(sheetName); i++) 
		{
			String cellData = xls.getCellData(sheetName, 0, i);
			System.out.println("cellData:- "+ cellData);
			if (cellData.equals(flagName)) 
			{
				flagRowNum = i;
				break;
			}
		}
		int colNameRowNum = flagRowNum + 1; // column name start
		int dataStartRowNum = flagRowNum + 2; // data start from
		int colCount = xls.getColumnCountByRownum(sheetName, colNameRowNum);
	
		int dataEndRowNum = 0;
		int z = dataStartRowNum;
		while (true) 
		{
			String cellData = xls.getCellData(sheetName, 0, z);
			System.out.println(cellData);
			if (cellData.equals("")) 
			{
				dataEndRowNum = z;
				break;
			}
			z++;
		}
		dataEndRowNum = dataEndRowNum - 1;
		int totalRow = dataEndRowNum- colNameRowNum;
		return totalRow;
	}
	
	
	public JSONObject getTestData(String filePath, String dataFlag, int iteration) throws IOException, ParseException
	{
		int dataSets=0;
		FileReader reader = new FileReader(filePath);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(reader);
		JSONArray dataDetails = (JSONArray) json.get("testdata");
		System.out.println("In dataUTIl Gettest" + dataDetails.toJSONString());
		System.out.println(" " );
		for(int dSetId=0; dSetId<dataDetails.size(); dSetId++) 
		{
			JSONObject testData = (JSONObject) dataDetails.get(dSetId);
			System.out.println("In dataUTIl --- test data" + testData.toJSONString());
			String flag = (String) testData.get("flag");
			System.out.println("flag:- " + flag);
			System.out.println("  ");
			if(flag.equals(dataFlag)) 
			{
				JSONArray dataSet = (JSONArray) testData.get("data");
				System.out.println("dataSet:- " + dataSet.toJSONString());
				System.out.println(" " );
				JSONObject data = (JSONObject) dataSet.get(iteration);
				System.out.println("data of iteration:- " + data.toJSONString());
				System.out.println(" " );
				return data;
			}
		}
		return null;
	}

}
