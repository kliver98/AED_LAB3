package interfaces;

public interface IABB <K extends Comparable<K>,V>{

	public void addElementABB(K key, V value);
	public void removeElementABB(K key);
	public V searchElementABB(K key);
	
}
