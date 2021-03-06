package network_socket_programing.OneWay_Communications;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {

    final static int PORT=2000;
    
    public static void main(String[] args) throws IOException{
        
        //global server socket.
        ServerSocket serverSocket=null;
        
        //initiaize the socket.
        try{
            serverSocket=new ServerSocket(PORT);
        }catch(IOException e){
            System.out.println("Cant listen to the port no: "+PORT);
        }
        
        //making a general socket for a client
        System.out.println("Waiting for a client");
        
        Socket clientSocket=null;
        try{
            clientSocket=serverSocket.accept();     //waiting for accept a client.
        }catch(IOException e){
            System.out.println("Acception failure...");
        }
        System.out.println("Connection Successfull and listening for input..........");
        
        //for input to the server.
        BufferedReader input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //for output to the server.
        PrintWriter output=new PrintWriter(clientSocket.getOutputStream(),true);      //true means auto flush the output.
        
        String line;        //to take the input.
        while((line=input.readLine())!=null){
            System.out.println("Server:"+line);         //for give to the terminal.
            output.println(line);
            if(line.equals("bye")) break;
            
        }
        output.close();
        input.close();
        clientSocket.close();
        serverSocket.close();
    }
}
