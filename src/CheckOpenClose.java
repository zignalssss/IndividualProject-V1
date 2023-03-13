import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class CheckOpenClose {
    private Random random = new Random();
    private ReadFiles formExcel = new ReadFiles(1 ,13 ,0,3) ;
    private ArrayList<ArrayList> arrRestaraunt = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> sortArrRestaraunt = new ArrayList<ArrayList>();

    private int numberofRandom;
    public void sortTimeRestaraunt(){
        arrRestaraunt = formExcel.getArrRestaurants();
        LocalTime time1 = LocalTime.parse(formExcel.getCurrentTime());
        for(int i = 0;i < arrRestaraunt.size();i++){
                LocalTime time2 = LocalTime.parse(arrRestaraunt.get(i).get(1).toString());
                LocalTime time3 = LocalTime.parse(arrRestaraunt.get(i).get(2).toString());
                if(time1.isBefore(time3) && time1.isAfter(time2)){
                    sortArrRestaraunt.add(arrRestaraunt.get(i));
                }
        }
    }

    public int RandomIndex(){
        int index = random.nextInt( 13)+1;
        setRandomIndex(index);
        return index;
    }
    public void setRandomIndex(int index){
        this.numberofRandom = index;
    }
    public int getRandomIndex(){
        return this.numberofRandom;
    }
}
