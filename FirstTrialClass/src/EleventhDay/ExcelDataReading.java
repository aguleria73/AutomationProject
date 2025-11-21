package EleventhDay;


public class ExcelDataReading {

	
	public static void main(String[] args) {
		//datareading1();
		datareading2();

	}
	
	
	public static void datareading1() 
	{
		String path = System.getProperty("user.dir") + "/DataReading.xlsx";
		
		Xls_Reader xl1 = new Xls_Reader(path);
		
		int rowCount = xl1.getRowCount("Login Detail");
		System.out.println("Row are:- " + rowCount);
		
		int columnCount = xl1.getColumnCount("Login Detail");
		System.out.println("Column are:- " + columnCount);
		
		System.out.println(" ");
		
		String Data = xl1.getCellData("Login Detail", 1 , 1);
		System.out.println("Excel Data:- " + Data);
		System.out.println("  ");
		
		
		for(int i=1; i<=rowCount; i++) 
		{
			for(int j=1; j<columnCount; j++) 
			{
				String columnData = xl1.getCellData("Login Detail", j, i);
				System.out.println(columnData);
			}
			System.out.println("Row fatched Successfuly");
			System.out.println(" ");
		}
	}
	
	public static void datareading2() { 
		String filename = System.getProperty("user.dir") + "/DataReading.xlsx";
		Xls_Reader xl2 = new Xls_Reader(filename);
		
		int rowCount = xl2.getRowCount("Sheet2");
		System.out.println("Row are:- " + rowCount);
		
		int columnCount = xl2.getColumnCountByRownum("Sheet2",1);
		System.out.println("Column are:- " + columnCount);
		
		System.out.println(" ");
		
		String Data = xl2.getCellData("Sheet2", 0 , 2);
		System.out.println("Excel Data:- " + Data);
		System.out.println("  ");
		
		
		for(int i=1; i<=rowCount; i++) 
		{
			for(int j=0; j<columnCount; j++) 
			{
				String columnData = xl2.getCellData("Sheet2", j, i);
				System.out.println(columnData);
//				System.out.println("COLUMN fatched Successfuly");
				
			}
			System.out.println("Row fatched Successfuly");
			System.out.println(" ");
		} 
		
	}

}
