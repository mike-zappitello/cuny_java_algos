/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Exercises;

import java.util.Scanner;

/**
 * this file contains the solutions to exercises in cs212
 * @author mike zappitello
 */
public class Exercises{
    
    /*This is the beginning of exercise 1*/
    
    /*This function prints out all even integes between 1 and 100*/
    static void printOneOneHundredEven(){
        System.out.printf("The even numbers of the set {1 - 100} are"+"\n");
        for(int n = 1; n < 101; n++){
            if(n%2==0){
            System.out.println(n);
            }
        }
    }
    
    /*This function prints out the sum of the multiples of 2 & 7 < 1000*/
    static void multiplesOfTwoAndSeven(){
        int sum = 0;
        for(int n = 1; n < 1001; n++){
            if(n%2==0){
                sum += n;
            }
            else if(n%7==0){
                sum += n;
            }
        }
        System.out.println("The sum of all the multiples of 2 and 7 below 1000 is " + sum);
    }
    
    /*This function scans the console for an integer and then prints out weather or not it is a leap year*/
    static void isLeapYear(){
        System.out.println("Please enter a year."); 
        
        int year;
        Scanner in = new Scanner(System.in);
        year = in.nextInt();
        in.close();
        
        System.out.printf("The year " + year + " ");
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    System.out.println("is a leap year.");
                }
                else{
                    System.out.println("is not a leap year.");
                }
            }
            else{
                System.out.println("is a leap year");
            }
        }
        else{
            System.out.println("is not a leap year");
        }
    }
    
    /*This function prints out the first 30 Fibonacci Numbers*/
    static void fibSeries(){
        System.out.println("The first 30 Fibonacci Numbers are");
        int j = 0;
        int k = 1;
        int oldK = 1;
        System.out.println(j + "\n" + k);

        for(int n = 0; n < 28; n++){
          k += j;
          j = oldK;
          oldK = k;
          System.out.println(k);
        }
    }
    
    /*This is the beginning of exercise 2*/
    
    /*The minE function takes an integer array and returns its second smallest element*/
    static int minE(int[] arr){
        int min;
        int twoMin;
        if(arr[0]>arr[1]){
            min = arr[0];
            twoMin = arr[1];
        }
        else{
            min = arr[1];
            twoMin = arr[0];          
        }
        for(int n=0; n<arr.length; n++){
            if(min>arr[n]){
                twoMin = min;
                min = arr[n];
            }
            else if(twoMin>arr[n]){
                twoMin = arr[n];
            }
        }
        return twoMin;
    }
    
    /*The rev function takes an integer array and returns an array with the same elements in reversed order*/
    static int[] rev(int[] arr){
        int[] revArr = new int[arr.length];
        for(int n=0; n<arr.length; n++){
            revArr[n] = arr[arr.length-n-1];
        }
        return revArr;
    }
    
    /*The isDistinct function takes an array and returns true iff each elemnt of the array is unique*/
    static boolean isDistinct(int[] arr){
        for(int n=0; n<arr.length; n++){
            for(int m=n+1; m<arr.length; m++){
                if(arr[m]==arr[n]){
                    return false;
                }
            }
        }
        return true;
    }
    
    /*This is the begining of exercise 3*/
    
    /*The swapHalfArray takes an array and swaps the first half of the array with the second half of the array*/
    static void swapHalfArray(double[] a){
        int length = a.length;
        double[] newA = new double[length];
        boolean isEven = (length%2 == 0);
        double temp;
        double[] newFirst = new double[length/2];
        double[] newLast = new double[length/2];
        
        if(isEven){
            for(int n = 0; n<length/2; n++){
                temp = a[n];
                a[n] = a[length/2+n];
                a[length/2+n] = temp;
            }
        }
        else{
            for(int n = 0; n < length/2; n++){
                temp = a[n];
                a[n] = a[length/2+1+n];
                a[length/2+1+n] = temp;
            }
        }
        for(int n = 0; n<length; n++){
            System.out.println(a[n]);
        }
            
    }
    
    /*The isSubsequence function takes two arrays, a and b, and returns true iff b is a subsequence of a*/
    static boolean isSubsequence(double[] a, double[] b){
        int lengthA = a.length;
        int lengthB = b.length;
        int counter = 0;
        
        for(int n = 0; n < lengthA; n++){
            if(b[counter] == a[n]){
                //System.out.println("abby");
                counter += 1;
            }
            if(counter == lengthB){
                return true;
            }
        }
        return false;
        
    }
    
    /*The oddAndEvenSwap takes two arrays, a and b, and swaps all of the even elements of a with b's and all of b's elements with a*/
    static void oddAndEvenSwap(double[] a, double[] b){
        if(a.length != b.length)
        {
            System.out.println("The Arrays are not of even Size");
            return;
        }
        
        double tempA; 
        double tempB;
        
        for(int n = 0; n<a.length; n++){
            tempA = a[n];
            tempB = b[n];
            if(n%2==0){
                b[n] = tempA;
            }
            else{
                a[n] = tempB;
            }
        }
    }
    
    /*This is the begining of exercise OO 3 (the one with the car class */
    
    /*The car class has three private fields; price, name, and max speed*/
    public static class Car{
        private double price;
        private String name;
        private int maxSpeed;
        
        public double getPrice(){
            return price;
        }
        
        public void setPrice(double newPrice){
            if(newPrice > 0.00){
                price = newPrice;
            }
			else{
				System.out.println("The price must be a positive number");
			}
        }
        
        public String getName(){
            return name;
        }
        
        public void setName(String newName){
            name = newName;
        }
        
        public int getMaxSpeed(){
            return maxSpeed;
        }
        
        public void setMaxSpeed(int newMaxSpeed){
            maxSpeed = newMaxSpeed;
        }
    }
    
    public static class CarPool {
        private Car[] garage = new Car[10];     //an array of 10 cars stored in the garage
        private int carCnt = 0;
        
        public void park(Car c){
            garage[carCnt] = c;
            carCnt++;
        }
        
        public void listParkedCars(){
            for(int i=0; i<carCnt; i++){
                System.out.printf("Car ");
                System.out.print(i+1);
                System.out.printf(" is ");
                System.out.printf(garage[i].name);
                System.out.println(".");
            }
            System.out.printf("\n");
        }
        
        public double carPoolValue(){
            double sum = 0;
            for(int i=0; i<carCnt; i++){
                sum += garage[i].price;
            }
            return sum;
        }
        
    }
    
    /*This is the begining of exercise 4 on simple sorting algorithms*/
    static int[] selectionSort(int[] a){
        int minLocation;
        int temp;
        
        for(int i=0; i<a.length-1; i++){
            minLocation=i;
            for(int j=i+1; j<a.length; j++){
                if(a[minLocation]>a[j]){
                    minLocation=j;
                }
            }
            if(minLocation != i){
                temp = a[minLocation];
                a[minLocation] = a[i];
                a[i] = temp;
            }
        }
        
        return a; 
    }
    
    static void insertionSort(int[] a){
        int temp;
        int iTemp;
        
		for(int i=1; i<a.length; i++){
			for(int j=i; j>0; j--){
				if(a[j]<a[j-1]){
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
				else{break;}					//breaks the for loop once the int is in the right spot
			}
		}
    }
    
    static int[] bubbleSort(int[] a){
        int temp;
 
		boolean bubble = true;
		
		while(bubble){
			bubble = false;
			
			for(int i=0; i<a.length-1; i++){
				if(a[i]>a[i+1]){
					bubble = true;
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		return a;
    }
	
	/*The rectangle class has two private fields, height and width.*/
	public static class Rectangle{
		private int width;
		private int height;
		
		public Rectangle(int newHeight, int newWidth){
			if(newHeight<0){newHeight = -newHeight;}
			if(newWidth<0){newWidth = -newWidth;}
			
			height = newHeight;
			width = newWidth;
		}
		
		public int getWidth(){
			return width;
		}
		
		public int getHeight(){
			return height;
		}
		
		public void setHeight(int newHeight){
			if(newHeight<0){newHeight = -newHeight;}
			height = newHeight;
		}
		
		public void setWidth(int newWidth){
			if(newWidth<0){newWidth = -newWidth;}
			width = newWidth;
		}
		
		public int getPerimeter(){
			return 2*height+2*width;
		}
		
		public int getArea(){
			return width*height;
		}
	}
        
	public static class Rational{
            private int num;
            private int denom;
            
            public Rational(){
                
            }
            
            public Rational(int newNum, int newDenom){
                num = newNum;
                denom = newDenom;
            }
            
            public Rational add(Rational r){
                Rational sum = new Rational();
                
                sum.denom = lcm(denom, r.denom);
                sum.num = num*lcm(denom, r.denom)/denom+r.num*lcm(denom, r.denom)/r.denom;
                
                return sum.reduce();
            }
            
            public Rational subtract(Rational r){
                Rational difference = new Rational();
                
                difference.denom = lcm(denom, r.denom);
                difference.num = num*lcm(denom, r.denom)/denom - r.denom*lcm(denom, r.denom)/r.denom;
                
                return difference.reduce();
            }
            
            public Rational multiply(Rational r){
                Rational product = new Rational();
                product.num = num*r.num;
                product.denom = denom*r.denom;
                return product.reduce();
            }
            
            public Rational divide(Rational r){
                Rational quotent = new Rational();
                quotent.num = num*r.denom;
                quotent.denom = denom*r.num;
                return quotent.reduce();
            }
            
            public Rational reduce(){
                Rational reduced = new Rational();
                int gcd = gcd(num, denom);
                reduced.num = num/gcd;
                reduced.denom = denom/gcd;
                return reduced;
            }
        }
    
	static int gcd(int a, int b){
        int temp;
        while(a!=0){
            temp = a;
            a=b%a;
            b=temp;
        }
        return b;
    }
    
    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
    
    public static void main(String[] args) {        
        int[] array1 = {12,5,6,7,6,5,39,20,38,5};
        insertionSort(array1);
    
        for(int n=0; n<array1.length; n++){
            System.out.println(array1[n]);
        }
        
        /*Rational r1 = new Rational(1,2);
        Rational r2 = new Rational(1,2);
        
        System.out.println(r1.subtract(r2).num);*/
    }
    
}
