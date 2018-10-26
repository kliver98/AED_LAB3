package model;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

import DataStructures.*;
import nodeTrees.*;

public class FIBA {
	public static String PATHFOLDER = "data/";
	public static String PATHFOLDERTEMP = "data/dataPlayerTemp/";
	
	private RedBlackBST<Double, String> playersRedBlackTreeSTL;
	private BST<Double, String> playersBSTSTL;
	private AVLTreeST<Double, String> playersAVlTreeAST;
	private BST<Double, String> playersBSTAST;
	private AVLTreeST<Double, String> playersAVlTreeTRB;
	private RedBlackBST<Double, String> playersRedBlackTreeBLK;
	
	private String folderName;
	private String pathName;
	
	public FIBA() {
		playersAVlTreeAST = new AVLTreeST<>();
		playersBSTAST = new BST<>();
		playersRedBlackTreeSTL = new RedBlackBST<>();
		playersBSTSTL = new BST<>();
		playersAVlTreeTRB = new AVLTreeST<>();
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
		
		int i = 0;
		
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
			
			System.out.println(++i);
			if (cmp < 0) 
				x = x.getLeftChild();
			else if (cmp > 0) 
				x = x.getRightChild();
		}
		
		return players;
	}
	
	/**
	 * Returns a list of players with rebounds greater than or equal to one given, AVL tree. <br>
	 * @param ast integer
	 * @return list
	 * @throws IOException 
	 */
	public ArrayList<Player> playerWithTRBGreaterAVLTree(double TRB) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		Double astD = TRB;
		
		NodeAVLBST<Double, String> x = playersAVlTreeTRB.getRoot();
		
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
		createTreeTRB();
	}
	
	public void initialData() throws IOException {
		createTreeAST();
		createTreeBLK();
		createTreeSTL();
		createTreeTRB();
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
	
	//Crea arbol avl por rebotes (TRB)
	public void createTreeTRB() throws IOException {
		File folder = new File(PATHFOLDER+folderName);
		if (folder.exists()) {
			File arr[] = folder.listFiles();
			for (int i = 0; i < arr.length; i++) {
				BufferedReader in = new BufferedReader(new FileReader(arr[i]));
				String line = in.readLine().split(",")[12];
				double TRB = Double.parseDouble(line);
				playersAVlTreeTRB.put(TRB, arr[i].getPath());
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
	
	public void addPlayer(String name, int age, String team, double pointsPerGame, double reboundsPerGame, double assistsPerGame,
			double robberiesByGames, double blockingByGames) throws IOException {
		File folder = new File(PATHFOLDERTEMP);
		File arr[] = folder.listFiles();
		int tam = arr.length;
		File file = new File(PATHFOLDERTEMP+"Jugador"+(tam+1)+".bin");
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		String line = ","+team+","+name+","+age+",,,"+pointsPerGame+",,,,,,"+reboundsPerGame+","+assistsPerGame+","+robberiesByGames+","+blockingByGames+",,,,";
		out.write(line);
		out.close();
		playersRedBlackTreeSTL.put(robberiesByGames, file.getPath());;
		playersBSTSTL.put(robberiesByGames, file.getPath());;
		playersAVlTreeAST.put(assistsPerGame, file.getPath());;
		playersBSTAST.put(assistsPerGame, file.getPath());;
		playersAVlTreeTRB.put(reboundsPerGame, file.getPath());;
		playersRedBlackTreeBLK.put(blockingByGames, file.getPath());;
		
	}
	
	/**
	 * Search player with assists in avl Tree.<br>
	 * @param ast
	 * @return
	 * @throws IOException
	 */
	public Player getPlayerAVLperAST(double ast) throws IOException {
		Double temp = ast;
		
		File file = new File(playersAVlTreeAST.get(temp));
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		String arr[] = in.readLine().split(",");
		
		String name = arr[2];
		int age = Integer.parseInt(arr[3]);
		String team = arr[1];
		double pointsPerGame = Double.parseDouble(arr[6]);
		double reboundsPerGame = Double.parseDouble(arr[12]);
		double assistsPerGame = Double.parseDouble(arr[13]);
		double robberiesByGames = Double.parseDouble(arr[14]);
		double blockingByGames = Double.parseDouble(arr[15]);
		
		Player temP = new Player(name, age, team, pointsPerGame, reboundsPerGame, assistsPerGame, robberiesByGames, blockingByGames);
		
		in.close();
		
		return temP;
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

	public AVLTreeST<Double, String> getPlayersAVlTreeTRB() {
		return playersAVlTreeTRB;
	}

	public void setPlayersAVlTreeTRB(AVLTreeST<Double, String> playersAVlTreeTRB) {
		this.playersAVlTreeTRB = playersAVlTreeTRB;
	}

	public RedBlackBST<Double, String> getPlayersRedBlackTreeBLK() {
		return playersRedBlackTreeBLK;
	}

	public void setPlayersRedBlackTreeBLK(RedBlackBST<Double, String> playersRedBlackTreeBLK) {
		this.playersRedBlackTreeBLK = playersRedBlackTreeBLK;
	}
}
