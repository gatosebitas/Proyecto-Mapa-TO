package com.mapa.controllers;
import com.mapa.models.ObjectFormat;
 public abstract class ObjectBuilder {
	ObjectFormat object;
	
	public ObjectFormat getObject() {
		return object;
	}
	
	public abstract void buildType();
	public abstract void buildValue();
	public abstract void buildId();
	public abstract void buildFormat();
	
	
 }