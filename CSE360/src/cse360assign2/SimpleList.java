package cse360assign2;
/**
 * Author Name: Ryan Gerner
 * Class ID: 406
 * Assignment Number: 1
 * Description:
 *		This assignment is meant to practice Javadoc, unit tests, and Junit
 *		This class is a list that can be added too, removed from, counted,
 *			and searched and also has a toString method that displays the list.
 *
 */


public class SimpleList {
	
	int [] list = new int [10];
	
	int count = 0;
	
	
	public static void main(String [] args) {
		
		SimpleList check = new SimpleList();
		
		check.add(1);
		check.add(2);
		check.add(3);
		
		for(int i = 0; i < check.list.length; i++) {
			System.out.print(check.list[i]);
		}
		System.out.println("\n");
		
		System.out.println(check.first());
		System.out.println(check.last());
		System.out.println(check.size());
		
		check.append(5);
		check.append(6);
		
		for(int i = 0; i < check.list.length; i++) {
			System.out.print(check.list[i]);
		}
		System.out.println("\n");
		
		System.out.println(check.first());
		System.out.println(check.last());
		System.out.println(check.size());
		
		
		
		
		
	}
	
	
	/**
	 * Constructor for the <code>SimpleList</code> class
	 * Sets count to 0, creates a 10 element empty array called list
	 */
	SimpleList(){
		count = 0;
		list = new int [10];
	}
	
	
	/**
	 * Adds the parameter to the beginning of <code>list</code> 
	 * Subsequent elements in <code>list</code> are pushed down this array
	 * If the list is full, the last element is pushed off this array and removed
	 * @param numberToAdd the number to be added to the beginning of this array
	 */
	
	public void add(int numberToAdd) {
		
		//increasing size of array by 50% if it is full
		if(count == list.length) {
			
			int amount = (list.length/2);
			int total = list.length + amount;
			int [] temp = new int [total];
			
			for(int counter = 0; counter < list.length; counter++) {
				temp[counter] = list[counter];
			}
			list = temp;
			
		}
		
		
		if(count >= 1) {
			for(int traverse = count; traverse >= 1; traverse--) {
				list[traverse] = list[traverse-1];
			}
		}
		list[0] = numberToAdd;
		
		count++;
	}
	
	/**
	 * Searches <code>list</code> for any instances of the parameter.
	 * If an instance is found, the instance is removed and the elements in <code>list</code> are moved down to fill in the empty space
	 * @param numberToRemove the number to search for and remove every instance of
	 */
	
	public void remove(int numberToRemove) {
		for (int traverse = 0; traverse < count; traverse++) {
			if (list[traverse] == numberToRemove) {
				for(int moveDown = traverse; moveDown < count; moveDown++) {
					list[moveDown] = list[moveDown + 1];
				}
				count--;
			}
		}
		
		//reducing size of array if 25% is empty
		int percent25 = (list.length /4);
		int emptyAmount = 0;
		
		for (int counter = 0; counter < list.length ; counter++) {
			if(list[counter] == 0) {
				emptyAmount++;
			}
		}	
			
		
		if(emptyAmount > percent25) {
			if(list.length > 1) {
				int [] temp = new int [list.length - 1];
				
				for(int copy = 0; copy < temp.length; copy++) {
					temp[copy] = list[copy];
				}
				list = temp;
			}	
		}
		
		
		
		
	}
	
	/**
	 * Returns the number of elements in <code>list</code>.
	 * @return the number of elements in list
	 */
	
	public int count() {
		return count;
	}
	
	/**Displays the contents of <code>list</code> in a String.
	 * Uses the <code>firstTime</code> variable in order to prevent a space to print at the front of the string
	 */
	
	public String toString() {
		String stringToReturn = "";
		int firstTime = 0;
		for (int traverse = 0; traverse < count; traverse++) {
			if(firstTime == 0) {
				stringToReturn = stringToReturn + list[traverse];
				firstTime = 1;
			}
			else {
				stringToReturn = stringToReturn + " " + list[traverse];
			}
			
		}
		return stringToReturn;
	}
	
	/** Returns the index of the last instance of this parameter.
	 * 
	 * @param numberToSearchFor the number to find the index of in the array
	 * @return the index of the instance of this parameter
	 */
	
	public int search (int numberToSearchFor) {
		int index = -1;
		for (int traverse = 0; traverse < count; traverse++) {
			if(list[traverse] == numberToSearchFor) {
				index = traverse;
			}
		}
		return index;
	}
	
	
	
	/**
	 * 
	 * @param appendInt the integer to be appended to the end of the list
	 */
	public void append(int appendInt) {
		
		//increasing size of array by 50% if it is full
		if(count == list.length) {
			
			int amount = (list.length/2);
			int total = list.length + amount;
			int [] temp = new int [total];
			
			for(int counter = 0; counter < list.length; counter++) {
				temp[counter] = list[counter];
			}
			list = temp;
			
		}
		
		if(count >= 1) {
			
			if(list[list.length - 1] == 0) {
				list[list.length - 1] = appendInt;
			}
			else {
				boolean firstLocation = true;
				int openIndex = -1;
				for(int findOpenSpace = list.length - 1; findOpenSpace >= 0; findOpenSpace--) {
					if(list[findOpenSpace] == 0 && firstLocation) {
						openIndex = findOpenSpace;
						firstLocation = false;
					}
				}
				list[openIndex] = appendInt;
			}
		}
		else {
			list[0] = appendInt;
		}
		
		
		count++;
		
	}
	
	/**locates and returns the ifrst integer in the list. If the list is empty, returns -1
	 * 
	 * @return the first integer of the list
	 */
	public int first() {
		
		int toReturn;
		
		if(list[0] == 0) {
			toReturn = -1;
		}
		
		else {
			toReturn = list[0];
		}
		
		return toReturn;
	}
	
	/**Returns the last element in the list and returns -1 if the list is empty.
	 * 
	 * @return the last element in the list, returns -1 if list is empty
	 */
	public int last() {
		
		int toReturn;
		boolean isEmpty = true;
		for(int checkEmpty = 0; checkEmpty < list.length; checkEmpty++) {
			if(list[checkEmpty] != 0) {
				isEmpty = false;
			}
		}
		
		if(isEmpty) {
			toReturn = -1;
		}
		else {
			toReturn = list[list.length-1];
		}
		return toReturn;
		
	}
	
	/**Returns the "number of possible locations in the list" I took this to mean the amount of integers in the list
	 * 
	 * @return the size of the array
	 */
	public int size() {
		
		int returnSize = 0;
		for(int sizeCount = 0; sizeCount < list.length; sizeCount++) {
			if (list[sizeCount] != 0) {
				returnSize++;
			}
		}
		return returnSize;
		
		
	}
	
	

}
