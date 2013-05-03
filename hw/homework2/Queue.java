//
//  CS 212 Homework 2
//  
//	mike zappitello


import java.util.Scanner;

public class Queue{
	private int length = 0;
	private int front = 0;
	private int[] theQueue = new int[100];
	
	public boolean isEmpty(){
		if(length == 0){
			return true;
		}
		else{
			return false;
		}
	}//end isEmpty
	
	public int peak(){
		if(isEmpty()){
			throw new IllegalStateException("The Queue is Empty");
		}
		else{
			return theQueue[front];
		}
	}//end peak
	
	public int pop(){		
		if(isEmpty()){
			throw new IllegalStateException("The Queue is Empty");
		}
		else{
			int temp = theQueue[front];
			front = (front+1)%100;
			length--;
			return temp;
		}
	}//end pop
	
	public void push(int i){
		theQueue[front+length] = i;
		length++;
	}//end push
	
	public int size(){
		return length;
	}//end size
	
	
	public static void main(String[] args){
	}
}
