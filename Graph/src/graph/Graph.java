package graph;

/* * * * * * * * * * * * * * * * * *
 * Created by Warren Peterson for  *
 * CST-201 on 1/14/2022 for Graph  *
 * Project in final week * * * * * *
 * * * * * * * * * * * * * * * * * */

import java.util.ArrayList;
import java.util.List;

class Graph {

	// Variables
	private int vertexSize; // Holds the vertices
	private String []vertexArray; // Vertex Array
    private int [][]twoDArrayOfEdges; // Contains the edges between vertices

    // Constructor Method to Generate Graph
    // O(n^2) Quadratic Time
    public Graph(int vertex) {
    	vertexSize = vertex;
    	vertexArray = new String[vertexSize];
    	twoDArrayOfEdges = new int[vertexSize][vertexSize];
        for(int vertexEdgeA = 0; vertexEdgeA < vertexSize; vertexEdgeA ++) {
        	// If 0 than there are no edges
        	for(int vertexEdgeB = 0; vertexEdgeB < vertexSize; vertexEdgeB++) {
        		twoDArrayOfEdges[vertexEdgeA][vertexEdgeB] = 0;
        	}
        }
    }
    
    // Sets the vertex and county names
    // O(1) Constant Time
    public void addVertex(int countyIndex, String countyVertex) {
    	vertexArray[countyIndex] = countyVertex;
    }
    
    // Gets the position of county in graph matrix
    // O(n) Linear Time
    public int getVertexPosition(String county) {
    	for(int vert = 0; vert < vertexSize; vert++) {
        	if(vertexArray[vert].equals(county))
        		return vert;
    	}
    	return -1;
    }

    // Method to add Edges to the array
    // O(1) Constant Time
    public void addEdge(String vertexA, String vertexB, int distance) {
    	// Retrieves position of vertex A
        int vertA = getVertexPosition(vertexA);
        // Retrieves position of vertex B
        int vertB = getVertexPosition(vertexB);
        //if city exists
        if( vertA != -1 && vertB != -1) {
        	// Sets edges for both county indexes
        	twoDArrayOfEdges[vertA][vertB] = distance;
        	twoDArrayOfEdges[vertB][vertA] = distance;
        }
    }

    // Get Distance Method finds the distance between two Neighboring Vertexes
    // O(1) Constant Time
    public int getDistance(String vertex1, String vertex2) {
    	// Retrieves the index of vertex A
        int vert1 = getVertexPosition(vertex1);
        // Retrieves the index of vertex B
        int vert2 = getVertexPosition(vertex2);
        // If counties being searched for exist
        if(vert1 != -1 && vert2 != -1)
        	// If an edge exists between the two
        	if(twoDArrayOfEdges[vert1][vert2] != 0)
        	   // Return the distance between edges
        		return twoDArrayOfEdges[vert1][vert2];
        // Else return MAX VALUE
        return Integer.MAX_VALUE;
    }

    // Method to Return the List of Vertex Neighbors along shared Edges
    // O(n) Linear Time
    public List<String> getNeighbors(String searchedVertex) {
    	// Retrieves the position of the vertex
    	int source = getVertexPosition(searchedVertex);
    	// List to store Neighbors
    	List<String> neighborList = new ArrayList<>();
    	// If county exists
    	if(source != -1)
    		// then check the edges of vertices
            for(int target = 0; target < vertexSize; target++) {
            	// If edges exist
                if(twoDArrayOfEdges[source][target] != 0)
                	//add the neighbor to list
                	neighborList.add(vertexArray[target]);
            }
    	return neighborList;//return the list
    }

    // Method that Creates the Adjacency Matrix
    // O(names)+(header size)+(n^2) Quadratic Time
    public void adjacencyMatrixComplier() {
    	System.out.println("--Map Key--\n");
    	// County names are A to O (0-15 counties) by using implicit cast
        for(int names = 0 ; names < vertexSize; names++) {
            System.out.println("("+ (char)(65 + names) +") = " + vertexArray[names]);
        }
        // For adjusting the spaces between cells
        System.out.println("");
        System.out.print("   ");
        // Tab over after each cell is displayed and use implicit cast
        // and display Column header from A to O
        for(int cols = 0; cols < vertexSize; cols ++) {
            System.out.print((char)(65 + cols) + "\t");
        }
        // For spacing
        System.out.println("");
        // Display Row Labels from A to O
        for(int row = 0; row < vertexSize; row++) {
            System.out.print((char)(65 + row) + " |");
            // Display the Two D Array of Edge Length between Vertices in the Matrix
            for(int col = 0; col < vertexSize; col++) {
                System.out.print(twoDArrayOfEdges[row][col]+"\t");
            }
            System.out.println("");
        }    
    }
}