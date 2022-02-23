package com.KK.generic;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtilities {
    public static String readData( String filePath, String sheet, int row, int cell){
        String value = null;
       try{
           Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)));
           value= workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (InvalidFormatException e) {
           e.printStackTrace();
       }
            return value;
    }
}
