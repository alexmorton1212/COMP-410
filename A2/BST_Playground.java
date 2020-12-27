package BST_A2;

public class BST_Playground {
	/*
	 * you will test your own BST implementation in here
	 *
	 * we will replace this with our own when grading, and will
	 * do what you should do in here... create BST objects,
	 * put data into them, take data out, look for values stored
	 * in it, checking size and height, and looking at the BST_Nodes
	 * to see if they are all linked up correctly for a BST
	 * 
	 */

	public static void main(String[]args){

		ContainsTest0();
		FindMinMaxTest0();
		HeightTest();
		EfficiencyTest0();
		EfficiencyTest1();
		Test0();
		Test1();
		RemoveTest4();
		EmptyTest0();
		
	}
	
	public static void EmptyTest0() {
		
		BST b = new BST();
		System.out.println("T: " + b.empty());
		b.insert("A");
		System.out.println("F: " + b.empty());
		b.remove("A");
		System.out.println("T: " + b.empty());
		
	}
	
	public static void EfficiencyTest0() {
		
		BST b = new BST();
		b.insert("E");
		b.insert("C");
		b.insert("T");
		b.insert("D");
		b.insert("A");
		b.insert("S");
		b.insert("U");
		System.out.println("Max: " + b.findMax());
		System.out.println("Min: " + b.findMin());
		System.out.println("Height: " + b.height());
		printLevelOrder(b);
		System.out.println("--------------------");
		b.remove("A");
		b.remove("U");
		System.out.println("Max: " + b.findMax());
		System.out.println("Min: " + b.findMin());
		System.out.println("Height: " + b.height());
		printLevelOrder(b);
		System.out.println("--------------------");
		b.remove("S");
		b.remove("D");
		System.out.println("Max: " + b.findMax());
		System.out.println("Min: " + b.findMin());
		System.out.println("Height: " + b.height());
		printLevelOrder(b);
		System.out.println("--------------------");
		b.remove("E");
		System.out.println("Max: " + b.findMax());
		System.out.println("Min: " + b.findMin());
		System.out.println("Height: " + b.height());
		printLevelOrder(b);
		System.out.println("--------------------");
	}
	
	public static void EfficiencyTest1() {
		
		BST b = new BST();
		b.remove("A");
		b.insert("R");
		b.insert("C");
		b.insert("G");
		b.remove("R");
		b.insert("D");
		b.insert("A");
		b.remove("A");
		b.insert("T");
		b.insert("U");
		b.remove("T");
		System.out.println("Max: " + b.findMax());
		System.out.println("Min: " + b.findMin());
		System.out.println("Height: " + b.height());
		printLevelOrder(b);
		System.out.println("--------------------");
		b.remove("R");
		System.out.println("Max: " + b.findMax());
		System.out.println("Min: " + b.findMin());
		System.out.println("Height: " + b.height());
		printLevelOrder(b);

	}

	public static void ContainsTest0(){
		// example test cases
		BST b = new BST();
		b.insert("B");
		b.insert("A");
		b.insert("D"); 
		b.insert("C"); 
		b.insert("E"); 
		b.contains("D"); //returns true
		printInOrder(b.getRoot());
		printLevelOrder(b);
	}

	public static void FindMinMaxTest0() {
		BST b = new BST();
		b.insert("A");
		b.insert("B");
		b.insert("E");
		b.insert("D");
		String max = b.findMax();
		String min = b.findMin();
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
	}

	public static void HeightTest() {
		BST b = new BST();
		b.insert("B"); b.insert("A"); b.insert("D");
		b.insert("C"); b.insert("F"); b.insert("E");
		int height = b.height();
		System.out.println(height);
	}

	public static void Test0() {
		BST b = new BST();
		b.insert("D");
		b.insert("B");
		b.insert("F");
		b.insert("A");
		b.insert("C");
		b.insert("E");
		b.insert("G");
		b.remove("E");

		printInOrder(b.getRoot());
		printLevelOrder(b);

	}

	public static void Test1() {

		BST b = new BST();
		b.insert("B");
		b.insert("A");
		b.insert("D");
		b.insert("C");
		b.insert("E");
		b.remove("D");
		printInOrder(b.getRoot());

	}
	
	public static void RemoveTest4() {
		
		BST b = new BST();
		b.insert("0");
		b.insert("C");
		b.insert("A");
		b.insert("B");
		b.insert("C");
		printInOrder(b.getRoot());
		
	}


	static void printLevelOrder(BST tree){ 
		//will print your current tree in Level-Order...
		//https://en.wikipedia.org/wiki/Tree_traversal
		int h=tree.getRoot().getHeight();
		System.out.println();
		System.out.println("Tree");
		for(int i=0;i<=h;i++){
			printGivenLevel(tree.getRoot(), i);			
			if (i != h) {
				System.out.println();
			}
		}
	}
	
	static void printGivenLevel(BST_Node root,int level){
		if(root==null)return;
		if(level==0)System.out.print(root.data+" ");
		else if(level>0){
			printGivenLevel(root.left,level-1);
			printGivenLevel(root.right,level-1);
		}
	}
	
	static void printInOrder(BST_Node root){
		//will print your current tree In-Order
		if(root!=null){
			printInOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			printInOrder(root.getRight());
		}
	}
}