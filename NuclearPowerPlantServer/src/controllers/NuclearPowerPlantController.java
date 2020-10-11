/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.DamagedReactorException;
import exceptions.ReactorAlreadyOffException;
import exceptions.ReactorAlreadyOnException;
import models.NuclearPowerPlant;

/**
 *
 * @author Breaze
 */
public class NuclearPowerPlantController {
    private final NuclearPowerPlant npp;

    public NuclearPowerPlantController() {
        this.npp = new NuclearPowerPlant();
    }
    
    public String turnOn(int reactor){
        String res = null;
        try
        {
            boolean response = this.npp.turnOn(reactor);
            if(response)
                res = "Reactor on";
        }catch(DamagedReactorException | ReactorAlreadyOnException e){
            res = "Error: "+e.getMessage();
            System.out.println("Error: "+e.getMessage());
        }
        return res;
    }
    public String turnOff(int reactor){
        String res = null;
        try
        {
            boolean response = this.npp.turnOff(reactor);
            if(response)
                res = "Reactor off";
        }catch(DamagedReactorException | ReactorAlreadyOffException e){
            res = "Error: "+e.getMessage();
            System.out.println("Error: "+e.getMessage());
        }
        return res;
    }
    
    public String chargeReactor(int reactor, int value){
        String res = null;
        try{
            boolean response = this.npp.chargeReactor(reactor, value);
            if(response)
                res = "Reactor charged";
        }catch(DamagedReactorException e){
            res = "Error: "+e.getMessage();
            System.out.println("Error: "+e.getMessage());
        }
        return res;
    }
    
    public String dischargeReactor(int reactor, int value){
        String res = null;
        try{
            boolean response = this.npp.dischargeReactor(reactor, value);
            if(response)
                res = "Reactor discharged";
        }catch(DamagedReactorException e){
            res = "Error: "+e.getMessage();
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public String repairReactor(int reactor){
        String res = null;
        boolean response = this.npp.repairReactor(reactor);
        if(response)
            res = "Reactor repared";
        else
            res = "Reactor Working";
        return res;
    }
    
}
