package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.ArrayList;
import model.FIBA;
import model.Player;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 620;
	public static final String TITLE = "Base de datos de jugadores de baloncesto";
	
	private PanelPlayerInformation pInfJugador;
	private PanelOptions pOpciones;
	private JDialogDatos jDialogDatos;
	private FIBA fBA;
	
	public MainWindow() {
		
		fBA = new FIBA();
		
		//Pruebas para ver si funcionan, manejar las exceciones
		
//		try {
//			fBA.initialData("data/NBASeasonData.csv");
//		} catch (FileAlreadyExistsException e) {
//			e.printStackTrace();
//			//si el archivo se encuentra solo se crean los arboles
//			try {
//				fBA.initialData();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			fBA.addPlayer("joe", 10, "HOLA", 10, 11, 5, 3, 40);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		try {
			ArrayList<Player> players = fBA.playerWithASTGreaterAVLTree(20);
			for (int i = 0; i < players.size(); i++) {
				System.out.println(players.get(i).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setLocation((int)(dm.width/(3.8)),dm.height/10);
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		agregarPaneles();
		this.setVisible(true);
	}
	
	public void agregarPaneles() {
		pInfJugador = new PanelPlayerInformation(this);
		pOpciones = new PanelOptions();
		jDialogDatos = new JDialogDatos(this);
		add(pInfJugador,BorderLayout.CENTER);
		add(pOpciones,BorderLayout.SOUTH);
		pack();
	}
	
	public void addPlayer(String name, int age, String team, int pointsPerGame, int reboundsPerGame, int assistsPerGame, int robberiesByGames, int blockingByGames ) {
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MainWindow main = new MainWindow();
	}

}
