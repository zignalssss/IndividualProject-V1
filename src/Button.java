import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {
    private Random random = new Random();
    private ProjectFont font = new ProjectFont();
    private ReadFiles formExcel = new ReadFiles();

    public JButton getRandomButton(){
        JButton buttonRandom = new JButton("Random ");
        buttonRandom.setFont(font.getFont().deriveFont(14f).deriveFont(Font.BOLD));
        buttonRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomNumber = random.nextInt(14);
                formExcel.ReadExcel(randomNumber);
                System.out.println("Random Number: "+randomNumber);
                System.out.println("Open: " + formExcel.getTimeOpen());
                System.out.println("Close: " + formExcel.getTimeClose());
            }
        });
        return buttonRandom;
    }
    public JButton getCheckButton(){
        JButton buttonCheck = new JButton("Check ");
        buttonCheck.setFont(font.getFont().deriveFont(14f).deriveFont(Font.BOLD));
        return buttonCheck;
    }
}
