package org.liceolapaz.des.fal;


import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

public class Tablero extends JPanel {
	
		
	
		 int filas; 
		 int columnas;
		 Boton[][] botones; 
		 
	public Tablero(int filas, int columnas) {   // aqui paso filas y columnas pq habra varias  filas y columnas ya que es un tablero
		this.filas = filas;
		this.columnas = columnas;
		this.setLayout (new GridLayout (filas, columnas)); //GridLayout hace una division de cuadriculas en el tablero.
	
	
		crearBotones();
		crearMinas(10);
	}
	
	private void crearMinas(int minas) {
		Random random = new Random();
		int contador = 0;
		 
		while(contador<minas) {
			
			int fila = random.nextInt((filas - 1) + 0);
			int columna = random.nextInt((columnas - 1) + 0);
		//	if(!botones[fila][columna].getEstado(Estado.BOMBA);)
			botones[fila][columna].setEstado(Estado.BOMBA);
			contador = contador +1;
		}
	}
	
	public void crearNumeros(Boton boton) {
		int contador = 0;
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
//				botones[fila][columna]  = 0-0;
				
				if(fila > 0  && columna > 0) { //  1-1
					if(botones[fila - 1][columna-1].estado.equals(Estado.BOMBA)) {
						contador += 1;															//TENEMOS =+ PERO CREO Q DEBERÍA SER																		//+= EN VEZ DE =+
					} 
					if(botones[fila - 1][columna].estado.equals(Estado.BOMBA)) {
						contador += 1;
					}
					if(botones[fila - 1][columna + 1].estado.equals(Estado.BOMBA)) {
						contador += 1;
					} 
					if(botones[fila][columna + 1].estado.equals(Estado.BOMBA)) {
							contador += 1;
					}
					if(botones[fila + 1][columna + 1].estado.equals(Estado.BOMBA)) {
						contador += 1;
					}
					if(botones[fila + 1][columna].estado.equals(Estado.BOMBA)) {
						contador += 1;
					}
					if(botones[fila + 1][columna - 1].estado.equals(Estado.BOMBA)) {
							contador += 1;
					} 
					if(botones[fila][columna - 1].estado.equals(Estado.BOMBA)) {
						contador += 1;
					}
					
						
				} else if(!(fila > 0)  && columna > 0) {
					if(botones[fila][columna -1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila + 1][columna -1].estado.equals(Estado.BOMBA)) {
							contador += 1;}
					if(botones[fila + 1][columna].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila + 1][columna +1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila][columna +1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					
									
				} else if(fila > 0 && !(columna > 0)) {
					
					if(botones[fila -1][columna].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila -1][columna +1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila][columna +1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila +1][columna +1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila +1][columna].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					
				} else if(fila == 0 && (columna == 0)) {
					if(botones[fila][columna +1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila +1][columna +1].estado.equals(Estado.BOMBA)) {
						contador += 1;}
					if(botones[fila +1][columna].estado.equals(Estado.BOMBA)) {
						contador += 1;}
				}
			} // termina el for de columnas
		//	botones[fila][columna].setText(contador);
		
			
		} // for filas
		
		
	}

	private void crearBotones() {
		Boton boton;
		 botones = new Boton[filas][columnas];
		
		 for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
				
				boton = new Boton(this, fila, columna); // primero añadimos todos los botones de fila y luego de columna.
				botones[fila][columna] = boton;
				add(botones[fila][columna]);  //añadimos el array lleno a nuestro panel
			}		 	 
		 }
	}
		
	
	
	
}
