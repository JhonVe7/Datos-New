package HowToTrainYourDragon;
import List.*;
import java.beans.beancontext.BeanContext;
import java.io.*;

public class DragonsQueue {

	
	public static List Dragons = new List();
	
	
	static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
	static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	
	
	
	// Method that made a select a dragon.

	
	public static void main(String[] args) {
		
		int Days = 0 ;
		int Debt = 0 ;
		int dragons = 0;
		String input = "";
		double temp = 0.0; 
		double less = 2.0;
		try{
			
			 while(input != null) {
			
				input = br.readLine();
				String[] cases = input.split(" ");
				Days = Integer.parseInt( cases[0]);
				Debt = Integer.parseInt(cases[1]);
				Dragons.insertAtBegin(new Dragon(Days, Debt));
				 for (int i = 0; i < cases.length; i++) {
					
				}
			 }
			 Dragons.printList();
			
			
				 
				
				
		}catch(Exception ex) {}
		
	}


	
}