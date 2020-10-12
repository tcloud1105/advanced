package applets;

import javax.swing.*;
import java.awt.*;

public class Applet_In_Action_12 extends JApplet {

    private double sum;

    public void init(){
        String fn = JOptionPane.showInputDialog("Enter first number");
        String sn = JOptionPane.showInputDialog("Enter second number");

        double n1 = Double.parseDouble(fn);
        double n2 = Double.parseDouble(sn);

        sum = n1 + n2;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawString("The sum is "+sum,25,25);
    }
}
