//
//Assignment to impliment quicksort
//
//@lastUpdate : 27 november 20012
//@author : mike zappitello
//
import java.util.Scanner;

public class quicksort {
	public static int[] sort(int[] array, int size)
	{	
		if(size <= 1){
			return array;
		}
		else{
			int pivot = array[0];
			int[] less = new int[size-1];
			int lessCount = 0;
			int[] greater = new int[size-1];
			int greaterCount = 0;
						
			for(int n=1; n<size; n++){
				System.out.println(array[n]);
				
				if(array[n]<pivot){
					less[lessCount] = array[n];
					lessCount++;
				}
				else{
					greater[greaterCount] = array[n];
					greaterCount++;
				}
			}
			
			return concatinate(sort(less, lessCount), pivot, sort(greater, greaterCount), lessCount, greaterCount);
		}
	}
	
	public static int[] concatinate(int[] less, int pivot, int[] greater, int lessSize, int greaterSize){
		int[] sortedArray = new int[lessSize+greaterSize+1];
		int place = 0;

		
		for(int c=0; c<lessSize; c++){
			sortedArray[place] = less[c];
			place++;
		}

		sortedArray[place] = pivot;
		place++;
		System.out.println(pivot);

		for(int c=0; c<greaterSize; c++){
			sortedArray[place] = greater[c];
			place++;
		}
		
		return sortedArray;
	}

	public static int[] mergeSort(int[] array, int size){
		return array;
	}

	public static int[] merge(int[] array1, int[] array2, int size1, int size2){
		int[] mergedArray = new int[size1+size2];
		int count1 = 0;
		int count2 = 0;		

		for(int p=0; p<size1+size2; p++){
			if(count1 == size1-1){
				mergedArray[p] = array2[count2];
			}
			else if(count2 == size2-1){
				mergedArray[p] = array1[count1];
			}
			else{
				if(array1[count1]<array2[count2]){
					mergedArray[p] = array1[count1];
					count1++;
				}
				else{
					mergedArray[p] = array2[count2];
					count2++;
				}
			}
		}

		return mergedArray;
	}

	public static void main(String[] args){
		System.out.println("heya");
		int[] theArray = {2, 3, 4, -1, 15, -243, 8};
		theArray = sort(theArray, theArray.length);
		
		System.out.println("***THE SORTED ARRAY***");
		
		for(int m=0; m<theArray.length; m++){
			System.out.println(theArray[m]);
		}
	}
}
