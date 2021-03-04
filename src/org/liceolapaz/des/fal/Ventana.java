package org.liceolapaz.des.fal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class Ventana extends JFrame {
	
	private Tablero tableroFacil;
	private JPanel primerPanel=new JPanel();
	private JPanel segundoPanel=new JPanel();

	
	public Ventana(){
		
		this.setVisible(true);
		this.setSize(500,500);
		this.setIconImage(new ImageIcon(getClass().getResource("/principal.png")).getImage());
		this.setTitle("Buscaminas- Fernando Ares Louro");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		crearPrimerPanel();
		crearSegundoPanel();
		crearMenu();
	}

	private void crearPrimerPanel() {
		this.getContentPane().add(primerPanel);
		primerPanel.setLayout(null);
		primerPanel.setVisible(true);
		setResizable(false);
		primerPanel.setBounds(0, 0, 500, 500);
	
		JLabel texto1 = new JLabel();
		primerPanel.add(texto1);
		texto1.setText("BUSCAMINAS");
	    texto1.setOpaque(true);
	    texto1.setBounds(190, 30, 100, 30);
		
		JButton boton = new JButton();
		primerPanel.add(boton);
		boton.setBounds(110, 100, 250, 250);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
		boton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/principal.png")).getImage()
				.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT)));
		
		boton.addActionListener(new ActionListener() {
			
				@Override
		public void actionPerformed(ActionEvent arg0) {
				primerPanel.setVisible(false);
				segundoPanel.setVisible(true);
		}
		});
		JLabel texto2 = new JLabel();
		primerPanel.add(texto2);
		texto2.setText("Pulse en la imagen para empezar a jugar");
		texto2.setOpaque(true);
		texto2.setBounds(125, 400, 250, 30);
	   
		
	}
	
	public void crearMenu() {
		JMenu partidaMenu = new JMenu("Partida");
		partidaMenu.setMnemonic(KeyEvent.VK_P);
		
		JMenu opcionesMenu = new JMenu("Opciones");
		opcionesMenu.setMnemonic(KeyEvent.VK_O);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenuItem nuevaPartida = new JMenuItem("Nueva Partida");
		nuevaPartida.setIcon(new ImageIcon("/nuevaPartida.png"));
		nuevaPartida.setMnemonic(KeyEvent.VK_N);
		nuevaPartida.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
			
		JMenuItem guardarPartida = new JMenuItem("Guardar Partida");
		guardarPartida.setMnemonic(KeyEvent.VK_G);
		guardarPartida.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
		
		JMenuItem cargarPartida = new JMenuItem("Cargar Partida");
		cargarPartida.setMnemonic(KeyEvent.VK_C);
		cargarPartida.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		
		JMenuItem salirPartida = new JMenuItem("Salir");
		salirPartida.setMnemonic(KeyEvent.VK_S);
		salirPartida.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		salirPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem almacenaResultados = new JMenuItem("Almacenar resultados");
		JMenuItem nivelDeDificultad = new JMenuItem("Nivel de dificultad");
		nivelDeDificultad.setMnemonic(KeyEvent.VK_D);
		nivelDeDificultad.setAccelerator(KeyStroke.getKeyStroke("Ctrl D"));
		partidaMenu.add(nuevaPartida);
		partidaMenu.add(guardarPartida);
		partidaMenu.add(cargarPartida);
		partidaMenu.add(salirPartida);
		opcionesMenu.add(almacenaResultados);
		opcionesMenu.add(nivelDeDificultad);
		menuBar.add(partidaMenu);
		menuBar.add(opcionesMenu);
		segundoPanel.add(menuBar, BorderLayout.NORTH);  

		
	}
	
	public void crearSegundoPanel() {
		setResizable(true);
		setLayout(new BorderLayout());
		this.getContentPane().add(segundoPanel, BorderLayout.CENTER);
		segundoPanel.setLayout(new BorderLayout());
		tableroFacil = new Tablero(8,8);
		segundoPanel.add(tableroFacil, BorderLayout.CENTER);
		tableroFacil.setVisible(true);
		
	
	}
	
}
