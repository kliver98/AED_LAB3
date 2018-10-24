package nodeTrees;

public class NodeAVLBST<K, V> extends NodeBST<K, V>{
	
	private NodeAVLBST<K, V> father;
	private NodeAVLBST<K, V> leftChild;
	private NodeAVLBST<K, V> rightChild;
    private int height;
	
	
	public NodeAVLBST(K key, V value, int height) {
		super(key, value);
		this.height = height;
	}

	public NodeAVLBST<K, V> getFather() {
		return father;
	}

	public void setFather(NodeAVLBST<K, V> father) {
		this.father = father;
	}

	public NodeAVLBST<K, V> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeAVLBST<K, V> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeAVLBST<K, V> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeAVLBST<K, V> rightChild) {
		this.rightChild = rightChild;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public NodeAVLBST<K, V> min(){
		if (leftChild!=null) 
			return leftChild.min();
		else 
			return this;
	}
	
	public NodeAVLBST<K, V> max(){
		if (rightChild!=null) 
			return rightChild.max();
		else 
			return this;
	}
	
}
