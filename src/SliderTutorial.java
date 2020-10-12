import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderTutorial extends JFrame {
    JSlider slider;
    JLabel label;
    JProgressBar b;

    public SliderTutorial(){
        setLayout(new FlowLayout());
        slider = new JSlider(JSlider.HORIZONTAL,0,20,0);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        add(slider);

        b = new JProgressBar(JProgressBar.HORIZONTAL,0,20);
        b.setAutoscrolls(true);
        add(b);
        label = new JLabel("Current value: 0");
        add(label);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int current = slider.getValue();
                label.setText("Current value: "+current);
                b.setValue(current);
            }
        });

    }
}
