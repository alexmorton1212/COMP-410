package SPLT_A4;

public class SPLT implements SPLT_Interface {

	private BST_Node root;
	private int size;

	public SPLT() {

		this.size = 0;
		this.root = null;
	}

	public BST_Node getRoot() {

		return this.root;
	}

	@Override
	public void insert(String s) {

		// inserts and splays
		// if node already exists, still splays
		
		if (size == 0) {

			root = new BST_Node(s);
			size++;
			return;
		}

		if (!contains(s)) { // contains splays for us

			splay(root.insertNode(s));
			size++;
			return;

		}

		return;
	}

	@Override
	public void remove(String s) {

		// splays then removes
		// if node does not exist, still splays
		
		if (contains(s)) { // contains splays for us

			if (root.data.equals(s) && size == 1) {

				root = null;
				size --;
				return;

			} else {

				if(root.data.equals(s)){

					if(root.left!=null){

						root.data = root.left.findMax().data;
						root.left.removeNode(root.data);

						if (root.left.data == null) {
							root.left=null;
						}

					} else {

						if (root.right != null){
							root.data = root.right.findMin().data;
							root.right.removeNode(root.data);
						}

						if(root.right.data == null) {
							root.right=null;
						}
					}


				} else {

					root.data = null;
					return;
				}
			}

			size--;

		} else if(root.data.compareTo(s)>0){

			if(root.left==null) {
				return;
			}
			if(!root.left.removeNode(s)) {
				return;
			}
			if(root.left.data==null) {
				root.left=null;
				return;
			}


		} else if(root.data.compareTo(s)<0){

			if(root.right==null) {
				return;
			}
			if(!root.right.removeNode(s)) {
				return;
			}
			if(root.right.data==null) {
				root.right=null;
				return;
			}

		} else {
			return;
		}

	}

	@Override
	public String findMin() {

		if (size == 0) {
			return null;

		} else {

			BST_Node aNode = root.findMin();

			splay(aNode);
			return aNode.data;
		}
	}

	@Override
	public String findMax() {

		if (size == 0) {
			return null;

		} else {

			BST_Node aNode = root.findMax();

			splay(aNode);
			return aNode.data;
		}
	}

	@Override
	public boolean empty() {

		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {

		if (size == 0) {
			return false;
		}

		// splays regardless of whether it contains 's'
		
		BST_Node aNode = root.lastNode(s);
		splay(aNode);

		if (root.containsNode(s)){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {

		if (size == 0 || root == null) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

	/* ADDTIONAL METHODS */

	private void splay(BST_Node aNode) {

		int cont = 0;
		
		if (aNode == root) {
			cont = 1;
			return;
		}
		
		while (cont == 0) {

			BST_Node parent = aNode.par;
			BST_Node grandparent = aNode.par.par;


			if (grandparent == null){

				zig(aNode);

			} else {

				if (aNode == parent.left && 
						parent == grandparent.left) {
					zigzigLeft(aNode);
				}

				if (aNode == parent.right && 
						parent == grandparent.right) {
					zigzigRight(aNode);
				}

				if (aNode == parent.right && 
						parent == grandparent.left) {
					zigzagLeft(aNode);
				}

				if (aNode == parent.left && 
						parent == grandparent.right) {

					zigzagRight(aNode);
				}
			}
			
			if (aNode == root) {
				cont = 1;
			}
		}
	}

	private void rotateRight(BST_Node aNode) {

		BST_Node hold;
		
		hold = aNode.left;
		hold.par = aNode.par;
		aNode.left = hold.right;
		

		if (aNode.left != null) {
			aNode.left.par = aNode;
		}

		hold.right = aNode;
		aNode.par = hold;

		rotate(hold, hold.par, aNode);
	}

	private void rotateLeft(BST_Node aNode) {

		BST_Node hold;
		
		hold = aNode.right;
		hold.par = aNode.par;
		aNode.right = hold.left;

		if (aNode.right != null) {
			aNode.right.par = aNode;
		}

		hold.left = aNode;
		aNode.par = hold;

		rotate(hold, hold.par, aNode);
	}

	private void rotate(BST_Node hold, BST_Node parent, BST_Node aNode) {

		if (parent == null) {
			root = hold;

		} else {

			if (aNode == parent.left) {
				parent.left = hold;
			} else {
				parent.right = hold;
			}
		}

	}

	/* ADDITIONAL METHODS FOR SPLAY (READABILITY FOR MYSELF :) ) */

	private void zig (BST_Node aNode) {

		BST_Node parent = aNode.par;

		if (aNode == parent.left) {
			rotateRight(parent); // zig right

		} else {

			if (aNode == parent.right){
				rotateLeft(parent); // zig left
			}
		}
	}

	private void zigzigLeft (BST_Node aNode) {

		BST_Node parent = aNode.par;
		BST_Node grandparent = aNode.par.par;

		rotateRight(grandparent);
		rotateRight(parent);	
	}

	private void zigzigRight (BST_Node aNode) {

		BST_Node parent = aNode.par;
		BST_Node grandparent = aNode.par.par;

		rotateLeft(parent);
		rotateLeft(grandparent);
	}

	private void zigzagLeft (BST_Node aNode) {

		BST_Node parent = aNode.par;
		BST_Node grandparent = aNode.par.par;

		rotateLeft(parent);
		rotateRight(grandparent);
	}

	private void zigzagRight (BST_Node aNode) {

		BST_Node parent = aNode.par;
		BST_Node grandparent = aNode.par.par;

		rotateRight(parent);
		rotateLeft(grandparent);
	}
}