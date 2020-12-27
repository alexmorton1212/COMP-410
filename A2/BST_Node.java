package BST_A2;

public class BST_Node {

	// Edge cases are accounted for in BST

	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String data) { 
		this.data = data; 
	}

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }


	/* CONTAINS.NODE
	 * recursively searches the tree for some string
	 */

	public boolean containsNode(String s){ 

		// checks if the node has data 's'

		if (this.data.equals(s)) {

			return true; 

		} else {

			// Case 1: 's' is less than the node's data
			// need to go left to look for 's'

			if (s.compareTo(this.data) < 0) {

				if (this.left != null) { 
					return this.left.containsNode(s);

				} else { 
					return false;
				}

			} else {

				// Case 2: 's' is greater than the node's data
				// need to go right to look for 's'

				if (s.compareTo(this.data) > 0) {

					if (this.right != null) {
						return this.right.containsNode(s);

					} else {
						return false;
					}

				} else {

					// Case 3: tree does not contain 's'

					return false;
				}
			}
		}
	}

	/* INSERT.NODE
	 * recursively searches for a place to put a new node
	 * new node will become a leaf (bottom of branch)
	 * ... upon reaching null in the correct direction
	 */

	public BST_Node insertNode(String s){ 

		// Case 1: 's' is less than the node's data
		// need to go left

		if (s.compareTo(this.data) < 0) {

			// Case a: new node created on left with data 's'

			if (this.left == null) {
				this.left = new BST_Node(s);

				// Case b: recursive case

			} else {

				this.left.insertNode(s);
			}

			// Case 2: 's' is greater than the node's data
			// need to go right

		} else {

			// Case a: new node created on right with data 's'

			if (this.right == null) {
				this.right = new BST_Node(s);

				// Case b: recursive case

			} else {

				this.right.insertNode(s);
			}
		}

		return this;

	}

	/* REMOVE.NODE
	 * recursively searches for the node to remove
	 * covers cases of a node being removed with
	 * ... 0 children, 1 child, or 2 children
	 */

	public BST_Node removeNode(String s){ 

		// need to go left to find node with data 's'

		if (s.compareTo(this.data) < 0) {

			this.left = this.left.removeNode(s);

		} else {

			// need to go right to find node with data 's'

			if (s.compareTo(this.data) > 0) {

				this.right = this.right.removeNode(s);

				
				// if it reaches the else block this means
				// ... we have found the node with data 's'	

			} else {
				
				// Case 1: no children

				if (this.right == null && this.left == null) {
					this.data = null;
				}

				// Case 2: single child

				if (this.right == null || this.left == null) {

					if (this.right == null) {
						return this.left;

					} else {

						if (this.left == null) {
							return this.right;
						}
					}
				}

				// Case 3: two children
				// removed node replaced with minimum leaf from right branch

				String min = this.right.findMin();
				this.data = min;
				
				this.right = this.right.removeNode(this.data);

			}

		}

		return this;
	}

	/* FIND.MIN
	 * returns node with the minimum value of the BST
	 * used in removeNode() when the top node
	 * ... is removed and needs replacement
	 */

	public String findMin(){ 

		// minimum must go to left branch

		if (this.left == null) {

			return this.getData();

		} else {

			return this.left.findMin();	
		}
	}

	/* FIND.MAX
	 * returns node with the maximum value of the BST
	 */

	public String findMax(){ 

		// maximum must go to right branch

		if (this.right == null) {

			return this.getData();

		} else {

			return this.right.findMax();
		}

	}

	/* GET.HEIGHT
	 * recursively finds height of longest branch
	 */

	public int getHeight(){

		int leftHeight = 0;
		int rightHeight = 0;

		if (this.left != null) {
			leftHeight = this.left.getHeight();
		}

		if (this.right != null) {
			rightHeight = this.right.getHeight();
		}

		// returns the greater height incremented
		// ... by one each time

		return largerHeight(leftHeight, rightHeight);
	}

	/* TO.STRING
	 * converts data value to a String
	 */

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}

	/* LARGER.HEIGHT 
	 * abstraction for getHeight() - cleaner
	 */
	
	public int largerHeight(int leftHeight, int rightHeight) {

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	

}