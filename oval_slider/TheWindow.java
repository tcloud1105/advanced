package oval_slider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TheWindow extends JFrame {
    private JSlider slider;
    private Oval_Slider_13 myPanel ;

    public TheWindow(){
        super("Oval Slider");
        myPanel = new Oval_Slider_13();
        myPanel.setBackground(Color.ORANGE);

        slider = new JSlider(SwingConstants.HORIZONTAL,0,200,10);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                myPanel.setD(slider.getValue());
            }
        });

     add(slider, BorderLayout.SOUTH);
     add(myPanel, BorderLayout.CENTER);

    }
}
