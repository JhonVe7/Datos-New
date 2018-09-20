package List;
import java.io.*;

/*
# Lists based on Pointers.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Lists based on Pointers
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class List {

	public Node head = null;
	
	
	public List() {}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	
	/**
	 * 
	 */
	public void printList()
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		Node temp = head;
		
		try
		{
			while(temp != null)
			{
				bw.write(temp.toString());
				temp = temp.getNext();
			}
			bw.flush();
		}
		catch(Exception ex) { ex.printStackTrace(); }
	}
	
	
	/**
	 * 
	 * @param newNode
	 */
	public void insertAtBegin(Node newNode)
	{
		newNode.setNext(head);
		head = newNode;
	}
	
	
	/**
	 * 
	 * @param newNode
	 */
	public void insertAtEnd(Node newNode)
	{
		Node temp = head;
		
		while (temp.getNext() != null) 
			temp = temp.getNext();
		
		temp.setNext(newNode);
	}
	
	
	/**
	 * 
	 * @param newNode
	 * @param index
	 */
	public void insertAtIndex(Node newNode, int index)
	{
		Node temp = head;
		
		for (int i = 0; i < index - 1; i++)
			temp = temp.getNext();
		
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
	}
	
	
	/**
	 * 
	 */
	public void deleteAtBegin()
	{
		Node temp = head;
		head = temp.getNext();
		temp = null;
		System.gc();
	}
	
	
	/**
	 * 
	 */
	public void deleteAtEnd()
	{
		if (!isEmpty()) 
		{
			Node temp = head;
			Node previous = head;
			
			while (temp.getNext() != null) 
			{
				previous = temp;
				temp = temp.getNext();
			}
			
			previous.setNext(null);
			temp = null;
			System.gc();
		}
	}
	
	
	/**
	 * 
	 * @param index
	 */
	public void deleteAtIndex(int index)
	{
		Node temp = head;
		Node toDelete;
		
		for(int i = 0; i < index - 1; i++)
			temp = temp.getNext();
		
		toDelete = temp.getNext(); 
		temp.setNext(toDelete.getNext());
		toDelete = null;
		System.gc();
	}
	
	
	/**
	 * 
	 * @param oldNode
	 * @param newNode
	 */
	public void updateFirst(Node oldNode, Node newNode)
	{
		Node temp = head;
		Node previous = head;
		
		while(temp != null)
		{
			if(temp.isEqual(oldNode))
			{
				newNode.setNext( temp.getNext() );
				previous.setNext(newNode);
				temp = null;
				break;
			}
			
			previous = temp;
			temp = temp.getNext();
		}
	}
	
	
	/**
	 * 
	 * @param oldNode
	 * @param newNode
	 */
	public void updateAll(Node oldNode, Node newNode)
	{
		Node temp = head;
		Node previous = head;
		
		while(temp != null)
		{
			if(temp.isEqual(oldNode))
			{
				newNode.setNext( temp.getNext() );
				previous.setNext(newNode);
				temp = null;
				previous = newNode;
				temp = newNode.getNext();
			}
			else
			{
				previous = temp;
				temp = temp.getNext();
			}
		}
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node linealSearch(Node node)
	{
		Node temp = head;
		Node result = null;
		
		while(temp != null)
			if(temp.isEqual(node))
			{	
				result =  temp;
				break;
			}
			else
				temp = temp.getNext();
			
		return result;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public List searchAll(Node node)
	{
		Node temp = head;
		List results = new List();
		
		while(temp != null)
		{
			if(temp.isEqual(node))
				results.insertAtEnd(temp.clone());
			
			temp = temp.getNext();
		}
		
		return results;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public int binarySearch(Node node)
	{
		head = quickSort(this).head;
		int middle, upper = this.length() - 1, lower = 0;
		
		while (lower < upper) 
		{
			middle = (upper + lower) / 2;
			
			if (this.get(middle).isEqual(node))
				return middle;
			else 
				if (this.get(middle).isLessThan(node)) 
					lower = middle;
				else 
					upper = middle;
		}
		
		if (lower == upper && this.get(lower).isEqual(node)) 
			return lower;
		
		return -1;
	}
	
	
	/**
	 * 
	 */
	public void reverse()
	{
		Stack tempStack = new Stack();
		Node temp = head;
		
		while(temp != null)
		{
			tempStack.push(temp.clone());
			temp = temp.getNext();
		}
		
		head = tempStack.top;
	}
	
	
	/**
	 * 
	 * @param unsorted
	 * @return
	 */
	public List quickSort(List unsorted)
	{
		if(unsorted.length() < 1)
		{
			return unsorted;	
		}
		else
		{
			Node pivot = unsorted.head;
			Node temp = pivot.getNext();
			
			List less_elements = new List();
			List greater_elements = new List();
			
			while(temp != null)
			{
				if(temp.isLessThan(pivot))
					less_elements.insertAtEnd(temp.clone());
				else
					greater_elements.insertAtEnd(temp.clone());
				
				temp = temp.getNext();
			}
			
			pivot.setNext(null);
			less_elements = quickSort(less_elements);
			less_elements.insertAtEnd(pivot);
			less_elements.insertAtEnd( quickSort(greater_elements).head );
			
			return less_elements;
		}
	}
	
	
	public List sublist(int begin)
	{
		List subList = new List();
		
		if(begin < this.length())
		{
			Node temp = head;
			
			for(int i = 0; i < begin; i++)
				temp = temp.getNext();
			
			while(temp != null)
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.getNext();
			}
		}
		
		return subList;
	}
	
	
	/**
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public List sublist(int begin, int end)
	{
		List subList = new List();
		
		if (begin < this.length() && end < this.length()) 
		{
			Node temp = head;
			int i;
			
			for (i = 0; i < begin; i++) 
				temp = temp.getNext();
			
			while (temp != null && i < end) 
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.getNext();
				i += 1;
			}
		}
		
		return subList;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int length()
	{
		Node temp = head;
		int counter = 0;
		
		while (temp != null) 
		{
			counter += 1;
			temp = temp.getNext();
		}
		
		return counter;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List cloneList()
	{
		List clone = new List();
		
		Node temp = head;
		
		while (temp != null) 
		{
			clone.insertAtEnd(temp.clone());
			temp = temp.getNext();
		}
		
		return clone;
	}
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public boolean isEqual(List list)
	{
		boolean isEqual = true;
		Node tempCurrent = head;
		Node tempList = list.head;
		
		while(tempCurrent != null && tempList != null)
			if(tempCurrent.isEqual(tempList))
			{
				tempCurrent = tempCurrent.getNext();
				tempList = tempList.getNext();
			}
			else
			{
				isEqual = false;
				break;
			}
			
		return isEqual;
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Node get(int index)
	{
		Node response = null;
		
		if (index < this.length())
		{
			response = head;
			
			for (int i = 0; i < index; i++) 
				response = response.getNext();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public int indexOf(Node node)
	{
		int index = -1;
		Node temp = head;
		
		while(temp != null)
		{
			index += 1;
			if(temp.isEqual(node))
				return index;
			
			temp = temp.getNext();
		}
		 
		index = -1;
		return index;
	}
	
	public static void main(String [] args)
	{
		List test = new List();
		
		test.insertAtBegin(new ExampleNode(15));
		test.insertAtBegin(new ExampleNode(10));
		test.insertAtBegin(new ExampleNode(9));
		test.insertAtEnd(new ExampleNode(4));
		test.insertAtEnd(new ExampleNode(5));
		test.insertAtIndex(new ExampleNode(15),3);
		
		test = test.quickSort(test);
		test.printList();
		
		test.deleteAtBegin();
		test.deleteAtEnd();
		test.deleteAtIndex(2);
		
		test.printList();
	}
}