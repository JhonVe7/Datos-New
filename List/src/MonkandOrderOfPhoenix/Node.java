package MonkandOrderOfPhoenix;
import MonkandOrderOfPhoenix.Node;

public class Node{//class Node

	//Student
	public int escuela;
	public int pergamino;
	
	
	public Node next; //pointer
	
	public Node() {}//Constructor
	
	public Node(int School, int pergamino)
	{//beginning constructor
		
		this.escuela = School;
		this.pergamino = pergamino;
		
		
	}//end Initialization
	
	public String toString() {//method print list
		
		return this.escuela + "" + this.pergamino + " ";
		
	}
}