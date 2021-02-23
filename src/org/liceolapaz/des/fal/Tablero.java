package org.liceolapaz.des.fal;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel {
	private Ventana ventana;
	private int filas;
	private int columnas;
	private int minas;
	JButton[][] tablero;
	
	public Tablero(Ventana ventana, int filas, int columnas, int minas) {
		super();
		this.ventana = ventana;
		this.filas = filas;
		this.columnas = columnas;
		
	}
	
	private int generarMina(int minas) {// meter esto en un boton de forma aleatoria
		Random rand = new Random();
		return rand.nextInt(minas) + 1;
	}

}
 
 