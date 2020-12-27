package DiGraph_A5;

public class DiGraphPlayground {

	public static void main (String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like 
		//    -- print
		//    -- sort
		//    -- random fill
		//    -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior

		exTest();
		AddEdgeTest1();
		DeleteEdgeTest1();
		Efficiency();
	}

	public static void exTest(){

		DiGraph d = new DiGraph();

		d.addNode(1, "f");
		d.addNode(3, "s");
		d.addNode(7, "t");
		d.addNode(0, "fo");
		d.addNode(4, "fi");
		d.addNode(3, "si");


		d.addEdge(0, "f", "s", 0, null);
		d.addEdge(1, "f", "s", 0, null); // shouldn't add
		d.addEdge(2, "s", "t", 0, null);
		d.addEdge(3, "fo", "fi", 0, null);
		d.addEdge(4, "fi", "si", 0, null);

		System.out.println("numEdges: "+ d.numEdges());
		System.out.println("numNodes: "+ d.numNodes());

	}

	public static void AddEdgeTest1() {

		DiGraph d = new DiGraph();

		d.addNode(1,"f");
		d.addNode(3,"s");
		d.addNode(7,"t");
		d.addEdge(0,"f","s", 0, null);
		d.addEdge(1, "f", "s", 0, null);
		System.out.println("numEdges: "+ d.numEdges());
		System.out.println("numNodes: "+ d.numNodes());
	}
	
	public static void DeleteEdgeTest1() {
		
		DiGraph d = new DiGraph();

		d.addNode(1,"f");
		d.addNode(3,"s");
		d.addNode(7,"t");
		d.addEdge(0,"f","s", 0, null);
		d.addEdge(1, "f", "s", 0, null);
		d.addEdge(2, "f", "s", 0, null);
		d.delEdge("f", "s");
		System.out.println("numEdges: "+ d.numEdges());
		
	}
	
	public static void Efficiency() { // about 10 seconds (when printing i), about 3 seconds normally
		
		DiGraph d = new DiGraph();
		
		long start = System.nanoTime();
		
		for (int i = 0; i < 1000000; i++) {
			
			d.addNode(i, "" + i);
			d.addEdge(i, "" + (i - 1), "" + i);
			
//			System.out.println(i);
			
		}
		
		long end = System.nanoTime() - start;
		
		System.out.println("Program took " + end/1000000000 + " s");
	}



//	private static String printMap(DiGraph d) {
//
//		for (Vertex vertex : d.Map.values()) {
//
//			if (vertex.outVertex.isEmpty()) {
//
//				System.out.println("(" + vertex.idNum + ")" + vertex.label);
//
//			} else {
//					
//				System.out.println("(" + vertex.idNum + ")" + vertex.label + " -- edge -- " + vertex.outVertex);
//				
//			}
//		}
//		System.out.println();
//		return "done";
//	}
}