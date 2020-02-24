package cse360assign2;

import java.util.Arrays;

// Marcus Perez
// Class ID: 384
// Assignment #1

// Java object that contains int array and count variable
// which has functions that can alter, modify, or print the list

public class SimpleList {
	// Object variables
	int[] list;
	int count;
	
	/**
	 * Default Constructor
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Shifts each value of the array and then adds our new value
	 * at the head of the array.
	 * 
	 * @param  value  the number that is to be added to the array.
	 */
	public void add(int value) {
		// If our count is 0, set the element to the head of the list
		if(count == 0) {
			list[count] = value;
			count++;
		}
		else {	
			// If the count is greater or equal to 10, resize the array
			if(count >= list.length) {
				int newSize = (int) (count * 1.5);
				int[] tempList = Arrays.copyOf(list, newSize);
				list  = tempList;
			}
			
			// Start at the tail of the array and move each element forward one index
			for(int i = count-1; i >= 0; i--) {
				list[i + 1] = list[i];
			}
			
			list[0] = value;
			
			count++;
		}
	}
	
	/**
	 * Deletes the value given and shifts the elements accordingly.
	 * 
	 * @param  value  the number that is to be removed from the array.
	 */
	public void remove(int value) {
		// Run through the entire array, looking for the value
		for(int i = 0; i < count; i++) {
			if(list[i] == value) {
				
				// Run through the list and move each element closer to the head
				for(int j = i; j < count-1; j++) {
					list[j] = list[j+1];
				}
				
				list[count-1]  = 0;
				count--;
				i = count;
				
				// Get the size of 75% of the current array
				int temp = (int) (list.length * .75);
				
				// If count is smaller than 75% of the array, resize
				if(count < temp) {
					int[] tempList = Arrays.copyOf(list, temp);
					list  = tempList;
				}
			}
		}
	}
	
	/**
	 * Returns the current count of objects in the array.
	 * 
	 * @return        the count of elements in the array.
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns a string of all of the elements in the array.
	 * 
	 * @return        string containing all of the elements, separated by commas.
	 */
	public String toString() {
		String listStr = "";
		
		if(count != 0) {
			// Increments through the array, adding it to the string with a space
			for(int i = 0; i < count-1; i++) {
				listStr += list[i] + " ";
			}
			
			// Adds the tail element to the string
			listStr += list[count-1];
		}
		
		
		
		return listStr;
	}
	
	/**
	 * Searches for a value and finds the index it is located.
	 * 
	 * @param  value  the number that is to be searched for from the array
	 * @return        int of the index the value is located at.
	 */
	public int search(int value) {
		int index = -1;
		
		// Increment through the array, testing each element against the value given
		for(int i = 0; i <= count - 1; i++) {
			if(list[i] == value) {
				index = i;
				i = count;
			}
		}
		
		return index;
	}
}