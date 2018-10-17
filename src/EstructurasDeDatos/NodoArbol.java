package EstructurasDeDatos;

import java.util.ArrayList;

public class NodoArbol <K, V> {
	
	private NodoArbol<K, V> father;
	private NodoArbol<K, V> leftChild;
	private NodoArbol<K, V> rightChild;
	private K key;
	private V value;
	
	public NodoArbol(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public ArrayList<NodoArbol<K, V>> inOrden() {
		ArrayList<NodoArbol<K, V>> a = new ArrayList<>();
		return a;
	}

	public ArrayList<NodoArbol<K, V>> postOrden() {
		return null;
	}

	public ArrayList<NodoArbol<K, V>> preOrden() {
		return null;
	}
	
	public NodoArbol<K, V> maxLeft(){
		if (rightChild!=null) {
			return rightChild.maxLeft();
		}
		else {
			return this;
		}
	}

	public NodoArbol<K, V> maxRight(){
		if (leftChild!=null) {
			return leftChild.maxLeft();
		}
		else {
			return this;
		}
	}
	

	public NodoArbol<K, V> getFather() {
		return father;
	}

	public void setFather(NodoArbol<K, V> father) {
		this.father = father;
	}

	public NodoArbol<K, V> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodoArbol<K, V> leftChild) {
		this.leftChild = leftChild;
	}

	public NodoArbol<K, V> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodoArbol<K, V> rightChild) {
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
