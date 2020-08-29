/**
 *  This class represents a BigNumber object.
 *  The BigNumber class is designed to operate exclusivity on the natural numbers group.
 *  
 * @author Jonathan Elyovich
 * @version 2018
 */
public class BigNumber 
{
	private IntNode _head; //Points to the least significant number.
	private final int THIS_IS_BIGGER = 1;
	private final int THIS_IS_SMALLER = -1;
	private final int THIS_IS_EQUAL = 0;
	private final int NODE_WITH_A_VALUE_OF_ZERO = 0;
	private final String EMPTY_STRING = "";

	
	
	//Constructors:
	/**
	* Constructs a new BigNumber object with a value of 0.
	* This algorithms TIME COMPLEXITY is O(1).
	* This algorithms SPACE COMPLEXITY is O(1).
	*/
	public BigNumber() 
	{
		_head = new IntNode(NODE_WITH_A_VALUE_OF_ZERO, null);
	}//End of empty constructor.

	
	/**
	* Constructs a new BigNumber object from a type long value.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(n).
	* @param other The type long value that will be stored as a BigNumber object.
	* @see Any non natural number (number<0) will be considered as: null. 
	*/
	public BigNumber(long other) 
	{
		IntNode last = null;
		if(other < 0) //Edge case when other is out of range.
		{
			_head = null;
		}
		if(other == 0) //Edge case when other = 0.
		{
			_head = new IntNode(NODE_WITH_A_VALUE_OF_ZERO, null);
		}
		while (other > 0) 
		{
			int digit = (int) (other % 10);
			IntNode node = new IntNode(digit, null);
			if (_head == null) 
			{
				_head = node; //Creating the first node, this command will run only once.
			} 
			else 
			{
				last.setNext(node);
			}
			last = node;
			other = other / 10;
		}
	}//End of constructor.
	
	
	/**
	* Constructs a new BigNumber object from another BigNumber object.
	* The new BigNumber object will be identical to the received BigNumber object in its value.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(n).
	* @param other The BigNumber object that will be copied.
	* @see Any non natural number (number<0) will be considered as: null. 
	*/
	public BigNumber(BigNumber other) 
	{
		if(other != null)
		{
			IntNode curr = other._head;
			IntNode last = null;
			while (curr != null) 
			{
				IntNode node = new IntNode(curr.getValue(), null);
				if (_head == null) 
				{
					_head = node; //Creating the first node, this command will run only once.
				} 
				else 
				{
					last.setNext(node);
				}
				last = node;
				curr = curr.getNext();
			}
		}
		else //Edge case when other is out of range.
		{
			_head = null;
		}
	}//end of copy constructor.
	
	
	
	
	//Public methods:
	/**
	* This method returns a String representation of a BigNumber object.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(n).
	* @return StringRepresentation A String representation of a BigNumber object.
	*/
	public String toString() 
	{
		if(_head != null) 
		{
			String StringRepresentation = toString(_head);
			return (StringRepresentation);
		}
		else //Edge case when _head is null.
		{
			return (null);
		}
	}//End of toString method.
	
	
	/**
	* This method calculates the sum of two BigNumber objects.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(n).
	* @param other The BigNumber object to be added to the BigNumber object applying this method.
	* @return bigNumberSum The sum of two BigNumber objects. 
	* any (notNullNumber + null) or (null + notNullNumber) will return: notNullNumber.  
	* (null + null) will return: null.
	*/
	public BigNumber addBigNumber(BigNumber other) 
	{
		//Edge cases with null.
		if((_head != null)&&(other._head == null))
		{
			BigNumber bigNumberSum = new BigNumber(this);
			return (bigNumberSum);
		}
		if((_head == null)&&(other._head != null))
		{
			BigNumber bigNumberSum = new BigNumber(other);
			return (bigNumberSum);
		}
		if((_head == null)&&(other._head == null))
		{
			return (null);
		}	
		IntNode otherBigNumberCurrentNode = other._head;
		IntNode thisBigNumberCurrentNode = _head;
		IntNode last = null;
		IntNode first = null;
		int borrowDigit = 0;
		while ((otherBigNumberCurrentNode != null) || (thisBigNumberCurrentNode != null)) 
		{
			int digOfBigNumberSum = borrowDigit;
			if (otherBigNumberCurrentNode != null) 
			{
				digOfBigNumberSum = digOfBigNumberSum + otherBigNumberCurrentNode.getValue();
			}
			if (thisBigNumberCurrentNode != null) 
			{
				digOfBigNumberSum = digOfBigNumberSum + thisBigNumberCurrentNode.getValue();
			}
			IntNode node = new IntNode((digOfBigNumberSum%10), null);
			if (last != null) 
			{
				last.setNext(node);
			}
			if (first == null) 
			{
				first = node;
			}
			last = node;
			borrowDigit = digOfBigNumberSum / 10;
			if (otherBigNumberCurrentNode != null)
			{
				otherBigNumberCurrentNode = otherBigNumberCurrentNode.getNext();
			}	
			if (thisBigNumberCurrentNode != null)
			{
				thisBigNumberCurrentNode = thisBigNumberCurrentNode.getNext();
			}	
		}
		if (borrowDigit > 0) 
		{
			last.setNext(new IntNode(borrowDigit, null));
		}
		BigNumber bigNumberSum = new BigNumber();
		bigNumberSum._head = first;
		return (bigNumberSum);
	}//End of addBigNumber method.

	
	/**
	* This method calculates the sum of a BigNumber object with a type long number.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(n).
	* @param num The type long number to be added to the BigNumber object applying this method.
	* @return bigNumberSum The sum of the BigNumber object with the type long number.
	* any (notNullNumber + null) or (null + notNullNumber) will return: notNullNumber. 
	*/
	public BigNumber addLong(long num) 
	{
		BigNumber other = new BigNumber(num);
		BigNumber bigNumberSum = addBigNumber(other);
		return (bigNumberSum);
	}//End of addLong method.
	
	
	/**
	* This method calculates the subtraction of two BigNumber objects.
	* This method will subtract the small BigNumber object from the big BigNumber object.
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(n).
	* @param other The BigNumber object to be subtracted with the BigNumber object applying this method.
	* @return bigNumberSubtraction The subtraction of two BigNumber objects (bigNumberSubtraction will never be negative).
	* any (notNullNumber - null) or (null - notNullNumber) will return: notNullNumber.  
	* (null - null) will return: null.
	*/
	public BigNumber subtractBigNumber(BigNumber other) 
	{
	//Edge cases with null.
		if((_head != null)&&(other._head == null))
		{
			BigNumber bigNumberSum = new BigNumber(this);
			return (bigNumberSum);
		}
		if((_head == null)&&(other._head != null))
		{
			BigNumber bigNumberSum = new BigNumber(other);
			return (bigNumberSum);
		}
		if((_head == null)&&(other._head == null))
		{
			return (null);
		}
		IntNode nodeOfSmallBigNumber;
		IntNode nodeOfBigBigNumber;
		if (this.compareTo(other) == THIS_IS_SMALLER) 
		{
			nodeOfSmallBigNumber = _head;
			nodeOfBigBigNumber = other._head;
		}
		else
		{
			nodeOfSmallBigNumber = other._head;
			nodeOfBigBigNumber = _head;
		}
		IntNode last = null;
		IntNode first = null;
		int borrowDigit = 0;
		while (nodeOfBigBigNumber != null) 
		{
			int digOfBigNumberSubtraction = borrowDigit + nodeOfBigBigNumber.getValue();
			if (nodeOfSmallBigNumber != null) 
			{
				digOfBigNumberSubtraction = digOfBigNumberSubtraction - nodeOfSmallBigNumber.getValue();
				nodeOfSmallBigNumber = nodeOfSmallBigNumber.getNext();
			}
			if ((nodeOfBigBigNumber.getNext() != null) || (digOfBigNumberSubtraction > 0))
			{
				if (digOfBigNumberSubtraction < 0) 
				{
					digOfBigNumberSubtraction = digOfBigNumberSubtraction + 10;
					borrowDigit = -1;
				} 
				else 
				{
					borrowDigit = 0;
				}
				IntNode node = new IntNode(digOfBigNumberSubtraction, null);
				if (last != null) 
				{
					last.setNext(node);
				}
				if (first == null) 
				{
					first = node;
				}
				last = node;
			}
			nodeOfBigBigNumber = nodeOfBigBigNumber.getNext();
		}
		BigNumber bigNumberSubtraction = new BigNumber();	
		bigNumberSubtraction._head = first;
		fixNumber(bigNumberSubtraction._head);
		if(bigNumberSubtraction._head == null)
		{
			bigNumberSubtraction._head = new IntNode(NODE_WITH_A_VALUE_OF_ZERO, null);
		}
		return (bigNumberSubtraction);
	}//End of subtractBigNumber method.

	
	/**
	* This method calculates the multiplication of two BigNumber objects.
	* This algorithms TIME COMPLEXITY is O(n^2).
	* This algorithms SPACE COMPLEXITY is O(n).
	* @param other The BigNumber object to be multiplied with the BigNumber object applying this method.
	* @return bigNumberMultiplication The multiplication of two BigNumber objects.
	* any (notNullNumber * null) or (null * notNullNumber) will return: null.  
	* (null * null) will return: null.
	*/
	public BigNumber multBigNumber(BigNumber other) 
	{
		if((_head == null)||(other._head == null))//Edge cases with null.
		{
			return (null);
		}
		if((checkIfZero(_head))||(checkIfZero(other._head)))//Edge cases with 0.
		{
			BigNumber bigNumberMultiplication = new BigNumber();
			return (bigNumberMultiplication);
		}
		IntNode node = _head;
		BigNumber bigNumberMultiplication = new BigNumber();
		int indexOfDigits = 0;
		while(node != null) 
		{
			int CounterToCurrDigit = 0;
			BigNumber localMultiplication = new BigNumber();
			while(CounterToCurrDigit<node.getValue())
			{
				localMultiplication = localMultiplication.addBigNumber(other);
				CounterToCurrDigit++;
			}
			if (indexOfDigits > 0) 
			{
				IntNode addZeros = new IntNode(NODE_WITH_A_VALUE_OF_ZERO, localMultiplication._head);
				for (int i = 0; i < indexOfDigits-1; i++) 
				{
					addZeros = new IntNode(NODE_WITH_A_VALUE_OF_ZERO, addZeros);
				}
				localMultiplication._head = addZeros;
			}
			indexOfDigits++;
			node = node.getNext();
			bigNumberMultiplication = bigNumberMultiplication.addBigNumber(localMultiplication);
		}
		return (bigNumberMultiplication);
	}//End of multBigNumber method.

	
	/**
	* This method checks if the value of the BigNumber that applied this method is greater, smaller or equal to the value of another BigNumber Object. 
	* This algorithms TIME COMPLEXITY is O(n).
	* This algorithms SPACE COMPLEXITY is O(1).
	* @param other The BigNumber object to be compared with the BigNumber object applying this method.
	* @return methodResult Will return 1 if (this is bigger than other), 0 if (this is smaller than other), or -1 otherwise.
	* if one of the objects is null, this method will return -2.
	*/
	public int compareTo(BigNumber other) 
	{
		if((_head != null)&&(other._head != null))
		{
			IntNode otherCurr = other._head;
			IntNode thisCurr = _head;
			int methodResult = THIS_IS_EQUAL;
			while ((otherCurr != null)&&(thisCurr != null)) 
			{
				if (thisCurr.getValue() > otherCurr.getValue()) 
				{
					methodResult = THIS_IS_BIGGER;
				}
				if (thisCurr.getValue() < otherCurr.getValue()) 
				{
					methodResult = THIS_IS_SMALLER;
				}
				otherCurr = otherCurr.getNext();
				thisCurr = thisCurr.getNext();
			}
			if ((otherCurr == null)&&(thisCurr != null)) 
			{
				return (THIS_IS_BIGGER);
			}
			if ((otherCurr != null)&&(thisCurr == null)) 
			{
				return (THIS_IS_SMALLER);
			}
			return (methodResult);
		}
		return (-2);
	}//End of compareTo method.
	
	
	
	
	//Private methods:
	//This method returns a reversed string representation of a list
	//This algorithms TIME COMPLEXITY is O(n).
	//This algorithms SPACE COMPLEXITY is O(n).
	private String toString(IntNode curr) 
	{
		if (curr == null) 
		{
			return (EMPTY_STRING);
		}
		return (toString(curr.getNext()) + curr.getValue());
	}//End of toString method.
	
	
	//This method checks if a list is comprised of only zeros.
	//This algorithms TIME COMPLEXITY is O(n).
	//This algorithms SPACE COMPLEXITY is O(1).
	private boolean checkIfZero(IntNode nodeToCheck) 
	{
		while (nodeToCheck != null) 
		{
			if (nodeToCheck.getValue() > NODE_WITH_A_VALUE_OF_ZERO) 
			{
				return (false);
			}
			nodeToCheck = nodeToCheck.getNext();
		}
		return (true);
	}//End of checkIfZero method.
	
	
	//This method deletes zeros from the end of a list
	//if node is: 1->2->3->0->0->null
	//it will change it to: 1->2->3->null
	//This algorithms TIME COMPLEXITY is O(n).
	//This algorithms SPACE COMPLEXITY is O(n).
	private boolean fixNumber(IntNode node)
	{
		if (node == null)
			{
				return (false);
			}
		if ((node.getValue() == NODE_WITH_A_VALUE_OF_ZERO) && (node.getNext() == null))
			{
				return (true);
			}
		if (fixNumber(node.getNext()))
		{
			node.setNext(null);
			return (node.getValue() == NODE_WITH_A_VALUE_OF_ZERO);
		}
		return (false);
	}//End of fixNumber method.
	
	
	
}//End of BigNumber Class.



