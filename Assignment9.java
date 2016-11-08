// Assignment #: 9
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: 

import java.io.*;
import java.util.*;

public class Assignment9 {
    
	public static void main (String[] args) throws IOException {
		//Initialize BufferedReader to read input
		InputStreamReader isr = new InputStreamReader (System.in);
	    BufferedReader stdin = new BufferedReader (isr);
	    
	    //Array of 100 to hold all the numbers given by the user
	    int[] numberList= new int[100];
	    
	    //nextNum is the last number entered by the user
	    int nextNum = 0;
	    //Index is the index of the array to be added next
	    int index = -1;
	    
	    //While the last number entered by user is not 0, 
	    //read the input and add it to list. Increase index with each step. 
	    do {
	    	try {
	    		index++;
	    		nextNum = Integer.parseInt(stdin.readLine().trim());
	    		numberList[index] = nextNum;
	    	}
	    	//IF the user tries to enter something besides a number, catch it
	    	catch (NumberFormatException e) {
	    		System.out.print("You must enter a number\n");
	    	}
	    }
	    while (nextNum != 0);
	    
	    
	    //Print out the results of all the methods
	    //Print out the min number in the list
	    System.out.print("The minimum number is " + Assignment9.findMin(numberList, 0, index) + "\n");
	   //Print out the sum of all the odd numbers
	    System.out.print("The sum of odd numbers is " + Assignment9.computeSumOfOdd(numberList, 0, index)+ "\n");
	    //Print out the number of negative numbers
	    System.out.print("The count of negative numbers is " + Assignment9.countNegative(numberList, 0, index)+ "\n");
	    //Print out the sum of all the numbers less than the last number given by the user
	    System.out.print("The sum of numbers that are less than the last is " + Assignment9.sumLessThanLast(numberList, 0, index, numberList[index-1])+ "\n");
	}
	
	//Find the minimum number in the list, given the list and a start and end
	public static int findMin(int[] numbers, int startIndex, int endIndex) {
		//if the start and end index are equal, return the value at this (this is min)
		if (startIndex == endIndex) {
			return numbers[startIndex];
		}
		else {
			//If first number is greater than last number, call the method again
			//and move the startIndex up
			if (numbers[startIndex] > numbers[endIndex])
			{
				return findMin(numbers, startIndex+1, endIndex);
			}
			//Else If first number is less than last number, call the method again
			//and move the endIndex down
			else {
				return findMin(numbers, startIndex, endIndex-1);
			}
		}
	}
    public static int computeSumOfOdd(int[] numbers, int startIndex, int endIndex) {
    	//If we have reached the end of the list (and therefore are at 0), return 0
    	if (startIndex == endIndex) {
    		return 0;
    	}
    	else {
    		//If the first number is even, recall method with next start
    		if (numbers[startIndex]%2 == 0) {
    			return 0 + computeSumOfOdd(numbers, startIndex + 1, endIndex);
    		}
    		//IF the first number is odd, add the value and recall method with next start
    		else {
    			return numbers[startIndex] + computeSumOfOdd(numbers, startIndex + 1, endIndex);
    		}
    	}
    }
    public static int countNegative(int[] numbers, int startIndex, int endIndex) {
    	//If we are at the end of the list, (and therefore at 0), return 0
    	if (startIndex == endIndex) {
    		return 0;
    	}
    	else {
    		//If the first number is positive, recall method with next start
    		if (numbers[startIndex] >= 0) {
    			return 0 + countNegative(numbers, startIndex+1, endIndex);
    		}
    		//If the first number is negative, add 1 and recall method with next start
    		else {
    			return 1 + countNegative(numbers, startIndex+1, endIndex);
    		}
    	}
    }
    public static int sumLessThanLast(int[] numbers, int startIndex, int endIndex, int lastNumber) {
    	//If we are at the end of the list, (and therefore at 0) return 0
    	if (startIndex == endIndex) {
    		return 0;
    	}
    	else {
    		//If the first number is less than the lastnumber, add the value
    		//and recall method with next start
    		if (numbers[startIndex] < lastNumber) {
    			return numbers[startIndex] + sumLessThanLast(numbers, startIndex+1, endIndex, lastNumber);
    		}
    		//IF the number is greater/equal than lastnumber, recall method with next start
    		else {
    			return 0 + sumLessThanLast(numbers, startIndex+1, endIndex, lastNumber);
    		}
    	}
    }
}
