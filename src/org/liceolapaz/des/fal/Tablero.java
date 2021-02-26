package org.liceolapaz.des.fal;


import java.awt.GridLayout;
import java.util.Random;


import javax.swing.JPanel;



public class Tablero extends JPanel {
	private int filas;
	private int columnas;
	Boton[][] botones;

	
	public Tablero(int filas, int columnas){
		this.filas=filas;
		this.columnas=columnas;
		this.setSize(400, 400);
		this.setVisible(true);
		this.setLayout (new GridLayout(filas,columnas));
		
		crearBotones();
	    crearMinas(10);
	
	}
	private void crearBotones() {
		Boton boton;
		 botones = new Boton[filas][columnas];
		
		 for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
				
				boton = new Boton(this, fila, columna); 
				botones[fila][columna] = boton;
				add(botones[fila][columna]);
			}		 	 
		 }
	}
	
	private void crearMinas(int minas) {
		Random random = new Random();
		int contador = 0;
		 
		while(contador<=minas) {
			
			int fila = random.nextInt((filas - 1) + 0);
			int columna = random.nextInt((columnas - 1) + 0);
			botones[fila][columna].setEsMina(true);
			contador= contador +1; //esto es para hacer luego el contador
		}
		
	}
	
}
 
 