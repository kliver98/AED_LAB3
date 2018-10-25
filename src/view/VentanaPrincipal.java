package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.FBA;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	
	public static final int WIDTH = 580;
	public static final int HEIGHT = 650;
	public static final String TITLE = "Base de datos de jugadores de baloncesto";
	
	private PanelInformacionJugador pInfJugador;
	private PanelOpciones pOpciones;
	private JDialogDatos jDialogDatos;
	private FBA fBA;
	
	public VentanaPrincipal() {
		
		fBA = new FBA();
		
		//Pruebas para ver si funcionan, manejar las exceciones
		
		try {
			fBA.initialData("data/NBASeasonData.csv");
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setLocation((int)(dm.width/(3.8)),dm.height/15);
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		agregarPaneles();
		this.setVisible(true);
	}
	
	public void agregarPaneles() {
		pInfJugador = new PanelInformacionJugador();
		pOpciones = new PanelOpciones();
		jDialogDatos = new JDialogDatos(this);
		add(pInfJugador,BorderLayout.CENTER);
		add(pOpciones,BorderLayout.SOUTH);
		pack();
	}
	
	public void addPlayer(String name, int age, String team, int rointsPerGame, int reboundsPerGame, int AssistsPerGame, int robberiesByGames, int blockingByGames ) {
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		VentanaPrincipal main = new VentanaPrincipal();
	}

}
