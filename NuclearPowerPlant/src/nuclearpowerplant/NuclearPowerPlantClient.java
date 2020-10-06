/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearpowerplant;

import helpers.NetworkScanner;
import helpers.PortScanner;
import helpers.NeighboursScanner;
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
            NeighboursScanner ns = new NeighboursScanner();
            ns.searchNuclearPowerPlants();
                    
        } catch (SocketException ex) {
            Logger.getLogger(NuclearPowerPlantClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
