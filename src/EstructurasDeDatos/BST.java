package EstructurasDeDatos;

import interfaces.IBST;

public class BST<K extends Comparable<K>, V> implements IBST<K, V> {
	
	private NodeTree<K, V> root;
	
	public BST() {
	}

	public boolean isEmpty() {
		return root == null;
	}
	
    public int height() {
        return height(root);
    }
    
    private int height(NodeTree<K, V> x) {
        if (x == null) 
        	return -1;
        return 1 + Math.max(height(x.getLeftChild()), height(x.getRightChild()));
    }
    
    public V get(K key) {
        return get(root, key);
    }

    private V get(NodeTree<K, V> x, K key) {
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

    private NodeTree<K, V> put(NodeTree<K, V> x, K key, V val, NodeTree<K, V> father) {
        if (x == null) {
        	NodeTree<K, V> temp = new NodeTree<K, V>(key, val);
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

    private NodeTree<K, V> deleteMin(NodeTree<K, V> x) {
        if (x.getLeftChild() == null) 
        	return x.getRightChild();
        x.setLeftChild(deleteMin(x.getLeftChild()));
        return x;
    }
    
    public void deleteMax() {
        root = deleteMax(root);
    }

    private NodeTree<K, V> deleteMax(NodeTree<K, V> x) {
        if (x.getRightChild() == null) 
        	return x.getLeftChild();
        x.setRightChild(deleteMax(x.getRightChild()));
        return x;
    }
    
    public void delete(K key) {
        root = delete(root, key);
    }

    private NodeTree<K, V> delete(NodeTree<K, V> x, K key) {
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
            
            NodeTree<K, V> t = x;
            x = min(t.getRightChild());
            x.setRightChild(deleteMin(t.getRightChild()));
            x.setLeftChild(t.getLeftChild());
        } 
        return x;
    }
    
    public K min() {
        return min(root).getKey();
    } 

    private NodeTree<K, V> min(NodeTree<K, V> x) { 
    	return x.min();
    } 
   
    public K max() {
        return max(root).getKey();
    } 

    private NodeTree<K, V> max(NodeTree<K, V> x) {
    	return x.max();
    } 
	
	public NodeTree<K, V> searchNode(K key){
		NodeTree<K, V> rst = null;
		
		if (root != null) {
			NodeTree<K, V> temp = root;
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