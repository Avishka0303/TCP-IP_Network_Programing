package SampleSocket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WhoIs {

    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("whois.internic.net", 43);
        //for get input
        InputStream input=socket.getInputStream();
        //for output 
        OutputStream output=socket.getOutputStream();
        //Stirng host
        String string="infiniteskills.com\n";
        //String turn into byte Stream;
        byte buffer[]=string.getBytes();    System.out.println("in byte : "+buffer);
        //send the command to the socket.
        output.write(buffer);
        
        //to read the input character.
        int ch;
        //get the input write back
        while((ch=input.read())!=-1){
            System.out.print((char)ch);
        }
        //close the socket.
        socket.close();
    } 
}
