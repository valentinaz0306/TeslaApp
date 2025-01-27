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
	Textfield Location,CreditCard;
	Button registerB;
	Boolean burger = false;
	User conUser; // Usuario conectado
	int pantalla;
	int modeloElegido = 0; // modelo elegido por el usuario 0=ninguno 1 model3 2 modelS 3 modelX 4 modelY
	int CantCarros;
	ArrayList<String> Compras = new ArrayList<String>(); 
	
	Boolean pendiente = false;
	
	Model3 modelo3;
	ModelS modelos;
	ModelY modeloy;
	ModelX modelox;
	
	// contadores para la animacion 
	
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
	PImage empty1;
	PImage empty2;
	
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
		checkout= loadImage("interfaz/checkout.png");
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
		empty1= loadImage("interfaz/empty1.png");
		empty2= loadImage("interfaz/empty2.png");
		
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
				.setCaptionLabel("")
			     .setPosition(85,313)
			     .setSize(180,38)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .setColorBackground(0)
			     .setColorActive(0)
			     .setColorLabel(255)
			     .setColorCaptionLabel(255)
			     .setColorForeground(0)
			     .hide()
			     .setLabelVisible(false)
			     ;
		emailR = cp5.addTextfield("emailR")
				.setCaptionLabel("")
			     .setPosition(85,374)
			     .setSize(180,38)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .setColorBackground(0)
			     .setColorActive(0)
			     .setColorLabel(255)
			     .setColorCaptionLabel(255)
			     .setColorForeground(0)
			     .hide()
			     .setLabelVisible(false)
			     ;
		passwordR = cp5.addTextfield("passwordR")
				.setCaptionLabel("")
			     .setPosition(85,432)
			     .setSize(180,38)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .hide()
			     .setColorBackground(0)
			     .setColorActive(0)
			     .setColorLabel(255)
			     .setColorCaptionLabel(255)
			     .setColorForeground(0)
			     .setPasswordMode(true)
			     .setLabelVisible(false)
			     ;
		cPasswordR = cp5.addTextfield("cPasswordR")
				.setCaptionLabel("")
			     .setPosition(85,492)
			     .setSize(180,38)
			     .setFont(font)
			     .setColor(color(255,255,255))
			     .setColorBackground(0)
			     .setColorActive(0)
			     .setColorLabel(255)
			     .setColorCaptionLabel(255)
			     .setColorForeground(0)
			     .hide()
			     .setPasswordMode(true)
			     .setLabelVisible(false)
			     ;
		//boton para login 
		
		
		// direccion
				Location= cp5.addTextfield("location")
					     .setPosition(113,337)
					     .setSize(181,34)
					     .setFont(font)
					     .setColor(color(255,255,255))
					     .hide()
					     .setLabelVisible(false)
					     .setColorBackground(0)
					     .setColorActive(0)
					     .setColorLabel(0)
					     .setColorCaptionLabel(0)
					     .setColorForeground(0)
					     ;
				
		// tarjeta de credito
				
			CreditCard= cp5.addTextfield("CreditCard")
					     .setPosition(113,408)
					     .setSize(181,34)
					     .setFont(font)
					     .setColor(color(255,255,255))
					     .hide()
					     .setLabelVisible(false)
					     .setColorBackground(0)
					     .setColorActive(0)
					     .setColorLabel(0)
					     .setColorCaptionLabel(0)
					     .setColorForeground(0)
					     ;
		
		CantCarros=1;
	}
	public void Login (){
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
	}
	public void showLogin() {
		username.show();
		password.show();
		
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
	
	public void hideCheckout() {
		Location.hide();
		Location.clear();
		CreditCard.hide();
		CreditCard.clear();
		
	}
	
	public void showCheckout() {
		Location.show();
		CreditCard.show();
	
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
			fill(255);
			textSize(25);
			//text("SIGN UP",155,490);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			//text(info,350,500);
		
		break;
		
		//registrar
		case 1:
			
			background(0);
			image(account,0,0,375,667);
			fill(255);
			textSize(12);
			text("Your nickname",90,365);
			text("Your E-mail",90,425);
			text("Your passworrd",90,484);
			text("Confirm passworrd",90,545);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
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
				fill(255);
				textSize(20);
				text(conUser.getUsername(),105,200);
			}
			fill(0);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			//text(info,350,500);
		
		break;
		
		// pantalla de shopping history 
		case 3:
			
			background(0);
			image(history,0,0,375,667);
			for (int i=0; i<Compras.size();i++) {
				fill(255);
				textSize(10);
				text(Compras.get(i),28,210+i*60);
			}
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
		
		break;
		
		case 4:
			
			background(0);
			image(graphic,0,0,375,667);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
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
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
			if (burger) {
				image(menuh,0,0,246,667);
				// nombre del usuario
				fill(255);
				textSize(20);
				text(conUser.getUsername(),105,200);
			}
			
		break;
		
		// model s
		case 6:
			
			background(0);
			image(models,0,0,375,667);
			fill(255);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
			if (burger) {
				image(menuh,0,0,246,667);
				// nombre del usuario
				fill(255);
				textSize(20);
				text(conUser.getUsername(),105,200);
			}
			
		break;
		
		// model y
		case 7:
			
			background(0);
			image(modely,0,0,375,667);
			fill(255);
			textSize(20);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
			if (burger) {
				image(menuh,0,0,246,667);
				// nombre del usuario
				fill(255);
				text(conUser.getUsername(),105,200);
			}
			
		break;
		
		// model x
		case 8:
			
			background(0);
			image(modelx,0,0,375,667);
			fill(255);
			textSize(20);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
			if (burger) {
				image(menuh,0,0,246,667);
				// nombre del usuario
				fill(255);
				text(conUser.getUsername(),105,200);
			}
			
		break;
		
		case 9:
			
			//pantalla de compra
			
			background(0);
			image(buy,0,0,375,667);
			
			
			if (modeloElegido == 1) {
				
				//pintar imagenes de modelos 
				
				modelo3.pintarCarro(0,90,400,250);
				
				fill(0);
				textSize(20);
				text("Model 3",142,350);
			
			}
			
			if (modeloElegido == 2) {
				
				modelos.pintarCarro(0,90,400,250);
				fill(0);
				textSize(20);
				text("Model S",142,350);
			}
			if (modeloElegido == 3) {
				
				modeloy.pintarCarro(0,90,400,250);
				fill(0);
				textSize(20);
				text("Model Y",142,350);
			}
				
			if (modeloElegido == 4) {
				
				modelox.pintarCarro(0,90,400,250);
				fill(0);
				textSize(20);
				text("Model X",142,350);
			}
			
			if (burger) {
				image(menuh,0,0,246,667);
				// nombre del usuario
				fill(255);
				textSize(20);
				text(conUser.getUsername(),105,200);
			}
			
			fill(0);
			textSize(20);
			text(CantCarros,170,503);
			
			fill(0);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
				
		break;
		
		//checkout
		case 10:
			
			background(0);
			image(checkout,0,0,375,667);
			
			if (modeloElegido == 1) {
				
				//pintar imagenes de modelos 
				
				modelo3.pintarCarro(95,170,200,125);
				fill(255);
				textSize(20);
				text("$"+ modelo3.getPrecio()*CantCarros,128,532);
				
			}
			
			if (modeloElegido == 2) {
				
				modelos.pintarCarro(95,170,200,125);
				fill(255);
				textSize(20);
				text("$"+ modelos.getPrecio()*CantCarros,128,532);
			
			}
			if (modeloElegido == 3) {
				
				modeloy.pintarCarro(95,170,200,125);
				fill(255);
				textSize(20);
				text("$"+ modeloy.getPrecio()*CantCarros,128,532);
				
				
			}
				
			if (modeloElegido == 4) {
				
				modelox.pintarCarro(95,170,200,125);
				fill(255);
				textSize(20);
				text("$"+ modelox.getPrecio()*CantCarros,128,532);
			}
			
			if (burger) {
				image(menuh,0,0,246,667);
				// nombre del usuario
				fill(255);
				textSize(20);
				text(conUser.getUsername(),105,200);
			}
			
			
			fill(255);
			//text("x:"+mouseX+" y:"+mouseY,mouseX,mouseY);
			
			break;

			
		
		}// cierre switch
		
	}// cierre draw
	
	public void mousePressed() {
		
		//pasar a crear cuenta
		if(mouseX>= 88 && mouseX<= 300 && mouseY >= 469 && mouseY <= 511 && pantalla==0){
			
			Login();
			}
		else if(mouseX>= 145 && mouseX<= 232 && mouseY >= 638 && mouseY <= 647 && pantalla==0){
			
			pantalla=1;
			hideLogin();
			showRegister();
			}
		
		//ingresar al home
		
		else if(dist(mouseX,mouseY,(float)188,(float)585)<=22 && pantalla==1 && Registrarse()) {
			 pantalla=2;
			 hideRegister();
			 hideCheckout();
		}
		//abrir menu burger
		else if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==2){
			
			burger=!burger;	
		}
		//esconder menu burger
		else if(mouseX>= 244 && mouseX<= 375 && mouseY >= 43 && mouseY <= 667 && burger==true){
				
			burger=false;
		}
		//boton Home
		else if(mouseX>= 0 && mouseX<= 243 && mouseY >= 230 && mouseY <= 300 && burger==true){
			
			pantalla = 2;
			burger=false;
			CantCarros = 1;
		}
		//boton Shopping History
		else if(mouseX>= 0 && mouseX<= 243 && mouseY >= 300 && mouseY <= 370 && burger==true){
			
			pantalla = 3;
			burger=false;
			CantCarros = 1;
		}
		//boton Shopping History back
		else if(mouseX>= 18 && mouseX<= 32 && mouseY >= 55 && mouseY <= 67 && (pantalla==3 || pantalla==4) ){
					
			pantalla = 2;
			// volver los contadores a cero 
			conta1=0;
			conta2=0;
			conta3=0;
		}
		
		// ir a la pantalla de los graficos 
		else if(mouseX>= 0 && mouseX<= 243 && mouseY >= 371 && mouseY <= 440 && burger==true){
			
			pantalla = 4;
			burger=false;
			CantCarros = 1;
		}
		
		// longout
		else if(mouseX>= 0 && mouseX<= 243 && mouseY >= 440 && mouseY <= 505 && burger==true){
					
					pantalla = 0;
					burger=false;
					showLogin();
					CantCarros = 1;
				}
				
			// model3
			else if(mouseX>= 20 && mouseX<= 180 && mouseY >= 322 && mouseY <= 485 && pantalla==2){
					
				pantalla = 5;
				modeloElegido = 1;
				
				}
			
			// burger model 3
			
				//abrir menu burger
			else if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==5){
							
				burger=!burger;	
				
				}
	
			// models
			else if(mouseX>= 190 && mouseX<= 346 && mouseY >= 322 && mouseY <= 485 && pantalla==2){
									
				pantalla = 6;
				modeloElegido = 2;
				}
			
			//abrir menu burger
			
			else if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==6){
						
			burger=!burger;	
			
			}
			
			// modelx
			
			else if(mouseX>= 20 && mouseX<= 180 && mouseY >= 495 && mouseY <= 657 && pantalla==2){
								
			pantalla = 7;	
			modeloElegido = 3;
				}
			
			//abrir menu burger
			else if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==7){
						
			burger=!burger;	
			
			}
			// models
			
			else if(mouseX>= 190 && mouseX<= 346 && mouseY >= 495 && mouseY <= 657 && pantalla==2){
											
			pantalla = 8;
			modeloElegido = 4;
				
			}
			
			//abrir menu burger
			
			else if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==8){
						
			burger=!burger;	
			
			}
			
			// pantalla buy
			
			else if(mouseX>= 269 && mouseX<= 345 && mouseY >= 624 && mouseY <= 646 &&( pantalla==5 || pantalla==6 || pantalla==7 || pantalla==8))
			{
				pantalla = 9; 
					
				}
			// col negro
			
			else if(mouseX>= 88 && mouseX<= 120 && mouseY >= 376 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("black");
				modelos.setColor("black");
				modeloy.setColor("black");
				modelox.setColor("black");
					
				}
			
			//col rojo
			
			else if(mouseX>= 135 && mouseX<= 173 && mouseY >= 379 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("red");
				modelos.setColor("red");
				modeloy.setColor("red");
				modelox.setColor("red");
				}
			
			//col azul
			
			else if(mouseX>= 183 && mouseX<= 221 && mouseY >= 379 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("blue");
				modelos.setColor("blue");
				modeloy.setColor("blue");
				modelox.setColor("blue");
					
				}
			//col blanco
			
			else if(mouseX>= 229 && mouseX<= 271 && mouseY >= 379 && mouseY <= 416 && pantalla==9){
				
				modelo3.setColor("white");
				modelos.setColor("white");
				modeloy.setColor("white");
				modelox.setColor("white");
				
					
				}
			
			// burger pantalla 9 
			
			//abrir menu burger
			else if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==9){
				
				burger=!burger;	
			}
		
			// boton pantalla 9 añadir unidades 
			
			else if(mouseX>= 238 && mouseX<= 251 && mouseY >= 496 && mouseY <= 504 && pantalla==9){
					
				CantCarros++;
			
				}
			
			// boton pantalla 9 quitar unidades 
			
			else if(mouseX>= 105 && mouseX<= 118 && mouseY >= 498 && mouseY <= 506 && pantalla==9){
							
				if(CantCarros>1) {
					
					CantCarros--;
				}
						
				}
			
			// boton continuar pantalla 9 a 10
			
			else if(mouseX>= 90 && mouseX<= 264  && mouseY >= 578 && mouseY <= 626 && pantalla==9){
													
					pantalla=10;
					showCheckout();
				}
			
			// burger pantalla 10
			else if(mouseX>= 17 && mouseX<= 40 && mouseY >= 52 && mouseY <= 68 && pantalla==10){
				
				burger=!burger;
				if (burger == true) {
					hideCheckout();
				} else {
					showCheckout();
				}
			}
			
			else if(mouseX>= 102 && mouseX<= 284 && mouseY >= 578 && mouseY <= 622 && pantalla==10) {
				pantalla= 3;
				hideCheckout();
				
				
				if(modeloElegido == 1) {
					Compras.add("Modelo 3, Cantidad: "+CantCarros+"  Valor Total: "+modelo3.getPrecio()*CantCarros);
				}
				if(modeloElegido == 2) {
					Compras.add("Modelo S, Cantidad: "+CantCarros+"  Valor Total: "+modelos.getPrecio()*CantCarros);
				}
				if(modeloElegido == 3) {
					Compras.add("Modelo Y, Cantidad: "+CantCarros+"  Valor Total: "+modeloy.getPrecio()*CantCarros);
				}
				if(modeloElegido == 4) {
					Compras.add("Modelo X, Cantidad: "+CantCarros+"  Valor Total: "+modelox.getPrecio()*CantCarros);
				}
			}
			
			
						
			
			
	}// cierra mousepressed
	
	
	
	
}// cierre main


