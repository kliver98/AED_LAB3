package DataStructures;

public class RedBlackBST<K extends Comparable<K>, V> extends BST<K, V>{
	
    public static final boolean RED   = true;
    public static final boolean BLACK = false;
	
	public RedBlackBST() {
	}
	
    private boolean isRed(NodeTree<K, V> x) {
        if (x == null) 
        	return false;
        return x.getColor() == RED;
        
    }
    
    @Override
    public void put(K key, V val) {
        root = put(root, key, val);
        root.setColor(BLACK);;
    }
    
    private NodeTree<K, V> put(NodeTree<K, V> h, K key, V val) { 
        if (h == null) 
        	return new NodeTree<K, V>(key, val, RED,0);

        int cmp = key.compareTo(h.getKey());
        if (cmp < 0) 
        	h.setLeftChild(put(h.getLeftChild(), key, val)); 
        else if (cmp > 0) 
        	h.setRightChild(put(h.getRightChild(), key, val)); 
        else 
        	h.setValue(val);

        // fix-up any right-leaning links
        if (isRed(h.getRightChild()) && !isRed(h.getLeftChild()))
        	h = rotateLeft(h);
        if (isRed(h.getLeftChild())  &&  isRed(h.getLeftChild().getLeftChild())) 
        	h = rotateRight(h);
        if (isRed(h.getLeftChild())  &&  isRed(h.getRightChild())) 
        	flipColors(h);
        
        return h;
    }
    
    @Override
    public void deleteMin() {
        // if both children of root are black, set root to red
        if (!isRed(root.getLeftChild()) && !isRed(root.getRightChild()))
            root.setColor(RED);

        root = deleteMin(root);
        if (!isEmpty()) 
        	root.setColor(BLACK);
    }

    // delete the key-value pair with the minimum key rooted at h
    private NodeTree<K, V> deleteMin(NodeTree<K, V> h) { 
        if (h.getLeftChild() == null)
            return null;

        if (!isRed(h.getLeftChild()) && !isRed(h.getLeftChild().getLeftChild()))
            h = moveRedLeft(h);

        h.setLeftChild(deleteMin(h.getLeftChild()));
        return balance(h);
    }
    
    public void deleteMax() {
        // if both children of root are black, set root to red
        if (!isRed(root.getLeftChild()) && !isRed(root.getRightChild()))
            root.setColor(RED);

        root = deleteMax(root);
        if (!isEmpty()) 
        	root.setColor(BLACK);
    }

    // delete the key-value pair with the maximum key rooted at h
    private NodeTree<K, V> deleteMax(NodeTree<K, V> h) { 
        if (isRed(h.getLeftChild()))
            h = rotateRight(h);

        if (h.getRightChild() == null)
            return null;

        if (!isRed(h.getRightChild()) && !isRed(h.getRightChild().getLeftChild()))
            h = moveRedRight(h);

        h.setRightChild(deleteMax(h.getRightChild()));

        return balance(h);
    }
    
    public void delete(K key) { 
        // if both children of root are black, set root to red
        if (!isRed(root.getLeftChild()) && !isRed(root.getRightChild()))
            root.setColor(RED);

        root = delete(root, key);
        if (!isEmpty()) 
        	root.setColor(BLACK);
        // assert check();
    }

    // delete the key-value pair with the given key rooted at h
    private NodeTree<K, V> delete(NodeTree<K, V> h, K key) { 
        if (key.compareTo(h.getKey()) < 0)  {
            if (!isRed(h.getLeftChild()) && !isRed(h.getLeftChild().getLeftChild()))
                h = moveRedLeft(h);
            h.setLeftChild(delete(h.getLeftChild(), key));
        }
        else {
            if (isRed(h.getLeftChild()))
                h = rotateRight(h);
            
            if (key.compareTo(h.getKey()) == 0 && (h.getRightChild() == null))
                return null;
            
            if (!isRed(h.getRightChild()) && !isRed(h.getRightChild().getLeftChild()))
                h = moveRedRight(h);
           
            if (key.compareTo(h.getKey()) == 0) {
            	NodeTree<K, V> x = h.getRightChild().min();
                h.setKey(x.getKey());
                h.setValue(x.getValue());
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.setRightChild(deleteMin(h.getRightChild()));
            }
            else h.setRightChild(delete(h.getRightChild(), key));
        }
        return balance(h);
    }
    
    /***************************************************************************
     *  Red-black tree helper functions.
     ***************************************************************************/
    
    // make a left-leaning link lean to the right
    private NodeTree<K, V> rotateRight(NodeTree<K, V> h) {
        NodeTree<K, V> x = h.getLeftChild();
        h.setLeftChild(x.getRightChild());
        x.setRightChild(h);
        x.setColor(x.getRightChild().getColor());
        x.getRightChild().setColor(RED);
        return x;
    }
    
    // make a right-leaning link lean to the left
    private NodeTree<K, V> rotateLeft(NodeTree<K, V> h) {
    	NodeTree<K, V> x = h.getRightChild();
    	h.setRightChild(x.getLeftChild());
    	x.setLeftChild(h);
    	x.setColor(x.getLeftChild().getColor());
    	x.getLeftChild().setColor(RED);
    	return x;
    }
    
    // flip the colors of a node and its two children
    private void flipColors(NodeTree<K, V> h) {
        h.setColor(!h.getColor());;
        h.getLeftChild().setColor(!h.getLeftChild().getColor());
        h.getRightChild().setColor(!h.getRightChild().getColor());
    }
    
    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private NodeTree<K, V> moveRedLeft(NodeTree<K, V> h) {
        flipColors(h);
        if (isRed(h.getRightChild().getLeftChild())) { 
            h.setRightChild(rotateRight(h.getRightChild()));
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    
    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private NodeTree<K, V> moveRedRight(NodeTree<K, V> h) {
        flipColors(h);
        if (isRed(h.getLeftChild().getLeftChild())) { 
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    // restore red-black tree invariant
    private NodeTree<K, V> balance(NodeTree<K, V> h) {
        if (isRed(h.getRightChild()))
        	h = rotateLeft(h);
        if (isRed(h.getLeftChild()) && isRed(h.getLeftChild().getLeftChild())) 
        	h = rotateRight(h);
        if (isRed(h.getRightChild()) && isRed(h.getRightChild())) 
        	flipColors(h);

        return h;
    }
    
    /***************************************************************************
     *  Check integrity of red-black tree data structure.
     ***************************************************************************/
    
    // do all paths from root to leaf have same number of black edges?
    public boolean isBalanced() { 
        int black = 0;     // number of black links on path from root to min
        NodeTree<K, V> x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.getLeftChild();
        }
        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(NodeTree<K, V> x, int black) {
        if (x == null) 
        	return black == 0;
        if (!isRed(x)) 
        	black--;
        return isBalanced(x.getLeftChild(), black) && isBalanced(x.getRightChild(), black);
    } 
}
