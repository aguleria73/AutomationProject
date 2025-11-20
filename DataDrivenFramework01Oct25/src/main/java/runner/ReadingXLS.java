package runner;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class ReadingXLS {

	public static void main(String[] args) {
		
		String h = "Hello";
		System.out.println("-------"+ h.toLowerCase());
		String path = System.getProperty("user.dir") + "/src/test/resources/jsons/xls_data/excelForTesting.xlsx";
//		System.out.println(filename);
		Xls_Reader xls = new Xls_Reader(path);
		System.out.println(xls.getColumnCount("DealSuite"));

		String sheetName = "DealSuite";
		String flagName = "deletedeal";
		int flagRowNum = 0;

		for (int i = 1; i <= xls.getRowCount(sheetName); i++) {
			String cellData = xls.getCellData(sheetName, 0, i);
			if (cellData.equals(flagName)) {
				flagRowNum = i;
				break;
			}
		}
		System.out.println("flagRowNum:- " + flagRowNum);
		int colNameRowNum = flagRowNum + 1; // column name start
		int dataStartRowNum = flagRowNum + 2; // data start from
		int colCount = xls.getColumnCountByRownum(sheetName, colNameRowNum);
		System.out.println(colCount);

		int dataEndRowNum = 0;
		int z = dataStartRowNum;
		while (true) {
			String cellData = xls.getCellData(sheetName, 0, z);
			if (cellData.equals("")) {
				dataEndRowNum = z;
				break;
			}
			z++;
		}
		dataEndRowNum = dataEndRowNum - 1;
		System.out.println("dataEndRowNum:- " + dataEndRowNum);
		int iterationNumber = 2;
		int index = 1;

		for (int i = dataStartRowNum; i <= dataEndRowNum; i++) {
			if (index == iterationNumber) // for getting data of particular row
			{
				for (int y = 0; y < colCount; y++) {
					String colName = xls.getCellData(sheetName, y, colNameRowNum);
//					System.out.println("colName:- "+ colName);
					String cellData = xls.getCellData(sheetName, y, i);
//					System.out.println(cellData);
					System.out.println(colName + " -- " + cellData);
				}
				break;
			} else {
				index++;
			}
			System.out.println("-------");
		}

	}

	public JSONObject getTestData(String sheetName, String flagName, int iterationNumber, String xlsFilePath) 
	{
		Xls_Reader xls = new Xls_Reader(xlsFilePath);
		int flagRowNum = 0;

		for (int i = 1; i <= xls.getRowCount(sheetName); i++) 
		{
			String cellData = xls.getCellData(sheetName, 0, i);
			System.out.println("getTestData --- cellData" + cellData);
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
			if (cellData.equals("")) 
			{
				dataEndRowNum = z;
				break;
			}
			z++;
		}
		dataEndRowNum = dataEndRowNum - 1;
//		int iterationNumber = 2;
		int index = 1;

		for (int i = dataStartRowNum; i <= dataEndRowNum; i++) 
		{
			if (index == iterationNumber+ 1) // for getting data of particular row
			{
				JSONObject json = new JSONObject();

				for (int y = 0; y < colCount; y++) {
					String colName = xls.getCellData(sheetName, y, colNameRowNum);
					String cellData = xls.getCellData(sheetName, y, i);
					System.out.println(colName + " --- " + cellData);
					json.put(colName, cellData);
				}
//				break;
				return json;
				
			} 
			else 
			{
				index++;
			}
		}
		return new JSONObject();
	}
	
	
	public int getTestDataSetsXls(String xlsFilePath, String flagName, String sheetName ) throws IOException, ParseException 
	{
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

}
