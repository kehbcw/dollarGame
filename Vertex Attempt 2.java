import java.util.*;

public class Vertex
{
    int dollars;
    private char name;
    ArrayList<Vertex> connectedTo = new ArrayList<Vertex>();
    //Vertex[] connectedTo = new Vertex[]; //can be connected to multiple vertices at most 6, Idk if this has to be a pointer or not?
    //maybe use ArrayList so we can append

    Vertex(int dollars, char name) {
        this.dollars = dollars;
        this.name = name;
    }

    public void setConnectedTo(Vertex connectMe) //
    {
        connectedTo.add(connectMe);
        //connectedTo[0] = connectMe; // I just put this here as a placeholder
        //maybe we could increment a counter everytime we add a new connection, or use ArrayList
    }
    
    public void giveDollars(){
        this.dollars--;
    }
    
    //Will add a dollar when another vertex gives
    public void addDollars(){
        this.dollars++;
    }
    
    public char getName(){
        return this.name;
    }
    
    public int getMoney(){
        return this.dollars;
    }
}