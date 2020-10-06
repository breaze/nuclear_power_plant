/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearpowerplantserver;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import network_layers.PortEntrance;
import network_layers.TCPServer;

/**
 *
 * @author Breaze
 */
public class NuclearPowerPlantServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        server.runServer();
        
        //PortEntrance pe = new PortEntrance();
        //pe.runServer();
    }
    
}
