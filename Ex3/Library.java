/**
 *  This class represents a Library object.
 * 
 * @author Jonathan Elyovich
 * @version 2018b
 */
public class Library 
{
	private Book[] _lib;
	private int _noOfBooks; //The number of books in the library.
	//class constants:
	private final int MAX_BOOKS = 200;
	private final int FIRST_CELL_IN_ARRAY = 0;
	private final int SECOND_CELL_IN_ARRAY = 1;
	private final int EMPTY_LIBRARY = 0; //The number of books in an empty the library is 0.
	
	
	
	
	//constructor:
	/**
	* Constructs a new (empty) Library object.
	* The maximum number of books value in the library is set to default 200.
	* The number of books value is set to default 0.
	*/
	public Library()
	{
		_lib = new Book[MAX_BOOKS];
		_noOfBooks = EMPTY_LIBRARY;
	}//end of constructor Library.
	
	
	
	
	//public methods:
	/**
	* Adds a given book to the library.
	* @param b the book to add to the library.
	* @return true if the book was added successfully. false otherwise.
	*/
	public boolean addBook(Book b)
	{
		if ((_noOfBooks==MAX_BOOKS)||(b==null))
		{
			return (false);
		}
		_lib[_noOfBooks] = new Book(b);
		_noOfBooks++;
		return (true);
	}//end of method addBook.

	
	/**
	* Removes all the copies of a given book from the library.
	* @param b the book that all the copies of it will be removed from the library.
	*/
	public void removeBook(Book b)
	{
		if (b!=null)
		{
			removeAllCopiesOfABook(b);
			fixArray();
		}
	}//end of method removeBook.	        			        

	
	/**
	* Calculates the number of borrowed books in the library.
	* @return the number of borrowed books in the library.
	*/
	public int howManyBooksBorrowed()
	{
		int borrowedBooksInLibrary = 0;
		int index = FIRST_CELL_IN_ARRAY;
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			if (_lib[index].getBorrowed())
			{
				borrowedBooksInLibrary++;
			}
			index++;
		}
		return (borrowedBooksInLibrary);
	}//end of method howManyBooksBorrowed.
	
	
	/**
	* Calculates how many books are borrowed by a given student in the library.
	* @param name the students name
	* @return the number of all the books that are borrowed by the given student.
	*/
	public int howManyBooksBorrowedToStudent(String name)
	{
		int borrowedBooksToStudent = 0;
		if (name==null)
		{
			return (borrowedBooksToStudent);
		}
		int index = FIRST_CELL_IN_ARRAY;
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			if ((_lib[index].getStudentName()!=null)&&(_lib[index].getStudentName().equals(name)))
			{
				borrowedBooksToStudent++;
			}
			index++;
		}
		return (borrowedBooksToStudent);
	}//end of method howManyBooksBorrowedToStudent.
	
	
	/**
	* Calculates who is the most popular author in the libraries books.
	* @return the most popular author in the libraries books. null if the library is empty.
	*/
	public String mostPopularAuthor()
	{
		if (_noOfBooks == EMPTY_LIBRARY)
		{
			return (null);
		}
		String mostPopularAuthor = _lib[FIRST_CELL_IN_ARRAY].getAuthor();
		int index = SECOND_CELL_IN_ARRAY;
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			if ((!(mostPopularAuthor.equals(_lib[index].getAuthor())))&&(numOfBooksByAuthor(mostPopularAuthor)<numOfBooksByAuthor(_lib[index].getAuthor())))
					{
						mostPopularAuthor = _lib[index].getAuthor();
					}
			index++;
		}
		return (mostPopularAuthor);
	}//end of method mostPopularAuthor.
		
	
	/**
	* finds the oldest book in the library depending on the year the book was published.
	* @return the oldest book in the library. null if the library is empty.
	*/
	public Book oldestBook ()
	{
		if (_noOfBooks == EMPTY_LIBRARY)
		{
			return (null);
		}
		Book oldestBook = new Book(_lib[FIRST_CELL_IN_ARRAY]);
		int index = SECOND_CELL_IN_ARRAY; 
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			if (_lib[index].olderBook(oldestBook))
					{
						oldestBook = new Book(_lib[index]);
					}
			index++;
		}
		return (oldestBook);
	}//end of method oldestBook.
	
	
	/**
	* Removes a single copy of a given book from the library.
	* @param name the book to be removed.
	* @return the book that was removed from the library. null if the remove was unsuccessful.
	*/
	public Book remove(String name)
	{
		if (name==null)
		{
			return (null);
		}
		int index = FIRST_CELL_IN_ARRAY;
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			if (_lib[index].getTitle().equals(name))
			{
				Book book1 = new Book(_lib[index]);
				_lib[index] = null;
				_noOfBooks--;
				fixArray();
				return (new Book(book1));
			}
			index++;
		}
		return (null);
	}//end of method remove.
	
	
	/** Returns a string representation of this library.
	 * @return representation of this library.
     */
	public String toString()
	{
		String stringToReturn = "The books in the library are:";
		int index = FIRST_CELL_IN_ARRAY;
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			stringToReturn += "\n"+_lib[index];
			index++;
		}
		return (stringToReturn);
	}//end of method toString.
	
	
	
	
	//private methods:
	//Removes all the copies of a given book.
	private void removeAllCopiesOfABook(Book bookToRemove)
	{
		int index = FIRST_CELL_IN_ARRAY;
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			if (_lib[index].equals(bookToRemove))
			{
				_lib[index] = null;
				_noOfBooks--;
			}
			index++;
		}	
	}//end of method removeAllCopiesOfABook.
	
	
	//compressing an array to have 0 nulls between objects, and keeps the order of the original objects intact. 
	private void fixArray()
	{
		final int STARTING_SHIFT = 0;
		int shift = STARTING_SHIFT;
	    for (int i=FIRST_CELL_IN_ARRAY; i<_lib.length; i++) 
	    {
	    	if (_lib[i]==null)
	        {
	            shift++;
	        } 
	        else if (shift>STARTING_SHIFT) 
	        	{
	        		_lib[i - shift] = new Book(_lib[i]);
	        		_lib[i] = null;
	        	}
	    }
	}//end of method fixArray.	
	
	
	//Calculates the number of books written by a given author in the library.
	private int numOfBooksByAuthor(String name)
	{
		int index = FIRST_CELL_IN_ARRAY;
		int numOfBooksByAuthor = 0;
		while ((index<_lib.length)&&(_lib[index]!=null))
		{
			if (_lib[index].getAuthor().equals(name))
			{
				numOfBooksByAuthor++;
			}
			index++;
		}
		return (numOfBooksByAuthor);
	}//end of method numOfBooksByAuthor.	
	
	
	
	
}//end of class Library.