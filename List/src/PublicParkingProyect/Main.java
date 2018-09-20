package PublicParkingProyect;
import List.*;
import ListProject.Student;

import java.io.*;

public class Main {

	public static List clients = new List();
	
	static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
	static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	
	// Menu principal - String 
	public static String menu()
	{
		String menu = "*************************************************"
				+"\nBienvenido al software de aparcamientos publicos.\n  Seleccione alguna"
				+ " de las siguientes opciones:\n\n1) Ingreso del cliente"
				+ "\n2) Salida del cliente\n3) Asignar cupo\n4) Lista de Clientes"
				+ "\n5) Salir del programa\n";
		return menu;
	}
	
	
	// Method that insert a new client.
	public static void insert_Client()
	{
		//String name, String vehiculo , String placa, int HoraIn. 
		try{
			
			bw.write("A continuacion diligencie la informacion del cliente.\nNombre: ");
			bw.flush();
			String name = br.readLine();
			
			bw.write("Marca del Vehiculo: ");
			bw.flush();
			String vehiculo = br.readLine();
			
			bw.write("placa: ");
			bw.flush();
			String placa = br.readLine();
			
			bw.write("Hora de ingreso: ");
			bw.flush();
			String HoraIn = br.readLine();
			
			
			
			clients.insertAtBegin(new Clients(name, vehiculo, placa, HoraIn) );
		}
		catch(Exception ex) {}
	}
	
	
	// Method that delete a client.

	public static void exit_Client()
	{
		try 
		{
			bw.write("A continuacion digite la placa del cliente para su salida.");
			bw.flush();
			String placa = br.readLine();
			
			int index = clients.indexOf(new Clients(placa));
			
			if(index != -1)
			{
				bw.write("Hora de salida: ");
				bw.flush();
				String HoraOut = br.readLine();
				
				bw.write("Total a pagar: ");
				bw.flush();
				
				clients.deleteAtIndex(index);
				bw.write("El cliente de placas " + placa + " ha salido.\n");
			}
			else
			{
				bw.write("La placa ingresada no existe.\n");
			}
			
			bw.flush();
		}
		catch(Exception ex) {}
		
	}
	
	
	public static void get_Client() {
		try {
		
		clients.printList();
			
		} catch (Exception e) {}
	}
	
	
	public static void assign_place(String placa) {
		
		try {
			//ingresa placa del nuevo cliente
			
				Node temp = Node.Head;
				// 20 es el total de cupos
				
				for (int i = 0; i < 20; i++){
					
					temp = temp.getNext();
					
					if(temp.getNext()== null && i != 20) {
						bw.write("\n El vehiculo de placas "+placa 
								+" se aparcará en la "+i+"° posición.");
						bw.flush();
					}else {
						if(temp.getNext()== null && i == 20) {
							bw.write("\nNo hay cupos disponibles.");
							bw.flush();
						}
					}
				}
				
			
		} catch (Exception e) {}
	}
	

	
	public static void main(String[] args) {
		
		int menu_option;
		
		try{	
			do{
				
				bw.write( menu() );
				bw.flush();
				
				menu_option = Integer.parseInt( br.readLine() );
				
				while(menu_option > 5){
					bw.write("Por favor, seleccione una opcion valida.\n");
					bw.flush();
					menu_option = Integer.parseInt( br.readLine() );
				}
				
				switch(menu_option){
				
					case 1:
						insert_Client();
					break;
					case 2:
						exit_Client();
					break;
					case 3:
						String placa = null;
						assign_place( placa);
					break;
					case 4:
						get_Client();
					break;
					case 5:
					break;
				}
			}
			while(menu_option != 5);
		}
		catch(Exception ex) {}
		
	}


	
}