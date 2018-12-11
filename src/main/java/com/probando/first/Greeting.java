package com.probando.first;

import com.mapa.service.Facade;

public class Greeting {
 
    
    public String getHello()  {
    	Facade f=new Facade();
        //System.out.println(f.listarVehiculo("usuarios2").get(0).toString());
    	return "hola mundo";
    }
    
}
