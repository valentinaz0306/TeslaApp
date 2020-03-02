package main;

import processing.core.PApplet;
import processing.core.PFont;
import controlP5.*;
import java.util.ArrayList;

public class Main extends PApplet {
	private ControlP5 cp5;
	//private ArrayList<Usuario> = new ArrayList<Usuario>;
	String info = "";
	Textfield username;
	Textfield password;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");;
	}
	public void settings() {
		size(750,1334);
	}
	public void setup() {
		PFont font = createFont("arial",20);
		cp5 = new ControlP5(this);
		// campo de texto para usuario 
		username = cp5.addTextfield("username")
	     .setPosition(300,170)
	     .setSize(200,40)
	     .setFont(font)
	     .setColor(color(255,255,255))
	     ;
		// campo de texto para contraseña
		password = cp5.addTextfield("password")
	     .setPosition(300,280)
	     .setSize(200,40)
	     .setFont(font)
	    //contraeña asteriscos
	     .setPasswordMode(true)
	     .setColor(color(255,255,255))
	     ;
		cp5.addButton("Hola")
		.setValue(0)
		.setPosition(300,400)
		.setSize(200,40);
	}
	public void Hola(int Value){
		println("help");
		info =  username.getText()+" "+password.getText();
	}
	public void controlEvent(ControlEvent theEvent) {
		  println(theEvent.getController().getName());
	}
	public void draw() {
		background(0);
		text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
		text(info,350,500);
	}
}


