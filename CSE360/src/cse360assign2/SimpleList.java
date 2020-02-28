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
		if(count >= 1) {
			for(int traverse = count; traverse >= 1; traverse--) {
				list[traverse] = list[traverse-1];
			}
		}
		list[0] = numberToAdd;
		
		if(count != 10) {
			count++;
		}
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

}
