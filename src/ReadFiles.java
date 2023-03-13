import java.time.LocalTime;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;

public class ReadFiles {
    private Timer timer;
    private int interval;
    private SimpleDateFormat Format = new SimpleDateFormat("HH:mm");

    private ArrayList<ArrayList> mainArrRestaurants = new ArrayList<ArrayList>();
    ReadFiles(){

    }
     ReadFiles(int startRow, int endRow, int startCol, int endCol){
            try {
                File file = new File("C:\\Users\\zignalssPC\\Desktop\\RestaurantsData.xlsx");   //creating a new file instance
                FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
                //creating Workbook instance that refers to .xlsx file
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
                //iterating over excel file
                for(int i = startRow ; i <= endRow ; i++){
                    ArrayList<String> arrRestaurants = new ArrayList<String>();
                    for(int j = startCol ; j <= endCol; j++) {
                        Cell cell = sheet.getRow(i).getCell(j);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                                arrRestaurants.add(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                                    Date date = cell.getDateCellValue();
                                    arrRestaurants.add(Format.format(date));
                                } else {
                                    double numericValue = cell.getNumericCellValue();
                                    if (numericValue % 1 == 0) {
                                        int intValue = (int) numericValue;

                                        System.out.print(intValue + "\t\t\t");
                                    } else {
                                        System.out.print(numericValue + "\t\t\t");
                                    }
                                }
                                break;
                            default:
                        }
                    }
                    mainArrRestaurants.add(arrRestaurants);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    public ArrayList getArrRestaurants(){
        return this.mainArrRestaurants;
    }
    public String getCurrentTime(){
        Date currentDate = new Date();
        String time = Format.format(currentDate);
        return time;
    }
}
