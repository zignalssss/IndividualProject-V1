import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Button extends ProjectFont{
    private CheckOpenClose check = new CheckOpenClose();
    private ImageFiles image = new ImageFiles();
    public JButton getRandomButton(JLabel restarauntImage){
        JButton buttonRandom = new JButton("Random");
        buttonRandom.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        buttonRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(check.getSortOpenRestarauntArr());
                if(check.getSortOpenRestarauntArr().isEmpty()){
                    restarauntImage.setIcon(image.getCloseCover());
                }else{
                    check.getRestarauntIndex(check.RandomIndex());
                    restarauntImage.setIcon(image.getRandomImage(check.getRandomIndex()));
                }
            }
        });
        return buttonRandom;
    }
    public JButton getCheckButton(JPanel MainFrame, JPanel CheckPage){
        JButton buttonCheck = new JButton("Check");
        buttonCheck.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        buttonCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.setVisible(false);
                CheckPage.setVisible(true);
            }
        });
        return buttonCheck;
    }
    public JButton getBackButton(JPanel MainFrame, JPanel CheckPage){
        JButton backButton = new JButton("Back");
        backButton.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.setVisible(true);
                CheckPage.setVisible(false);
            }
        });
        return backButton;
    }
}
