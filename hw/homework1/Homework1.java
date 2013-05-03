// This is the sollution for Homework 1 in CS212
//  
//	@author Mike Zappitello
// 

import java.util.Scanner;

public class Homework1{

	public static class MyStack{
		private int topOfStack = -1;
		private int length;
		private char [] array;
		
		public MyStack(int size){
			if(size < 1){
				System.out.println("The size of the stack must be greater than 0.");
			}
			else{
				array = new char[size];
				length = size;
			}
		}
		
		/*Insert a new item into the stack
		**@param x: the item to insert*/
		public void push(char x){
			if(isFull()){return;}
			topOfStack++;
			array[topOfStack] = x;
		}
		
		/*Remove the most recently inserted item from the stack*/
		public void pop(){
			if(isEmpty()){return;}
			topOfStack--;
		}
		
		/*Get the most recently inserted item in the stack
		**Does not alter the stack
		**@return the most recently inserted item in the stack*/
		public char top(){
			if(isEmpty()){return 0;}
			
			return array[topOfStack];
		}
		
		/*Return and remove the most recently inserted item from the stack
		**@return the most recently inserted item in the stack*/
		public char topAndPop(){
			if(isEmpty()){return 0;}
			
			char top = array[topOfStack];
			topOfStack--;
			return top;
		}
		
		/*Test if the stack is logically empty.
		**@return true if empty, false otherwise*/
		public boolean isEmpty(){
			if(topOfStack==-1){
				return true;
			}
			return false;
		}
		
		/*Test if the stack is logically full.
		**@return true if full, false otherwise*/
		public boolean isFull(){
			if(topOfStack>length-2){
				return true;
			}
			return false;
		}
		
		/*Make the stack logically empty.*/
		public void makeEmpty(){
			topOfStack = -1;
		}
		

		
		public boolean isValid(String s){
			int length = s.length();
			
			for(int n=0; n<length; n++){						//goes through the string
				if(isBracket(s.charAt(n))){						//if a char is a bracket, we have stuff to do					
					if(isCorresponding(top(), s.charAt(n))){	//if the next braket is corresponding, pop off the top of the stack
						pop();
					}
					else{
						push(s.charAt(n));						//else, push the char down in the stack
					}
				}
			}
			System.out.println(topOfStack);

			if(isEmpty()){return true;}							//if the stack is empty, our brakets cancled out
			else{return false;}									//if not, then they didn't
		}
		
	}
	
	public static boolean isCorresponding(char o, char c){
		if(o == '(' && c == ')'){return true;}
		else if(o == '{' && c == '}'){return true;}
		else if(o == '[' && c == ']'){return true;}
		else{return false;}
	}
	
	public static boolean isBracket(char a){
		if(a == '('){return true;}
		else if(a == '['){return true;}
		else if(a == '{'){return true;}
		else if(a == ')'){return true;}
		else if(a == '}'){return true;}
		else if(a == ']'){return true;}
		else{return false;}
	}

	public static void main(String[] args){
		MyStack stack1 = new MyStack(10);
		/*stack1.push(8);
		stack1.push(9);
		stack1.push(12);
		stack1.push(9);
		stack1.push(12);
		stack1.push(32);
		stack1.makeEmpty();
		stack1.push(45);
		stack1.push(123);
		//System.out.println(stack1.topAndPop());
		//System.out.println(stack1.top());
		//System.out.println("hello");*/
		
		String s = ")3(+9))";
		
		boolean test = stack1.isValid(s);
				
		System.out.println(test);
	}
}
