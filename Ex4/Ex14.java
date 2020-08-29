/**
 * This class is a collection of all the answers to MMN14.
 *
 * @author Jonathan Elyovich
 * @version 2018b
 * @see THE RIGHT ANSWERS TO QUESTION NUMBER 1 SECTION a ARE:  3, 5, 6.  
 * @see THE TIME COMPLEXITY IN QUESTION NUMBER 1 SECTION b.1 is: O(n).
 * @see THE SPACE COMPLEXITY IN QUESTION NUMBER 1 SECTION b.1 is: O(1).
 * @see THE TIME COMPLEXITY IN QUESTION NUMBER 1 SECTION b.2 is: O(n).
 * @see THE SPACE COMPLEXITY IN QUESTION NUMBER 1 SECTION b.2 is: O(1).
 * @see THE TIME COMPLEXITY IN QUESTION NUMBER 2 SECTION a is: O(n).
 * @see THE SPACE COMPLEXITY IN QUESTION NUMBER 2 SECTION a is: O(1).
 * @see THE TIME COMPLEXITY IN QUESTION NUMBER 2 SECTION b is: O(n).
 * @see THE SPACE COMPLEXITY IN QUESTION NUMBER 2 SECTION b is: O(1).
 */


public class Ex14
{
	private static final int INDEX_OF_FIRST_ROW = 0;
	private static final int INDEX_OF_FIRST_COLUMN = 0;
	private static final int EMPTY_COUNTER = 0;
	private static final int SPIDERMAN_STARTING_LEVEL = 0;
	private static final int SPIDERMAN20_MINIMUM_LEVEL = 20;
	private static final int SPIDERMAN20_MAXIMUM_LEVEL = 29;
	private static final int SPIDERMAN20_ELEVATOR_LEVEL = 20;
	private static final int TEN = 10;
	
	
	
	
	//Public methods:
	/**
	* Finds out if there is a given number in a given two dimensional array.
	* This algorithm returns True if the given number is found or false otherwise.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(1).
	* @param m A two dimensional array in which the given number is searched.
	* @param val The number that is searched.
	* @return true if the number was found in the given array. false otherwise.
	*/
	public static boolean findValWhat(int[][] m, int val)
	{
		int i=INDEX_OF_FIRST_ROW;
		int j=m.length-1;
		while((i<m.length) && (j>=INDEX_OF_FIRST_COLUMN))
		{
			if (m[i][j] > val)
			{
				j--;
			}
			else 
				if(m[i][j] < val)
				 {
					i++;
				 }
				else
					if(m[i][j] == val)
					{
						return (true);
					}
					else
						return (false);
		}
		return (false);
	}//End of findValWhat method.
	
	
	/**
	* Finds out if there is a given number in a given two dimensional array.
	* This algorithm returns True if the given number is found or false otherwise.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(1).
	* @param m A two dimensional array in which the given number is searched.
	* @param val The number that is searched.
	* @return true if the number was found in the given array. false otherwise.
	*/
	public static boolean findValTest(int[][] m, int val)
	{
		int j=INDEX_OF_FIRST_COLUMN;
		int i = m.length-2;
		while (i>=INDEX_OF_FIRST_ROW)
		{
			if(m[i][j]<=val)
			{
				while (j<m.length)
				{
					if(m[i][j]==val || m[i+1][j]==val)
					{
						return (true);
					}
					j++;
				}
				return (false);
			}
			i--;
		}
		return (false);
	}//End of findValTest method.
	
	
	/**
	* Finds out how many substrings in a given string, start in a given letter, end in the same latter,
	* and have that same letter exactly once in between them.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(1).
	* @param s The string that is searched.
	* @param c The letter that is searched.
	* @return The number of substrings in a given string, that start in a given letter, end in the same latter,
	* and have that same letter exactly once in between them.
	*/
	public static int subStrC(String s, char c)
	{
		int counter = EMPTY_COUNTER;
		for(int i=0; i<s.length(); i++)
		{
			if (s.charAt(i)==c)
			{
				counter++;
			}
		}
		if(counter<3)
		{
			return (0);
		}
		return (counter-2);
	}//End of subStrC method.
	
	
	/**
	* Finds out how many substrings in a given string, start in a given letter, end in the same latter,
	* and have a k maximum of that same letter exactly once in between them.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(1).
	* @param s The string that is searched.
	* @param c The letter that is searched.
	* @return The number of substrings in a given string, that start in a given letter, end in the same latter,
	* and have a k maximum of that same letter exactly once in between them.
	*/
	public static int subStrMaxC(String s, char c, int k)
	{
		int counter = EMPTY_COUNTER;
		int sum = 0;
		for(int i=0; i<s.length(); i++)
		{
			if (s.charAt(i)==c)
			{
				counter++;
			}
		}
		if (k>=counter)
		{
			k=counter-1;
		}
		for(int i=k+1; i>0; i--)
		{
				sum = sum + (counter - i);
		}
		return (sum);
	}//End of subStrMaxC method.
	
	
	/**
	* Finds out in how many ways can spiderman reach a given floor.
	* @param n The desired floor.
	* @return The number of different ways that spiderman can reach a given floor.
	*/
	public static int spiderman(int n)
	{
		if(n<=SPIDERMAN_STARTING_LEVEL)
		{
			return (SPIDERMAN_STARTING_LEVEL);
		}
		return spiderman(n, SPIDERMAN_STARTING_LEVEL);
	}//End of spiderman method.

	
	/**
	* Finds out in how many ways can spiderman reach a given floor, with an elevator at the 20th floor limitation.
	* @param n The desired floor.
	* @return The number of different ways that spiderman can reach a given floor.
	*/
	public static int spidermanPhoneBooth20(int n)
	{
		if ((n<SPIDERMAN20_MINIMUM_LEVEL) || (n>SPIDERMAN20_MAXIMUM_LEVEL)) 
		{
			return (SPIDERMAN_STARTING_LEVEL);
		}
		return spidermanPhoneBooth20(n, SPIDERMAN_STARTING_LEVEL);
	}//End of spidermanPhoneBooth20 method.

	
	/**
	* Finds out how many paths meet with the questions limitation.
	* @param mat A two dimensional array in which the paths are searched.
	* @return The number of different paths.
	*/
	public static int countPaths(int [][] mat)
	{
		return (countPaths(mat,INDEX_OF_FIRST_ROW,INDEX_OF_FIRST_COLUMN));
	}//End of countPaths method.
	
	
	
	
	//Private methods:
	//Finds out in how many ways can spiderman reach a given floor.
	//currentFloor --> The starting floor.
	//n --> The desired
	private static int spiderman(int n, int currentFloor)
	{
		if (currentFloor == n)
		{
			return (1);
		}
		if (currentFloor > n)
		{
			return (0);
		}
		return (spiderman(n, currentFloor+1) + spiderman(n, currentFloor+2));
	}//End of spiderman method.
	
	
	//Finds out in how many ways can spiderman reach a given floor.
	//currentFloor --> The starting floor.
	//n --> The desired
	private static int spidermanPhoneBooth20(int n, int currentFloor)
	{
		if ((currentFloor==SPIDERMAN20_ELEVATOR_LEVEL) || (currentFloor==n))
		{
			return (1);
		}
		if (currentFloor > n) 
		{
			return 0;
		}
		return spidermanPhoneBooth20(n, currentFloor + 1) + spidermanPhoneBooth20(n, currentFloor + 2);
	}//End of spidermanPhoneBooth20 method.
	
	
	//Finds out how many paths meet with the questions limitation.
	//mat --> A two dimensional array in which the paths are searched.
	//i --> represents the current row number.
	//j --> represents the current column number.
	private static int countPaths(int [][] mat, int i ,int j)
	{
		if((i>=mat.length) || (j>=mat[i].length) || ((mat[i][j]==0) && (!((i==mat.length-1)&&(j==mat[i].length-1)))))
		{//if index is out of range or the current cell contains 0 (and is not the last cell) - return 0.
			return (0);
		}
		if((i==mat.length-1) && (j==mat[i].length-1))
		{
			return (1);
		}
		int x= mat[i][j]/TEN;
		int y = mat[i][j]%TEN;
		return(countPaths(mat, i+x, j+y) + countPaths(mat, i+y, j+x));
	}//End of countPaths method.

	
	
	
}//End of Ex14 Class.
