package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Specific_data {
	public String FIRSTNAME,LASTNAME,POSTALCODE;
	public void spData() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Test_data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		FIRSTNAME=sh.getRow(1).getCell(0).getStringCellValue();
		LASTNAME=sh.getRow(1).getCell(1).getStringCellValue();
		POSTALCODE=sh.getRow(1).getCell(2).getStringCellValue();
	}

}
