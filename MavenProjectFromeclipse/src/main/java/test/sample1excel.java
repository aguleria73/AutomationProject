package test;

public class sample1excel {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "/DataReading.xlsx";
		System.out.println(path);
		
		Xls_Reader xl1 = new Xls_Reader(path);
		int rowCount = xl1.getRowCount("Login Detail");
		System.out.println("Row are:- " + rowCount);
		
		int columnCount = xl1.getColumnCount("Login Detail");
		System.out.println("Column are:- " + columnCount);

	}

}
