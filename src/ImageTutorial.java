import javax.swing.*;
import java.awt.*;

public class ImageTutorial extends JFrame {
    private ImageIcon image1;
    private JLabel label1;
    private ImageIcon image2;
    private JLabel label2;

    public ImageTutorial(){
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("plane.jpg"));
        label1 = new JLabel(image1);
        add(label1);

        image2 = new ImageIcon(getClass().getResource("earth.jpg"));
        label2 = new JLabel(image1);
        add(label2);
    }
}
