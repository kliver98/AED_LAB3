package test;

import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

import DataStructures.RedBlackBST;

class RedBlackTreeTest extends TestCase {
	
	private RedBlackBST< Integer,Integer> redBlackTree;
	public RedBlackTreeTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void stageOne() {
		redBlackTree = new RedBlackBST<Integer , Integer>();
	}
	@Test
	public void insertTest() {
		stageOne();
		for (int i = 0; i < 200; i++) {
			redBlackTree.put(i, i);
		}
		redBlackTree.put(1, 1);
		boolean result = redBlackTree.isEmpty();
		boolean resultExpected = false;
		
		assertTrue(resultExpected == result);
			
	}

}
