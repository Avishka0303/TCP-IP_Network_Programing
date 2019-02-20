package TwoWayChatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    
    static final String IP_ADRESS_OF_SERVER="127.0.0.1";
    static final int PORT_OF_SERVER=2000;
    
    public static void main(String[] args) throws IOException {
        Socket socket=null;     //socket for transmitions
        PrintWriter output=null;        //for give the output.
        BufferedReader input=null;      //for give the input.
        
        try{
            socket=new Socket(IP_ADRESS_OF_SERVER,PORT_OF_SERVER);          //socket for transmit and recive data with server.
            output=new PrintWriter(socket.getOutputStream(),true);               //for give outputs.(auto flushable.)
            input=new BufferedReader(new InputStreamReader(socket.getInputStream()));       //for take input from the server.
        }catch(UnknownHostException e){
            System.out.println("Unknown host.");
            System.exit(1);
        }catch(IOException e1){
            System.out.println("cannot connect to the host");
        }
        
        //input object for clinet to type in terminal 
        BufferedReader standardInput=new BufferedReader(new InputStreamReader(System.in));
        
        //string for user input
        String userInput;
        while((userInput=standardInput.readLine()) != null){
            output.println(userInput);
            System.out.println("Echo : "+input.readLine());
        }
        
        //close the connections.
        standardInput.close();
        input.close();
        output.close();
        socket.close();
    }
}
