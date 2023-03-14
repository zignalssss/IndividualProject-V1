import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class ImageFiles {
    private ArrayList<JLabel> arrImage = new ArrayList<JLabel>();
    private File starterImage = new File("Starterimage.png");
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
    
    private ArrayList<JLabel> imageArray = new ArrayList<JLabel>();
    private File[] arrFile = {starterImage,image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13};

    public ImageFiles(){
        for (File file:arrFile) {
            imageArray.add(new JLabel( new ImageIcon(((new ImageIcon(file.getAbsolutePath())).getImage()).getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH))));
        }
    }
    public JLabel getRandomImage(int index){
        return  null;
    }
    public JLabel getImageCover(){
        return this.imageArray.get(0);
    }


}
