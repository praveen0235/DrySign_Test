/*package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import baseinit.Base;


public class FileConversionXLSXToCSV2 {

	
	public void convertExcelToCSV(Sheet sheet, String sheetName,String outputFilePath) {
        StringBuilder data = new StringBuilder();
        
        try {
            Iterator<Row> rowIterator = sheet.iterator();
			 
            //to append the headers
            if(Base.firstIterationRun==true)
        	{
            	Iterator<Row> rowIterator1 = sheet.iterator();
            	Row row = rowIterator1.next();
            	 Iterator<Cell> cellIterator = row.cellIterator();
                 while (cellIterator.hasNext()) {
                     Cell cell = cellIterator.next();

                     CellType type = cell.getCellTypeEnum();
                     if (type == CellType.BOOLEAN) {
                         data.append(cell.getBooleanCellValue());
                     } else if (type == CellType.NUMERIC) {
                         data.append(cell.getNumericCellValue());
                     } else if (type == CellType.STRING) {
                         data.append(cell.getStringCellValue());
                     } else if (type == CellType.BLANK) {
                     } else {
                         data.append(cell + "");
                     }
                     data.append(",");  
                 }
                  
                 data.append('\n');

        	}
            
          //to append the data
            for(int i=1;i<=Base.rowcount;i++)
    		{
            	if(Base.firstIterationRun==true)
            	{
            	if(!Base.suiteXLS.getCellData("TestSuite", "TestStartedTime", i).isEmpty())
				{
            		Row row = rowIterator.next();
            		if(Base.suiteXLS.getCellData("TestSuite", "Result", i).equalsIgnoreCase("PASSED"))
            		{
                
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    CellType type = cell.getCellTypeEnum();
                    if (type == CellType.BOOLEAN) {
                        data.append(cell.getBooleanCellValue());
                    } else if (type == CellType.NUMERIC) {
                        data.append(cell.getNumericCellValue());
                    } else if (type == CellType.STRING) {
                        data.append(cell.getStringCellValue());
                    } else if (type == CellType.BLANK) {
                    } else {
                        data.append(cell + "");
                    }
                    data.append(",");  
                }
                 
                data.append('\n');
				}
            }
    		}else
    		{
    			Boolean test =Base.suiteXLS.getCellData("TestSuite", "TestStartedTime", i).isEmpty();
    			if(!test)
				{
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    CellType type = cell.getCellTypeEnum();
                    if (type == CellType.BOOLEAN) {
                        data.append(cell.getBooleanCellValue());
                    } else if (type == CellType.NUMERIC) {
                        data.append(cell.getNumericCellValue());
                    } else if (type == CellType.STRING) {
                        data.append(cell.getStringCellValue());
                    } else if (type == CellType.BLANK) {
                    } else {
                        data.append(cell + "");
                    }
                    data.append(",");  
                }
                 
                data.append('\n');
            }

    		}
            	
            }
            Files.write(Paths.get(outputFilePath),
                data.toString().getBytes("UTF-8"));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void conversionStart(String inputFilePath,String outputFilePath)
    {
    	FileConversionXLSXToCSV2 app = new FileConversionXLSXToCSV2();
        String path =  inputFilePath;
        //InputStream inp = null;
        try (InputStream inp = new FileInputStream(path)) {
            Workbook wb = WorkbookFactory.create(inp);

            //for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                //System.out.println(wb.getSheetAt(i).getSheetName());
                app.convertExcelToCSV(wb.getSheetAt(0), wb.getSheetAt(0).getSheetName(),outputFilePath);
           // }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}

*/