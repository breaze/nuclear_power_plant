/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearpowerplant;

import helpers.HostScanner;
import helpers.PortScanner;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breaze
 */
public class NuclearPowerPlantClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            HostScanner hs = new HostScanner();
            PortScanner ps = new PortScanner();
            //hs.checkHosts();
            ps.scanPort();
            
            //hs.getIp();
        } catch (SocketException ex) {
            Logger.getLogger(NuclearPowerPlantClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
