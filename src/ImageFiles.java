import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class ImageFiles {
    private File starterImage = new File("Starterimage.png");
    private File image1 = new File("1.jpg");
    private File image2 = new File("2.png");

    private JLabel imageCover,res1,res2,res3;
    private ArrayList<JLabel> imageArray = new ArrayList<JLabel>();

    public ImageFiles(){
        imageCover = new JLabel( new ImageIcon(((new ImageIcon(starterImage.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH)));
        res1 = new JLabel( new ImageIcon(((new ImageIcon(image1.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH)));
        res2 = new JLabel( new ImageIcon(((new ImageIcon(image2.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH)));
    }
    public JLabel getRandomImage(int index){
        return  null;
    }
    public JLabel getImageCover(){
        return this.imageCover;
    }
    public JLabel getRes1(){
        return this.res1;
    }
    public JLabel getRes2(){
        return this.res2;
    }

}
