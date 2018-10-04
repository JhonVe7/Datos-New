package MonkandPrisionerofAzckaban;
/**
* Data Structure, HarryPotter
*	@author :Camila chacón
*5
5 4 1 3 2
**/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MonkandAzkaban {
		
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
			
		int X = 0;
		int Y = 0;
		
		String Quantity = br.readLine();
		
				
		String Num = br.readLine();
				
		String Nums[] = Num.split(" ");
				
					
		int array[] = new int[Integer.parseInt(Quantity)];
				
					
		for (int i = 0; i < Integer.parseInt(Quantity); i++) {
					
					
			array[i] = Integer.parseInt(Nums[i]);
					
			
		}
					
		for (int n = 0; n < Integer.parseInt(Quantity); n++) {
			
			for (int i = n; i < Integer.parseInt(Quantity); i++) {
						
				if(i+1 == Integer.parseInt(Quantity)) {
					X = -1;
					break;
				}
						
				if(array[i+1] > array[n]) {					
					X = (i+2);
					break;					
				}
				else 
							
					X = -1;			
								
			}
			
			for (int j = n; j>=0; j--) {
						
				if(j-1 == -1) {
					Y = -1;
					break;
				}
				
				if(array[j-1] > array[n]) {
							
					Y = (j);
								
					break;
							
				}
				else 
					
					Y = -1;		
						
			}
					
			int Total = (X)+(Y);
						
			System.out.println(Total);
					
			X=0;
			Y=0;
					
		}
			
	}
		
		
}