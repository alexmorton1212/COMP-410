package MinBinHeap_A3;

public class MinBinHeap_Playground {
	public static void main(String[] args){   
		//Add more tests as methods and call them here!!
//		TestBuild();
		//    TestGetMin();
		//    TestDelete1();
		//	  TestDelete2();
		//	  TestGetMin1();
		//	  TestGetMin2();
		//	  BigTest();
		//    BigTest2();
		//	  BigTest3();
	}

	//	public static void BigTest() {
	//
	//		MinBinHeap mbh= new MinBinHeap();
	//		System.out.println("Size: " + mbh.size());
	//		mbh.insert(new EntryPair("a", -1));
	//		System.out.println("Pair: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//		System.out.println("Size: " + mbh.size());
	//		mbh.delMin();
	//		System.out.println("Size: " + mbh.size());
	//		mbh.delMin();
	//		System.out.println("Size: " + mbh.size());
	//
	//	}

	//	public static void BigTest2() {
	//
	//		MinBinHeap mbh= new MinBinHeap();
	//		mbh.insert(new EntryPair("a", -1));
	//		mbh.insert(new EntryPair("b", -2));
	//		System.out.println("Minimum: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//		System.out.println("Size: " + mbh.size());
	//		mbh.delMin();
	//		mbh.insert(new EntryPair("c", -2));
	//		System.out.println("Minimum: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//		System.out.println("Size: " + mbh.size());
	//		mbh.insert(new EntryPair("d", 0));
	//		mbh.insert(new EntryPair("e", 1));
	//		mbh.insert(new EntryPair("f", 2));
	//		mbh.insert(new EntryPair("g", 3));
	//		mbh.delMin();
	//		System.out.println("Minimum: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//		System.out.println("Size: " + mbh.size());
	//	}

	//			public static void BigTest3() {
	//		
	//				MinBinHeap mbh= new MinBinHeap();
	//				EntryPair[] collection= new EntryPair[5];
	//				collection[0]=new EntryPair("b",1);
	//				collection[1]=new EntryPair("c",7);
	//				collection[2]=new EntryPair("a",3);
	//				collection[3]=new EntryPair("d",5);
	//			    collection[4]=new EntryPair("e",14);
	//			    
	//				mbh.build(collection);
	//				System.out.println("Size: " + mbh.size());
	//				
	//				printHeap(mbh.getHeap(),mbh.size());
	//				System.out.println("Minimum: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//				
	//				mbh.insert(new EntryPair("f", 10));
	//				mbh.insert(new EntryPair("g", 6));
	//				mbh.insert(new EntryPair("h", 17));
	//				System.out.println("Minimum: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//				
	//				System.out.println("Size: " + mbh.size());
	//				printHeap(mbh.getHeap(),mbh.size());
	//				System.out.println("Minimum: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//				
	//				mbh.delMin();
	//				mbh.delMin();
	//				System.out.println("Minimum: (" + mbh.getMin().value + ", " + mbh.getMin().priority + ")");
	//				
	//				System.out.println("Size: " + mbh.size());
	//				printHeap(mbh.getHeap(),mbh.size());
	//				
	//			}



//	public static void TestBuild(){ 
//		//	      constructs a new minbinheap, constructs an array of EntryPair, 
//		//	      passes it into build function. Then print collection and heap.
//
//		MinBinHeap mbh= new MinBinHeap();
//		EntryPair[] collection= new EntryPair[8];
//		collection[0]=new EntryPair("i",3);
//		collection[1]=new EntryPair("b",5);
//		collection[2]=new EntryPair("c",1);
//		collection[3]=new EntryPair("d",0);
//		collection[4]=new EntryPair("e",46);
//		collection[5]=new EntryPair("f",5);
//		collection[6]=new EntryPair("g",6);
//		collection[7]=new EntryPair("h",17);
//		mbh.build(collection);
//
//		System.out.println(mbh.size());
//
//		for (int i = 1; i < mbh.size() + 1; i++) {
//			System.out.println(mbh.getHeap()[i].value + " " + mbh.getHeap()[i].priority);
//		}
//
//		printHeapCollection(collection);
//		printHeap(mbh.getHeap(), mbh.size());
//	}

	//  public static void TestGetMin() {
	//	  
	//	  MinBinHeap mbh= new MinBinHeap();
	//	  mbh.insert(new EntryPair("a",1));
	//	  System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//	  mbh.insert(new EntryPair("b",2));
	//	  System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//	  mbh.insert(new EntryPair("c",1));
	//	  System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//	  System.out.println(mbh.size());
	//	  mbh.delMin();
	//	  System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//	  System.out.println(mbh.size());
	//  }

	//  public static void TestDelete1() {
	//	  
	//	  MinBinHeap mbh= new MinBinHeap();
	//	  mbh.insert(new EntryPair("a",5));
	//	  mbh.insert(new EntryPair("b",4));
	//	  mbh.insert(new EntryPair("c",3));
	//	  mbh.insert(new EntryPair("d",2));
	//	  mbh.insert(new EntryPair("e",1));
	//	  
	//	  for (int i = 1; i < mbh.size() + 1; i++) {
	//		  System.out.println(mbh.getHeap()[i].value + " " + mbh.getHeap()[i].priority);
	//	  }
	//	  
	//	  System.out.println(mbh.size());
	//	  
	//	  System.out.println();
	//
	//	  mbh.delMin();	  
	//	  mbh.delMin();
	//	  
	//	  // System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//	  
	//	  for (int i = 1; i < mbh.size() + 1; i++) {
	//		  System.out.println(mbh.getHeap()[i].value + " " + mbh.getHeap()[i].priority);
	//	  }
	//  }

	//	public static void TestDelete2() {
	//
	//		MinBinHeap mbh= new MinBinHeap();
	//		mbh.insert(new EntryPair("a",1));
	//		mbh.insert(new EntryPair("b",2));
	//		mbh.insert(new EntryPair("c",3));
	//
	//		System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//		mbh.delMin();
	//		System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//		mbh.delMin();
	//		System.out.println(mbh.getMin().value + " " + mbh.getMin().priority);
	//		mbh.delMin();
	//		printHeap(mbh.getHeap(),mbh.size());
	//		System.out.println("Size: " + mbh.size());
	//	}

	//	public static void TestGetMin1() {
	//
	//		MinBinHeap mbh= new MinBinHeap();
	//		EntryPair[] collection= new EntryPair[5];
	//		collection[0]=new EntryPair("a",4);
	//		collection[1]=new EntryPair("b",5);
	//		collection[2]=new EntryPair("c",1);
	//		collection[3]=new EntryPair("d",3);
	//		collection[4]=new EntryPair("e",2);
	//		
	//		long startTime = System.nanoTime();
	//		mbh.build(collection);
	//		long endTime = System.nanoTime();
	//		System.out.println("Took "+(endTime - startTime) + " ns");
	//		
	//		printHeapCollection(collection);
	//	    printHeap(mbh.getHeap(), mbh.size());
	//		
	//		System.out.print(mbh.getMin().value + " " + mbh.getMin().priority);
	//		
	//	}

	//	public static void TestGetMin2() {
	//
	//		MinBinHeap mbh= new MinBinHeap();
	//		EntryPair[] collection= new EntryPair[3];
	//		collection[0]=new EntryPair("a",4);
	//		collection[1]=new EntryPair("b",5);
	//		collection[2]=new EntryPair("c",31);
	//		
	//		long startTime = System.nanoTime();
	//		mbh.build(collection);
	//		long endTime = System.nanoTime();
	//		System.out.println("Took "+(endTime - startTime) + " ns");
	//		
	//		printHeapCollection(collection);
	//	    printHeap(mbh.getHeap(), mbh.size());
	//		
	//		System.out.print(mbh.getMin().value + " " + mbh.getMin().priority);
	//		
	//	}


	public static void printHeapCollection(EntryPair[] e) { 
		//this will print the entirety of an array of entry pairs you will pass 
		//to your build function.
		System.out.println("Printing Collection to pass in to build function:");
		for(int i=0;i < e.length;i++){
			System.out.print("("+e[i].value+","+e[i].priority+")\t");
		}
		System.out.print("\n");
	}

	public static void printHeap(EntryPair[] e,int len) { 
		//pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
		System.out.println("Printing Heap");
		for(int i=1;i < len+1;i++){
			System.out.print("("+e[i].value+","+e[i].priority+")\t");
		}
		System.out.print("\n");
	}
}
