import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class RandResProject extends ProjectFont{
    private JFrame frame = new JFrame("RandResProject");
    private Color color = new Color(255,235,205);
    private ReadFiles formExcel = new ReadFiles() ;
    RandResProject(){
        setMainPage();
        createJFrame();
    }
    private void createJFrame(){

        frame.setSize(1000,700);
        frame.getContentPane().setBackground(color);
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
        projectText.setFont(getFont().deriveFont(17f).deriveFont(Font.BOLD));
        JLabel currentTimeText = new JLabel("Current Time: " + formExcel.getCurrentTime(),JLabel.CENTER);
        currentTimeText.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        panelforMainPage.setLayout(new BoxLayout(panelforMainPage,BoxLayout.Y_AXIS));
        Timer timer = new Timer(1000, e -> {
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = time.format(formatter);
            currentTimeText.setText("Current Time: " + formattedTime);
        });
        timer.start();
        panelForText.add(projectText);
        panelForImage.add(image.getImageCover());
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
        panelforMainPage.setBackground(color);
        frame.add(panelforMainPage);
    }

    public static void main(String[] args) {
        new RandResProject();
    }
}
