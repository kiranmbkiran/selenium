package commonLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FileData {

	public static long PAGE_LOAD_TIMEOUT=70;
    public static long IMPLICIT_WAIT=70;
    
  //  String onlinebatchdata="online_batch_creation_form_data";
	
	@DataProvider
	public  static String [][] getData(String sheetName ) throws IOException{
		
		File excelFile=new File("./src/main/java/TestData/LoginTestdata.xlsx");
		     System.out.println(excelFile.exists());
		     
		     FileInputStream fis=new FileInputStream(excelFile);
		     XSSFWorkbook workbook=new XSSFWorkbook(fis);
		     XSSFSheet sheet= workbook.getSheet(sheetName);
		     int noofrows= sheet.getPhysicalNumberOfRows();
		     int noofcoloumns=sheet.getRow(0).getLastCellNum();
		     
		     String [][] data= new String[noofrows-1][noofcoloumns];
		     
		     
		     for(int i=0;i<noofrows-1; i++){
		    	 for(int j=0; j<noofcoloumns;j++){
		    		 DataFormatter df=new DataFormatter();
		    		 data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
		    		    
		    		 System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
		    	 }
		     }
		     workbook.close();
		     fis.close();
		     
		  //   for(String[] dataArr : data){
		    //	 System.out.println(dataArr);
		    // }
		     
		     return data;
		     
	}
	
	//used fetch data from excel
	
	public String fetchDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable {
	    FileInputStream fis = new FileInputStream("./src/main/java/TestData/LoginTestdata.xlsx");
	    
	    Workbook book = WorkbookFactory.create(fis);
	    Sheet sheet = book.getSheet(sheetName);

	    if (sheet == null) {
	        throw new IllegalArgumentException("Sheet with name '" + sheetName + "' not found.");
	    }

	    Row row = sheet.getRow(rowNum);

	    if (row == null) {
	        throw new IllegalArgumentException("Row with index " + rowNum + " not found in sheet '" + sheetName + "'.");
	    }

	    Cell cell = row.getCell(cellNum);

	    if (cell == null) {
	        throw new IllegalArgumentException("Cell with index " + cellNum + " not found in sheet '" + sheetName + "', row " + rowNum + ".");
	    }

	    String value = cell.getStringCellValue();
	    book.close();
	    return value;
	}
	
	// used to set data into excel
	public void AddDataIntoExcelFile(String sheetName,int rowNum,int cellNum,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);       
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		book.write(fos);
		fos.flush();
		fos.close();
	}
	
	    
}

	

