/**
 *  This class represents a Book object.
 * 
 * @author Jonathan Elyovich
 * @version 2018b
 */
public class Book 
{
	private String _title;
	private String _author;
	private int _yearPublished;
	private int _noOfPages;
	private boolean _borrowed;
	private String _studentName;
	private Date _borrowedDate;
	private Date _returnDate;
	
	private final int MAX_DAYS = 30;
	private final int MAX_DAYS_TO_DOUBLE_PENALTY = 2*MAX_DAYS;
	private final int PENALTY_PER_DAY = 5;
	private final int MAX_PENALTY_PER_DAY = 2*PENALTY_PER_DAY;
	private final int MAX_YEAR_PUBLISHED = 2018;
	private final int MIN_YEAR_PUBLISHED = 1800;
	private final int CHECK_POSITIVE = 0;
	private final int DEFAULT_YEAR = 2000;
	private final int DEFAULT_PAGES = 1;
	
	
	
	
	//constructors:
    /**
    * Constructs a new Book object. If year is not valid it will be set to default 2000. If number of pages is not valid it will be set to default 1. _borrowed field is set to false. All other fields are set to null.
    * @param title book title
    * @param author book author
    * @param year the year the book was published
    * @param  num book number of pages
    */
	public Book(String title, String author, int year, int num)
	{
		_title = title;
		_author = author;
		_yearPublished = checkYearPublishedToInt(year);
		_noOfPages = checkNoOfPagesToInt(num);
		_borrowed = false;
		_studentName = null;
		_borrowedDate = null;
		_returnDate = null;
	}//end of constructor Book.
	
	
	/**
	    * Copy constructor for Book object.
	    * @param other book to be copied
	    */
	public Book(Book other)
	{
		_title = other._title;
		_author = other._author;
		_yearPublished = other._yearPublished;
		_noOfPages = other._noOfPages;
		_borrowed = other._borrowed;
		_studentName = other._studentName;
		_borrowedDate = new Date(other._borrowedDate);
		_returnDate = new Date(other._returnDate);
	}//end of Copy Constructor Date.
	
	
	
	
	/** Returns the book title.
     * @return the book title
     */
	public String getTitle()
	{
		return (_title);
	}//end of method getTitle.
	
	
	/** Returns the book author.
     * @return the book author
     */
	public String getAuthor()
	{
		return (_author);
	}//end of method getAuthor.
	
	
	/** Returns the year the book was published.
     * @return the year the book was published
     */
	public int getYear()
	{
		return (_yearPublished);
	}//end of method getYear.
	
	
	/** Returns the book number of pages.
     * @return the book number of pages
     */
	public int getPages()
	{
		return (_noOfPages);
	}//end of method getPages.
	
	
	/** Returns true if the book is borrowed; false otherwise.
     * @return true if the book is borrowed; false otherwise
     */
	public boolean getBorrowed()
	{
		return (_borrowed);
	}//end of method getBorrowed.
	
	
	/** Returns the student name.
     * @return the student name
     */
	public String getStudentName()
	{
		return (_studentName);
	}//end of method getStudentName.
	
	
	/** Returns the book borrowed date.
     * @return the book borrowed date
     */
	public Date getBorrowedDate()
	{
		return (new Date(_borrowedDate));
	}//end of method getBorrowedDate.
	
	
	/** Returns the book return date.
     * @return the book return date
     */
	public Date getReturnDate()
	{
		return (new Date(_returnDate));
	}//end of method getReturnDate.
	
	
	
	
	/** Sets the book title.
	 * @param s the new book title String to be set
     */
	public void setTitle(String s)
	{
		_title = s;
	}//end of method setTitle.
	
	
	/** Sets the book author.
	 * @param s the new book author String to be set
     */
	public void setAuthor(String s)
	{
		_author = s;
	}//end of method setAuthor.
	
	
	/** Sets the year the book was published (only if valid).
	 * @param n the book published year to be set
     */
	public void setYear(int n)
	{
		if (checkYearPublishedToBoolean(n))
		{
			_yearPublished = n;
		}
	}//end of method setYear.
	
	
	/** Sets the book number of pages (only if valid).
	 * @param n the book published year to be set
     */
	public void setPages(int n)
	{
		if (checkNoOfPagesToBoolean(n))
		{
			_noOfPages = n;
		}
	}//end of method getReturnDate.
	
	
	
	
	/** Checks if this book is equal to other book.
	 * @param other the book to compare this book to
	 * @return true if this book and other book are the same; false otherwise
     */
	public boolean equals(Book other)
	{
		if ((_title==other._title)&&(_author==other._author)&&(_yearPublished==other._yearPublished)&&(_noOfPages==other._noOfPages))
		{
			return (true);
		}
		return (false);
	}//end of method equals.
	
	
	/** Returns a string representation of this book.
	 * @return representation of this book in the following format, for example, Title: Pride and Prejudice Author: Jane Austen Year: 1813, 350 pages
     */
	public String toString()
	{
		return ("Title: "+_title+"\t"+"Author: "+_author+"\t"+"Year: "+_yearPublished+", "+_noOfPages+" pages");
	}//end of method toString.
	
	
	/** Checks if this book is older than other book.
	 * @param other the book to compare to
	 * @return true if this book is older than other book; false otherwise
     */
	public boolean olderBook(Book other)
	{
		if (_yearPublished<other._yearPublished)
		{
			return (true);
		}
		return (false);
	}//end of method olderBook.
	
	
	/** Checks if this book and other book have same author.
	 * @param other the book to compare to
	 * @return true if this book and other book have same author; false otherwise
     */
	public boolean sameAuthor(Book other)
	{
		if (_author==other._author)
		{
			return (true);
		}
		return (false);
	}//end of method sameAuthor.
	
	
	/** Gets student name and borrow date and updates the appropriate book attributes.
	 * @param name the student name
	 * @param d borrow date
     */
	public void borrowBook(String name, Date d)
	{
		if (!_borrowed)
		{
			_studentName = name;
			_borrowed = true;
			_borrowedDate = new Date(d);
		}
	}//end of method borrowBook.
	
	
	/** Gets return date and updates the appropriate book attributes.
	 * @param d return date
	 * @return true if student is late or book is not borrowed; false otherwise
     */
	public boolean returnBook(Date d)
	{
		if(_borrowed)
		{
			_studentName = null;
			_borrowed = false;
			_returnDate = new Date(d);
			if (_borrowedDate.difference(d)>MAX_DAYS)
			{
				return (true);
			}
			return (false);	
		}
		return (true);	
	}//end of method returnBook.
	
	
	/** Gets today's date and if book is borrowed returns how many days the book is borrowed; otherwise returns 0.
	 * @param d today's date
	 * @return how many days the book is borrowed
     */
	public int howLongBorrowed(Date d)
	{
		if ((d.before(_borrowedDate))||(!_borrowed))
		{
			return (0);
		}
		return (_borrowedDate.difference(d));
	}//end of method howLongBorrowed.
	
	
	/** Checks if book is available.
	 * @param d today's date
	 * @return false if the book is borrowed; otherwise if book is not borrowed returns false if today's day is Friday or Saturday; otherwise returns true
     */
	public boolean isAvailable(Date d)
	{
		final int FRIDAY = 6;
		final int SATURDAY =0;
		if ((_borrowed)||(d.dayInWeek()==FRIDAY)||(d.dayInWeek()==SATURDAY))
		{
			return (false);
		}
		return (true);
	}//end of method isAvailable.
	
	
	/** Computes penalty given return date.
	 * @param d return date
	 * @return penalty if book is borrowed and student is late; 0 otherwise.
     */
	public int computePenalty(Date d)
	{
		int differenceInDays = howLongBorrowed(d);
		if (differenceInDays>MAX_DAYS)
		{
			if (differenceInDays>MAX_DAYS_TO_DOUBLE_PENALTY)
			{
				return ((MAX_DAYS*PENALTY_PER_DAY)+((differenceInDays-MAX_DAYS_TO_DOUBLE_PENALTY)*MAX_PENALTY_PER_DAY));
			}
			return ((differenceInDays-MAX_DAYS)*PENALTY_PER_DAY);
		}
		return (0);
	}//end of method computePenalty.
	
	
	
	
	//checks if the parameter yearPublished is valid.
	//if it is valid the method will return yearPublished or DEFAULT_YEAR otherwise. 
	private int checkYearPublishedToInt(int yearPublished)
	{
		if ((yearPublished<MIN_YEAR_PUBLISHED)||(MAX_YEAR_PUBLISHED<yearPublished))
		{
			return (DEFAULT_YEAR);
		}
		return (yearPublished);
	}//end of method checkYearPublishedToInt.
	
	
	//checks if the parameter noOfPages is valid.
	//if it is valid the method will return noOfPages or DEFAULT_PAGES otherwise. 
	private int checkNoOfPagesToInt(int noOfPages)
	{
		if (noOfPages<=CHECK_POSITIVE)
		{
			return (DEFAULT_PAGES);
		}
		return (noOfPages);
	}//end of method checkNoOfPagesToInt.
	
	
	//checks if the parameter yearPublished is valid.
	//if it is valid the method will return true or false otherwise. 
	private boolean checkYearPublishedToBoolean(int yearPublished)
	{
		if ((yearPublished<MIN_YEAR_PUBLISHED)||(MAX_YEAR_PUBLISHED<yearPublished))
		{
			return (false);
		}
		return (true);	
	}//end of method checkYearPublishedToBoolean.
	
	
	//checks if the parameter noOfPages is valid.
	//if it is valid the method will return true or false otherwise. 
	private boolean checkNoOfPagesToBoolean(int noOfPages)
	{
		if (noOfPages<=CHECK_POSITIVE)
		{
			return (false);
		}
		else
		{
			return (true);
		}	
	}//end of method checkNoOfPagesToBoolean.
		
	
	
	
}//end of class Book.
