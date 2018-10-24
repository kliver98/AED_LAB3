package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import DataStructures.AVLTreeST;
import DataStructures.RedBlackBST;

public class FBA {
	public static String PATHFOLDER = "data/temp";
	
	private RedBlackBST<String, Player> playersRedBlackTree;
	private AVLTreeST< String, Player> playersAVlTree;
	private String fileName;
	
	public FBA() {
		
	}

	public RedBlackBST<String, Player> getPlayersRedBlackTree() {
		return playersRedBlackTree;
	}

	public void setPlayersRedBlackTree(RedBlackBST<String, Player> playersRedBlackTree) {
		this.playersRedBlackTree = playersRedBlackTree;
	}

	public AVLTreeST<String, Player> getPlayersAVlTree() {
		return playersAVlTree;
	}

	public void setPlayersAVlTree(AVLTreeST<String, Player> playersAVlTree) {
		this.playersAVlTree = playersAVlTree;
	}
	
	public void loadData(String path) throws IOException {
		File file = new File(path);
		File folder = new File("data\\temp"+file.getName());
		
		if (!folder.exists()) {
			folder.mkdirs();
			
			BufferedReader bReader = new BufferedReader(new FileReader(file));
			
			String line = bReader.readLine();
			String line1 = "";
			int conta = 1;
			
			while((line1 = bReader.readLine())!=null) {
				FileWriter fileWriter = new FileWriter(folder.toString()+"/Player"+conta+".bin");
				BufferedWriter bWriter  = new BufferedWriter(fileWriter);
				
				bWriter.write(line+"\n"+line1+"\n");
				bWriter.close();
				
				conta++;
			}
			bReader.close();
		}
		else {
			throw new FileAlreadyExistsException("The file exist");
		}
		
	}

}
