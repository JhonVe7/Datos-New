package PublicParkingProyect;
import List.Node;

public class Clients implements Node {
	
	//Data Structure Node Client
	String Name = null;
	String Vehicle = null;
	String Placa = null;
	String HoraIn = null;
	String HoraOut = null;
	int bill = 0;
	
	Clients next = null;
	
	public Clients(String placa){
		
		this.Placa = placa;
	}
	
	public Clients(String name, String vehicle, String placa, String horaIn ){
	
		this.Name = name;
		this.Vehicle = vehicle;
		this.Placa = placa;
		this.HoraIn = horaIn;	
	}
	
	public Clients(String name, String vehicle, String placa, String horaIn, String horaOut, int pay){
	
		this.Name = name;
		this.Vehicle = vehicle;
		this.Placa = placa;
		this.HoraIn = horaIn;
		this.HoraOut = horaOut;
		this.bill = pay;
	}
	
	@Override
	public void setNext(Node node){
		
		next = (Clients)node; 
	}
	
	@Override
	public Node getNext(){
		
		return next;
	}
	
	@Override
	public Node clone(){
		
		Clients clone = new Clients(Name, Vehicle, Placa, HoraIn, HoraOut, bill);
		return clone;
	}
	
	@Override
	public boolean isEqual(Node node){
		
		Clients temp = (Clients)node;
		if(this.Placa.equals( temp.Placa ))
			return true;
			
		return false;
	}
	
	
	
	@Override
	public String toString()
	{
		return "*"+"\nNombre: " + this.Name + "\nVehiculo: " + this.Vehicle 
				+ "\nPlaca: " + this.Placa + "\nHora de Ingreso: "+ this.HoraIn +"\n";
	}

	@Override
	public boolean isLessThan(Node node) {
		// TODO Auto-generated method stub
		return false;
	}
}