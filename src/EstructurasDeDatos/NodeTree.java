package EstructurasDeDatos;

import java.util.ArrayList;

public class NodeTree <K, V> {
	
	private NodeTree<K, V> father;
	private NodeTree<K, V> leftChild;
	private NodeTree<K, V> rightChild;
	private K key;
	private V value;
	
	public NodeTree(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public ArrayList<NodeTree<K, V>> inOrden() {
		ArrayList<NodeTree<K, V>> a = new ArrayList<>();
		return a;
	}

	public ArrayList<NodeTree<K, V>> postOrden() {
		return null;
	}

	public ArrayList<NodeTree<K, V>> preOrden() {
		return null;
	}
	
	public NodeTree<K, V> min(){
		if (leftChild!=null) 
			return leftChild.min();
		else 
			return this;
	}

	public NodeTree<K, V> max(){
		if (rightChild!=null) 
			return rightChild.max();
		else 
			return this;
	}
	

	public NodeTree<K, V> getFather() {
		return father;
	}

	public void setFather(NodeTree<K, V> father) {
		this.father = father;
	}

	public NodeTree<K, V> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeTree<K, V> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeTree<K, V> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeTree<K, V> rightChild) {
		this.rightChild = rightChild;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
