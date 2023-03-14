import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageFiles {

    private File starterImage = new File("Starterimage.png");
    private File closeImage = new File("Close.png");
    private File image1 = new File("1.png");
    private File image2 = new File("2.png");
    private File image3 = new File("3.png");
    private File image4 = new File("4.png");
    private File image5 = new File("5.png");
    private File image6 = new File("6.png");
    private File image7 = new File("7.png");
    private File image8 = new File("8.png");
    private File image9 = new File("9.png");
    private File image10 = new File("10.png");
    private File image11 = new File("11.png");
    private File image12 = new File("12.png");
    private File image13 = new File("13.png");
    private CheckOpenClose check = new CheckOpenClose();
    private HashMap< Integer, ImageIcon> rastarauntImage = new HashMap<Integer, ImageIcon>();
    private ImageIcon starterCover = new ImageIcon();
    private ImageIcon closeCover = new ImageIcon();
    private File[] arrFile = {image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13};

    public ImageFiles(){
        int i = 1;
        starterCover = (new ImageIcon(((new ImageIcon(starterImage.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH)));
        closeCover = (new ImageIcon(((new ImageIcon(closeImage.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH)));
        for (File file:arrFile) {
            rastarauntImage.put(i,new ImageIcon(((new ImageIcon(file.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH)));
            i++;
        }
    }
    public ImageIcon getRandomImage(int index){
        return rastarauntImage.get(check.getNumberRestaraunt(index));
    }
    public ImageIcon getImageCover(){
        return this.starterCover;
    }
    public ImageIcon getCloseCover(){
        return this.closeCover;
    }


}
