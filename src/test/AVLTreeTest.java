package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

import DataStructures.AVLTreeST;
import junit.framework.TestCase;
import model.Player;

class AVLTreeTest extends TestCase {
	
	private AVLTreeST<String, Player> AVLTree;
	public void stageOne() {
		AVLTree =  new AVLTreeST<>();	
	}
	@Test
	public void insertTestOne() {
		stageOne();
		
		Player player  =  new Player("Kliver", 19, "c", 1, 1, 1,1,1 );
		AVLTree.put(player.getName(), player);
			boolean result = false;
			boolean resultExpected = AVLTree.isEmpty();
			assertTrue(resultExpected  == result);		
	}
	@Test
	public void deleteTest() {
		stageOne();
		Player [] arrayPlayers = new Player [12]; 
		String [] names = new String []{"a", "b" ,"c", "d", "e", "f", "g", "h", "i", "j", "k ", "l"};
			for (int i = 0; i < arrayPlayers.length; i++) {
				AVLTree.put(names[i], new Player(names[i], 2,"x", 1,2,3,4,5));
			}
			AVLTree.delete("c");
		Player playerExpected = null;
		Player playerResult = AVLTree.get("c");
		assertTrue(playerResult == playerExpected);
	}
	@Test
	public void searhTest() {
		
		stageOne();
		Player [] arrayPlayers = new Player [12]; 
		
		String [] names = new String []{"a", "b" ,"c", "d", "e", "f", "g", "h", "i", "j", "k ", "l"};
			for (int i = 0; i < arrayPlayers.length; i++) {
				AVLTree.put(names[i], new Player(names[i], 2,"x", 1,2,3,4,5));
			}
		Player toAdd = new Player("z", 2,"x", 1,2,3,4,5);
		AVLTree.put(toAdd.getName(), toAdd);
		Player playerExpected = toAdd;
		Player playerResult = AVLTree.get("z");
		assertTrue(playerExpected == playerResult);
		
	}
	

}
