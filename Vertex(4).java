import java.util.ArrayList;
public class Vertex
{
    int dollars;
    char name; //changed it from private for now but might change it back
    ArrayList<Vertex> connectedTo = new ArrayList<Vertex>();

    Vertex(int dollars, char name) {
        this.dollars = dollars;
        this.name = name;
    }

    public void setConnectedTo(Vertex connectMe)
    {
        connectedTo.add(connectMe);
    }

    public boolean isConnected(Vertex otherVertex)
    {
        return connectedTo.contains(otherVertex);
    }
    
    //adds a dollar to every vertex connected to the curent one and subtracts a dollar each time a dollar is given
    public void giveDollars(){
        for(int i = 0; i < connectedTo.size(); i++){
            connectedTo.get(i).addDollars();
            this.dollars--;
        }
    }
    
    //takes a dollar from every vertex connected and adds it to the current vertex
    public void takeDollars(){
        for(int i = 0; i < connectedTo.size(); i++){
            connectedTo.get(i).subDollars();
            this.dollars++;
        }
    }
    
    //subtracts a dollar from the dollar amount
    public void subDollars(){
        this.dollars--;
    }
    
    //Will add a dollar when another vertex gives
    public void addDollars(){
        this.dollars++;
    }
    
    //returns the char letter associated with the vertex
    public char getName(){
        return this.name;
    }
    
    //returns the total amount of money the vertex has 
    public int getMoney(){
        return this.dollars;
    }
}