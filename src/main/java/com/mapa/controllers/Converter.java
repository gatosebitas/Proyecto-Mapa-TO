package com.mapa.controllers;
 import com.mapa.models.ObjectFormat;
 public class Converter {
	private ObjectBuilder objectBuilder;
	
	public void setObjectBuilder(ObjectBuilder ob) {
		objectBuilder = ob;
	}
	
	public ObjectFormat getObject() {
		return objectBuilder.getObject();
	}
	
	public void construirObject() {
		objectBuilder.buildType();
		objectBuilder.buildValue();
		objectBuilder.buildId();
		objectBuilder.buildFormat();		
	}
 }