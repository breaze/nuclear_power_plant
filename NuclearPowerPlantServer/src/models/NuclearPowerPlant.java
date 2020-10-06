/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import exceptions.DamagedReactorException;
import exceptions.ReactorAlreadyOffException;
import exceptions.ReactorAlreadyOnException;

/**
 *
 * @author Breaze
 */
public class NuclearPowerPlant {
    private final NuclearReactor reactors[];
    
    public NuclearPowerPlant(){
        this.reactors = new NuclearReactor[3];
    }
    
    public boolean turnOn(int reactor){
        boolean res = false;
        try
        {
            res = this.reactors[reactor].turnOn();
        }catch(DamagedReactorException | ReactorAlreadyOnException e){
            System.out.println(e.getMessage());
        }
        return res;
        
    }
    
    public boolean turnOff(int reactor){
        boolean res = false;
        try
        {
            res = this.reactors[reactor].turnOff();
        }catch(DamagedReactorException | ReactorAlreadyOffException e){
            System.out.println(e.getMessage());
        }
        return res;
        
    }
    
    public boolean chargeReactor(int reactor, int value){
        boolean res = false;
        try
        {
            this.reactors[reactor].chargeReactor(value);
            res = true;
        }catch(DamagedReactorException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public boolean dischargeReactor(int reactor, int value){
        boolean res = false;
        try
        {
            this.reactors[reactor].dischargeReactor(value);
            res = true;
        }catch(DamagedReactorException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public boolean repairReactor(int reactor){
        boolean res = this.reactors[reactor].repairReactor();
        return res;
    }
    
}
