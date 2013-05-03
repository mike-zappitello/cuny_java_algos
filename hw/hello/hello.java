//
//  hello.java
//  
//
//  Created by mzappitello on 9/27/12.
//  just a little bit to fuck around in
//


/*THINGS TO DO
**get rid of the append method
**change the insert method so that it places the new node in the correct spot
**implement an insertion and selection sort
*/

import java.util.Scanner;

public class hello {
	//the Node class
	public static class Node{
		private int data;				//the first component is an integer
		private Node next;				//the second component is the next node

		public Node(int i){				//constructor using only the int value
			data = i;
		}	
		
		public Node(){ }
	
		public int getData(){			//accesor to print out the int
			return data;
		}

		public Node getNext(){			//accesor returns next node
			return next;
		}

		public void setNext(Node n){	//mutator, changes next node
			next = n;
		}
	}//end Node
	
	//the LinkedList class
	public static class LinkedList{
		private Node head;				//the head is the first number in the linked list
		private int count = 0;			//the number of nodes in the linked list
		private Node tail;				//points to the last node in the linked list
	
		public LinkedList(){			//empty constructor class
		}//end LinkedList()

		public LinkedList(Node n){		//constructs a linked list from a single node
			head = n;
			count =1;
			tail = head;
		}//end LinkedList(Node n)

		public LinkedList(int i){		//creates a linked list with the first node using the value i
			head = new Node(i);			//creates the first node in the linked list
			count = 1;
			tail = head;
		}//end LinkedList(int i)

		public void printAll(){			//prints out all of the values in the linked list
			Node current = head;
			for(int n = 0; n<count; n++){
				System.out.println(current.getData());
				current = current.getNext();
			}//end for loop
		}//end printAll

		public void append(int i){
			tail.setNext(new Node(i));		//adds value to the end of the list
			tail = tail.getNext();			//updates the tail node
			count ++;						//updates the count
		}//end append
		
		public void insert(int newInt){
			Node newNode = new Node(newInt);
			
			Node current = head;
			Node previous = head;
			System.out.println(current.getData());
			
			while(newInt>current.getData() && current.getNext()!=null){
				System.out.println(previous.getData());
				previous = current;
				current = current.getNext();
			}
			
			if(previous==null){
				newNode.setNext(head);
				head = newNode;
			}
			else if(current.getNext()!=null){
				previous.setNext(newNode);
				newNode.setNext(current);
			}
			else{
				previous.setNext(newNode);
				tail = newNode;
			}
			
			count++;
		}//end insert
		
		/*public void replace(int old, int newInt){
			Node current = head;
		
			for(int n=0; n<count; n++){
				if(current.getData() == old){
					current.setData(newInt);
					break;
				}
			}	
			
		}*/

		public void delete(int i){
			Node current = head;
			Node previous = head;

			while(current != null){
				if(current.data == i){								//not technically cool in java to compare strings, but just an example.
					if(current == head){
						head = head.getNext();
					}//end if
					else if(current == tail){
						previous.setNext(current.getNext());
						tail = previous;
					}//end else if
					else{
						previous.setNext(current.getNext());		//sets the previous nodes next as the current nodes next, effectively deleting
					}//end else
					count --;
					break;
				}//end if
				else{
					previous = current;
					current = current.getNext();
				}//end else
			}//end while
		}//end delete
	}//end LinkedList
	
	public static void main(String[] args){
		System.out.println("Heya!");
		
		LinkedList tester = new LinkedList(8);
		tester.insert(9);
		tester.insert(11);
		//tester.append(12);
		//tester.append(13);
		//tester.insert(100);
		//tester.delete(10);
		tester.printAll();
	}//end main
}
