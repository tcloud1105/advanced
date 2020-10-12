import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame {
    private JButton button1;
    private JTable table;
    private Connection conn = null;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField eid;
    private JTextField ename;
    private JTextField esurname;
    private JTextField eage;
    private JTextField search;
    private JButton save;
    private JButton update;
    private JButton delete;
    private JComboBox comboBox;
    private JList list;
    private JComboBox selectedChoice;

    public void refreshTable(){
        try{
            String query = "select EID,Name,Surname,Age from employeeInfo";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            // download rs2xml jar to load data to your table
            //table.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void fillComboBox(){
        try{
            String query = "select * from employeeInfo";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                comboBox.addItem(rs.getString("Name"));
            }

            pst.close();
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void loadList(){
        try{
            String query = "select * from employeeInfo";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            DefaultListModel lm = new DefaultListModel();
            while(rs.next()){
                lm.addElement(rs.getString("Name"));
            }

            list.setModel(lm);
            pst.close();
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public EmployeeInfo(){
        super("employee info");
        setLayout(new FlowLayout());

        label1 = new JLabel("EID"); eid = new JTextField(10);
        label2 = new JLabel("Name"); ename = new JTextField(10);
        label3 = new JLabel("Surname"); esurname = new JTextField(10);
        label4 = new JLabel("Age"); eage = new JTextField(10);
        save = new JButton("Save");
        update = new JButton("Update");
        delete = new JButton("Delete");
        conn = SqliteConnection.dbConnector();
        button1 = new JButton("Load Employee Data");
        comboBox = new JComboBox();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   String query = "select EID,Name,Surname,Age from employeeInfo";
                   PreparedStatement pst = conn.prepareStatement(query);
                   ResultSet rs = pst.executeQuery();
                   // download rs2xml jar to load data to your table
                   //table.setModel(DbUtils.resultSetToTableModel(rs));

                   pst.close();
                   rs.close();
               }catch (Exception ex){
                   ex.printStackTrace();
               }

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "insert into EmployeeInfo (EID, Name, Surname,Age) VALUES (?,?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, eid.getText());
                    pst.setString(2, ename.getText());
                    pst.setString(3, esurname.getText());
                    pst.setString(4, eage.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Saved");
                    pst.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                refreshTable();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "update EmployeeInfo set Name=?, Surname=?, Age=? where EID=?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, ename.getText());
                    pst.setString(2, esurname.getText());
                    pst.setString(3, eage.getText());
                    pst.setString(4, eid.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Updated");
                    pst.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                refreshTable();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
                if(action==0){
                try{
                    String query = "delete from EmployeeInfo where EID = ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, eid.getText());

                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Deleted");
                    pst.close();
                }catch (Exception ex){
                  ex.printStackTrace();
                }
                refreshTable();
             }
            }
        });

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{

                    String query = "select * from employeeInfo where Name=? ";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, (String)comboBox.getSelectedItem());
                    ResultSet rs = pst.executeQuery();

                    while(rs.next()){
                        eid.setText(rs.getString("EID"));
                        ename.setText(rs.getString("Name"));
                        esurname.setText(rs.getString("Surname"));
                        eage.setText(rs.getString("Age"));
                    }

                    pst.close();
                    rs.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try{
                    int row = table.getSelectedRow();
                    String EID = (String)table.getModel().getValueAt(row,0);
                    String query = "select * from employeeInfo where EID=? ";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, EID);
                    ResultSet rs = pst.executeQuery();

                    while(rs.next()){
                        eid.setText(rs.getString("EID"));
                        ename.setText(rs.getString("Name"));
                        esurname.setText(rs.getString("Surname"));
                        eage.setText(rs.getString("Age"));
                    }

                    pst.close();
                    rs.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        selectedChoice.setModel(new DefaultComboBoxModel(new String[]{"EID","Name","Surname","Age"}));
        search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try{

                    String selection = (String) selectedChoice.getSelectedItem();
                    String query = "select * from employeeInfo where "+selection+"=? ";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, search.getText());
                    ResultSet rs = pst.executeQuery();

                   // table.setModel(DbUtils.resultSetToTableModel(rs));
                    pst.close();
                    rs.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(label1); add(eid); add(label2);add(ename);add(label3);add(esurname);
        add(label4);add(eage);add(save);add(update);add(delete);add(comboBox);
        add(list);
        add(label5); add(search);add(selectedChoice);
        add(button1);
        add(new JScrollPane(table));
        refreshTable();
        fillComboBox();
        loadList();

        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




























}
