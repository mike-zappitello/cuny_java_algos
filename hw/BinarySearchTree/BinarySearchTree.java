//assignment to use a binary search tree
//
//@lastUpdate : 6 december 2012
//@author: mike Zappitello

import java.util.Scanner;

public class BinarySearchTree{ 
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(){
			//empty
		}
		public Node(int val){
			value = val;
		}
	}
	public static class BST{
		private Node root;
		
		//constructors
		public BST(){
			//empty
		}
		public BST(Node rt){
			root = rt;
		}
		public BST(int val){
			root = new Node(val);
		}
	
		//insert a new int into the tree
		private void insert(int val, Node start){
			Node placeMe = new Node(val);
			if(val<start.value){
				if(start.left == null){
					start.left=placeMe;
				}
				else{
					insert(val, start.left);
				}
			}
			else{
				if(start.right==null){
					start.right=placeMe;
				}
				else{
					insert(val, start.right);
				}
			}
			return;
		}
		public void insert(int val){
			insert(val, root);
		}
	
		//returns true if a value is in the tree
		private boolean contains(int value, Node start){
			if(value<start.value){
				if(start.left==null){return false;}
				if(value==start.left.value){return true;}
				return contains(value, start.left);
			}
			if(start.right==null){return false;}
			if(value==start.right.value){return true;}
			return contains(value, start.right);
		}
		public boolean contains(int value){
			return contains(value, root);
		}
	
		//returns the height of the tree
		private int getHeight(Node start){
			if(start.right==null && start.left==null){
				return 1;
			}
			else if(start.right==null){
				return 1 + getHeight(start.left);
			}
			else if(start.left==null){
				return 1 + getHeight(start.right);
			}
			
			int right = getHeight(start.right);
			int left = getHeight(start.left);
			
			if(right>left){
				return 1 + right;
			}
			return 1 + left;
		}
		public int getHeight(){
			return getHeight(root);
		}
	
		//returns the minimum valueof the tree
		private int getMinimum(Node start){
			if(start.left==null){
				return start.value;
			}
			return getMinimum(start.left);
		}
		public int getMinimum(){
			return getMinimum(root);
		}
	
		//prints out all of the elements of the tree
		private void preorderTraversal(Node start){
			System.out.println(start.value);
		
			if(start.left!=null){
				preorderTraversal(start.left);
			}
			if(start.right!=null){
				preorderTraversal(start.right);
			}
		}
		public void preorderTraversal(){
			preorderTraversal(root);
		}
	}
	public static void main(String[] args){
		System.out.println("HEYA!");
		
		BST tree = new BST(8);
		tree.insert(12);
		tree.insert(9);
		tree.insert(4);
		tree.insert(7);
		tree.insert(2);
		tree.insert(15);
		tree.insert(1);
		tree.insert(-2);
		
		tree.preorderTraversal();
		
		System.out.println(tree.contains(-5));
		System.out.println(tree.getHeight());
	}
}


