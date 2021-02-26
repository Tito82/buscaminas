package org.liceolapaz.des.fal;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;



public class Boton extends JButton {
	 Tablero tablero;
	 int fila;
	 int columna;
	 boolean esMina;
	 
	public Boton(Tablero tablero, int fila, int columna) {  
		this.tablero = tablero;
		this.fila = fila;
		this.columna = columna;
		this.esMina = false;
		this.setOpaque(true);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
	 comprobarMinas();
	 
			}

			private void comprobarMinas() {
				if(esMina==true) {
					setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/boom.png")).getImage().getScaledInstance(50, 50, 0)));
				}else{
					setBackground(Color.WHITE);
				}}
			
		});
	
	
	}	
	public void setEsMina(boolean esMina) {
		this.esMina = esMina;
	}

	public void crearMinas() {
		
		
	}
	
		
			

	

}