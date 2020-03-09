package main;

public abstract class Vehiculo  {

private String modelo;	
private float precio;	
private int unidades;	
private String color;	
private String status;	


public Vehiculo (String model,float price, String col) {
	
	modelo= model;
	precio= price;
	color= col;
	unidades=50;
	status= "disponible";
		
}

// metodos 

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