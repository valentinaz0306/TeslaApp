package main;

import processing.core.PApplet;
import processing.core.PFont;
import controlP5.*;
import java.util.ArrayList;
import processing.core.PImage;

public class Main extends PApplet {
	
	private ControlP5 cp5;
	//arralist para registar usuarios 
	private ArrayList<User> Users = new ArrayList<User>();
	
	//animacion 
	int grafi=70;
	int grafi2=85;
	///////
	String info = "";
	Textfield username,password;
	Textfield usernameR,emailR,passwordR,cPasswordR;
	Button loginB,registerB;
	Boolean burger = false;
	User conUser; // Usuario conectado
	int pantalla;
	int modeloElegido = 0; // modelo elegido por el usuario 0=ninguno 1 model3 2 modelS 3 modelX 4 modelY
	
	
	Boolean pendiente = false;
	
	Model3 modelo3;
	ModelS modelos;
	ModelY modeloy;
	ModelX modelox;
	
	// contadore para la animacion 
	
	int conta1=0;
	int conta2=0;
	int conta3=0;
	
	/// Imagenes interfaz 
	
	PImage login;
	PImage account;
	PImage home;
	PImage menuh;
	PImage history;
	PImage buy;
	PImage models;
	PImage model3;
	PImage modelx;
	PImage modely;
	PImage graphic;
	PImage checkout;
	PImage login2;
	
	/// Feedback  
	
	/// CAR MODELS
	
	// MODEL3
	PImage A3;
	PImage N3;
	PImage B3;
	PImage R3;
	
	// MODEL S
	PImage SA;
	PImage SR;
	PImage SN;
	PImage SB;
	
	// MODEL X
	
	PImage XA;
	PImage XN;
	PImage XB;
	PImage XR;
	
	// MODEL Y
	
	PImage YA;
	PImage YN;
	PImage YB;
	PImage YR;
	
	/// BENNER FOTOS
	
	PImage banner1;
	PImage banner2;
	PImage banner3;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");;
	}
	public void settings() {
		size(375,667);
		
	}
	public void setup() {
		
		
		pantalla=0;
		
		
		// imagenes interfaces
		buy= loadImage("interfaz/buy.png");
		checkout= loadImage("interfaz/checkout..png");
		graphic= loadImage("interfaz/graphic.png");
		history= loadImage("interfaz/history.png");
		home= loadImage("interfaz/home.png");
		menuh= loadImage("interfaz/MenuH.png");
		models= loadImage("interfaz/models.png");
		model3= loadImage("interfaz/model3.png");
		modelx= loadImage("interfaz/modelx.png");
		modely= loadImage("interfaz/modely.png");
		account= loadImage("interfaz/account.png");
		login2= loadImage("interfaz/login2.png");
		
		// imagenes modelos de carros
		
		// MODEL 3
		A3= loadImage("models/3A.png");
		N3= loadImage("models/3N.png");
		B3= loadImage("models/3B.png");
		R3= loadImage("models/3R.png");
		
		// MODEL S
		
		SA= loadImage("models/SA.png");
		SN= loadImage("models/SN.png");
		SB= loadImage("models/SB.png");
		SR= loadImage("models/SR.png");
		
		// MODEL X
		
		XA= loadImage("models/XA.png");
		XN= loadImage("models/XN.png");
		XB= loadImage("models/XB.png");
		XR= loadImage("models/XR.png");
		
		// MODEL Y
		
		YA= loadImage("models/YA.png");
		YN= loadImage("models/YN.png");
		YB= loadImage("models/YB.png");
		YR= loadImage("models/YR.png");
		
		// imagenes banner 
		
		banner1= loadImage("banner/banner1.png");
		banner2= loadImage("banner/banner2.png");
		banner2= loadImage("banner/banner3.png");
		
		
		//ARREGLO DE CARROS
		PImage[] mo3= new PImage[4];
		mo3[0]=N3;
		mo3[1]=R3;
		mo3[2]=A3;
		mo3[3]=B3;
		
		PImage[] mos= new PImage[4];
		mos[0]=SN;
		mos[1]=SR;
		mos[2]=SA;
		mos[3]=SB;
		
		PImage[] mox= new PImage[4];
		mox[0]=XN;
		mox[1]=XR;
		mox[2]=XA;
		mox[3]=XB;
		
		PImage[] moy= new PImage[4];
		moy[0]=YN;
		moy[1]=YR;
		moy[2]=YA;
		moy[3]=YB;
		
		 modelo3 = new Model3("black",this,mo3);
		 modelos = new ModelS("black",this,mos);
		 modelox = new ModelX("black",this,mox);
		 modeloy = new ModelY("black",this,moy);
		
		
		// SE AÑADE UN NUEVO USUARIO AL ARRAYLIST 
		Users.add(new User("test","test","test@test.com"));
		PFont font = createFont("PT Sans",20);
		cp5 = new ControlP5(this);
		
		// campo de texto para usuario 
		username = cp5.addTextfield("username")
	     .setPosition(115,343)
	     .setSize(180,38)
	     .setFont(font)
	     .setColor(color(255,255,255))
	     .setColorBackground(0)
	     .setColorActive(0)
	     .setColorLabel(0)
	     .setColorCaptionLabel(0)
	     .setColorForeground(0)
	     ;
		// campo de texto para contraseña
		password = cp5.addTextfield("password")
	     .setPosition(115,403)
	     .setSize(180,38)
	     .setFont(font)
	    //contraeña asteriscos
	     .setPasswordMode(true)
	     .setColor(color(255,255,255))
	     .setColorBackground(0)
	     .setColorActive(0)
	     .setColorLabel(0)
	     .setColorCaptionLabel(0)
	     .setColorForeground(0)
	     ;
		// campo de texto para nombre de usuario registro
		usernameR =cp5.addTextfield("usernameR")
			     .setPosition(85,310)
			     .setSize(200,40)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .hide()
			     ;
		emailR = cp5.addTextfield("emailR")
			     .setPosition(85,374)
			     .setSize(200,40)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .hide()
			     ;
		passwordR = cp5.addTextfield("passwordR")
			     .setPosition(85,431)
			     .setSize(200,40)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .hide()
			     .setPasswordMode(true)
			     ;
		cPasswordR = cp5.addTextfield("cPasswordR")
			     .setPosition(85,492)
			     .setSize(200,40)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .hide()
			     .setPasswordMode(true)
			     ;
		//boton para login 
		loginB = cp5.addButton("Hola")
		.setValue(0)
		.setPosition(87,473)
		.setSize(200,40);
	}
	public void Hola (int Value){
		println("help");
		//match de usuario login y registro 
		Boolean bol = true;
		
		for (int i = 0; i < this.Users.size(); i++) {
			User LogUser = this.Users.get(i);
			
			println(LogUser.getUsername()+username.getText()+LogUser.getPassword()+password.getText());
			
			// Compara entre el username y contraseña digitado con el de todos los usuarios registrados
			// y si son iguales entra a su sesión.
			// str.equals(str2) devuelve true si la cadena str es igual a la cadena str2
			
			if (LogUser.getUsername().equals(username.getText()) && LogUser.getPassword().equals(password.getText())) {
				//println("Entré");
				
				conUser = LogUser;
				pantalla = 2;
				hideLogin();
				info = "El usuario existe!";
				bol = false;
				break;
			}
		}
		if (bol) {
			info = "El usuario no existe!";
		}
	}
	public void hideLogin() {
		username.hide();
		password.hide();
		password.clear();
		username.clear();
		loginB.hide();
	}
	public void showLogin() {
		username.show();
		password.show();
		loginB.show();
	}
	public void hideRegister() {
		usernameR.hide();
		emailR.hide();
		passwordR.hide();
		cPasswordR.hide();
		// limpiar 
		usernameR.clear();
		emailR.clear();
		passwordR.clear();
		cPasswordR.clear();
	}
	public void showRegister() {
		usernameR.show();
		emailR.show();
		passwordR.show();
		cPasswordR.show();
	}
	public Boolean Registrarse() {
		String name=usernameR.getText();
		String pass=passwordR.getText();
		String confPass=cPasswordR.getText();
		String em=emailR.getText();
		if(!name.equals("") && !pass.equals("") && !em.equals("") && pass.contentEquals(confPass)) {
			conUser = new User(name,pass,em);
			Users.add(conUser);
			println(Users.get(1).getUsername()+" "+Users.get(1).getEmail()+" "+Users.get(1).getPassword());
			return true;
		}
		else {
			return false;			
		}
	}
	
	public void animacion(int bolas, int posy) {
		int cont=0;
		
		for(int i=0;i<bolas;i++) {
			
			fill(255,0,0);
			noStroke();
			ellipse(22 + cont,posy,8,8);
			
			cont= cont+3;
		}
			
	}
	
	public void draw() {
		switch(pantalla) {
		
		//login
		case 0:
			
			background(0);
			image(login2,0,0,375,667);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			//text(info,350,500);
		
		break;
		
		//registrar
		case 1:
			
			background(0);
			image(account,0,0,375,667);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			//text(info,350,500);
		
		break;
		
		// home + menu hamburguesa 
		case 2:
			
			background(0);
			image(home,0,0,375,667);
			//menu hamburguesa
			if (burger) {
				image(menuh,0,0,246,667);
				// nombre del usuario
				text(conUser.getUsername(),105,200);
			}
			fill(0);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			//text(info,350,500);
		
		break;
		
		// pantalla de shopping history 
		case 3:
			
			background(0);
			image(history,0,0,375,667);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
		
		break;
		
		case 4:
			
			background(0);
			image(graphic,0,0,375,667);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
			animacion(conta1,385);
			animacion(conta3,509);
			animacion(conta2,447);
			if(conta1< grafi) {
				conta1++;
			}
			
			if(conta2< grafi2) {
				conta2++;
			}
			
			if(conta3< grafi) {
				conta3++;
			}
			
		
		break;
		
		// model 3
		case 5:
			
			background(0);
			image(model3,0,0,375,667);
			fill(255);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
		break;
		
		// model s
		case 6:
			
			background(0);
			image(models,0,0,375,667);
			fill(255);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
		break;
		
		// model y
		case 7:
			
			background(0);
			image(modely,0,0,375,667);
			fill(255);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
		break;
		
		// model x
		case 8:
			
			background(0);
			image(modelx,0,0,375,667);
			fill(255);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
		break;
		
		case 9:
			background(0);
			image(buy,0,0,375,667);
			fill(0);
			text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
			
			if (modeloElegido == 1) {
				//pintar imagenes de modelos 
				
				modelo3.pintarCarro(0,90);
			
			}
			
			if (modeloElegido == 2) {
				
				modelos.pintarCarro(0,90);
			}
			if (modeloElegido == 3) {
				
				modeloy.pintarCarro(0,90);
			}
				
			if (modeloElegido == 4) {
				
				modelox.pintarCarro(0,90);
			}
			
		break;
		
		}// cierre switch
		
	}// cierre draw
	
	public void mousePressed() {
		
		//pasar a crear cuenta
		if(mouseX>= 145 && mouseX<= 232 && mouseY >= 638 && mouseY <= 647 && pantalla==0){
			
			pantalla=1;
			hideLogin();
			showRegister();
			}
		
		//ingresar al home
		
		if(dist(mouseX,mouseY,(float)188,(float)585)<=22 && pantalla==1 && Registrarse()) {
			 pantalla=2;
			 hideRegister();
		}
		//abrir menu burger
		if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==2){
			
			burger=!burger;	
		}
		//esconder menu burger
		if(mouseX>= 244 && mouseX<= 375 && mouseY >= 43 && mouseY <= 667 && burger==true){
				
			burger=false;
		}
		//boton Home
		if(mouseX>= 0 && mouseX<= 243 && mouseY >= 230 && mouseY <= 300 && burger==true){
			
			pantalla = 2;
			burger=false;
		}
		//boton Shopping History
		if(mouseX>= 0 && mouseX<= 243 && mouseY >= 300 && mouseY <= 370 && burger==true){
			
			pantalla = 3;
			burger=false;
		}
		//boton Shopping History back
		if(mouseX>= 18 && mouseX<= 32 && mouseY >= 55 && mouseY <= 67 && (pantalla==3 || pantalla==4) ){
					
			pantalla = 2;
			// volver los contadores a cero 
			conta1=0;
			conta2=0;
			conta3=0;
		}
		
		// ir a la pantalla de los graficos 
		if(mouseX>= 0 && mouseX<= 243 && mouseY >= 371 && mouseY <= 440 && burger==true){
			
			pantalla = 4;
			burger=false;
		}
		
		// longout
				if(mouseX>= 0 && mouseX<= 243 && mouseY >= 440 && mouseY <= 505 && burger==true){
					
					pantalla = 0;
					burger=false;
					showLogin();
				}
				
			// model3
			if(mouseX>= 20 && mouseX<= 180 && mouseY >= 322 && mouseY <= 485 && pantalla==2){
					
				pantalla = 5;
				modeloElegido = 1;
				
				}
	
			// models
			
			if(mouseX>= 190 && mouseX<= 346 && mouseY >= 322 && mouseY <= 485 && pantalla==2){
									
				pantalla = 6;
				modeloElegido = 2;
				}
			
			// modelx
			
			if(mouseX>= 20 && mouseX<= 180 && mouseY >= 495 && mouseY <= 657 && pantalla==2){
								
			pantalla = 7;	
			modeloElegido = 3;
				}
			
			// models
			
			if(mouseX>= 190 && mouseX<= 346 && mouseY >= 495 && mouseY <= 657 && pantalla==2){
											
			pantalla = 8;
			modeloElegido = 4;
				
			}
			
			// checkout
			
			if(mouseX>= 269 && mouseX<= 345 && mouseY >= 624 && mouseY <= 646 &&( pantalla==5 || pantalla==6 || pantalla==7 || pantalla==8))
			{
				
				pantalla = 9;
					
				}
			// col negro
			
			if(mouseX>= 88 && mouseX<= 120 && mouseY >= 376 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("black");
				modelos.setColor("black");
				modeloy.setColor("black");
				modelox.setColor("black");
					
				}
			
			//col rojo
			
			if(mouseX>= 135 && mouseX<= 380 && mouseY >= 379 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("red");
				modelos.setColor("red");
				modeloy.setColor("red");
				modelox.setColor("red");
				}
			
			//col azul
			
			if(mouseX>= 189 && mouseX<= 380 && mouseY >= 218 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("blue");
				modelos.setColor("blue");
				modeloy.setColor("blue");
				modelox.setColor("blue");
					
				}
			//col blanco
			
			if(mouseX>= 236 && mouseX<= 268 && mouseY >= 379 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("white");
				modelos.setColor("white");
				modeloy.setColor("white");
				modelox.setColor("white");
				
					
				}
			
			// cambiar de color
		
			
			
			
	}// cierra mousepressed
	
	
	
	
}// cierre main


