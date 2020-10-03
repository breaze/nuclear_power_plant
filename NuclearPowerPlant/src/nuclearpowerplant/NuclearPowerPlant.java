/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearpowerplant;

import helpers.HostScanner;

/**
 *
 * @author Breaze
 */
public class NuclearPowerPlant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HostScanner hs = new HostScanner();
        hs.checkHosts();
        //hs.getIp();
    }
    
}
