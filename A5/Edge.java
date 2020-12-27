package DiGraph_A5;

public class Edge {
	
	long idNum;
	String startLabel;
	String endLabel;
	long weight;
	String edgeLabel;
	

	public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		
		this.idNum = idNum;
		this.startLabel = sLabel;
		this.endLabel = dLabel;
		this.weight = weight;
		this.edgeLabel = eLabel;
	}
	
	public Edge(long idNum, String sLabel, String dLabel) {
		
		this.idNum = idNum;
		this.startLabel = sLabel;
		this.endLabel = dLabel;
		this.weight = 1; // default
		this.edgeLabel = null; // default
		
	}
	
	public long getID() {
		return this.idNum;
	}
	
	public String getStartLabel() {
		return this.startLabel;
	}
	
	public String getEndLabel() {
		return this.endLabel;
	}
	
	public long weight() {
		return this.weight;
	}
	
	public String getEdgeLabel() {
		return this.edgeLabel;
	}

}
