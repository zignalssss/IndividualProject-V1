import javax.swing.*;
import java.awt.*;


public class RandResProject{

    private JFrame frame = new JFrame("RandResProject");
    private ProjectFont font = new ProjectFont();
    private ReadFiles formExcel = new ReadFiles();
    RandResProject(){
        setMainPage();
        createJFrame();

    }
    private void createJFrame(){
        frame.setSize(1000,700);
        frame.getContentPane().setBackground(Color.pink);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void setMainPage(){
        ImageFiles image = new ImageFiles();
        Button button = new Button();
        JPanel panelforMainPage = new JPanel();
        JPanel panelForText = new JPanel();
        JPanel panelForImage = new JPanel();
        JPanel panelForButton = new JPanel();
        JPanel panelForCurrentTime = new JPanel();
        JLabel projectText = new JLabel("Random Restaurant Near KUSRC");
        projectText.setFont(font.getFont().deriveFont(17f).deriveFont(Font.BOLD));
        JLabel currentTimeText = new JLabel("Current Time: " + formExcel.getCurrentTime(),JLabel.CENTER);
        panelforMainPage.setLayout(new BoxLayout(panelforMainPage,BoxLayout.Y_AXIS));
        panelForText.add(projectText);
        panelForImage.add(image.getRes1());
        panelForButton.add(button.getRandomButton());
        panelForButton.add(button.getCheckButton());
        panelForCurrentTime.add(currentTimeText);
        panelforMainPage.add(Box.createRigidArea(new Dimension(0,10)));
        panelforMainPage.add(panelForText);
        panelforMainPage.add(Box.createRigidArea(new Dimension(0,30)));
        panelforMainPage.add(panelForImage);
        panelforMainPage.add(Box.createRigidArea(new Dimension(0,30)));
        panelforMainPage.add(panelForCurrentTime);
        panelforMainPage.add(Box.createRigidArea(new Dimension(0,30)));
        panelforMainPage.add(panelForButton);
        frame.add(panelforMainPage);
    }

    public static void main(String[] args) {
        new RandResProject();
    }
}
