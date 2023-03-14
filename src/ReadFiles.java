import java.time.LocalTime;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;

public class ReadFiles<T> {
    private Timer timer;
    private int interval;
    private SimpleDateFormat Format = new SimpleDateFormat("HH:mm");

    private ArrayList<ArrayList<T>> mainArrRestaurants = new ArrayList<ArrayList<T>>();
    ReadFiles(){

    }
    public ReadFiles(int startRow, int endRow, int startCol, int endCol) {
        try {
            File file = new File("C:\\Users\\zignalssPC\\Desktop\\RestaurantsData.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            //iterating over excel file
            for (int i = startRow; i <= endRow; i++) {
                ArrayList<T> arrRestaurants = new ArrayList<T>();
                for (int j = startCol; j <= endCol; j++) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING: // field that represents string cell type
                            arrRestaurants.add((T) cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                arrRestaurants.add((T) Format.format(date));
                            } else {
                                double numericValue = cell.getNumericCellValue();
                                if (numericValue % 1 == 0) {
                                    int intValue = (int) numericValue;
                                    arrRestaurants.add((T) Integer.valueOf(intValue));
                                } else {
                                    arrRestaurants.add((T) Double.valueOf(numericValue));
                                }
                            }
                            break;
                        default:
                    }
                }
                mainArrRestaurants.add(arrRestaurants);
            }
        } catch (Exception e) {
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
