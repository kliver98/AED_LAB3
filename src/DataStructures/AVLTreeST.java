package DataStructures;

public class AVLTreeST<K extends Comparable<K>, V> extends BST<K, V> {

	public AVLTreeST() {
	}
	
	@Override
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private NodeTree<K, V> put(NodeTree<K, V> x, K key, V val) {
        if (x == null) 
        	return new NodeTree<K, V>(key, val, false, 0);
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) 
            x.setLeftChild(put(x.getLeftChild(), key, val));
        
        else if (cmp > 0) 
            x.setRightChild(put(x.getRightChild(), key, val));
        
        else 
            x.setValue(val);
        
        x.setHeight(1 + Math.max(height(x.getLeftChild()), height(x.getRightChild())));
        return balance(x);
    }
    
    private int height(NodeTree<K, V> x) {
        if (x == null) 
        	return -1;
        return x.getHeight();
    }
    
    private NodeTree<K, V> balance(NodeTree<K, V> x) {
        if (balanceFactor(x) < -1) {
            if (balanceFactor(x.getRightChild()) > 0) {
                x.setRightChild(rotateRight(x.getRightChild()));
            }
            x = rotateLeft(x);
        }
        else if (balanceFactor(x) > 1) {
            if (balanceFactor(x.getLeftChild()) < 0) {
                x.setLeftChild(rotateLeft(x.getLeftChild()));
            }
            x = rotateRight(x);
        }
        return x;
    }
    
    private int balanceFactor(NodeTree<K, V> x) {
        return height(x.getLeftChild()) - height(x.getRightChild());
    }
    
    private NodeTree<K, V> rotateRight(NodeTree<K, V> x) {
    	NodeTree<K, V> y = x.getLeftChild();
        x.setLeftChild(y.getRightChild());
        y.setRightChild(x);
        x.setHeight(1 + Math.max(height(x.getLeftChild()), height(x.getRightChild())));
        y.setHeight(1 + Math.max(height(y.getLeftChild()), height(y.getRightChild())));
        return y;
    }

    private NodeTree<K, V> rotateLeft(NodeTree<K, V> x) {
    	NodeTree<K, V> y = x.getRightChild();
    	x.setRightChild(y.getLeftChild());
    	y.setLeftChild(x);
    	x.setHeight(1 + Math.max(height(x.getLeftChild()), height(x.getRightChild())));
    	y.setHeight(1 + Math.max(height(y.getLeftChild()), height(y.getRightChild())));
        return y;
    }
    
    public void delete(K key) {
        root = delete(root, key);
    }

    private NodeTree<K, V> delete(NodeTree<K, V> x, K key) {
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) 
            x.setLeftChild(delete(x.getLeftChild(), key));

        else if (cmp > 0) 
            x.setRightChild(delete(x.getRightChild(), key));
        
        else {
            if (x.getLeftChild() == null) 
                return x.getRightChild();
            
            else if (x.getRightChild() == null) 
                return x.getLeftChild();
            
            else {
                NodeTree<K, V> y = x;
                x = y.getRightChild().min();
                x.setRightChild(deleteMin(y.getRightChild()));
                x.setLeftChild(y.getLeftChild());
            }
        }
        x.setHeight(1 + Math.max(height(x.getLeftChild()), height(x.getRightChild())));
        return balance(x);
    }
    
    public void deleteMin() {
        root = deleteMin(root);
    }

    private NodeTree<K, V> deleteMin(NodeTree<K, V> x) {
        if (x.getLeftChild() == null) 
        	return x.getRightChild();
        x.setLeftChild(deleteMin(x.getLeftChild()));
        x.setHeight(1 + Math.max(height(x.getLeftChild()), height(x.getRightChild())));
        return balance(x);
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private NodeTree<K, V> deleteMax(NodeTree<K, V> x) {
        if (x.getRightChild() == null) 
        	return x.getLeftChild();
        x.setRightChild(deleteMax(x.getRightChild()));
        x.setHeight(1 + Math.max(height(x.getLeftChild()), height(x.getRightChild())));
        return balance(x);
    }
    
    public boolean isAVL() {
        return isAVL(root);
    }

    private boolean isAVL(NodeTree<K, V> x) {
        if (x == null) 
        	return true;
        int bf = balanceFactor(x);
        if (bf > 1 || bf < -1) 
        	return false;
        
        return isAVL(x.getLeftChild()) && isAVL(x.getRightChild());
    }
}
