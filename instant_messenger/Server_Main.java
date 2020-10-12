package instant_messenger;

import javax.swing.*;

public class Server_Main {
    public static void main(String[] args){
        Server server = new Server();
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        server.startRunning();
    }
}
