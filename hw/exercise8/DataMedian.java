//
//  DataMedian.java
//  
//
//  Created by mzappitello on 10/23/12.
//  Copyright 2012 __MyCompanyName__. All rights reserved.
//

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataMedian {
	/*readData takes a file of integers and turns them into a list of integers
	//@param	String s - the file location on the computer
	//@return	List lst - the list of integers as a string
	*/
	private static List<Integer> readData(String s) throws java.io.IOException {
		FileReader theFile = new FileReader(s);

		BufferedReader br = new BufferedReader(theFile);		//creates the buffered reader from the file located in s
				
		String text = br.readLine();							//gets the first line of the file
		int number;
		
		List<Integer> list = new ArrayList<Integer>();
		
		while(text!=null){										//goes as long as there is another line
			number = Integer.decode(text);						//converts the string to an int
			list.add(number);									//adds the number to the list
			//System.out.println(number);						//prints out the line
			text = br.readLine();								//moves to the next line
		}
		java.util.Collections.sort(list);						//sorts the list
		return list;											//returns the list
	}

	/*calcMedian takes a list of integers and calculates its median
	//@param:	List<Integer> l	-	the list
	//@return:	median			-	the median of the list
	*/
	public static double calcMedian(List<Integer> l){
		int length = l.size();									//gets length of list
		double median;
		if(length%2==0){										//if even
			double sum = (l.get(length/2-1)+l.get(length/2));	//add the two center ints
			median = sum/2;										//devide them by two
		}
		else{
			median = l.get(length/2+1);							//else return the central int
		}
		return median;											//return the median
	}

	public static void main(String[] args){
		List<Integer> sortedList = new ArrayList<Integer>();	//creates a list
		try{													//tries to read the data
			sortedList = readData("/Users/xrallirokzx3/Desktop/CUNY/2012_Fall/Java/hw/exercise8/testData.txt");
		}
		catch (java.io.IOException e){							//catches an io exception
			System.err.println("Caught IOException: " + e.getMessage());
		}
		System.out.println(calcMedian(sortedList));				//prints out the median of the list
	}
}
