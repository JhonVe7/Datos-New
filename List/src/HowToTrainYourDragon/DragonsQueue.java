package HowToTrainYourDragon;
import List.*;

import java.beans.beancontext.BeanContext;
import java.io.*;

public class DragonsQueue {

	
	public static Queue Dragons = new Queue();
	
	
	static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
	static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
	

	
	// Method that insert a new Dragon.
	public static void insert_Dragon(int Days, int Debt)
	{
		//Int Days, int Debt;
		try{		
	 		String input = br.readLine();
			while(!input.equals("")){
	 			bw.write("error: values invalid");
	 			bw.flush();
	 		}
	 		while(Days >= 1 && Debt <= 1000) {
	 			Dragons.enqueue(new Dragon(Days,Debt) );
	 		}
		}
		catch(Exception ex) {}
	}
	
	
	
	// Method that made a trainig a dragon.

	public static void Trainig()
	{
		
	/*	try {			
		While(Dragons.isEmpty == false){
			
			Dragon.IndexOf(0) = 
		}
		catch(Exception ex) {}	
	*/
	}
	
	
	
	public static void main(String[] args) {
		int Days = 0 ;
		int Debt = 0 ;
		
		try{
		Days = Integer.parseInt( br.readLine());
		bw.write("\t");
		bw.flush();
		Debt = Integer.parseInt(br.readLine());
		bw.write("\n");
		bw.flush();
		insert_Dragon(Days, Debt);
		
		}catch(Exception ex) {}
		
	}


	
}