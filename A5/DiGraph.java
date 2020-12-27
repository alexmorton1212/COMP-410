package DiGraph_A5;

import java.util.*;

public class DiGraph implements DiGraphInterface {

	HashMap<String, Vertex> Map = new HashMap<String, Vertex>();

	// using array lists makes the time complexity very very long - AVOID!
	// efficiency: adding 1 000 000 nodes and edges takes ~ 3 seconds now

	Set<Long> vertexList = new HashSet<Long>(); // keeps list of vertices (IDs)
	Set<Long> edgeList = new HashSet<Long>();   // keeps list of edges (IDs)

	public DiGraph ( ) { 

		// default constructor ... do not modify (at self)
	}

	@Override
	public boolean addNode(long idNum, String label) {

		if (idNum < 0 || 
				label == null || 
				Map.containsKey(label) || 
				vertexList.contains(idNum)) {

			return false;
		} 

		Map.put(label, new Vertex(idNum, label)); // adds vertex to map
		vertexList.add(idNum);					  // adds vertex ID to list

		return true;

	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {

		if (idNum < 0 || 
				edgeList.contains(idNum) ||
				!Map.containsKey(sLabel) || 
				!Map.containsKey(dLabel) ||
				existingDirected(sLabel, dLabel)) {

			return false;
		}

		Edge aEdge = new Edge(idNum, sLabel, dLabel, weight, eLabel);
		edgeList.add(aEdge.idNum);					  // adds edge ID to list

		Map.get(sLabel).outVertex.put(dLabel, aEdge); // adds edge (s --> d) 
		Map.get(dLabel).inVertex.put(sLabel, aEdge);  // adds edge (d <-- s)

		return true;

	}

	public boolean addEdge(long idNum, String sLabel, String dLabel) {

		// alternative addEdge function if weight and eLabel are not specified
		// default to 1 and null respectively
		
		if (idNum < 0 || 
				edgeList.contains(idNum) ||
				!Map.containsKey(sLabel) || 
				!Map.containsKey(dLabel) ||
				existingDirected(sLabel, dLabel)) {

			return false;
		} 

		Edge aEdge = new Edge(idNum, sLabel, dLabel);
		edgeList.add(aEdge.idNum);				      // adds edge ID to list

		Map.get(sLabel).outVertex.put(dLabel, aEdge); // adds edge (s --> d) 
		Map.get(dLabel).inVertex.put(sLabel, aEdge);  // adds edge (d <-- s)

		return true;

	}

	@Override
	public boolean delNode(String label) {

		if (!Map.containsKey(label)) {

			return false;
		}

		Vertex aVertex = Map.get(label);

		Map.remove(label, aVertex);						// removes vertex from map
		vertexList.remove(aVertex.idNum);   			// removes vertex ID from list

		for (int i = 0; i < Map.values().size(); i++) { // removes edges connected to removed vertex

			removeEdges(aVertex, label);
		}

		return true;

	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {

		if (!Map.containsKey(sLabel) || !Map.containsKey(dLabel)) {

			return false;
		}

		Vertex sVertex = Map.get(sLabel);
		Vertex dVertex = Map.get(dLabel);

		if (sVertex.outVertex.containsKey(dLabel) &&
				dVertex.inVertex.containsKey(sLabel)) {

			disconnectVertices(sVertex, dVertex);   

			return true;
		}

		return false;
	}

	@Override
	public long numNodes() {

		return vertexList.size();
	}

	@Override
	public long numEdges() {

		return edgeList.size();
	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {

		// as per instruction, I "got wild" and used my own code from A3 :)
		// go me ...
		// "priority" from minBinHeap was changed to "weight" to match Edge class (readability)
		
		MinBinHeap heap = new MinBinHeap();
		EntryPair aVertex = new EntryPair(label, 0);

		List<ShortestPathInfo> path = new ArrayList<ShortestPathInfo>();
		List<String> checked = new ArrayList<String>();	// list of labels that have been touched during path traversal

		heap.insert(aVertex);
		path.add(new ShortestPathInfo(label, 0));


		while (heap.size() > 0) {

			Vertex currentVertex = Map.get(heap.getMin().value);
			String currentLabel = currentVertex.label;
			long currentDistance = heap.getMin().weight;

			heap.delMin();

			if(!checked.contains(currentLabel)) {

				path.add(new ShortestPathInfo(currentLabel, currentDistance));
				checked.add(currentLabel);

			} 

			for (Edge edge : currentVertex.outVertex.values()) {

				Vertex bVertex = Map.get(edge.endLabel);

				if (!checked.contains(bVertex.label)) {

					long outDistance = currentVertex.outVertex.get(bVertex.label).weight;
					long newDistance = currentDistance + outDistance;

					heap.insert(new EntryPair(bVertex.label, newDistance));

				}
			}
		}

		for (Vertex vertex: Map.values()) { // checks for disjoint paths

			if (disjointPath(checked, vertex)) {

				path.add(new ShortestPathInfo(vertex.label, -1));
			}
		}

		return path.toArray(new ShortestPathInfo[path.size()]);

	}


	/* ***** HELPER METHODS ***** */


	/* removedEdges: 
	   - takes in a vertex that was removed and its label	
	   - checks if it had edges attached and disconnects them 
	   - used in conjunction with deleting a vertex
	 */

	private void removeEdges(Vertex vertex, String label) {

		HashMap<String, Edge> in = vertex.inVertex;
		HashMap<String, Edge> out = vertex.outVertex;

		if (!Map.containsKey(label)) { // makes sure label is gone before removing edges

			if (in.containsKey(label)) {

				long inID = in.get(label).idNum;

				edgeList.remove(inID);
				vertex.inVertex.remove(label);
			}

			if (out.containsKey(label)) {

				long outID = out.get(label).idNum;

				edgeList.remove(outID);
				vertex.outVertex.remove(label);
			}

		} else { // could be extended to remove all edges and create a disjoint vertex (not for class)

			throw new RuntimeException("'Removed' Vertex still exists");
		}

	}
	
	/* disconnectVertices:
	   - takes in the start and end vertices of a removed edge
	   - disconnects the vertices from the edge
	   - removes edge ID from edge list
	   - used in conjunction with deleting an edge
	 */
	
	private void disconnectVertices(Vertex sVertex, Vertex dVertex) {

		Edge aEdge = Map.get(sVertex.label).outVertex.get(dVertex.label);
		
		sVertex.outVertex.remove(dVertex.label, aEdge);
		dVertex.inVertex.remove(sVertex.label, aEdge);
		
		edgeList.remove(aEdge.idNum);
	}

	/* disjointPath:
	   - takes in list of "checked" labels and a vertex
	   - returns true if the vertex is disjoint (disconnected)
	 */
	
	private boolean disjointPath(List<String> checked, Vertex vertex) {

		if(!checked.contains(vertex.label)) {

			return true; // there is a disjoint path
		}

		return false;
	}

	/* existingDirected:
	   - takes in a start label and end label
	   - returns true if there already exists an edge with the same start and end vertices
	   - used in conjunction with adding an edge
	 */

	private boolean existingDirected(String sLabel, String dLabel) {

		if (Map.get(sLabel).outVertex.containsKey(dLabel) 
				&& Map.get(dLabel).inVertex.containsKey(sLabel)) {

			return true; // there is already a directed edge here

		} else {

			return false;
		}
	}

}