//File: KeysAndParents.java
//Ace Crawford 
//Fall 2023, Transy
//PPL

import java.io.*;

public class KeysAndParents{

	private String vertexName;
	private String vertexParent;
	private double vertexKey;

	public void setName(String name){
		vertexName = name;
	}

	public String getName(){
		return vertexName;
	}

	public void setParent(String parent){
		vertexParent = parent;
	}

	public String getParent(){
		return vertexParent;
	}

	public void setKey(double weight){
		vertexKey = weight;
	}

	public double getKey(){
		return vertexKey;
	}

}
