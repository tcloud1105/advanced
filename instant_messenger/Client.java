package instant_messenger;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import oracle.jrockit.jfr.JFR;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
   private JTextField userText;
   private JTextArea chatWindow;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private String message = "";
   private String serverIP;
   private Socket connection;

   // constructor
    public Client(String host){
        super("Tcloud Instant Messenger");
        serverIP = host;
        userText = new JTextField();
        userText.setEditable(false);
        userText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(e.getActionCommand());
                userText.setText("");
            }
        });
        add(userText, BorderLayout.NORTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow), BorderLayout.CENTER);
        setSize(300,150);
        setVisible(true);
    }

    // connect to server
    public void startRunning(){
        try{
            connectToServer();
            setupStreams();
            whileChatting();
        }catch (EOFException eofException){
            showMessage("\n Client terminated connection");
        }catch (IOException ioException){
            ioException.printStackTrace();
        }finally{
            closeConnection();
        }
    }


    // connect to server
    private void connectToServer() throws IOException {
        showMessage("Attempting connection...\n");
        connection = new Socket(InetAddress.getByName(serverIP), 6500);
        showMessage("Connected to: "+connection.getInetAddress().getHostName());

    }

    // set up streams to send and receive messages
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\n your streams are set up");
    }

    // while chatting with server
    private void whileChatting() throws IOException{
        ableToType(true);
        do{
            try{
                message = (String) input.readObject();
                showMessage("\n" + message);
            }catch (ClassNotFoundException classNotFoundException){
                showMessage("\n Message Not Understood");
            }
        }while (!message.equals("SERVER - END"));
    }

    // close the streams and sockets
    private void closeConnection() {
        showMessage("\n closing the connection");
        ableToType(false);
        try{
            output.close();
            input.close();
            connection.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

   // send messages to server
    private void sendMessage(String message){
        try{
            output.writeObject("CLIENT - "+ message);
            output.flush();
            showMessage("\nCLIENT - "+ message);
        }catch (IOException ioException){
            chatWindow.append("\n something went wrong when sending message");
        }
    }

// change/update chatWindow
    private void showMessage(final String m){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatWindow.append(m);
            }
        });
    }

// gives user permission to type information
    private void ableToType(boolean b){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                userText.setEditable(b);
            }
        });
    }



}
