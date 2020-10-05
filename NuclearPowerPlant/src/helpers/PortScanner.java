/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breaze
 */
public class PortScanner {
    private DatagramSocket socket;
    public PortScanner() throws SocketException
    {
        this.socket = new DatagramSocket();
    }
    
    public boolean send(String msg, String server, int port) throws UnknownHostException, IOException
    {
        boolean isConnected = false;
        InetAddress host = InetAddress.getByName(server);        
        int puerto = 9020;
        
        byte[] buffer = msg.getBytes();

        DatagramPacket request = 
                new DatagramPacket(buffer, buffer.length, host, puerto);
        if(!this.socket.isConnected())
            return isConnected;
        this.socket.send(request);
        return isConnected;
    }
    
    public void scanPort(){
        PropertiesManager pm = new PropertiesManager();
        String portRange[] = pm.getPortRange();
        String onNetwork[] = pm.getOnNetwork();
        ArrayList<String> neighbours = new ArrayList();
        ArrayList<Integer> ports = new ArrayList();
        int startPort = Integer.parseInt(portRange[0]);
        int finalPort = Integer.parseInt(portRange[1]);
        System.out.println("Scanning ports...");
        for(String server : onNetwork)
        {
            for(int i = startPort; i <= finalPort; i++){
                boolean isConnected;
                try {
                    isConnected = this.send("exist", server, i);
                    if(!isConnected)
                        continue;
                    String response = this.getResponse();
                    if(response.equals("true"))
                    {
                        neighbours.add(server);
                        ports.add(i);
                        System.out.println(server+" is reachable in port: "+i);
                    }       
                } catch (IOException ex) {
                    System.out.println("Error: "+ ex);
                }
            }
        }
        this.saveNeighbours(neighbours, ports);
        
    }
    public String getResponse() throws IOException
    {
        byte[] buffer = new byte[10];

        DatagramPacket request = 
                new DatagramPacket(buffer, buffer.length);
        this.socket.receive(request);
        //System.out.println(new String(request.getData()));
        return new String(request.getData());
    }
    
    public void saveNeighbours(ArrayList<String> serverList, ArrayList<Integer> serverPorts){
        PropertiesManager pm = new PropertiesManager();
        String servers = "";
        String ports = "";
        for(int i = 0; i < serverList.size(); i++){
            
            servers += (i<serverList.size()-1)?serverList.get(i)+",":serverList.get(i);
            ports += (i<serverPorts.size()-1)?serverPorts.get(i)+",":serverPorts.get(i);
        }
        pm.saveValue("neighbours", servers);
        pm.saveValue("ports", ports);
    }
}
