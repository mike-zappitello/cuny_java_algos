//
//  homework5.java
//  
//
//  Created by mzappitello on 11/6/12.
//  Copyright 2012 __MyCompanyName__. All rights reserved.
//

/*
Left to do
-throw exceptions for index out of bounds in push, pop, and topAndPop
-turn in
*/
import java.lang.ArrayIndexOutOfBoundsException;


public class homework5 {
	public static abstract class IsStack{
		protected int length;
	
		//insert a new item into the stack
		//@param x the item to insert
		public abstract void push(int x);
		
		//remove the most recently inserted iterm from the stack
		public abstract void pop();
	
		//return and remove the most recently inserted item from the stack
		//@return the most recently inserted item in the stack
		public abstract int topAndPop();
		
		//test if the stack is logically empty
		//@return true if empty, false otherwise
		public boolean isEmpty(){
			if(length == 0){return true;}
			else{return false;}
		}
		
		//make the stack logically empty
		public abstract void makeEmpty();
	}
	
	public static class Node{
		private int data;
		private Node next;
			
		public Node(){ }
			
		public Node(int i){
			data = i;
		}
		
		public int getData(){
			return data;
		}
		
		public Node getNext(){
			return next;
		}
	
		public void setNext(Node n){
			next = n;
		}
	}
	
	public static class LinkedList{
		private Node head;				//the head is the first number in the linked list
		private int count = 0;			//the number of nodes in the linked list
		private Node tail;				//points to the last node in the linked list
	
		public LinkedList(){			//empty constructor class
			//left blank
		}//end LinkedList

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
		
		public Node getHead(){
			return head;
		}
		
		public int getCount(){
			return count;
		}

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
	
		public void insert(int newInt, int index) throws ArrayIndexOutOfBoundsException{
			try{
				if(index > count || index < 0){
						throw new ArrayIndexOutOfBoundsException(index);
				}
				Node newNode = new Node(newInt);
			
				Node current = head;
				Node previous = head;
				
				for(int n = 0; n < index; n++){
					previous = current;
					current = current.getNext();
				}
			
				if(index == 0){							//insert in front if index = 0
					newNode.setNext(head);
					head = newNode;
				}
				else if(index == count){				//insert at end if index = count
					previous.setNext(newNode);
					tail = newNode;
				}
				else{									//insert at index position
					previous.setNext(newNode);
					newNode.setNext(current);
				}
			
				count++;
			}
			catch(ArrayIndexOutOfBoundsException except){
				System.out.println("The index " + index + " is out of bounds");
			}
		}//end insert
		
		public void remove(int index) throws ArrayIndexOutOfBoundsException{
			try{
				if(index > count-1 || index < 0){
						throw new ArrayIndexOutOfBoundsException(index);
				}
				Node current = head;
				Node previous = head;
			
				for(int n = 0; n < index; n++){
					previous = current;
					current = current.getNext();
				}
			
				if(index == 0){					//index = 0
					head = current.getNext();
				}
				else if(index == count){		//index = count
					tail = previous;
					tail.setNext(null);
				}
				else{							//index anywhere else
					previous.setNext(current.getNext());
				}
			
				count--;
				return;
			}
			catch(ArrayIndexOutOfBoundsException except){
				System.out.println("The index " + index + " is out of bounds");
			}
		}
	}
	
	public static class ListStack extends IsStack{
		private LinkedList stack = new LinkedList();
				
		public ListStack(){
			//left blank
		}
		
		@Override
		public void push(int x){
			stack.insert(x, 0);
			length = stack.getCount();
		}
		
		@Override
		public void pop() throws ArrayIndexOutOfBoundsException{
			try{
				if(length < 1){
					throw new ArrayIndexOutOfBoundsException();
				}
				stack.remove(0);
				length = stack.getCount();
			}
			catch(ArrayIndexOutOfBoundsException except){
				System.out.println("Cannot Pop with an empty stack.");
				System.exit(0);
			}
		}
	
		@Override
		public int topAndPop() throws ArrayIndexOutOfBoundsException{
			try{
				if(length < 1){
					throw new ArrayIndexOutOfBoundsException();
				}
				int top = stack.head.getData();
				stack.remove(0);
				length = stack.getCount();
				return top;
			}
			catch(ArrayIndexOutOfBoundsException except){
				System.out.println("Cannot Pop with an empty stack.");
				System.exit(0);
				return 0;
			}
		}
		
		@Override
		public void makeEmpty(){
			for(int n=0; n<length; n++){
				stack.remove(0);
			}
			length = stack.getCount();
		}
	}
	
	public static class ArrayStack extends IsStack{
		private int [] list;
		
		public ArrayStack(){
			length = 0;
			list = new int[10];
		}
		
		@Override
		public void push(int x) throws ArrayIndexOutOfBoundsException{
			try{
				if(length > 9){
					throw new ArrayIndexOutOfBoundsException();
				}
				list[length] = x;
				length++;
			}
			catch(ArrayIndexOutOfBoundsException except){
				System.out.println("The stack is full.");
				System.exit(0);
			}
		}
	
		@Override
		public void pop() throws ArrayIndexOutOfBoundsException{
			try{
				if(length < 1){
					throw new ArrayIndexOutOfBoundsException();
				}
				length--;
			}
			catch(ArrayIndexOutOfBoundsException except){
				System.out.println("Cannot Pop with an empty Stack");
				System.exit(0);
			}
		}
	
		@Override
		public int topAndPop() throws ArrayIndexOutOfBoundsException{
			try{
				if(length < 1){
					throw new ArrayIndexOutOfBoundsException();
				}
				int top = list[length-1];
				length--;
				return top;
			}
			catch(ArrayIndexOutOfBoundsException except){
				System.out.println("Cannot Pop with an empty Stack.");
				System.exit(0);
				return 0;
			}
		}
		
		@Override
		public void makeEmpty(){
			length = 0;
		}
	}

	public static void main(String[] args){		
		System.out.println("Heya!");
		//IsStack stack1 = new ListStack();
		IsStack stack1 = new ArrayStack();
		stack1.push(8);
		stack1.push(9);
		stack1.push(10);
		stack1.push(12);
		stack1.push(23);
		stack1.push(143);
		stack1.push(4);
		stack1.push(4);
		stack1.push(1);
		stack1.push(23);
		stack1.push(0);
		System.out.println(stack1.topAndPop());
		stack1.makeEmpty();
		stack1.pop();
		stack1.push(12);
		stack1.pop();
		System.out.println(stack1.isEmpty());
		
		
	}

}
