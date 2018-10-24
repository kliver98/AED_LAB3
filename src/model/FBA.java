package model;

import DataStructures.AVLTreeST;
import DataStructures.BST;
import DataStructures.RedBlackBST;

public class FBA {
	
	private RedBlackBST<String, Player> playersRedBlackTree;
	private AVLTreeST< String, Player> playersAVlTree;
	private BST< String, Player> playersBST; 
 	
	public BST<String, Player> getPlayersBST() {
		return playersBST;
	}

	public void setPlayersBST(BST<String, Player> playersBST) {
		this.playersBST = playersBST;
	}

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
	
	

}
