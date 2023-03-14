import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.jar.JarEntry;


public class RandResProject extends ProjectFont{
    private JFrame frame = new JFrame("RandResProject");
    private Color color = new Color(255,235,205);
    private ReadFiles formExcel = new ReadFiles() ;
    private JPanel panelforMainPage = new JPanel();
    private JPanel panelforCheckPage  = new JPanel();
    private CheckOpenClose check = new CheckOpenClose();
    private Button button = new Button();
    RandResProject(){
        setMainPage();
        setCheckPage();
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
        JPanel panelForText = new JPanel();
        JPanel panelForImage = new JPanel();
        JPanel panelForButton = new JPanel();
        JPanel panelForCurrentTime = new JPanel();
        JLabel restarauntImage = new JLabel();
        JLabel projectText = new JLabel("Random Restaurant Near KUSRC");
        restarauntImage.setIcon(image.getImageCover());
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
        panelForImage.add(restarauntImage);
        panelForButton.add(button.getRandomButton(restarauntImage));
        panelForButton.add(button.getCheckButton(panelforMainPage,panelforCheckPage));
        panelForCurrentTime.add(currentTimeText);
        panelForText.setBackground(color);
        panelForImage.setBackground(color);
        panelForCurrentTime.setBackground(color);
        panelForButton.setBackground(color);
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
    private void setCheckPage(){
        Button button = new Button();
        panelforCheckPage = new JPanel();
        JPanel panelForTextOpen = new JPanel();
        JPanel panelForTextClose = new JPanel();
        JPanel panelForHold = new JPanel();
        JPanel panelOpen = new JPanel();
        JPanel panelClose = new JPanel();
        JPanel panelTextPage = new JPanel();
        JPanel panelBackButton = new JPanel();
        JLabel checkStatus = new JLabel("Check Restaraunt",JLabel.CENTER);
        JLabel open = new JLabel("Open",JLabel.CENTER);
        JLabel close = new JLabel("Close",JLabel.CENTER);
        JScrollPane scrollFrameOpen = new JScrollPane(check.getRestarautOpenName());
        JScrollPane scrollFrameClose = new JScrollPane(check.getRestarautCloseName());
        scrollFrameOpen.setPreferredSize(new Dimension( 200,450));
        scrollFrameClose.setPreferredSize(new Dimension( 200,450));
        scrollFrameOpen.setAutoscrolls(true);
        panelForTextOpen.setLayout(new BoxLayout(panelForTextOpen,BoxLayout.Y_AXIS));
        panelForTextClose.setLayout(new BoxLayout( panelForTextClose,BoxLayout.Y_AXIS));
        panelForHold.setLayout(new BoxLayout(panelForHold,BoxLayout.X_AXIS));
        panelforCheckPage.setLayout(new BoxLayout(panelforCheckPage,BoxLayout.Y_AXIS));
        panelforCheckPage.setPreferredSize(new Dimension( 800,600));
        open.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        close.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        checkStatus.setFont(getFont().deriveFont(17f).deriveFont(Font.BOLD));
        panelBackButton.add(button.getBackButton(panelforMainPage,panelforCheckPage));
        panelOpen.add(open);
        panelClose.add(close);
        panelTextPage.add(checkStatus);
        panelForTextOpen.add(panelOpen);
        panelForTextOpen.add(scrollFrameOpen);
        panelForTextClose.add(panelClose);
        panelForTextClose.add(scrollFrameClose);
        panelForHold.add(panelForTextOpen);
        panelForHold.add(panelForTextClose);
        panelforCheckPage.add(Box.createRigidArea(new Dimension(0,30)));
        panelforCheckPage.add(panelTextPage);
        panelforCheckPage.add(Box.createRigidArea(new Dimension(0,50)));
        panelforCheckPage.add(panelForHold);
        panelforCheckPage.add(panelBackButton);

        frame.add(panelforCheckPage);

    }

    public static void main(String[] args) {
        new RandResProject();
    }
}
