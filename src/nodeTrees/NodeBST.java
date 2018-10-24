package nodeTrees;

import java.util.ArrayList;

public class NodeBST <K, V> {
	
	private NodeBST<K, V> father;
	private NodeBST<K, V> leftChild;
	private NodeBST<K, V> rightChild;
	private K key;
	private V value;
	
	public NodeBST(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public ArrayList<NodeBST<K, V>> inOrden() {
		ArrayList<NodeBST<K, V>> a = new ArrayList<>();
		return a;
	}

	public ArrayList<NodeBST<K, V>> postOrden() {
		return null;
	}

	public ArrayList<NodeBST<K, V>> preOrden() {
		return null;
	}
	
	public NodeBST<K, V> min(){
		if (leftChild!=null) 
			return leftChild.min();
		else 
			return this;
	}
	
    public NodeBST<K, V> deleteMin() {
        if (leftChild == null) 
        	return rightChild;
        leftChild = leftChild.deleteMin();
        return this;
    }

	public NodeBST<K, V> max(){
		if (rightChild!=null) 
			return rightChild.max();
		else 
			return this;
	}
	
	public NodeBST<K, V> deleteMax() {
		if (rightChild == null) 
			return leftChild;
		rightChild = rightChild.deleteMin();
		return this;
	}
	

	public NodeBST<K, V> getFather() {
		return father;
	}

	public void setFather(NodeBST<K, V> father) {
		this.father = father;
	}

	public NodeBST<K, V> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeBST<K, V> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeBST<K, V> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeBST<K, V> rightChild) {
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
