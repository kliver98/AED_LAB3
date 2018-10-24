package nodeTrees;

public class NodeRedBlackBST<K, V> extends NodeBST<K, V>{
	
	private NodeRedBlackBST<K, V> father;
	private NodeRedBlackBST<K, V> leftChild;
	private NodeRedBlackBST<K, V> rightChild;
	private K key;
	private V value;
	private boolean color;

	public NodeRedBlackBST(K key, V value, boolean color) {
		super(key, value);
		this.color = color;
	}

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public NodeRedBlackBST<K, V> getFather() {
		return father;
	}

	public void setFather(NodeRedBlackBST<K, V> father) {
		this.father = father;
	}

	public NodeRedBlackBST<K, V> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeRedBlackBST<K, V> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeRedBlackBST<K, V> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeRedBlackBST<K, V> rightChild) {
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
	
	public NodeRedBlackBST<K, V> min(){
		if (leftChild!=null) 
			return leftChild.min();
		else 
			return this;
	}
	
	public NodeRedBlackBST<K, V> max(){
		if (rightChild!=null) 
			return rightChild.max();
		else 
			return this;
	}
}
