package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import DataStructures.BST;
import model.Player;

class BStTreeTest {

	private BST< String, Player> bSTtTree;
		
	public void stageOne() {
		bSTtTree = new BST<>();
	}
	
	@Test
	public void insertTestOne() {
		stageOne();
		
		Player player  =  new Player("Kliver", 19, "c", 1, 1, 1,1,1 );
		bSTtTree.put(player.getName(), player);
			boolean result = false;
			boolean resultExpected = bSTtTree.isEmpty();
			assertTrue(resultExpected  == result);		
	}
	@Test
	public void deleteTest() {
		stageOne();
		Player [] arrayPlayers = new Player [12]; 
		String [] names = new String []{"a", "b" ,"c", "d", "e", "f", "g", "h", "i", "j", "k ", "l"};
			for (int i = 0; i < arrayPlayers.length; i++) {
				bSTtTree.put(names[i], new Player(names[i], 2,"x", 1,2,3,4,5));
			}
			bSTtTree.delete("c");
		Player playerExpected = null;
		Player playerResult = bSTtTree.get("c");
		assertTrue(playerResult == playerExpected);
	}
	@Test
	public void searhTest() {
		
		stageOne();
		Player [] arrayPlayers = new Player [12]; 
		
		String [] names = new String []{"a", "b" ,"c", "d", "e", "f", "g", "h", "i", "j", "k ", "l"};
			for (int i = 0; i < arrayPlayers.length; i++) {
				bSTtTree.put(names[i], new Player(names[i], 2,"x", 1,2,3,4,5));
			}
		Player toAdd = new Player("z", 2,"x", 1,2,3,4,5);
		bSTtTree.put(toAdd.getName(), toAdd);
		Player playerExpected = toAdd;
		Player playerResult = bSTtTree.get("z");
		assertTrue(playerExpected == playerResult);
		
	}
	

}
