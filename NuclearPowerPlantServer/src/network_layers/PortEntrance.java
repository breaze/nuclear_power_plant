/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_layers;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Breaze
 */
public class PortEntrance {
    private final int PORT = 9020;
    private DatagramSocket socket = null;
    
    public PortEntrance() throws SocketException{
        this.socket = new DatagramSocket(this.PORT);
    }
    
    public void runServer() throws IOException
    {
        
        while(true)
        {
            String response = null;
            byte[] buffer = new byte[1000];
            
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);	
            System.out.println("Listening...");
            this.socket.receive(request);
            //The client should send the information in the next format: function:word:definition
            String data = new String(request.getData());
            System.out.println("server << ("+data+")");
            if(data.equals("close"))
            {
                send("close", request.getAddress(), request.getPort());
                break;
            }else
            {
                response = "error";
                if(data.equals("exist"))
                    response = data.toUpperCase();
                this.send(response, request.getAddress(), request.getPort());
            }
        }
        System.out.println("End of the process");
    }
    
    private void send(String msg, InetAddress host, int port) throws IOException
    {
        byte[] buffer = msg.getBytes();

        DatagramPacket response = 
                new DatagramPacket(buffer, buffer.length, host, port);

        this.socket.send(response);
    }
}
