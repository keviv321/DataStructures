package HackerRank;
import java.io.*;
import java.util.*;
/*import java.text.*;
import java.math.*;
import java.util.regex.*;*/

public class Revised_russian_roulette {
	

	
	    private static int[] revisedRussianRoulette(/*int[] doors,*/ ArrayList<Integer> arr) {
	        // Complete this function
	    	int index , count = 0 , count1 = 0;
	    	int array[] = new int[2];
	    	ArrayList <Integer> arr1 = new ArrayList<Integer>();
	    	arr1.addAll(arr);
	    	count1 = countOccurences(arr1);
	    	Integer i = 1;
	    	while (!arr.isEmpty())
	    	{	
	    		index = arr.indexOf(1);//count1++;
	    		if (index!=-1)
	    		{
	    			if (arr.get(index+1)==i)
	    				arr.remove(i);//System.out.println("x");}
	    			arr.remove(i);
	    			count++;
	    		}
	    		else
	    			break;
	    	}
	    	array[0] = count;
	    	array[1] = count1;
	    	return array;
	    	
	    }

	    private static int countOccurences(ArrayList<Integer> arr) {
			// TODO Auto-generated method stub
	    	int count = 0;Integer i = 1;
	    	while (!arr.isEmpty())
	    	{
	    		if (arr.contains(1))
	    		{
	    			arr.remove(i);//System.out.println("k");
	    			count++;
	    		}
	    		else
	    			break;
	    	}
			return count;
		}

		public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] doors = new int[n];
	        ArrayList <Integer> arr = new ArrayList<Integer>();
	        for(int doors_i = 0; doors_i < n; doors_i++){
	            doors[doors_i] = in.nextInt();
	            arr.add(doors[doors_i]);
	        }
	        int[] result = revisedRussianRoulette(arr);
	        for (int i = 0; i < result.length; i++) {
	            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
	        }
	        System.out.println("");


	        in.close();
	    }
	}



