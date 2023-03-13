import java.time.LocalTime;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFiles {
    private SimpleDateFormat Format = new SimpleDateFormat("HH:mm");
    private String TimeOpenNumeric,TimeCloseNumeric,Restaurants;

        public ReadFiles(){

        }
        public void ReadExcel(int index){
        try {
            File file = new File("C:\\Users\\zignalssPC\\Desktop\\RestaurantsData.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            //iterating over excel file
            for(int i = 1 ; i <= 3 ; i++) {
                Cell cell = sheet.getRow(index).getCell(i);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                        setRestaurants(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                        if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                            Date date = cell.getDateCellValue();
                            if(i == 2){
                                setTimeOpen(Format.format(date));

                            }else if (i == 3){
                                setTimeClose(Format.format(date));
                            }
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
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setTimeOpen(String time){
            this.TimeOpenNumeric = time;
    }
    public void setTimeClose(String time){
            this.TimeCloseNumeric =time;
    }
    public void setRestaurants(String restaurants){
            this.Restaurants = restaurants;
    }
    public String getRestaurants(){
            return this.Restaurants;
    }
    public String getTimeOpen(){
            return this.TimeOpenNumeric;
    }
    public String getTimeClose(){
            return this.TimeCloseNumeric;
    }
    public String getCurrentTime(){
        Date currentDate = new Date();
        String time = Format.format(currentDate);
        return time;
    }
}
