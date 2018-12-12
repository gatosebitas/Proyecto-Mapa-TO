package com.mapa.controllers;

import com.mapa.models.ObjectFormat;

public class JsonObjectBuilder extends ObjectBuilder{
	
	public JsonObjectBuilder(Object object) throws IllegalArgumentException, IllegalAccessException {
		super.object = new ObjectFormat(object);
	}

	public void buildType() {
		String type [] =object.getType();
		for (int i = 0; i < type.length; i++) {
			String temp =type[i];
			type[i]="\""+temp+"\"";
		}
		object.setType(type);
	}

	public void buildValue() {
		Object values [] =object.getValue();
		String ids [] = object.getId();
		for (int i = 0; i < values.length; i++) {
			if (ids[i].compareToIgnoreCase("String")==0) {
				values[i]="\""+values[i]+"\"";
			}
		}
		object.setValue((String[]) values);
	}
	public void buildFormat() {
		String type [] =object.getType();
		Object value []=object.getValue();
		String id [] = object.getId();
		String cadena ="{ ";
		for (int i = 0; i < id.length; i++) {
			if(i!=id.length-1)
				cadena+=type[i]+":"+value[i]+", ";
			else
				cadena+=type[i]+":"+value[i]+" }";
		}
		
		object.setFormat(cadena);
	}

	@Override
	public void buildId() {
		// TODO Auto-generated method stub
		
	}

}
