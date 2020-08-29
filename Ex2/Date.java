/**
 *  This class represents a Date object.
 * 
 * @author Jonathan Elyovich
 * @version (2018)
 */
public class Date 
{
    private int _day;
    private int _month;
    private int _year;
    
    private final int JANUARY = 1;
    private final int FEBRUARY = 2;
    private final int MARCH = 3;
    private final int APRIL = 4;
    private final int MAY = 5;
    private final int JUNE = 6;
    private final int JULY = 7;
    private final int AUGUST = 8;
    private final int SEPTEMBER = 9;
    private final int OCTOBER = 10;
    private final int NOVEMBER = 11;
    private final int DECEMBER = 12;
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = JANUARY;
    private final int DEFAULT_YEAR = 2000;

    
    
    
    //constructors:
    /**
    * Creates a new Date object if the date is valid, otherwise creates the date 1/1/2000.
    * @param day the day in the month (1-31)
    * @param month the month in the year (1-12)
    * @param year the year (4 digits)
    */
    public Date(int day, int month, int year) 
    {
    	if (isDateValid(day,month,year))
    	{
    		_day = day;
            _month = month;
            _year = year;
    	}
    	else
    	{
    		_day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
    	}
    }//end of constructor Date.
    
    /**
    * Copy Constructor
    * @param other the date to be copied
    */
    public Date(Date other)
    {
    	if (other!=null)
    	{
    		_day = other._day;
    	    _month = other._month;
            _year = other._year;
    	}
    }//end of Copy Constructor Date.
    
    
    
    
    /** gets the year 
     * @return the year
     */
    public int getYear()
    {
        return _year;
    }//end of method getYear.
      
    /** gets the month 
     * @return the month
     */
    public int getMonth()
    {
        return _month;
    }//end of method getMonth.
    
    /** gets the day 
     * @return the day
     */
    public int getDay()
    {
        return _day;
    }//end of method getDay.
    
   
    
    
    /** sets the year (only if date remains valid)
     * @param yearToSet the value to be set
     */
    public void setYear(int yearToSet)
    {
    	if (isDateValid(this._day, this._month, yearToSet))
    	{
            _year = yearToSet;
    	}
    }//end of method setYear.
    
    /** set the month (only if date remains valid)
     * @param monthToSet the value to be set
     */
    public void setMonth(int monthToSet)
    {
    	if (isDateValid(this._day, monthToSet, this._year))
    	{
            _month = monthToSet;
    	}
    }//end of method setMonth.
      
    /** sets the day (only if date remains valid) 
     *  @param dayToSet the value to be set
     */
    public void setDay(int dayToSet)
    {
    	if (isDateValid(dayToSet, this._month, this._year))
    	{
            _day = dayToSet;
    	}
    }//end of method setDay.

    
    
    
    /** check if 2 dates are the same 
     *  @param other the date to compare this date to
     *  @return true if the dates are the same
     */
    public boolean equals(Date other)
    {
    	if((_day==other._day)&&(_month==other._month)&&(_year==other._year))
    	{
    		return (true);
    	}
    	return (false);
    }//end of method equals.

    
    /**
    * check if this date is before other date
    * @param other the date to check if this date is before other date  
    * @return true if this date is before other date
    */
    public boolean before(Date other) 
    {
    	if ((_year<other._year) || ((_year==other._year)&&(_month<other._month)) || ((_year==other._year)&&(_month==other._month)&&(_day<other._day)))
        {
            return true;
        }
        return false;
    }//end of method before.

    
    /**
     * check if this date is after other date
     * @param other the date to check if this date is after other date  
     * @return true if this date is after other date
     */
    public boolean after(Date other) 
    {
    	if (other.before(this))
    	{
    		return (true);
    	}
    	return (false);
    }//end of method after.

    
    /**
     * calculates the difference in days between two dates
     * @param other the date to calculate the difference between  
     * @return the number of days between the dates
     */
    public int difference(Date other) 
    {
    	return (Math.abs(this.calculateDate(_day,_month,_year)-other.calculateDate(other._day,other._month,other._year)));
    }//end of method difference.


    /**
    * returns a String that represents this date
    * @return String that represents this date in the following format: 
    * day/month/year for example: 2/3/1998
    */
    public String toString() 
    {
        return (_day +"/" + _month + "/" + _year);
    }//end of method toString.
    
    
    /**
     * calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
     * @return the day of the week that this date occurs on
     */
    public int dayInWeek()
    {
    	int Day, D, M, Y, C;
    	final int JANUARY_CORRECTION = 13;
    	final int FEBRUARY_CORRECTION = 14;
    	final int MINUS_ONE_YEAR = -1;
    	final int SPLIT_YEAR_COEFFICIENT = 100;
    	final int ZERO = 0;
    	D = this._day;
    	if ((this._month == JANUARY)||(this._month == FEBRUARY))
    	{
    		if(this._month == JANUARY)
    		{
    			M = JANUARY_CORRECTION;
    		}
    		else
    		{
    			M = FEBRUARY_CORRECTION;
    		}
    		Y = this._year + MINUS_ONE_YEAR;
    	}
    	else
    		{
    			M = this._month;
    			Y = this._year;
    		}
    	C = Y/SPLIT_YEAR_COEFFICIENT;
    	Y = Y%SPLIT_YEAR_COEFFICIENT;
    	Day = (D+(26*(M+1))/10+Y+Y/4+C/4-2*C)%7;
    	if (Day < ZERO)
    	{
    		return (Math.floorMod(Day,7));
    	}
    	return (Day);
    }//end of method dayInWeek.
    
    
    
    
    //check if leap year
    private boolean leap(int year)
    {
    	final int LEAP_YEAR_COEFFICIENT1 = 4;
    	final int LEAP_YEAR_COEFFICIENT2 = 100;
    	final int LEAP_YEAR_COEFFICIENT3 = 400;
    	final int ZERO_REMAINDER = 0;
    	return(((year%LEAP_YEAR_COEFFICIENT1 == ZERO_REMAINDER)&&(year%LEAP_YEAR_COEFFICIENT2 != ZERO_REMAINDER))||(year%LEAP_YEAR_COEFFICIENT3 == ZERO_REMAINDER));
    }//end of method leap.
    
    
    //check if the date is valid
    private boolean isDateValid(int day, int month, int year)
    {
    	final int MINIMUM_FOUR_DIGITS = 1000;
    	final int MAXIMUN_FOUR_DIGITS = 9999;
    	final int MINIMUM_DAY = 1; //minimum day in any month.
    	final int MAXIMUN_DAY_IN_JANUARY = 31; //maximum day in:JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER and DECEMBER.
    	final int MAXIMUN_DAY_IN_APRIL = 31; //maximum day in:APRIL, JUNE, SEPTEMBER and NOVEMBER.
    	final int MAXIMUN_DAY_IN_FEBRUARY_NO_LEAP = 28;
    	final int MAXIMUN_DAY_IN_FEBRUARY_YES_LEAP = 29;
    	if ((MINIMUM_FOUR_DIGITS<=year)&&(year<=MAXIMUN_FOUR_DIGITS))
    	{
    		if (((month==JANUARY)||(month==MARCH)||(month==MAY)||(month==JULY)||(month==AUGUST)||(month==OCTOBER)||(month==DECEMBER))&&(MINIMUM_DAY<=day)&&(day<=MAXIMUN_DAY_IN_JANUARY))
        	{
        		return(true);
        	}
        	if (((month==APRIL)||(month==JUNE)||(month==SEPTEMBER)||(month==NOVEMBER))&&(MINIMUM_DAY<=day)&&(day<=MAXIMUN_DAY_IN_APRIL))
        	{
        		return(true);
        	}
        	if ((month == FEBRUARY) && (MINIMUM_DAY<=day) && (((leap(year))&&(day<=MAXIMUN_DAY_IN_FEBRUARY_YES_LEAP)) || ((!leap(year))&&(day<=MAXIMUN_DAY_IN_FEBRUARY_NO_LEAP))))
        	{
        		return (true);
        	}
    	}
    	return(false);
    }//end of method isDateValid.
    

    //calculates the number of days past since the beginning of the gregorian callender. 
    private int calculateDate ( int day, int month, int year)
    {
		if (month < 3) {
		year--;
		month = month + 12;
		}
		return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
	}//end of method calculateDate.
    
   
    
    
}//end of class Date.


