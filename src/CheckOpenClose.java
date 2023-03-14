import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class CheckOpenClose {
    private Random random = new Random();
    private ReadFiles formExcel = new ReadFiles(1 ,13 ,0,3) ;
    private ArrayList<ArrayList> arrRestaraunt = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> sortOpenArrRestaraunt = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> sortCloseArrRestaraunt = new ArrayList<ArrayList>();
    private int numberofRandom;
    public CheckOpenClose(){
        ArrayList<ArrayList> sortOpen = new ArrayList<ArrayList>();
        ArrayList<ArrayList> sortClose = new ArrayList<ArrayList>();
        arrRestaraunt = formExcel.getArrRestaurants();
        LocalTime time1 = LocalTime.parse(formExcel.getCurrentTime());
        for(int i = 0;i < arrRestaraunt.size();i++){
                LocalTime time2 = LocalTime.parse(arrRestaraunt.get(i).get(2).toString());
                LocalTime time3 = LocalTime.parse(arrRestaraunt.get(i).get(3).toString());
                if(time1.isBefore(time3) && time1.isAfter(time2)){
                    sortOpen.add(arrRestaraunt.get(i));
                }else{
                    sortClose.add(arrRestaraunt.get(i));
                }
        }
        setSortOpenArr(sortOpen);
        setSortCloseArr(sortClose);
    }

    public int RandomIndex(){
        int index = random.nextInt(sortOpenArrRestaraunt.size());
        setRandomIndex(index);
        return index;
    }
    public void setSortOpenArr(ArrayList sortArray){
        this.sortOpenArrRestaraunt = sortArray;
    }
    public void setSortCloseArr(ArrayList sortArray){
        this.sortCloseArrRestaraunt = sortArray;
    }
    public ArrayList getRestarauntIndex(int index){
        return sortOpenArrRestaraunt.get(index);
    }
    public ArrayList getSortArr(){
        return this.sortOpenArrRestaraunt;
    }
    public void setRandomIndex(int index){
        this.numberofRandom = index;
    }
    public int getRandomIndex(){
        return this.numberofRandom;
    }
}
