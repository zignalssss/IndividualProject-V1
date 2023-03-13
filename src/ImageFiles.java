import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class ImageFiles {
    private File image1 = new File("1.jpg");

    private JLabel res1,res2,res3;
    private ArrayList<JLabel> imageArray = new ArrayList<JLabel>();

    public ImageFiles(){
        res1 = new JLabel( new ImageIcon(((new ImageIcon(image1.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH)));
    }
    public JLabel getRandomImage(int index){
        return  null;
    }
    public JLabel getRes1(){
        return this.res1;
    }

}
