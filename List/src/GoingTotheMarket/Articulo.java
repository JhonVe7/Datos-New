package GoingTotheMarket;
import List.Node;

public class Articulo implements Node {
	
	//Data Structure Node Client
	String name = "";
	double  cost = 0.0;

	Articulo next = null;
	
	public Articulo(double cost ){
		
		this.cost = cost;
		
	}
	public Articulo(String name){
		
		this.name = name;
		
	}
	
	public Articulo(String name , double cost ){
	
		this.name = name;
		this.cost = cost;
		
	}
	
	
	@Override
	public void setNext(Node node){
		
		next = (Articulo)node; 
	}
	
	@Override
	public Node getNext(){
		
		return next;
	}
	
	@Override
	public Node clone(){
		
		Articulo clone = new Articulo (name, cost);
		return clone;
	}
	
	@Override
	public boolean isEqual(Node node){
		
		Articulo temp = (Articulo)node;
		if(this.cost == temp.cost )
			return true;
			
		return false;
	}
	
	
	
	@Override
	public String toString()
	{
		return "*" + this.name + this.cost +"\n";
	}

	@Override
	public boolean isLessThan(Node node) {
		// TODO Auto-generated method stub
		return false;
	}
}