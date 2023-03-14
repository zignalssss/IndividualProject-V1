import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Button extends ProjectFont{
    private CheckOpenClose check = new CheckOpenClose();
    public JButton getRandomButton(){
        JButton buttonRandom = new JButton("Random ");
        buttonRandom.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        buttonRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(check.getRestarauntIndex(check.RandomIndex()));
            }
        });
        return buttonRandom;
    }
    public JButton getCheckButton(){
        JButton buttonCheck = new JButton("Check ");
        buttonCheck.setFont(getFont().deriveFont(14f).deriveFont(Font.BOLD));
        return buttonCheck;
    }
}
