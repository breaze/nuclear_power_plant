/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_layers;

import helpers.PropertiesManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Breaze
 */
public class TCPServer {
    private ServerSocket server;
    private Socket client;
    private int port;
    
    
    public void TCPServer(){
        this.server = null;
    }
    public void runServer(){
        this.readPort();
        try{
            this.server = new ServerSocket(this.port);
            System.out.println("Listening...");
            while(true){
                this.client = this.server.accept();
                System.out.println("Client connected");
                ServerThread sh = new ServerThread(this.client);
                sh.start();
                System.out.println("Client disconnected");
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void readPort(){
        PropertiesManager pm = new PropertiesManager();
        int serverPort = pm.getServerPort();
        this.port = serverPort;
    }
}
