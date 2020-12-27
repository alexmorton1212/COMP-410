package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {

	// listSize: number of nodes in list 
	// changes according to insert(), remove(), clear()

	int listSize = 0;

	// sentinel: entry point to linked list (head)

	Node sentinel;

	/* CONSTRUCTOR
	 * Don't modify this (used by grader)!
    */

	public LinkedListImpl(){

		// root (sentinel) 
		// data not part of data set

		sentinel = new Node(0); 
	}

	
	/* INSERT
	 * inserts a node at a specific place in the linked list
	 * getNode() finds the correct nodes to link around the newly entered node
	 * must make a "circle" of nodes (linked forwards and backwards)
	 * returns true if insertion is successful
	 * beware of null pointers if linked list is not closed correctly
	 */

	public boolean insert(double elt, int index) {

		Node aNode = new Node(elt);
		
		Node leftNode;
		Node rightNode;

		// * Edge Cases: *

		// index must be in the list or one greater

		if (index < 0 || index > listSize) {
			return false; 
		}


		// * Valid Cases: *

		// Case 1: insert node at beginning
		// make sure to close the linked list completely
		// ... or else null pointers galore

		if (listSize == 0) {
			
			sentinel.next = aNode;
			getNode(listSize).next = sentinel;
			sentinel.prev = getNode(listSize);
			aNode.prev = sentinel;

			listSize++;

			return true;
		} 

		// Case 2: insert node at end of list
		// make sure to close the linked list completely
		// ... or else null pointers AVERYwhere

		if (index == listSize) {
			
			leftNode = sentinel.prev;
			leftNode.next = aNode;
			aNode.next = sentinel;
			sentinel.prev = aNode;
			aNode.prev = leftNode;
			
			listSize++;

			return true;	
		} 
		
		// Case 3: insert node in the middle of list
		// make sure to close the linked list completely
		// ... or else null pointers out the wazzoo

		rightNode = getNode(index);
		leftNode = rightNode.prev;
		leftNode.next = aNode;
		aNode.next = rightNode;
		rightNode.prev = aNode;
		aNode.prev = leftNode;
		
		listSize++;

		return true;
	}


	/* REMOVE
	 * removes the specified node from the linked list
	 * getNode() finds the correct node by index
	 * node is removed and the nodes previously to the left and right are linked
	 * returns true if removal is successful
	 * beware of null pointers (if linked list is not closed correctly) 
	 */

	public boolean remove(int index) {

		Node leftNode;
		Node rightNode;

		// * Edge Cases: *

		// index has to be valid
		// there must be at least one node in the list

		if (index < 0 || index >= listSize) {
			return false;
		}

		// * Valid Cases: *

		// Case 1: only node in list removed 
		// sentinel linked back to self 

		if (listSize == 1) {

			sentinel.next = sentinel;
			sentinel.prev = sentinel;

			listSize--;

			return true;
		}

		// Case 2: first node removed
		// right node is the "second" node in list
		// sentinel makes this right node the "first"

		if (index == 0) {

			rightNode = sentinel.next.next;
			sentinel.next = rightNode;
			rightNode.prev = sentinel;

			listSize--;

			return true;
		}

		// Case 3: last node removed
		// left node becomes the "last" node in the list

		if (index == listSize) {

			// leftNode = getNode(index - 1);
			
			leftNode = sentinel.prev.prev;
			leftNode.next = sentinel;
			sentinel.prev = leftNode;

			listSize--;

			return true;
		} 

		// Case 4: removes node from the middle
		// node to the left and right become linked

		leftNode = getNode(index - 1);
		rightNode = leftNode.next.next;
		leftNode.next = rightNode;
		rightNode.prev = leftNode;

		listSize--;

		return true;
	}


	/* GET
	 * retrieves the data element of the specified node
	 */

	public double get(int index) {

		if (index < 0 || index >= listSize) {
			return Double.NaN;
		} else {
			return getNode(index).data;
		}
	}


	/* SIZE
	 * returns the current size of the list
	 * aka number of nodes in the list
	 * does not include "sentinel" in the count
	 */

	public int size() {

		return listSize;
	}


	/* IS.EMPTY
	 * checks if the list is empty
	 * aka checks if there are 0 nodes (true in this case)
	 */

	public boolean isEmpty() {

		if (listSize == 0) {
			return true;
		} else {
			return false;
		}
	}


	/* CLEAR
	 * links sentinel's surrounding values to null
	 * size of list becomes 0 (if successful)
	 * be careful of null pointers here
	 */

	public void clear() {

		sentinel.next = null;
		sentinel.prev = null;
		listSize = 0;
	}


	/* GET.ROOT
	 * leave this method alone (used by grader)
	 * grabs linked list
	 */

	public Node getRoot(){ 
		return sentinel;
	}


	/* *** HELPER METHODS *** */

	/* GET.NODE
	 * traverses through the linked list
	 * finds the "current" node based on the index
	 * used for insert() -->
	 * keeps track of the nodes around where a new node will be entered
	 * used for remove() -->
	 * finds the node that needs to be removed
	 */

	private Node getNode(int index) {

		Node current = sentinel.next;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current;
	}


}