import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class CheckOpenClose extends ProjectFont{
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
        setSortOpenRestarauntArr(sortOpen);
        setSortCloseRestarauntArr(sortClose);
    }

    public int RandomIndex(){
        int index = random.nextInt(sortOpenArrRestaraunt.size());
        setRandomIndex(index);
        return index;
    }
    public JPanel getRestarautOpenName(){
        JPanel panel = new JPanel();
        for(int i = 0;i < sortOpenArrRestaraunt.size();i++){
            JLabel text = new JLabel((i+1) + ". " + sortOpenArrRestaraunt.get(i).get(1));
            text.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            panel.add(text);
        }
        return panel;
    }
    public JPanel getRestarautCloseName(){
        JPanel panel = new JPanel();
        for(int i = 0;i < sortCloseArrRestaraunt.size();i++){
            JLabel text = new JLabel((i+1) + ". " + sortCloseArrRestaraunt.get(i).get(1));
            text.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            panel.add(text);
        }
        return panel;
    }
    public void setSortOpenRestarauntArr(ArrayList sortArray){
        this.sortOpenArrRestaraunt = sortArray;
    }
    public void setSortCloseRestarauntArr(ArrayList sortArray){
        this.sortCloseArrRestaraunt = sortArray;
    }
    public ArrayList getRestarauntIndex(int index){
        return sortOpenArrRestaraunt.get(index);
    }
    public int getNumberRestaraunt(int index){
        return (int)sortOpenArrRestaraunt.get(index).get(0);
    }
    public ArrayList getSortOpenRestarauntArr(){
        return this.sortOpenArrRestaraunt;
    }
    public ArrayList getSortCloseRestarauntArr(){
        return this.sortOpenArrRestaraunt;
    }
    public void setRandomIndex(int index){
        this.numberofRandom = index;
    }
    public int getRandomIndex(){
        return this.numberofRandom;
    }
}
