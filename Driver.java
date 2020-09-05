/** Title: Dollar Game
 *  Name of File: 
 *  External Files:
 *  External Files Created by Program: n/a
 *  Programmers: Kerry Houihan, Caleb Riese
 *  Programmers Emails: kehbcw@mail.umsl.edu
 *  Class: CS 4500 Section 1 
 *  Date Finished:
 *  Date Sumbitted:
 *  Explaination: This program simulates the dollar game. In this game, the user indicates the number
 *                of vertices along with how these vertices are connected to each other. The vertices 
 *                are assigned a dollar amount which can be positive or negative. Each vertex can give 
 *                a dollar to all the vertices they are connected to, or they can take from all the 
 *                vertices they are connected with. The objective of the game is to have all the vertices
 *                not have a negative dollar amount associated with it in as few moves as possible.
 *                The user can play until they decide to quit. When they quit, all of the information 
 *                from the game will be outputted, and they will be told if they won or not. 
 *  Resources Used:
 */ 

import java.util.Scanner;

public class Driver
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the dollar game! The objective of this game is to have all of your vertices equal to one or zero "
                         + "essentially, you do not want debt. You will specify the number of vertices along with how they are connected. "
                         + "You can play as long as you want when you're done we'll let you know if you have won or not. Good Luck!");

        System.out.println("How many Vertices?(Between 2-7 inclusive)");
        int numberOfVertices = Integer.parseInt(input.nextLine());
        
        int maxEdges = (numberOfVertices * (numberOfVertices -1))/2;

        System.out.println("How many Edges? (Between " + (numberOfVertices - 1) + "-" + maxEdges);
        int numberOfEdges = Integer.parseInt(input.nextLine());

        Vertex[] vertices = new Vertex[numberOfVertices];
        char[] verticeNames = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'}; 
        String[] edgeNames = new String[numberOfEdges];
        
        /** This loop asks the user for starting amount for each vertex. Then, each vertex
         *  is initalized with the starting amount and the letter of the alphabet that will 
         *  refer to each vertex
         */
        for(int count = 0; count < vertices.length; count++){
            System.out.println("Please enter the starting number for vertex " + verticeNames[count]);
            int startingAmount = Integer.parseInt(input.nextLine());
            vertices[count] = Vertex(staringAmount, verticeNames[count]);
        }
        
        for(int count = 0; count < maxEdges; count++){
            Boolean flag = false;
            do{
            System.out.print("Please enter the two characters of two vertices you wish to connect \n"
                            + "Vertices cannot connect to themselves, and a second edge between two "
                            + "vertices is not allowed");
            String edgeName = input.nextLine();
            edgeName = edgeName.toUpperCase()
            
            flag = checkString(edgeName, edgeNameArray);
            
            }while(!flag);
            
           edgeNameArray[count] = edgeName; //add new edge to the array of edges
           char[] charEdge = edgeName.toCharArray();
           
           for(int i = 0; i < vertices.length; i++){
               if(vertices[i].getName() == charEdge[0]){
                   int vertexPosition1 = i;
               }else if(vertices[i].getName == charEdge[1])
                    int vertexPosition2 = i;
               }
           }
           
           vertices[vertexPosition1].setConnectedTo(vertices[vertexPosition2]);
           vertices[vertexPosition2].setConnectedTo(vertices[vertexPosition1]);
           
           
        }
    }

    boolean checkString(String edgeName, String[] verifiedEdgesArray){
       
        char[] edgeNameArray = edgeName.toCharArray();
           
        char[] possibleEdgeArray = new char[]{verifiedEdgesArray[1], verifiedEdgesArray[0]}; //other possibility
        String possibleEge = new String(possibleEdgeArray);
        
        if(edgeName.length() !=2){
            System.out.println("Error: invalid input. An edge consists of two vertices.");
            return false;
        }
            
        if(edgeNameArray[0] == edgeNameArray[1]){
            System.out.println("Error: An edge cannot connect the same vertices");
            return false;
        }
        
        for(int i = 0; i < edgeName.length; i++){
            if(edgeName == verifiedEdgesArray[i] || possibleEdge == verifiedEdgesArray[i]){
                System.out.println("Error: Edge already exists. .");
                return false;
            }
        }
        
        return true;
    }
}

