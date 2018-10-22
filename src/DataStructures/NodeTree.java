package DataStructures;

public class NodeTree<K, V> {

	private NodeTree<K, V> father;
	private NodeTree<K, V> leftChild;
	private NodeTree<K, V> rightChild;
	private K key;
	private V value;
	private boolean color;
    private int height;
    
	public NodeTree(K key, V value, boolean color, int height) {
		super();
		this.key = key;
		this.value = value;
		this.color = color;
		this.height = height;
	}
	
	public NodeTree<K, V> min(){
		if (leftChild!=null) 
			return leftChild.min();
		else 
			return this;
	}
	
    public NodeTree<K, V> deleteMin() {
        if (leftChild == null) 
        	return rightChild;
        leftChild = leftChild.deleteMin();
        return this;
    }

	public NodeTree<K, V> max(){
		if (rightChild!=null) 
			return rightChild.max();
		else 
			return this;
	}
	
	public NodeTree<K, V> deleteMax() {
		if (rightChild == null) 
			return leftChild;
		rightChild = rightChild.deleteMin();
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

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	} 
	

}
