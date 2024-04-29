//File: Tree.java
//Ace Crawford 
//Fall 2023, Transy
//PPL

import java.io.*;
import java.util.ArrayList;

public class Tree{

	private Vertex root;
	private ArrayList<KeysAndParents> inputTree = new ArrayList<KeysAndParents>();

	//sets the parent for an object KeysAndParents in an array list of KeysAndParents, given the vertex that needs to be changed and the new name.
	public void setParentofTreeLimb(String u, Vertex v){
		for( int x = 0; x < inputTree.size(); x++){
			if(inputTree.get(x).getName().equals(v.getName())){
				inputTree.get(x).setParent(u);
			}
		}
	}

	//sets the weight for an object KeysAndParents in an array list of KeysAndParents, given the vertex that needs to be changed and the new weight.
	public void setWeightOfTreeLimb(double weightUV, Vertex v){
		for( int x = 0; x < inputTree.size(); x++){
			if(inputTree.get(x).getName().equals(v.getName())){
				inputTree.get(x).setKey(weightUV);
			}
		}
	}

	//prints the name, parent, and weight of each KeysAndParent object in the tree, as well as the weight of the whole tree.
	public void print(){
		KeysAndParents vertex = new KeysAndParents();
		double treeWeight = 0;

		for( int x = 0; x < inputTree.size(); x++){
			System.out.println("Vertex name: " + inputTree.get(x).getName());
			System.out.println("Parent: " + inputTree.get(x).getParent());
			System.out.println("Weight: " + inputTree.get(x).getKey());
			treeWeight = treeWeight + inputTree.get(x).getKey();
			System.out.println(" ");
		}
		System.out.println("The total weight of the tree is: " + treeWeight);
	}

	//initlilizes the tree with the vertexes in graph
	public void initilize(Graph inputGraph){

		ArrayList<String> listOfVertices = new ArrayList<String>();
		listOfVertices = inputGraph.getVerticies();

			for( int x = 0; x < listOfVertices.size(); x++){
				KeysAndParents vertex = new KeysAndParents();
				vertex.setName(listOfVertices.get(x));
				int max = Integer.MAX_VALUE;
				max--;
				vertex.setKey(Integer.MAX_VALUE); //https://codegym.cc/groups/posts/integermax_value-in-java-with-examples
				inputTree.add(vertex);
			}
	}

	//sets the root of the tree tp it's parent as nil, and it's key as 0
	public void setRoot(Vertex root){
		KeysAndParents vertex = new KeysAndParents();

		for(int x = 0; x < inputTree.size(); x++){
			if(inputTree.get(x).getName().equals(root.getName())){ //https://www.w3schools.com/java/ref_string_equals.asp
				inputTree.get(x).setParent("nil");
				inputTree.get(x).setKey(0);
			}
		}
	}



}
