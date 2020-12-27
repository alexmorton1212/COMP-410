package BST_A2;

public class BST implements BST_Interface {
	
	public BST_Node root;
	int height;
	int size;
	
	public BST(){ 
		size = 0;
		height = 0;
		root = null; 
	}
	
	/* ROOT
	 * used for testing, please leave as is
	 */

	public BST_Node getRoot(){ 

		if (size == 0) {
			return null;
		}
		return root; 
	}

	/* INSERT
	 * delegates to BST_Node to insert node
	 * size increments by one upon successful insertion
	 */
	
	public boolean insert(String s) {

		// checks if tree already contains 's'
		// cannot have duplicate values

		if (contains(s)) {
			return false;
		}

		// Case 1: tree is empty
		// root becomes the main node / only node

		if (size == 0) {
			root = new BST_Node(s);
			size++;
			return true;

		// Case 2: tree is not empty
		// delegates to BST_Node insertNode()	

		} else {
			root.insertNode(s);
			size++;
			return true;
		}
	}

	/* REMOVE
	 * delegates to BST_Node to remove node
	 * size decrements by one upon successful removal
	 */
	
	public boolean remove(String s) {

		// checks if tree already contains 's'
		// if it does not, there is nothing to remove

		if (!contains(s)) {
			return false;
		} 

		// Case 1: tree is empty
		// there is nothing to remove

		if (size == 0 ) {
			return false;

		// Case 2: tree is not empty
		// delegates to BTS_Node removeNode()	

		} else {

			root.removeNode(s);
			size--;
			return true;		
		}		
	}

	/* FIND.MIN
	 * delegates to BST_Node findMin()
	 * finds the smallest node in the tree
	 */
	
	public String findMin() {

		// if the tree is empty
		// there is no minimum
		
		if (size == 0) {
			return null;
		}

		return root.findMin();
	}

	/* FIND.MAX
	 * delegates to BST_Node findMax()
	 * finds the largest node in the tree
	 */
	
	public String findMax() {

		// if the tree is empty
		// there is no maximum
		
		if (size == 0) {
			return null;
		}

		return root.findMax();
	}

	/* EMPTY
	 * checks if the tree is empty
	 * does not delegate
	 */

	public boolean empty() {

		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	/* CONTAINS
	 * delegates to BST_Node
	 * checks if a node in the tree has data 's'
	 */
	
	public boolean contains(String s) {

		// if the tree is empty
		// it does not contain anything
		
		if (size == 0) {
			return false;
		}
		
		// delegates to BST_Node containsNode()
		
		if (root.containsNode(s)) {
			return true;
		} else {	
			return false;
		}
	}

	/* SIZE
	 * size determined by insert() and remove()
	 */

	public int size() {
		
		return size;
	}

	/* HEIGHT
	 * delegates to BST_Node to find height of tree
	 * top node in tree not included in height
	 */
	
	public int height() {
		
		// if tree is empty, height is invalidated

		if (root == null || size == 0) {
			return -1;
		}
		
		// delegates to BST_Node getHeight()
		// need to subtract one to get correct height
		
		return root.getHeight() - 1;
	}

}