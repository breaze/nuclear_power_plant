/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breaze
 */
public class HostScanner {
    public void checkHosts(){
        PropertiesManager pm = new PropertiesManager();
        String base = pm.getBase();
        ArrayList<String> neighbours = new ArrayList<>();
        int timeout = 100;
        //TODO: Assign value 1 to i and j variables and change the exit condition of the loops to
        // < 255
        for (int i = 23; i <= 24; i++)
        {       
            for(int j = 40; j <= 46; j++){
                try {
                    String host = base + "." + i+"."+j;  
                    if (InetAddress.getByName(host).isReachable(timeout))
                    {
                        System.out.println(host + " is reachable");
                        neighbours.add(host);
                    }
                    else
                        System.out.println(host);
                } catch (IOException ex) {
                    Logger.getLogger(HostScanner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.saveNeighbours(neighbours);
    }
    
    private void saveNeighbours(ArrayList<String> neighbours){
        String value = "";
        for(int i = 0; i < neighbours.size(); i++){
            if(i<(neighbours.size()-1))
                value += neighbours.get(i)+",";
            else
                value +=neighbours.get(i);
        }
        PropertiesManager pm = new PropertiesManager();
        pm.saveValue("neighbours", value);
    }
}
