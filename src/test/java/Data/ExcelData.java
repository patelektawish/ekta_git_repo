package Data;

import config.AppConfig;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {

        @DataProvider
        public Iterator<Object[]> excelDP(){

            //Create main data list
            List<Object[]> data = new ArrayList<>();


            // Read the file as inputstream
            try {
                InputStream stream = new FileInputStream(AppConfig.getProperty("datafile-name"));

                // create excel workbook
                Workbook workbook = new XSSFWorkbook(stream);

                // select the excelsheet and read that in Sheet object
                Sheet selectedSheet = workbook.getSheet("Demo");


                //Sheet has rows and cells
                // first we will loop throw rows, using rows iterator

                Iterator<Row> rowIterator = selectedSheet.rowIterator();

                // Now we have rowIterator, use while loop to read row
                while (rowIterator.hasNext()){
                    //next() will return actual Row

                    Row row = rowIterator.next();

                    //we got thr Row in variable row, now we will create a Object Array
                    List<Object> dataFromCell = new ArrayList<>();
                    // to Loop through cells we need cell iterator
                    Iterator<Cell> cellIterator = row.cellIterator();
                    // we have iterator , now lets put while loop to get all values
                    while (cellIterator.hasNext()){
                        Cell cell = cellIterator.next();
                        if(cell.getCellTypeEnum()== CellType.NUMERIC){
                            dataFromCell.add(cell.getNumericCellValue());
                        }
                        if(cell.getCellTypeEnum()== CellType.STRING){
                            dataFromCell.add(cell.getStringCellValue());
                        }
                        if(cell.getCellTypeEnum()== CellType.BOOLEAN){
                            dataFromCell.add(cell.getBooleanCellValue());
                        }
                        if(cell.getCellTypeEnum()== CellType.FORMULA){
                            dataFromCell.add(cell.getNumericCellValue());
                        }


                    }
                    data.add(dataFromCell.toArray());
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
            return data.iterator();
        }
    }


