package HowToTrainYourDragon;
import List.Node;

public class Dragon implements Node {
	
	//Data Structure Node Client
	int Days = 0;
	int  Debt = 0;

	Dragon next = null;
	
	public Dragon(int debt ){
		
		this.Debt = debt;
		
	}
	
	public Dragon(int days , int debt ){
	
		this.Days = debt;
		this.Debt = days;
		
	}
	
	
	@Override
	public void setNext(Node node){
		
		next = (Dragon)node; 
	}
	
	@Override
	public Node getNext(){
		
		return next;
	}
	
	@Override
	public Node clone(){
		
		Dragon clone = new Dragon (Days, Debt);
		return clone;
	}
	
	@Override
	public boolean isEqual(Node node){
		
		Dragon temp = (Dragon)node;
		if(this.Debt == temp.Debt )
			return true;
			
		return false;
	}
	
	
	
	@Override
	public String toString()
	{
		return "*"+"\nDias: " + this.Days + "\nDeuda: " + this.Debt +"\n";
	}

	@Override
	public boolean isLessThan(Node node) {
		// TODO Auto-generated method stub
		return false;
	}
}