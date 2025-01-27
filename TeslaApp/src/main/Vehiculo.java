package main;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Vehiculo  {

private String modelo;	
private float precio;	
private int unidades;	
private String color;	
private String status;
private PApplet app;
private PImage[] images;


public Vehiculo (String model,float price, String col,PApplet ap,PImage[] images) {
	
	app = ap;
	modelo= model;
	precio= price;
	color= col;
	unidades=50;
	status= "disponible";
	this.images = images;
		
}

// metodos 

public void pintarCarro(int x, int y, int tamx, int tamy) {
	
	
	if(color.equals("black")){
		
		app.image(images[0],x,y,tamx,tamy);
		
	}
	
	if(color.equals("red")){
		
		app.image(images[1],x,y,tamx,tamy);
			
		}
	
	if(color.equals("blue")){
		
		app.image(images[2],x,y,tamx,tamy);
			
		}
	
	if(color.equals("white")){
		
		app.image(images[3],x,y,tamx,tamy);
			
		}
	
	
}

public String getModelo() {
	return modelo;
}


public void setModelo(String modelo) {
	this.modelo = modelo;
}


public float getPrecio() {
	return precio;
}


public void setPrecio(float precio) {
	this.precio = precio;
}


public int getUnidades() {
	return unidades;
}


public void setUnidades(int unidades) {
	this.unidades = unidades;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}





}