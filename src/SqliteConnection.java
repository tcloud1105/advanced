import java.sql.*;
import javax.swing.*;

public class SqliteConnection {
    Connection conn=null;

    public static Connection dbConnector(){
        try{
           Class.forName("org.sqlite.JDBC");// download sqlite JDBC Driver:https://bitbucket.org/xerial/sqlite-jdbc
           Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Programming Code\\Java\\jdbc_sqlite_project\\src\\employeeData.sqlite ");
            return conn;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
