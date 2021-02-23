package org.liceolapaz.des.fal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;



public class Ventana extends JFrame {
	private Tablero tableroFacil;
	
	
	public Ventana(){
		super();
		JFrame ventana = new JFrame();
		this.setVisible(true);
		this.setSize(500,500);
		this.setIconImage(new ImageIcon(getClass().getResource("/principal.png")).getImage());
		this.setTitle("Buscaminas- Fernando Ares Louro");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		//this.setJMenuBar(menubar);
		crearMenu();
		initComponents();
	}

	private void initComponents() {
	//
		
		
//		JPanel primerPanel = new JPanel();
//		primerPanel.setLayout(new BoxLayout(primerPanel, BoxLayout.Y_AXIS));
//		primerPanel.setBackground(Color.GRAY);
//		primerPanel.setVisible(true);
//		
//		JLabel texto1 = new JLabel();
//		texto1.setText("BUSCAMINAS");
//		texto1.setOpaque(true);
//		texto1.setBackground(Color.LIGHT_GRAY);
//		
////		JButton boton = new JButton();
////		boton.setIcon(new ImageIcon(getClass().getResource("/principal.png")));
//		
//		JLabel texto2 = new JLabel();
//		texto2.setText("Pulse en la imagen para empezar a jugar");
//		texto2.setOpaque(true);
//		texto2.setBackground(Color.LIGHT_GRAY);
//		
//		
//		primerPanel.add(texto1);
////		primerPanel.add(boton);
//		
//		this.getContentPane().add(primerPanel);
		crearSegundoPanel();
		crearTablero(10,10,10);
	}
	
	private void crearTablero(int filas, int columnas, int minas) {
		this.tableroFacil = new Tablero(this, filas, columnas, minas);
		tableroFacil.setBorder(new LineBorder(Color.BLACK, 5));
		add(tableroFacil, BorderLayout.CENTER);
		
	}

	public void crearMenu() {
		JMenu partidaMenu = new JMenu("Partida");
		partidaMenu.setMnemonic(KeyEvent.VK_P);
		//partidaMenu.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));

		JMenu opcionesMenu = new JMenu("Opciones");
		opcionesMenu.setMnemonic(KeyEvent.VK_O);
		//opcionesMenu.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
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
		nivelDeDificultad.setAccelerator(KeyStroke.getKeyStroke("Ctrl+D"));
		
		partidaMenu.add(nuevaPartida);
		partidaMenu.add(guardarPartida);
		partidaMenu.add(cargarPartida);
		partidaMenu.add(salirPartida);
		opcionesMenu.add(almacenaResultados);
		opcionesMenu.add(nivelDeDificultad);
		menuBar.add(partidaMenu);
		menuBar.add(opcionesMenu);
		
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
		
		
	}
	
	public void crearSegundoPanel() {
		JPanel segundoPanel = new JPanel();
		segundoPanel.setBounds(0, 0, 500, 500);
		segundoPanel.setVisible(true);
		segundoPanel.setBackground(Color.lightGray);
	    this.getContentPane().add(segundoPanel);
	    
	}
	
//	private void addPanel(JPanel panel) {
//		this.getContentPane().add(panel); FORMA PASO POR PARAMETRO DE COMPONENTE
//	}
		
	
		

}
