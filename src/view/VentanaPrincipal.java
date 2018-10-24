package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.FBA;
import model.Player;

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
		pOpciones = new PanelOpciones(this);
		jDialogDatos = new JDialogDatos(this);
		add(pInfJugador,BorderLayout.CENTER);
		add(pOpciones,BorderLayout.SOUTH);
		pack();
	}
	
	public void addPlayerRedBlackBST(String name, int age, String team, int rointsPerGame, int reboundsPerGame, int AssistsPerGame, int robberiesByGames, int blockingByGames ) {
		fBA.getPlayersRedBlackTree().put(name, new Player(name, age, team, rointsPerGame, reboundsPerGame, AssistsPerGame, robberiesByGames, blockingByGames));
	}
	public void addPlayerAVLBst(String name, int age, String team, int rointsPerGame, int reboundsPerGame, int AssistsPerGame, int robberiesByGames, int blockingByGames ) {
		fBA.getPlayersAVlTree().put(name,new Player(name, age, team, rointsPerGame, reboundsPerGame, AssistsPerGame, robberiesByGames, blockingByGames));
	}
	
	public void addPlayerBST(String name, int age, String team, int rointsPerGame, int reboundsPerGame, int AssistsPerGame, int robberiesByGames, int blockingByGames ) {
		fBA.getPlayersAVlTree().put(name,new Player(name, age, team, rointsPerGame, reboundsPerGame, AssistsPerGame, robberiesByGames, blockingByGames));
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		VentanaPrincipal main = new VentanaPrincipal();
	}

}
