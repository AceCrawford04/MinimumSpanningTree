//File: Graph.java
//Ace Crawford 
//Fall 2023, Transy
//PPL
import java.io.*;
import java.util.ArrayList;

public class Graph{

	private ArrayList<Edge> graph = new ArrayList<Edge>();

	//reads in file and initilizes the graph
	public void makeGraph(String fileName){	
		try{
			String start;
			String end;
			double weight;

 			FileReader file = new FileReader(fileName);
 			StreamTokenizer inputStream = new StreamTokenizer(file);
 			int tokenType = inputStream.nextToken();
 			while (tokenType != StreamTokenizer.TT_EOF) {
				Edge tempEdge = new Edge();
 				Edge count = new Edge();

  				start = inputStream.sval;
 				Vertex startVertex = new Vertex();
 				startVertex.setName(start);
 				tempEdge.setStart(startVertex);

 				tokenType = inputStream.nextToken();
 				end = inputStream.sval;
 				Vertex endVertex = new Vertex();
 				endVertex.setName(end);
 				tempEdge.setEnd(endVertex);

 				tokenType = inputStream.nextToken();
 				weight = inputStream.nval;
 				tempEdge.setWeight(weight);

 				graph.add(tempEdge);
 				tokenType = inputStream.nextToken();
 			}
		 }
		catch(FileNotFoundException e){
			System.exit(1);
		}
		catch(IOException e){
			System.exit(1);
		}
	}

	//the print method for graph is NOT called in this program. It is here incase professor Moorman must do component testing, to make his life easier :)
	//prints the starting vertex, ending vertex, and weight of each edge stored in the graph
	public void print(){
		System.out.println(" ");
		Edge tempEdge = new Edge();
		tempEdge = graph.get(1);
		
		for( int x = 0; x < graph.size(); x++){
			System.out.println(graph.get(x).getStart().getName());
			System.out.println(graph.get(x).getEnd().getName());
			System.out.println(graph.get(x).getWeight());
		}
	}

	//finds all the verticies without duplicates stored in the graph, and returns an array list of strings containing the name of each vertice
	public ArrayList<String> getVerticies(){
		ArrayList<String> listOfVertices = new ArrayList<String>();

		//adding the start vertices of each edge to the array list
		for( int x = 0; x < graph.size(); x++){
			if(!listOfVertices.contains(graph.get(x).getStart().getName())){
			listOfVertices.add(graph.get(x).getStart().getName());
			}	
		}

		//adding the end vertices of each edge to the array list
		for( int x = 0; x < graph.size(); x++){
			if(!listOfVertices.contains(graph.get(x).getEnd().getName())){
			listOfVertices.add(graph.get(x).getEnd().getName());
			}	
		}
		return listOfVertices;
	}

	public int size(){
		return graph.size();
	}

	//gets the name of a starting vertex given the index of an edge in the graph
	public String getStartVertexName (int i){
		return graph.get(i).getStart().getName();
	}

	//gets a starting vertex from the graph given the index of an edge in the graph
	public Vertex getStartVertex (int i){
		return graph.get(i).getStart();
	}

	//gets the name of an ending vertex given the index of an edge in the graph
	public String getEndVertexName (int i){
		return graph.get(i).getEnd().getName();
	}

	//gets an endinging vertex from the graph given the index of an edge in the graph
	public Vertex getEndVertex (int i){
		return graph.get(i).getEnd();
	}
	
	//takes in the name of u, and the vertex v. Returns the weight of (u,v) based on the graph
	public double getWeightUV(String u, Vertex v){
		double uVWeight = 0;

		for(int i = 0; i < graph.size(); i++){
			if( graph.get(i).getStart().getName().equals(u) && graph.get(i).getEnd().getName().equals(v.getName())){
				uVWeight = graph.get(i).getWeight();
			}
			if(graph.get(i).getEnd().getName().equals(u) && graph.get(i).getStart().getName().equals(v.getName())){
				uVWeight = graph.get(i).getWeight();
			}
		}
		return uVWeight;
	}

	//checks if the root of the graph is present in the graph
	public boolean checkForRoot(Vertex root){
		boolean rootInGraph = false;

		for(int i = 0; i < graph.size(); i++){
			if(graph.get(i).getStart().getName().equals(root.getName())){
				rootInGraph = true;
			}
		}
		return rootInGraph;
	}

	public void createMST(Vertex root, Graph inputGraph){
		//Graph inputGraph = new Graph();
		Key keyList= new Key();
		Tree tree = new Tree();

		keyList.initilize(inputGraph);
		keyList.setRoot(root);
		tree.initilize(inputGraph);
		tree.setRoot(root);

		String minU;
		Vertex v = new Vertex();
		int keyListSize = keyList.size();
		double weightUV = 0;
		double keyV = 0;

			//while the list of keys is not empty
			while(!keyList.isEmpty()){	
				//for each vertex in the key
	 			for(int x = 0; x < keyListSize; x++){
	 				minU = keyList.extractMinimum();
	 			
	 				//for each edge of the graph
	 				for(int i = 0; i < inputGraph.size(); i++){
	 					boolean connected = false;
	 					//checking if the end vertex for the current edge is connected to the minimum u
	 					if(minU.equals(inputGraph.getStartVertexName(i))){
	 						v = inputGraph.getEndVertex(i);
	 						connected = true;
	 					}
	 					//checking if the start vertex fro the current edge is connected to the minimum u
	 					if(minU.equals(inputGraph.getEndVertexName(i))){
	 					v = inputGraph.getStartVertex(i);
	 					connected = true;
	 					}
	 					if (connected == true){
	 						//if v is in the list of keys
	 						if(keyList.inKey(v)){
	 							weightUV = inputGraph.getWeightUV(minU, v);
	 							keyV = keyList.getWeightOfV(v);

	 								if(weightUV < keyV){
	 									//set the parent of v to be the current u
	 									keyList.setParentofKey(minU, v);
	 									//set v's parent in the tree
	 									tree.setParentofTreeLimb(minU, v);
	 				    				//set the key of v to be the current u
	 				     				keyList.setWeightOfKey(weightUV, v);
	 				     				//set v's weight in the tree
	 				    				tree.setWeightOfTreeLimb(weightUV, v);
	 								}
	 					
	 						}
	 				}
	 				}

	 			}
			}
		tree.print();
	}

}
