import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class show_date extends JFrame {
    private JLabel lblclock;

    public void clock(){
        Thread clock = new Thread(){
            public void run(){
                try {
                    for(;;) {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);

                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);

                        lblclock.setText("Time  " + hour + ":" + minute + ":" + second + "   Date  " + year + "/" + month + "/" + day);
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
   clock.start();
    }
    public show_date(){
        super("date and time");
        lblclock = new JLabel("Clock");
        lblclock.setFont(new Font("Tahoma",Font.BOLD,14));
        lblclock.setBounds(20,61,392,166);
        clock();
        getContentPane().setBackground(new Color(255,255,200));
        add(lblclock);

    }
}
