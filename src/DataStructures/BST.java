package DataStructures;

import nodeTrees.*;
import interfaces.*;

public class BST<K extends Comparable<K>, V> implements IBST<K, V> {
	
	private NodeBST<K, V> root;
	
	public BST() {
	}

	public boolean isEmpty() {
		return root == null;
	}
	
    public int height() {
        return height(root);
    }
    
    private int height(NodeBST<K, V> x) {
        if (x == null) 
        	return -1;
        return 1 + Math.max(height(x.getLeftChild()), height(x.getRightChild()));
    }
    
    public V get(K key) {
        return get(root, key);
    }

    private V get(NodeBST<K, V> x, K key) {
        if (x == null) 
        	return null;
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) 
        	return get(x.getLeftChild(), key);
        
        else if (cmp > 0) 
        	return get(x.getRightChild(), key);
        
        else
        	return x.getValue();
    }
    
    public void put(K key, V val) {
        root = put(root, key, val, root);
    }

    private NodeBST<K, V> put(NodeBST<K, V> x, K key, V val, NodeBST<K, V> father) {
        if (x == null) {
        	NodeBST<K, V> temp = new NodeBST<K, V>(key, val);
//			No disponible
//        	if (x!=father) 
//        		temp.setFather(father);
        	return temp;
        }
        
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) 
        	x.setLeftChild(put(x.getLeftChild(), key, val, x));
        
        else if (cmp > 0) 
        	x.setRightChild(put(x.getRightChild(), key, val, x));
        
        else 
        	x.setValue(val);
        
        return x;
    }
    
    public void deleteMin() {
        root = deleteMin(root);
    }
	
    private NodeBST<K, V> deleteMin(NodeBST<K, V> x) {
        if (x.getLeftChild() == null) 
        	return x.getRightChild();
        x.setLeftChild(deleteMin(x.getLeftChild()));
        return x;
    }
    
    public void deleteMax() {
        root = deleteMax(root);
    }
    
    private NodeBST<K, V> deleteMax(NodeBST<K, V> x) {
        if (x.getRightChild() == null) 
        	return x.getLeftChild();
        x.setRightChild(deleteMin(x.getRightChild()));
        return x;
    }
    
    public void delete(K key) {
        root = delete(root, key);
    }

    private NodeBST<K, V> delete(NodeBST<K, V> x, K key) {
        if (x == null) 
        	return null;

        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) 
        	x.setLeftChild(delete(x.getLeftChild(),  key));
        else if (cmp > 0) 
        	x.setRightChild(delete(x.getRightChild(), key));
        else { 
            if (x.getRightChild() == null) 
            	return x.getLeftChild();
            
            if (x.getLeftChild()  == null) 
            	return x.getRightChild();
            
            NodeBST<K, V> t = x;
            x = t.getRightChild().min();
            x.setRightChild(deleteMin(t.getRightChild()));
            x.setLeftChild(t.getLeftChild());
        } 
        return x;
    }
    
	public NodeBST<K, V> searchNode(K key){
		NodeBST<K, V> rst = null;
		
		if (root != null) {
			NodeBST<K, V> temp = root;
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

	public NodeBST<K, V> getRoot() {
		return root;
	}

	public void setRoot(NodeBST<K, V> root) {
		this.root = root;
	}
}