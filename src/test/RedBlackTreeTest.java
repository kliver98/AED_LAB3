package test;

import junit.framework.TestCase;
import model.Player;

import org.junit.jupiter.api.Test;

import DataStructures.RedBlackBST;

class RedBlackTreeTest extends TestCase {
	
	private RedBlackBST<String,Player> redBlackTree;
	public RedBlackTreeTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void stageOne() {
		redBlackTree = new RedBlackBST<String , Player>();
	}
	@Test
	public void insertTestOne() {
		stageOne();
		
		Player player  =  new Player("Kliver", 19, "c", 1, 1, 1,1,1 );
			redBlackTree.put(player.getName(), player);
			boolean result = false;
			boolean resultExpected = redBlackTree.isEmpty();
			assertTrue(resultExpected  == result);
			
	}
	
//	@Test 
//	public void insertTestTwo() {
//		stageOne();
//		
//	}
	
	@Test
	public void deleteTest() {
		stageOne();
		Player [] arrayPlayers = new Player [12]; 
		String [] names = new String []{"a", "b" ,"c", "d", "e", "f", "g", "h", "i", "j", "k ", "l"};
			for (int i = 0; i < arrayPlayers.length; i++) {
				redBlackTree.put(names[i], new Player(names[i], 2,"x", 1,2,3,4,5));
			}
		redBlackTree.delete("c");
		Player playerExpected = null;
		Player playerResult = redBlackTree.get("c");
		assertTrue(playerResult == playerExpected);
	}
	@Test
	public void searhTest() {
		
		stageOne();
		Player [] arrayPlayers = new Player [12]; 
		
		String [] names = new String []{"a", "b" ,"c", "d", "e", "f", "g", "h", "i", "j", "k ", "l"};
			for (int i = 0; i < arrayPlayers.length; i++) {
				redBlackTree.put(names[i], new Player(names[i], 2,"x", 1,2,3,4,5));
			}
		Player toAdd = new Player("z", 2,"x", 1,2,3,4,5);
		redBlackTree.put(toAdd.getName(), toAdd);
		Player playerExpected = toAdd;
		Player playerResult = redBlackTree.get("c");
		assertTrue(playerExpected == playerResult);
		
	}
	
	

}
