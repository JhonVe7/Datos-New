/* 5
E 1 1
E 2 1
E 1 2
D
D */
package LittleMonkandGobletofFire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MonkGobletofFire {
	
	static String string = "";
	
	public Node head = null; //Empty list
	
	public boolean isEmpty() {//Check if is empty
		
		return head == null ? true : false;
		
	}//end method
	
	public void enqueue(Node newNode){//Insert at begin of the Queue

		if(isEmpty()) {
			
			head = newNode;	
			
		}else{
			
		Node temp = head;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNode;	
	}
		
}//end method
	
	public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node temp = head;
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}//end method
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		MonkGobletofFire Monk = new MonkGobletofFire();
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int acciones = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < acciones; i++) {

			String string = br.readLine();
			String Final[] = string.split(" ");
			
		if(Final[0].equals("E")) {
			
			if(Monk.isEmpty()) {
				
				Monk.enqueue(new Node(Integer.parseInt(Final[1]) , Integer.parseInt(Final[2])));
				
			}else{
				
				Node temp = Monk.head;
				Node pre = Monk.head;
				
				while(temp!=null) {
					
					if(Integer.parseInt(Final[1])<temp.escuela) {
						
						break;
						
					}else
						
						pre = temp;
						temp = temp.next;
					
				}
				
				pre.next = new Node(Integer.parseInt(Final[1]) , Integer.parseInt(Final[2]));
				pre.next.next = temp;
				
				
				
			}
		
		}else if(Final[0].equals("D")){
			
			Node temp = Monk.head;
			Monk.head = Monk.head.next;
			string = temp.toString();
			System.out.println(string);
			System.gc();
			
		}
		
	}		
}
}