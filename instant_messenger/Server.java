package instant_messenger;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ServerSocket server;
    private Socket connection;

    // constructor
    public Server(){
        super("Tcloud Instant Messenger");
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
        add(new JScrollPane(chatWindow));
        setSize(300,150);
        setVisible(true);
    }
   // set up and run the server
    public void startRunning(){
        try{
            server = new ServerSocket(6500,100);
            while(true){
                try{
                    // connect and have the conversation
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                }catch (EOFException eofException){
                    showMessage("\n Server ended the connection!");
                }finally {
                    closeConnection();
                }
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }


    // wait for connection, then display connection information
    private void waitForConnection() throws IOException{
        showMessage("Waiting for someone to connect...\n");
        connection = server.accept();
        showMessage("Now connected to " + connection.getInetAddress().getHostName());
    }

    // get stream to send and receive data
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\n Streams are now setup! \n");
    }

    // during the chat conversation
    private void whileChatting() throws IOException{
        String message = " You are now connected! ";
        sendMessage(message);
        ableToType(true);
        do{
            // have a conversation
            try{
                message = (String) input.readObject();
                showMessage("\n"+message);
            }catch (ClassNotFoundException classNotFoundException){
                showMessage("\n message not understood");
            }
        }while(!message.equals("CLIENT - END"));
    }

    // close streams and sockets after you are done chatting
    private void closeConnection() {
        showMessage("\n Closing connections...\n");
        ableToType(false);
        try{
           output.close();
           input.close();
           connection.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    // send a message to client
    private void sendMessage(String message) {
        try{
           output.writeObject("SERVER - "+ message);
           output.flush();
           showMessage("\nSERVER - "+ message);
        }catch (IOException ioException){
            chatWindow.append("\n ERROR, MESSAGE NOT SENT");
        }

    }

    // updates chatWindow
    private void showMessage(final String text){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatWindow.append(text);
            }
        });
    }

    // let user type text into their box
    private void ableToType(boolean b) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               userText.setEditable(b);
            }
        });
    }















}
