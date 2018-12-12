package com.mapa.models;
import java.lang.reflect.Field;

public class ObjectFormat {
	private String []type;
	private Object [] value;
	private String []id;
	private String format;
	
	public ObjectFormat(Object object) throws IllegalArgumentException, IllegalAccessException {
			
		Class<?> objClass = object.getClass();

	    Field[] fieldss = objClass.getFields();
	    System.out.println(fieldss.length);
	    type = new String [fieldss.length];
	    value = new String [fieldss.length];
	    id = new String [fieldss.length];
	    int i=0;
	    for(Field field : fieldss) {
	        String name = field.getName();
	        Object value = field.get(object);
	        String id = field.getType().getSimpleName();

	        System.out.println(name + ": " + value.toString()+" : "+id);
	        this.type[i]=name;
	        this.value[i]=""+value;
	        this.id[i]=id;
	        i++;
	    }
		
	}
	
	public ObjectFormat() {
		
	}
	public String [] getType() {
		return type;
	}
	public void setType(String []type) {
		this.type = type;
	}
	public Object [] getValue() {
		return value;
	}
	public void setValue(String []value) {
		this.value = value;
	}

	public String [] getId() {
		return id;
	}

	public void setId(String [] id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	
}
