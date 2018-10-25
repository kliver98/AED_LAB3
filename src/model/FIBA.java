package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

import DataStructures.AVLTreeST;
import DataStructures.BST;
import DataStructures.RedBlackBST;
import nodeTrees.NodeAVLBST;
import nodeTrees.NodeBST;
import nodeTrees.NodeRedBlackBST;

public class FIBA {
	public static String PATHFOLDER = "data/";
	
	private RedBlackBST<Double, String> playersRedBlackTreeSTL;
	private BST<Double, String> playersBSTSTL;
	private AVLTreeST<Double, String> playersAVlTreeAST;
	private BST<Double, String> playersBSTAST;
	private AVLTreeST<Double, String> playersAVlTreeDRB;
	private RedBlackBST<Double, String> playersRedBlackTreeBLK;
	
	private String folderName;
	private String pathName;
	
	public FIBA() {
		playersAVlTreeAST = new AVLTreeST<>();
		playersBSTAST = new BST<>();
		playersRedBlackTreeSTL = new RedBlackBST<>();
		playersBSTSTL = new BST<>();
		playersAVlTreeDRB = new AVLTreeST<>();
		playersRedBlackTreeBLK = new RedBlackBST<>();
	}
	
	/**
	 * Returns a list of players with robberies greater than or equal to one given, red black tree. <br>
	 * @param ast integer
	 * @return list
	 * @throws IOException 
	 */
	public ArrayList<Player> playerWithSTLGreaterRedBlackTree(double stl) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		Double astD = stl;
		
		NodeRedBlackBST<Double, String> x = playersRedBlackTreeSTL.getRoot();
		
        while (x != null) {
            int cmp = astD.compareTo(x.getKey());
            
            if (cmp <= 0) {
            	File fileTemp = new File(x.getValue());
            	BufferedReader in = new BufferedReader(new FileReader(fileTemp));
            	String arr[] = in.readLine().split(",");
            	
            	String name = arr[2];
            	int age = Integer.parseInt(arr[3]);
            	String team = arr[1];
            	double pointsPerGame = Double.parseDouble(arr[6]);
            	double reboundsPerGame = Double.parseDouble(arr[12]);
            	double assistsPerGame = Double.parseDouble(arr[13]);
            	double robberiesByGames = Double.parseDouble(arr[14]);
            	double blockingByGames = Double.parseDouble(arr[15]);
            	
            	Player temp = new Player(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
            	
            	players.add(temp);
            	
            	in.close();
			}
            
            if (cmp < 0) 
            	x = x.getRightChild();
            else if (cmp > 0) 
            	x = x.getLeftChild();
        }
		
		return players;
	}
	
	/**
	 * Returns a list of players with robberies greater than or equal to one given, bst tree. <br>
	 * @param ast integer
	 * @return list
	 * @throws IOException 
	 */
	public ArrayList<Player> playerWithSTLGreaterBSTTree(double stl) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		Double astD = stl;
		
		NodeBST<Double, String> x = playersBSTSTL.getRoot();
		
		while (x != null) {
			int cmp = astD.compareTo(x.getKey());
			
			if (cmp <= 0) {
				File fileTemp = new File(x.getValue());
				BufferedReader in = new BufferedReader(new FileReader(fileTemp));
				String arr[] = in.readLine().split(",");
				
				String name = arr[2];
				int age = Integer.parseInt(arr[3]);
				String team = arr[1];
				double pointsPerGame = Double.parseDouble(arr[6]);
				double reboundsPerGame = Double.parseDouble(arr[12]);
				double assistsPerGame = Double.parseDouble(arr[13]);
				double robberiesByGames = Double.parseDouble(arr[14]);
				double blockingByGames = Double.parseDouble(arr[15]);
				
				Player temp = new Player(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
				
				players.add(temp);
				
				in.close();
			}
			
			if (cmp < 0) 
				x = x.getRightChild();
			else if (cmp > 0) 
				x = x.getLeftChild();
		}
		
		return players;
	}
	
	/**
	 * Returns a list of players with attendance greater than or equal to one given, AVL tree. <br>
	 * @param ast integer
	 * @return list
	 * @throws IOException 
	 */
	public ArrayList<Player> playerWithASTGreaterAVLTree(double ast) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		Double astD = ast;
		
		NodeAVLBST<Double, String> x = playersAVlTreeAST.getRoot();
		
		while (x != null) {
			int cmp = astD.compareTo(x.getKey());
			
			if (cmp <= 0) {
				File fileTemp = new File(x.getValue());
				BufferedReader in = new BufferedReader(new FileReader(fileTemp));
				String arr[] = in.readLine().split(",");
				
				String name = arr[2];
				int age = Integer.parseInt(arr[3]);
				String team = arr[1];
				double pointsPerGame = Double.parseDouble(arr[6]);
				double reboundsPerGame = Double.parseDouble(arr[12]);
				double assistsPerGame = Double.parseDouble(arr[13]);
				double robberiesByGames = Double.parseDouble(arr[14]);
				double blockingByGames = Double.parseDouble(arr[15]);
				
				Player temp = new Player(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
				
				players.add(temp);
				
				in.close();
			}
			
			if (cmp < 0) 
				x = x.getRightChild();
			else if (cmp > 0) 
				x = x.getLeftChild();
		}
		
		return players;
	}
	
	/**
	 * Returns a list of players with attendance greater than or equal to one given, bst tree. <br>
	 * @param ast integer
	 * @return list
	 * @throws IOException 
	 */
	public ArrayList<Player> playerWithASTGreaterBSTTree(double ast) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		Double astD = ast;
		
		NodeBST<Double, String> x = playersBSTAST.getRoot();
		
		while (x != null) {
			int cmp = astD.compareTo(x.getKey());
			
			if (cmp <= 0) {
				File fileTemp = new File(x.getValue());
				BufferedReader in = new BufferedReader(new FileReader(fileTemp));
				String arr[] = in.readLine().split(",");
				
				String name = arr[2];
				int age = Integer.parseInt(arr[3]);
				String team = arr[1];
				double pointsPerGame = Double.parseDouble(arr[6]);
				double reboundsPerGame = Double.parseDouble(arr[12]);
				double assistsPerGame = Double.parseDouble(arr[13]);
				double robberiesByGames = Double.parseDouble(arr[14]);
				double blockingByGames = Double.parseDouble(arr[15]);
				
				Player temp = new Player(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
				
				players.add(temp);
				
				in.close();
			}
			
			if (cmp < 0) 
				x = x.getRightChild();
			else if (cmp > 0) 
				x = x.getLeftChild();
		}
		
		return players;
	}
	
	/**
	 * Returns a list of players with rebounds greater than or equal to one given, AVL tree. <br>
	 * @param ast integer
	 * @return list
	 * @throws IOException 
	 */
	public ArrayList<Player> playerWithDRBGreaterAVLTree(double drb) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		Double astD = drb;
		
		NodeAVLBST<Double, String> x = playersAVlTreeDRB.getRoot();
		
		while (x != null) {
			int cmp = astD.compareTo(x.getKey());
			
			if (cmp <= 0) {
				File fileTemp = new File(x.getValue());
				BufferedReader in = new BufferedReader(new FileReader(fileTemp));
				String arr[] = in.readLine().split(",");
				
				String name = arr[2];
				int age = Integer.parseInt(arr[3]);
				String team = arr[1];
				double pointsPerGame = Double.parseDouble(arr[6]);
				double reboundsPerGame = Double.parseDouble(arr[12]);
				double assistsPerGame = Double.parseDouble(arr[13]);
				double robberiesByGames = Double.parseDouble(arr[14]);
				double blockingByGames = Double.parseDouble(arr[15]);
				
				Player temp = new Player(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
				
				players.add(temp);
				
				in.close();
			}
			
			if (cmp < 0) 
				x = x.getRightChild();
			else if (cmp > 0) 
				x = x.getLeftChild();
		}
		
		return players;
	}
	
	/**
	 * Returns a list of players with blocking greater than or equal to one given, red black tree. <br>
	 * @param ast integer
	 * @return list
	 * @throws IOException 
	 */
	public ArrayList<Player> playerWithBLKGreaterBSTTree(double blk) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		Double astD = blk;
		
		NodeRedBlackBST<Double, String> x = playersRedBlackTreeBLK.getRoot();
		
		while (x != null) {
			int cmp = astD.compareTo(x.getKey());
			
			if (cmp <= 0) {
				File fileTemp = new File(x.getValue());
				BufferedReader in = new BufferedReader(new FileReader(fileTemp));
				String arr[] = in.readLine().split(",");
				
				String name = arr[2];
				int age = Integer.parseInt(arr[3]);
				String team = arr[1];
				double pointsPerGame = Double.parseDouble(arr[6]);
				double reboundsPerGame = Double.parseDouble(arr[12]);
				double assistsPerGame = Double.parseDouble(arr[13]);
				double robberiesByGames = Double.parseDouble(arr[14]);
				double blockingByGames = Double.parseDouble(arr[15]);
				
				Player temp = new Player(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
				
				players.add(temp);
				
				in.close();
			}
			
			if (cmp < 0) 
				x = x.getRightChild();
			else if (cmp > 0) 
				x = x.getLeftChild();
		}
		
		return players;
	}
	
	public void initialData(String path) throws IOException {
		loadData(path);
		createTreeAST();
		createTreeBLK();
		createTreeSTL();
		createTreeDRB();
	}
	
	public void initialData() throws IOException {
		createTreeAST();
		createTreeBLK();
		createTreeSTL();
		createTreeDRB();
	}
	
	public void loadData(String path) throws IOException {
		File file = new File(path);
		File folder = new File("data\\temp"+file.getName());
		
		folderName = folder.getName();
		pathName = path;
		
		if (!folder.exists()) {
			folder.mkdirs();
			
			BufferedReader bReader = new BufferedReader(new FileReader(file));
			
//			String line = bReader.readLine();
			bReader.readLine();
			String line1 = "";
			int conta = 1;
			
			while((line1 = bReader.readLine())!=null) {
				FileWriter fileWriter = new FileWriter(folder.toString()+"/Player"+conta+".bin");
				BufferedWriter bWriter  = new BufferedWriter(fileWriter);
				
//				bWriter.write(line+"\n"+line1+"\n");
				bWriter.write(line1+"\n");
				bWriter.close();
				
				conta++;
			}
			bReader.close();
		}
		else {
			throw new FileAlreadyExistsException("The file exist");
		}
	}
	
	//Crea un arbol AVL y BST por asistencia
	public void createTreeAST() throws IOException {
		File folder = new File(PATHFOLDER+folderName);
		if (folder.exists()) {
			File arr[] = folder.listFiles();
			for (int i = 0; i < arr.length; i++) {
				BufferedReader in = new BufferedReader(new FileReader(arr[i]));
				String line = in.readLine().split(",")[13];
				double ast = Double.parseDouble(line);
				playersAVlTreeAST.put(ast, arr[i].getPath());
				playersBSTAST.put(ast, arr[i].getPath());
				in.close();
			}
		}
	}
	
	//Crea un arbol Rojo negro y BST por robos
	public void createTreeSTL() throws IOException {
		File folder = new File(PATHFOLDER+folderName);
		if (folder.exists()) {
			File arr[] = folder.listFiles();
			for (int i = 0; i < arr.length; i++) {
				BufferedReader in = new BufferedReader(new FileReader(arr[i]));
				String line = in.readLine().split(",")[14];
				double stl = Double.parseDouble(line);
				playersRedBlackTreeSTL.put(stl, arr[i].getPath());
				playersBSTSTL.put(stl, arr[i].getPath());
				in.close();
			}
		}
	}
	
	//Crea arbol avl por rebotes (DRB)
	public void createTreeDRB() throws IOException {
		File folder = new File(PATHFOLDER+folderName);
		if (folder.exists()) {
			File arr[] = folder.listFiles();
			for (int i = 0; i < arr.length; i++) {
				BufferedReader in = new BufferedReader(new FileReader(arr[i]));
				String line = in.readLine().split(",")[12];
				double drb = Double.parseDouble(line);
				playersAVlTreeDRB.put(drb, arr[i].getPath());
				in.close();
			}
		}
	}
	
	//Crea arbol rojo y negro por bloqueos(BLK)
	public void createTreeBLK() throws IOException {
		File folder = new File(PATHFOLDER+folderName);
		if (folder.exists()) {
			File arr[] = folder.listFiles();
			for (int i = 0; i < arr.length; i++) {
				BufferedReader in = new BufferedReader(new FileReader(arr[i]));
				String line = in.readLine().split(",")[15];
				double blk = Double.parseDouble(line);
				playersRedBlackTreeBLK.put(blk, arr[i].getPath());
				in.close();
			}
		}
	}

	public RedBlackBST<Double, String> getPlayersRedBlackTreeSTL() {
		return playersRedBlackTreeSTL;
	}

	public void setPlayersRedBlackTreeSTL(RedBlackBST<Double, String> playersRedBlackTreeSTL) {
		this.playersRedBlackTreeSTL = playersRedBlackTreeSTL;
	}

	public BST<Double, String> getPlayersBSTSTL() {
		return playersBSTSTL;
	}

	public void setPlayersBSTSTL(BST<Double, String> playersBSTSTL) {
		this.playersBSTSTL = playersBSTSTL;
	}

	public AVLTreeST<Double, String> getPlayersAVlTreeAST() {
		return playersAVlTreeAST;
	}

	public void setPlayersAVlTreeAST(AVLTreeST<Double, String> playersAVlTreeAST) {
		this.playersAVlTreeAST = playersAVlTreeAST;
	}

	public BST<Double, String> getPlayersBSTAST() {
		return playersBSTAST;
	}

	public void setPlayersBSTAST(BST<Double, String> playersBSTAST) {
		this.playersBSTAST = playersBSTAST;
	}

	public AVLTreeST<Double, String> getPlayersAVlTreeDRB() {
		return playersAVlTreeDRB;
	}

	public void setPlayersAVlTreeDRB(AVLTreeST<Double, String> playersAVlTreeDRB) {
		this.playersAVlTreeDRB = playersAVlTreeDRB;
	}

	public RedBlackBST<Double, String> getPlayersRedBlackTreeBLK() {
		return playersRedBlackTreeBLK;
	}

	public void setPlayersRedBlackTreeBLK(RedBlackBST<Double, String> playersRedBlackTreeBLK) {
		this.playersRedBlackTreeBLK = playersRedBlackTreeBLK;
	}
}
