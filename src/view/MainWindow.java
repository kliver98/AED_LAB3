package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import model.FIBA;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 620;
	public static final String TITLE = "Base de datos de jugadores de baloncesto";
	
	private PanelPlayerInformation pInfPlayer;
	private PanelOptions pOptions;
	private FIBA fBA;
	
	public MainWindow() {
		
		fBA = new FIBA();
		
		this.setLayout(new BorderLayout());
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setLocation((int)(dm.width/(3.8)),dm.height/10);
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		addPanels();
		this.setVisible(true);
	}
	
	public void addPanels() {
		pInfPlayer = new PanelPlayerInformation();
		pOptions = new PanelOptions(this);
		
		add(pInfPlayer,BorderLayout.CENTER);
		add(pOptions,BorderLayout.SOUTH);
		pack();
	}
	
	/**
	 * Put into PanelPlayerInformation a list of players with robberies greater than or equal to one given, red black tree. <br>
	 * @param ast integer
	 * @throws IOException 
	 */
	public void playerWithSTLGreaterRedBlackTree(double stl) {
		try {
			pInfPlayer.updateListPlayers(fBA.playerWithSTLGreaterRedBlackTree(stl));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Put into PanelPlayerInformation a list of players with robberies greater than or equal to one given, bst tree. <br>
	 * @param ast integer
	 * @throws IOException 
	 */
	public void playerWithSTLGreaterBSTTree(double stl) {
		try {
			pInfPlayer.updateListPlayers(fBA.playerWithSTLGreaterBSTTree(stl));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Put into PanelPlayerInformation a list of players with attendance greater than or equal to one given, AVL tree. <br>
	 * @param ast integer
	 * @throws IOException 
	 */
	public void playerWithASTGreaterAVLTree(double ast) {
		try {
			pInfPlayer.updateListPlayers(fBA.playerWithASTGreaterAVLTree(ast));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Put into PanelPlayerInformation a list of players with attendance greater than or equal to one given, bst tree. <br>
	 * @param ast integer
	 * @throws IOException 
	 */
	public void playerWithASTGreaterBSTTree(double ast) {
		try {
			pInfPlayer.updateListPlayers(fBA.playerWithASTGreaterBSTTree(ast));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Put into PanelPlayerInformation a list of players with rebounds greater than or equal to one given, AVL tree. <br>
	 * @param ast integer
	 * @throws IOException 
	 */
	public void playerWithTRBGreaterAVLTree(double TRB) {
		try {
			pInfPlayer.updateListPlayers(fBA.playerWithTRBGreaterAVLTree(TRB));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Put into PanelPlayerInformation a list of players with blocking greater than or equal to one given, red black tree. <br>
	 * @param ast integer
	 * @throws IOException 
	 */
	public void playerWithBLKGreaterBSTTree(double blk) {
		try {
			pInfPlayer.updateListPlayers(fBA.playerWithBLKGreaterBSTTree(blk));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFile(String path) {
		fBA.initialData(path);
	}
	
	public void addPlayer(String name, int age, String team, double pointsPerGame, double reboundsPerGame, double assistsPerGame,
			double robberiesByGames, double blockingByGames) {
		try {
			fBA.addPlayer(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
		} catch (IOException e) {
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MainWindow main = new MainWindow();
	}

}
