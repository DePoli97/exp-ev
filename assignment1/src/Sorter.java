package exp01.src;

interface Sorter<T extends Comparable<T>> {
	
	void sort(T[] items);
	
}
