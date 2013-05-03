//	The solutions to Homework 4
//  @class CS212
//	@author mike zappitello
//	@lastUpdate 16 Oct. 2012

import java.util.Scanner;

public class Homework4 {
	/*takes a regular time and converts it into military time
	//@param	String	timeString	the time to be converted
	//@return	int		time		the input time converted to an integer military time
	*/
	static int militaryTime(String timeString){
		int time = 0000;
		int hours = 0;
		int minutes = 0;
		
		String[] times = timeString.split(":|am|pm");
		
		minutes = Integer.parseInt(times[1]);
		hours = Integer.parseInt(times[0]);
		
		if(timeString.endsWith("pm")){
			hours += 12;
		}

		time = hours*100+minutes;
		return time;
	}
	
	/*takes a temp in F and returns the equivilent temp in C
	//@param	String	fTemp		the temp in F
	//@return	double	cTemp		the temp in C
	*/
	static double fahrenheitToCelcius(String fTemp){
		int tempF = Integer.parseInt(fTemp);
		double tempC = (tempF-32)/1.8;
		return tempC;
	}
	
	/*takes a string of integers representing the number and types of coins
	//@param	String	cointStamp	the number of pennies, knickles, dimes, and quarters
	//@return	String	ammount		the total in dollars that the coins are worth
	*/
	static String coinCounting(String coinStamp){
		double ammount = 0;
		String[] coinString = coinStamp.split(" ");
		int[] coinInt = new int[5];
		
		for(int n=0; n<5; n++){
			coinInt[n] = Integer.parseInt(coinString[n]);
		}
		
		ammount = coinInt[0] + coinInt[1]*.25 + coinInt[2]*.1 + coinInt[3]*.05 + coinInt[4]*.01;
		String total = "$" + ammount;
		return total;
	}

	public static void main(String[] args){
		//System.out.println(militaryTime("03:45am"));
		//System.out.println(fahrenheitToCelcius("53"));
		System.out.println(coinCounting("0 3 6 0 19"));
	}
}