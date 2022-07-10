package utils;

import org.openqa.selenium.WebDriver;

public class Utility {
	
	// Screnshot
	public static void capturetScreen(WebDriver driver, int testID) {
		
		String path = "test-output\\Screeshshot\\Test-" ;
		
		// Code 
		// Image Name ->  Test+TestID+SystemDate&Time
		//                Test-101 07-07-2022 08:08:08
	}
	
	// Excelsheet
	// Sheet Row Cell
	public static String getDataFromExcel(String sheet, int row, int cel) {
		// 
		// Code 
		String path = "src\\main\\resource\\TestData\\testing.xlsx";
		String data ;
		
		try {
			data = getStringCellValue();
		}
		catch(Exception e)
		{
			double value = getNumericCellValue();
			data = value to String ;
			// how to convert  double/int to String in java
		}
		
		return data ;
	}
	
	

}
