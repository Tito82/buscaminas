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
	 Estado estado;
	 
	 
	public Boton(Tablero tablero, int fila, int columna) {  
		this.tablero = tablero;
		this.fila = fila;
		this.columna = columna;
		this.estado = Estado.TAPADO;
		
		this.setVisible(true);
		this.setOpaque(true);
		this.setBackground(Color.LIGHT_GRAY);
//		this.setSize(80, 60);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comprobarMinas();
				
			}

			
		});
		
	}
		
		private void comprobarMinas() {
						
			switch (this.estado) {
			case VACIO:
				//COMPROBAR BOMBAS CONTIGUAS Y ESPACIO ABIERTO
				//CAMBIAR COLOR CASILLA
				this.setEnabled(false); //DESHABILITAS
				break;
			case BOMBA:
				setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/boom.png")).getImage().getScaledInstance(50, 50, 0))); //CAMBIAR ICONO
				this.setEnabled(false); //DESAHABILAR BOTON
				//TERMINAR JUEGO-- > PERDISTE
				break;
			case NUMERO:
				   //MOSTRAR NUMERO Y COLOR
				this.setEnabled(false);

				break;
			case BANDERA:
				
				colocarBandera(); //COMPROBAMOS SI HAY BANDERA Y REACCIONAR
				//COMPROBAR TERMINAR JUEGO
				
				break;

			}
		
		}
		
	public void colocarBandera() {
			this.setIcon(this.estado.equals(Estado.BANDERA) ? null : 
				new ImageIcon(new ImageIcon(getClass().getResource("/bandera.png")).getImage().getScaledInstance(50, 50, 0)));
	}

	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void crearMinas() {
	
	};
	
}
