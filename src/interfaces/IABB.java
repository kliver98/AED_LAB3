package interfaces;

//import EstructurasDeDatos.NodeTree;

public interface IABB <K extends Comparable<K>,V>{

	public void put(K key, V value);
	public void delete(K key);
	public V get(K key);
	public void deleteMin();
	public void deleteMax();
	public K min();
	public K max();
//	public int size();
	public int height();
	public boolean isEmpty();
//	public NodeTree<K, V> searchNode(K key);
	
}
