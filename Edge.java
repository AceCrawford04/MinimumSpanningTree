//File: Edge.java
//Ace Crawford 
//Fall 2023, Transy
//PPL

import java.io.*;

public class Edge{

private Vertex edgeStart;
private Vertex edgeEnd;
private double edgeWeight;

public void setStart(Vertex start){
		edgeStart = start;
	}

public Vertex getStart(){
		return edgeStart;
	}

public void setEnd(Vertex end){
		edgeEnd = end;
	}

public Vertex getEnd(){
		return edgeEnd;
	}

public void setWeight(double length){
		edgeWeight = length;
	}

public double getWeight(){
		return edgeWeight;
	}
}
