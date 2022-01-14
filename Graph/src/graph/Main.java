package graph;

/* * * * * * * * * * * * * * * * * *
 * Created by Warren Peterson for  *
 * CST-201 on 1/14/2022 for Graph  *
 * Project in final week * * * * * *
 * * * * * * * * * * * * * * * * * */

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
        Graph graphProgram = new Graph(15);//graph with 15 vertices

        //setting all city names explicitly
        graphProgram.addVertex(0,"Mohave");
        graphProgram.addVertex(1,"Coconino");
        graphProgram.addVertex(2,"Navajo");
        graphProgram.addVertex(3,"Apache");
        graphProgram.addVertex(4,"Greenlee");
        graphProgram.addVertex(5,"Cochise");
        graphProgram.addVertex(6,"Santa Cruz");
        graphProgram.addVertex(7,"Pima");
        graphProgram.addVertex(8,"Pinal");
        graphProgram.addVertex(9,"Graham");
        graphProgram.addVertex(10,"Gila");
        graphProgram.addVertex(11,"Yavapai");
        graphProgram.addVertex(12,"La Paz");
        graphProgram.addVertex(13,"Yuma");
        graphProgram.addVertex(14,"Maricopa");
        //adding edges between cities
        graphProgram.addEdge("Mohave","Coconino",14);
        graphProgram.addEdge("Mohave","Yavapai",14);
        graphProgram.addEdge("Mohave","La Paz",9);
        graphProgram.addEdge("Coconino","Navajo",9);
        graphProgram.addEdge("Coconino","Gila",17);
        graphProgram.addEdge("Coconino","Yavapai",9);
        graphProgram.addEdge("Navajo","Gila",13);
        graphProgram.addEdge("Navajo","Graham",20);
        graphProgram.addEdge("Navajo","Apache",5);
        graphProgram.addEdge("Apache","Greenlee",17);
        graphProgram.addEdge("Apache","Graham",19);
        graphProgram.addEdge("Greenlee","Cochise",16);
        graphProgram.addEdge("Greenlee","Graham",4);
        graphProgram.addEdge("Cochise","Graham",12);
        graphProgram.addEdge("Cochise","Pima",9);
        graphProgram.addEdge("Cochise","Santa Cruz",8);
        graphProgram.addEdge("Santa Cruz","Pima",6);
        graphProgram.addEdge("Pima","Graham",12);
        graphProgram.addEdge("Pima","Pinal",7);
        graphProgram.addEdge("Pima","Maricopa",10);
        graphProgram.addEdge("Pima","Yuma",23);
        graphProgram.addEdge("Pinal","Graham",13);
        graphProgram.addEdge("Pinal","Gila",5);
        graphProgram.addEdge("Pinal","Maricopa",6);
        graphProgram.addEdge("Graham","Gila",7);
        graphProgram.addEdge("Gila","Yavapai",18);
        graphProgram.addEdge("Gila","Maricopa",8);
        graphProgram.addEdge("Yavapai","La Paz",9);
        graphProgram.addEdge("Yavapai","Maricopa",16);
        graphProgram.addEdge("La Paz","Maricopa",15);
        graphProgram.addEdge("La Paz","Yuma",11);
        graphProgram.addEdge("Maricopa","Yuma",16);
        
        System.out.println("List of Counties :\nMohave\nCoconino\nNavajo\nApache\nGreenlee\nCochise\nSanta Cruz\nPima\nPinal\nGraham\nGila\nYavapai\nLa Paz\nYuma\nMaricopa" );
        System.out.println("Enter a County Name to see its neighboring cities :");
        
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
        List<String> myList = graphProgram.getNeighbors(input);
        System.out.print("Neighbor cities of " + input + " : ");
      //display list
        System.out.println(myList);
        System.out.println("The neighbors of " + input + " are :");
        System.out.println("Enter a neighboring county: \n");
        String searchedWord = scanner.nextLine();
        System.out.print("Distance between " + input + " and " + searchedWord + " : "+graphProgram.getDistance(input,searchedWord)+"\n");//distance between two cities
        System.out.println("Click Enter to see the Adjacency Matrix");
        String nextLine = scanner.nextLine();
        System.out.println(nextLine);
        //adjacency matrix  
        graphProgram.adjacencyMatrixComplier();     
    }

}