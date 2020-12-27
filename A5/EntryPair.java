package DiGraph_A5;

import DiGraph_A5.EntryPair_Interface;

public class EntryPair implements EntryPair_Interface {
	public String value;
	public long weight; // changed from DiGraph

	public EntryPair(String aValue, long aPriority) {
		value = aValue;
		weight = aPriority;
	}

	public String getValue() { return value; }
	public int getPriority() { return (int) weight; }
}
