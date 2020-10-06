/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_layer;

import com.sun.corba.se.spi.activation.Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Breaze
 */
public class TCPClient {
    private String server;
    private int port;
    private Socket client;
    private DataInputStream input;
    private DataOutputStream output;
    
    public TCPClient(String server, int port){
        this.server = server;
        this.port = port;
    }
    
    public void connect(){
        try {
            this.client = new Socket(this.server, this.port);
            this.input = new DataInputStream(this.client.getInputStream());
            this.output = new DataOutputStream(this.client.getOutputStream());
            this.output.writeUTF("discharge:0:110");
            String response = this.input.readUTF();
            System.out.println(response);
            this.client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
