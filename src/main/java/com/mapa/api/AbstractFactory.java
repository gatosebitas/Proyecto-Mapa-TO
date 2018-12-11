package org.example.ws.web.api;

import com.mapa.models.Punto_Interes;
import com.mapa.models.Vehiculo;

public interface AbstractFactory {
	
	 Punto_Interes Save(Punto_Interes p );
	 Vehiculo Save(Vehiculo v);

}
