package SPLT_A4;

public class SPLT_Playground {
	public static void main(String[] args){
		genTest();
		insertTest1();
		insertTest2();
		insertTest3();
		removeTest1();
		removeTest2();
		bigBoy();
	}

	public static void genTest(){
		SPLT tree= new SPLT();
		tree.insert("hello");
		tree.insert("world");
		tree.insert("my");
		tree.insert("name");
		tree.insert("is");
		tree.insert("blank");
		tree.remove("hello");
		System.out.println("size is "+tree.size());
		printLevelOrder(tree);
		System.out.println();
	}

	public static void insertTest1(){
		SPLT tree= new SPLT();
		tree.insert("B");
		tree.insert("A");
		tree.insert("D");
		tree.insert("C");
		System.out.println("size is "+tree.size());
		System.out.println(tree.getRoot().data);
		printLevelOrder(tree);
		System.out.println();
	}

	public static void insertTest2(){
		SPLT tree= new SPLT();
		tree.insert("B");
		tree.insert("A");
		tree.insert("D");
		tree.insert("C");
		tree.insert("E");
		tree.insert("0");
		System.out.println("size is "+tree.size());
		System.out.println(tree.getRoot().data);
		printLevelOrder(tree);
		System.out.println();
	}

	public static void insertTest3(){
		SPLT tree= new SPLT();
		tree.insert("A");
		tree.insert("B");
		tree.insert("C");
		tree.insert("A");
		System.out.println("size is "+tree.size());
		System.out.println(tree.getRoot().data);
		printLevelOrder(tree);
		System.out.println();
	}
	
	public static void removeTest1(){
		SPLT tree= new SPLT();
		tree.insert("B");
		tree.insert("A");
		tree.insert("D");
		tree.insert("C");
		tree.insert("E");
		tree.remove("C");
		System.out.println("size is "+tree.size());
		System.out.println(tree.getRoot().data);
		printLevelOrder(tree);
		System.out.println();
	}
	
	public static void removeTest2(){
		SPLT tree= new SPLT();
		tree.insert("B");
		tree.insert("A");
		tree.insert("D");
		tree.insert("C");
		tree.insert("E");
		tree.remove("C");
		tree.remove("C");
		System.out.println("size is "+tree.size());
		System.out.println(tree.getRoot().data);
		printLevelOrder(tree);
		System.out.println();
	}

	public static void bigBoy(){
		SPLT tree= new SPLT();
		tree.insert("B");
		tree.insert("A");
		tree.insert("D");
		tree.insert("Q");
		tree.insert("E");
		tree.remove("D");
		tree.insert("D");
		tree.remove("C");
		System.out.println("size is "+tree.size());
		System.out.println(tree.getRoot().data);
		System.out.println(tree.findMax());
		System.out.println(tree.findMin());
		tree.insert("E");
		tree.remove("C");
		System.out.println("size is "+tree.size());
		System.out.println(tree.getRoot().data);
		System.out.println(tree.findMax());
		System.out.println(tree.findMin());
		printLevelOrder(tree);
		System.out.println();
	}


	static void printLevelOrder(SPLT tree){ 
		//will print your current tree in Level-Order...Requires a correct height method
		//https://en.wikipedia.org/wiki/Tree_traversal
		int h=tree.height();
		for(int i=0;i<=h;i++){
			System.out.print("Level "+i+":");
			printGivenLevel(tree.getRoot(), i);
			System.out.println();
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
		if(root!=null){
			printInOrder(root.getLeft());
			System.out.print(root.getData()+" ");
			printInOrder(root.getRight());
		}
	}

}
