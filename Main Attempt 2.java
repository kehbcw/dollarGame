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
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numberOfVertices;
        int numberOfEdges;
        
        char[] verticeNames = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        String edgeName;
        
        int startingAmount;
        
        
        System.out.print("Welcome to the dollar game! The objective of this game is to have all of your vertices equal to one or zero "
                         + "essentially, you do not want debt. You will specify the number of vertices along with how they are connected. "
                         + "You can play as long as you want when you're done we'll let you know if you have won or not. Good Luck!");
        System.out.println();
        
        System.out.println("How many Vertices? (Between 2-7 inclusive)");
        numberOfVertices = Integer.parseInt(input.nextLine());
        
        
        int maxEdges = (numberOfVertices * (numberOfVertices -1))/2;
        
        System.out.println("How many Edges? (Between " + (numberOfVertices - 1) + "-" + maxEdges);
        numberOfEdges = Integer.parseInt(input.nextLine());
        
        Vertex[] vertices = new Vertex[numberOfVertices];
        String[] edgeNameArray = new String[numberOfEdges];
        
        for(int count = 0; count < vertices.length; count++){
            System.out.println("Please enter the starting number for vertex " + verticeNames[count]);
            startingAmount = Integer.parseInt(input.nextLine());
            vertices[count] = new Vertex(startingAmount, verticeNames[count]);
        }
        
        //for(int count = 0; count < vertices.length; count++){
          //  System.out.println(vertices[count].getName() + " " + vertices[count].getMoney());
        //}
        
        for(int count = 0; count < numberOfEdges; count++){
            boolean flag = false;
            
            do{
                System.out.print("Please enter the two characters of two vertices you wish to connect \n"
                                + "Vertices cannot connect to themselves, and a second edge between two "
                                + "vertices is not allowed\n");
           
                edgeName = input.nextLine();
                edgeName = edgeName.toUpperCase();
                
                flag = checkString(edgeName, edgeNameArray);
                
           } while(!flag);
           
           edgeNameArray[count] = edgeName;
           
           assignEdges(edgeName);
           
        }
        }
        
    public static boolean checkString(String edgeName, String[] edgeNameArray){
        
        char[] charArray = edgeName.toCharArray();
        boolean flag = false;

        char[] possibleEdgeArray = new char[]{charArray[1], charArray[0]};
        String possibleEdge = new String(possibleEdgeArray);
        
        //checks the length of the edge given 
        if(edgeName.length() !=2){
            System.out.println("Error: invalid input. An edge consists of two vertices.");
            flag = false;
            return flag;
        }
        
        //checks to sure the edge given is not an edge to itself 
        if(charArray[0] == charArray[1]){
            System.out.println("Error: An edge cannot connect the same vertices");
            flag = false;
            return flag;
        }
        
        //checks to see if the edge given matches a previous edge or if the reverse edge given matches a previous edge 
        for(int i = 0; i < edgeNameArray.length; i++){
            if(Arrays.asList(edgeNameArray).contains(edgeName) || Arrays.asList(edgeNameArray).contains(possibleEdge)){ 
                System.out.println("Error: Edge already exists.");
                flag = false;
                return flag;
            }
        }
        flag = true;
        return flag;
        
    }
    
    //trying to call the setConnectedTo method of the Vertex class. 
    //attempting to find the position in the vertices array for both of the edge values
    //then trying to use the setConnectedTo method and pass the other char
    public static void assignEdges(String edgeName, Vertex[] vertices){
        char[] charArray = edgeName.toCharArray();
        int vertexPosition1;
        int vertexPosition2;
        
        for(int i = 0; i < vertices.length; i++){
            if(vertices[i].getName() == charArray[0]){
                vertexPosition1 = i;
                System.out.println(vertices[i].getName());
            }else if(vertices[i].getName() == charArray[1])
                 vertexPosition2 = i;
                 System.out.println(vertices[i].getName());
               }
           }
           
           Vertex vertex1 = vertices[vertexPosition1];
           Vertex vertex2 = vertices[vertexPosition2];
           
           vertex1.setConnectedTo(vertex2);
           vertex2.setConnectedTo(vertex1);
    }
       