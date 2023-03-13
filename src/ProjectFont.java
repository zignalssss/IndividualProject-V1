import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ProjectFont {
    private Font Kanit;
    public ProjectFont(){
        try{
            Kanit = Font.createFont(Font.TRUETYPE_FONT,new File("Kanit-Light.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("Kanit-Light.ttf")));
        }catch (IOException | FontFormatException e){
            e.printStackTrace();
        }
    }
    public Font getFont(){
        return Kanit;
    }

}
