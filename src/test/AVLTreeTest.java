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
Player player1  =  new Player("Kliver", 19, "C", 1, 1, 1,1,1 );
Player player2 =  new Player("Federico", 12, "A", 1, 1, 1,1,1 );
Player player3  =  new Player("Calos", 39, "B", 1, 1, 1,1,1 );
Player player4  =  new Player("Alberto", 29, "R", 1, 1, 1,1,1 );
Player player5  =  new Player("Jose", 19, "K", 1, 1, 1,1,1 );
AVLTree.put(player1.getName(), player1);
AVLTree.put(player2.getName(), player2);
AVLTree.put(player3.getName(), player3);
AVLTree.put(player4.getName(), player4);
AVLTree.put(player5.getName(), player5);
boolean result = false;
boolean resultExpected = AVLTree.isEmpty();
assertTrue(resultExpected  == result);
}
@Test
public void deleteTest() {
stageOne();
Player [] arrayPlayers = new Player [12]; 
String [] names = new String []{"Antonio", "Federico" ,"Martin", "Jose", "Carlos", "Joe", "Kliver", "Andres", "Christian", "Armando", "Miguel ", "Huberth"};
for (int i = 0; i < arrayPlayers.length; i++) {
AVLTree.put(names[i], new Player(names[i], 2,"x", 1,2,3,4,5));
}
AVLTree.delete("Antonio");
Player playerExpected = null;
Player playerResult = AVLTree.get("Antionio");
assertTrue(playerResult == playerExpected);
}
@Test
public void searhTest() {
stageOne();
Player [] arrayPlayers = new Player [12]; 
String [] names = new String []{"Manuel", "Castillo" ,"Alberto", "Daniel", "Omar", "Nicolas", "Pedro", "Hernan", "Ancizar", "Esteban", "Roberto ", "Cristobal"};
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