package DiGraph_A5;

import DiGraph_A5.EntryPair;
import DiGraph_A5.Heap_Interface;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; //load this array
	private int size = 0;
	private static final int arraySize = 10000; //Everything in the array will initially null, build from position 1 

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
		//of child/parent computations...
		//the book/animation page both do this.
	}

	@Override
	public EntryPair[] getHeap() { 
		return this.array;
	}

	public void insert(EntryPair entry) {

		if (entry == null) {
			throw new RuntimeException("EntryPair cannot be null");
		}

		size++;	// need to start at index 1
		array[size] = entry;
		bubbleUp(size);
	}

	@Override
	public void delMin() {

		if (isEmpty()) {
			return;
		}

		array[1] = array[size--];

		bubbleDown(1); // heap starts at position 1 (minimum location)

	}

	@Override
	public EntryPair getMin() {

		if (isEmpty()) {
			return null;
		}

		return array[1];
	}

	public int size() {

		return size;
	}

	public void build(EntryPair[] entries) {

		// build always occurs first as per directions

		size = entries.length;

		// puts the values from entries into array

		int j = 1;
		for (EntryPair entry: entries) {
			array[j++] = entry;
		}

		// bubbles the entries into correct place

		for (int i = size/2; i > 0; i--) {
			bubbleDown(i);
		}
	}

	public int findParentPos(EntryPair pair1) {

		return (int) Math.floor(pair1.weight/2);				
	}

	/* HELPER METHODS */

	private int findParentIndex(int index) {

		return (int) Math.floor(index/2);
	}

	private void bubbleUp(int newIndex) {

		int parentIndex;
		EntryPair temp;

		if (newIndex != 0) {

			parentIndex = findParentIndex(newIndex);

			if (array[parentIndex].weight > array[newIndex].weight) {

				temp = array[parentIndex];
				array[parentIndex] = array[newIndex];
				array[newIndex] = temp;

				bubbleUp(parentIndex);
			}
		}
	}

	private void bubbleDown (int newIndex) {

		int child;
		EntryPair temp = array[newIndex];

		for ( ; (newIndex * 2) <= size; newIndex = child) {
			child = newIndex * 2;

			if (child != size && (array[child + 1].weight < array[child].weight)) {
				child++;
			}

			if (array[child].weight < temp.weight) {
				array[newIndex] = array[child];

			} else {
				break;
			}
		}

		array[newIndex] = temp;

	}

	private boolean isEmpty () {

		if (size <= 0) {
			return true;
		} else {
			return false;
		}
	}


}
