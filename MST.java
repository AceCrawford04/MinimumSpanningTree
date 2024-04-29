//File: MST.java
//Ace Crawford 
//Fall 2023, Transy
//PPL
//This program takes in a file of edges in the form starting vertex, ending vertex, weight and a root then creates a minimum spanning tree
import java.io.*;

public class MST {


	public static void main (String[] args){
	//move mst to graph
	if( args.length < 2){ //https://www.mygreatlearning.com/blog/java-array-length/
		System.out.println("Error: not enough argumants were entered.");
		System.out.println("Please enter a file name and the root of the tree.");
	} else if (args.length > 2) {
		System.out.println("Error: too many arguments were entered.");
		System.out.println("Please enter a file name and the root of the tree.");
	} else {
		String fileName;
		int edgeCount;
		Vertex root = new Vertex();
		Graph inputGraph = new Graph();
		//Key keyList= new Key();
		//Tree tree = new Tree();

		fileName = args[0];
		root.setName(args[1]);
		System.out.println("The name of the root is " + root.getName());
		inputGraph.makeGraph(fileName);

		if (inputGraph.checkForRoot(root) == false){
			System.out.println("Error: the root you entered was not in the graph.");
		}
		else{

			inputGraph.createMST(root, inputGraph);
	}
	}
	}
}
