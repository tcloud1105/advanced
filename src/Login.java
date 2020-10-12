import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {

    private Connection conn = SqliteConnection.dbConnector();
    private JLabel label1;
    private JLabel label2;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private GridLayout grid;
    public Login(){
        super("login");
        setLayout(null);
        setBounds(100,100,485,407);
        label1 = new JLabel("Username");
        label1.setBounds(140,91,59,27);
        add(label1);

        label2 = new JLabel("Password");
        label1.setBounds(140,139,46,14);
        add(label1);

        username = new JTextField(10);
        username.setBounds(219,79,200,50);
        add(username);

        password = new JPasswordField(10);
        password.setBounds(219,139,193,17);
        add(password);

        login = new JButton("Login");
        login.setIcon(new ImageIcon(getClass().getResource("x.png")));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "select * from EmployeeInfo where username=? and password=?";
                PreparedStatement pst = null;
                try{
                    pst = conn.prepareStatement(query);
                    pst.setString(1,username.getText());
                    pst.setString(2, password.getText());
                    ResultSet rs = pst.executeQuery();
                    int count = 0;
                    while(rs.next()){
                      count = count + 1;

                    }
                    if(count==1){
                        JOptionPane.showMessageDialog(null,"username and password is correct");
                        dispose();
                        EmployeeInfo einfo = new EmployeeInfo();
                        einfo.setVisible(true);
                    }else if(count > 1){
                        JOptionPane.showMessageDialog(null,"duplicate username and password");
                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect username/password, try again...");
                    }
                    rs.close();
                    pst.close();
                }catch (Exception exception){
                   JOptionPane.showMessageDialog(null,exception);
                }
            }
        });
        login.setBounds(172,231,200,50);
        add(login);
    }















}
