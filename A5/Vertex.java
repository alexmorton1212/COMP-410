package DiGraph_A5;

import java.util.HashMap;

public class Vertex {

	long idNum;
	String label;
	
	HashMap<String, Edge> inVertex;
	HashMap<String, Edge> outVertex;
	
	public Vertex(long idNum, String label) {
		
		this.idNum = idNum;
		this.label = label;
		
		this.inVertex = new HashMap<String, Edge>();
		this.outVertex = new HashMap<String, Edge>();
		
	}
	
	public long getID() {
		return this.idNum;
	}
	
	public String getLabel() {
		return this.label;
	}

}

