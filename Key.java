//File: Key.java
//Ace Crawford 
//Fall 2023, Transy
//PPL

import java.io.*;
import java.util.ArrayList;

public class Key{

	private ArrayList<KeysAndParents> key = new ArrayList<KeysAndParents>();

	//takes in a graph, and initilizes the key
	public void initilize(Graph inputGraph){
		ArrayList<String> listOfVertices = new ArrayList<String>();
		//gets a list of all the verticies with no duplicates that are present in the graph
		listOfVertices = inputGraph.getVerticies();

			for( int x = 0; x < listOfVertices.size(); x++){
				KeysAndParents vertex = new KeysAndParents();
				vertex.setName(listOfVertices.get(x));
				int max = Integer.MAX_VALUE;
				vertex.setKey(Integer.MAX_VALUE); //https://codegym.cc/groups/posts/integermax_value-in-java-with-examples
				key.add(vertex);
			}
	}

	//takes in the root of the tree, and initilizes it's parent to nil, and it's key to 0
	public void setRoot(Vertex root){
		KeysAndParents vertex = new KeysAndParents();
		for(int x = 0; x < key.size(); x++){
			if(key.get(x).getName().equals(root.getName())){ //https://www.w3schools.com/java/ref_string_equals.asp
				key.get(x).setParent("nil");
				key.get(x).setKey(0);
			}
		}
	}

	//the print method for key is NOT called in this program. It is here incase professor Moorman must do component testing, to make his life easier :)
	//prints the name, parent, and key for every KeysAndParent object held in the key
	public void print(){
		System.out.println(" ");
		KeysAndParents vertex = new KeysAndParents();

		for( int x = 0; x < key.size(); x++){
			System.out.println(key.get(x).getName());
			System.out.println(key.get(x).getParent());
			System.out.println(key.get(x).getKey());
			System.out.println(" ");
		}
	}

	//return true if key is empty, returns false if the key is not empty
	public boolean isEmpty(){
		return key.isEmpty();//https://www.geeksforgeeks.org/arraylist-isempty-java-example/
	}

	//extracts the KeysAndParent object with the minimum key, then returns the name of the minimum KeysAndParents object
	public String extractMinimum(){

		KeysAndParents minVertex = new KeysAndParents();
		double min = Integer.MAX_VALUE;

		for(int x = 0; x < key.size(); x++){
			if(key.get(x).getKey() < min){
				minVertex = key.get(x);
				min = key.get(x).getKey();
			}
		}
	key.remove(minVertex);
	return minVertex.getName();
}

	public int size(){
		return key.size();
	}

	//checks if a given vertex is in the key
	public boolean inKey(Vertex v){
		boolean inTheKey = false;

		for( int x = 0; x < key.size(); x++){
			if(key.get(x).getName().equals(v.getName())){
				inTheKey = true;
			}
		}
		return inTheKey;
	}

	//gets the weight of a given vertex in the key
	public double getWeightOfV(Vertex v){
		double weightOfV = 0;
		for( int x = 0; x < key.size(); x++){
			if(key.get(x).getName().equals(v.getName()))
				weightOfV = key.get(x).getKey();
		}
		return weightOfV;
	}

	//sets the parent of a given vertex in the tree with the name passed in
	public void setParentofKey(String u, Vertex v){
		for( int x = 0; x < key.size(); x++){
			if(key.get(x).getName().equals(v.getName())){
				key.get(x).setParent(u);
			}
		}
	}

	//sets the weight of a given vertex in the tree with the weight passed in
	public void setWeightOfKey(double weightUV, Vertex v){
		for( int x = 0; x < key.size(); x++){
			if(key.get(x).getName().equals(v.getName())){
				key.get(x).setKey(weightUV);
			}
		}
	}


}
