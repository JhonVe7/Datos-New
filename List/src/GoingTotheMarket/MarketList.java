package GoingTotheMarket;
import List.*;

import java.io.*;

public class MarketList {
	
	public static List Marketlist = new List();
	
	static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
	static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

	// Method that insert a new article.
	public static void insert_Article(String input){
	
	String name = "";	
	double  cost = 0.0;
	String[] data;
	data= input.split("\t");
	
	// define variables
	name = data[0];
	cost =Integer.parseInt( data[1]);
	
		try{	
			while(!input.equals("")){
	 			bw.write("error: values invalid");
	 			bw.flush();
	 		}
	 			Marketlist.insertAtBegin(new Articulo(name,cost) );		
		}
		catch(Exception ex) {}
	}
	
	public static double return_value() {
	double x = 0.0;
		/*Articulo input = new Articulo(name);	
		Marketlist.linealSearch(input);
	*/	
	return x;
	}
	
	public static void main(String[] args) {
		
		int bills = 0 ;
		int Art = 0 ;
		int cant = 0;
		double cost = 0.0;
		String input;
		
		
		try{	
			bills= Integer.parseInt(br.readLine());
			for (int i = 0; i <= bills; i++) {
				
				Art = Integer.parseInt(br.readLine());

				for (int j = 0; j <= Art; j++) {
					input = br.readLine();	
					insert_Article(input);
				}
				for (int j = 0; j < Art; j++) {
					cant = Integer.parseInt(br.readLine());
					cost = cant*return_value();
					
				}
			}
			
		
		
		}catch(Exception ex) {}
		
	}


	
}