package EstructurasDeDatos;

import interfaces.IABB;

public class Arbol<K extends Comparable<K>, V> implements IABB<K, V> {
	
	private NodoArbol<K, V> root;

	@Override
	public void addElementABB(K key, V value) {
		if (root == null) 
			root = new NodoArbol<K, V>(key, value);
		else {
			NodoArbol<K, V> temp = root;
			while(temp != null) {
				if (temp.getKey().compareTo(key)>0) {
					if (temp.getRightChild()==null) 
						temp.setRightChild(new NodoArbol<K, V>(key, value));
					else 
						temp = temp.getRightChild();
				}
				else {
					if (temp.getLeftChild()==null) 
						temp.setLeftChild(new NodoArbol<K, V>(key, value));
					else 
						temp = temp.getLeftChild();
				}
			}
		}
		
		
	}

	@Override
	public void removeElementABB(K key) {
		
		
	}

	@Override
	public V searchElementABB(K key) {
		V rst = null;
		
		if (root != null) {
			NodoArbol<K, V> temp = root;
			boolean st = true;
			while(temp != null && st) {
				if (temp.getKey().compareTo(key)==0) {
					st = false;
					rst = temp.getValue();
				}
				else if (temp.getKey().compareTo(key)>0) 
					temp = temp.getRightChild();
				else 
					temp = temp.getLeftChild();
			}
		}
		return rst;
	}
	
	public NodoArbol<K, V> searchNode(K key){
		NodoArbol<K, V> rst = null;
		
		if (root != null) {
			NodoArbol<K, V> temp = root;
			boolean st = true;
			while(temp != null && st) {
				if (temp.getKey().compareTo(key)==0) {
					st = false;
					rst = temp;
				}
				else if (temp.getKey().compareTo(key)>0) 
					temp = temp.getRightChild();
				else 
					temp = temp.getLeftChild();
			}
		}
		return rst;
	}

}