/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breaze
 */
public class PropertiesManager {
    private Properties props = new Properties();
    private InputStream input = null;	
    private final String PROPERTIES_ROUTE;
    public PropertiesManager(){
        this.props = new Properties();
        this.PROPERTIES_ROUTE = "./src/config.properties";
        this.readProperties();
    }
    
    private void readProperties(){
        try {
            this.input = new FileInputStream(this.PROPERTIES_ROUTE);
            this.props.load(input);
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    public String[] getNeighbourServers(){
        String neighbours[] = this.props.getProperty("server.neighbours").split(",");
        return neighbours;
    }
    
    public String getBase(){
        String base = this.props.getProperty("server.base");
        return base;
    
    }
    
    public void saveValue(String key, String value){
        try {
            FileOutputStream out = new FileOutputStream(this.PROPERTIES_ROUTE);
            this.props.setProperty("server."+key, value);
            String n = this.props.getProperty("server.neighbours");
            System.out.println("Hola: "+n);
            props.store(out, null);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
