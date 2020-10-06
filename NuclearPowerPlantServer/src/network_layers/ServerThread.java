/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_layers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breaze
 */
public class ServerThread extends Thread {

    private Socket client;
    private DataInputStream input;
    private DataOutputStream output;

    public ServerThread(Socket client) {
        try {
            this.client = client;
            this.input = new DataInputStream(this.client.getInputStream());
            this.output = new DataOutputStream(this.client.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void run() {
        try {
            String message = this.input.readUTF();
            System.out.println("server >> " + message);
            this.output.writeUTF("Hola Perras :v ");
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
    }
    
    public final void disconnect() {
        try {
            this.client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
