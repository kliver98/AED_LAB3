package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import DataStructures.AVLTreeST;
import DataStructures.BST;
import DataStructures.RedBlackBST;

public class FBA {
	public static String PATHFOLDER = "data/";
	
	private RedBlackBST<String, String> playersRedBlackTreeSTL;
	private BST< String, String> playersBSTSTL;
	private AVLTreeST< String, String> playersAVlTreeAST;
	private BST< String, String> playersBSTAST;
	private AVLTreeST< String, String> playersAVlTreeTRB;
	private RedBlackBST<String, String> playersRedBlackTreeBLK;
	
	private String folderName;
	private String pathName;
	
	public FBA() {
		playersAVlTreeAST = new AVLTreeST<>();
		playersBSTAST = new BST<>();
		playersRedBlackTreeSTL = new RedBlackBST<>();
		playersBSTSTL = new BST<>();
		playersAVlTreeTRB = new AVLTreeST<>();
		playersRedBlackTreeBLK = new RedBlackBST<>();
	}
	
	public void initialData(String path) throws IOException {
		loadData(path);
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
				playersAVlTreeAST.put(line, arr[i].getPath());
				playersBSTAST.put(line, arr[i].getPath());
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
				playersRedBlackTreeSTL.put(line, arr[i].getPath());
				playersBSTSTL.put(line, arr[i].getPath());
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
				playersAVlTreeTRB.put(line, arr[i].getPath());
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
				playersRedBlackTreeBLK.put(line, arr[i].getPath());
				in.close();
			}
		}
	}

	public RedBlackBST<String, String> getPlayersRedBlackTreeSTL() {
		return playersRedBlackTreeSTL;
	}

	public void setPlayersRedBlackTreeSTL(RedBlackBST<String, String> playersRedBlackTreeSTL) {
		this.playersRedBlackTreeSTL = playersRedBlackTreeSTL;
	}

	public BST<String, String> getPlayersBSTSTL() {
		return playersBSTSTL;
	}

	public void setPlayersBSTSTL(BST<String, String> playersBSTSTL) {
		this.playersBSTSTL = playersBSTSTL;
	}

	public AVLTreeST<String, String> getPlayersAVlTreeAST() {
		return playersAVlTreeAST;
	}

	public void setPlayersAVlTreeAST(AVLTreeST<String, String> playersAVlTreeAST) {
		this.playersAVlTreeAST = playersAVlTreeAST;
	}

	public BST<String, String> getPlayersBSTAST() {
		return playersBSTAST;
	}

	public void setPlayersBSTAST(BST<String, String> playersBSTAST) {
		this.playersBSTAST = playersBSTAST;
	}

	public AVLTreeST<String, String> getPlayersAVlTreeTRB() {
		return playersAVlTreeTRB;
	}

	public void setPlayersAVlTreeTRB(AVLTreeST<String, String> playersAVlTreeTRB) {
		this.playersAVlTreeTRB = playersAVlTreeTRB;
	}

	public RedBlackBST<String, String> getPlayersRedBlackTreeBLK() {
		return playersRedBlackTreeBLK;
	}

	public void setPlayersRedBlackTreeBLK(RedBlackBST<String, String> playersRedBlackTreeBLK) {
		this.playersRedBlackTreeBLK = playersRedBlackTreeBLK;
	}
}
