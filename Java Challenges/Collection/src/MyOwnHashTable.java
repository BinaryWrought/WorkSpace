/*
 * This is free to use as it was only made for practice.
 */

import java.util.Scanner;

/**
 * This is an implementation of a hash-table using only arrays as suggested for a Google technical screen.
 * 
 * I'm including this challenge because it was specifically requested by Google.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */

/**
 * This class is a bucket for a hashtable
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 */
class HashEntry
{
    private int key;
    private int value;
    
    /**
     * Default constructor takes a key, value pair
     * @param key   the key to the value
     * @param value the value to be stored at the key
     */
    HashEntry( int key, int value )
    {
        this.key = key;
        this.value = value;
    }
    
    /**
     * Get the key for this bucket
     * @return 
     */
    public int getKey()
    {
        return key;
    }
    
    /**
     * Get the value for this bucket
     * @return 
     */
    public int getValue()
    {
        return value;
    }
}

/**
 * A class to implement a hashtable using the hashentry as a bucket
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 */
class MyHashTable
{     
   private final static int TABLE_SIZE = 128;
   
   HashEntry[] table;
   
   /**
    * Default constructor for MyHashTable creates the table as an array of HashEntry with a fixed size and sets all buckets to null
    */
   MyHashTable()
   {
       table = new HashEntry[TABLE_SIZE];
       for( int i = 0; i < TABLE_SIZE; i++ )
           table[i] = null;
   }
   
   /**
    * This method will get the value for the specified key
    * @param key the key to the value being sought
    * @return the value of the buck with specified key
    */
   public int get( int key )
   {
       int hash = key % TABLE_SIZE;
       while( table[hash] != null && table[hash].getKey() != key )  //
           hash = ( hash + 1 ) % TABLE_SIZE;
       if( table[hash] == null )
           return -1;
       else
           return table[hash].getValue();
   }
   
   /**
    * This method will put a new key, value pair in the table
    * @param key the key for this bucket
    * @param value the value to be stored at this key
    */
   public void put( int key, int value )
   {
       int hash = (key % TABLE_SIZE);
       while( table[hash] != null && table[hash].getKey() != key)
           hash = (hash + 1) % TABLE_SIZE;
       table[hash] = new HashEntry(key, value);
   }
}

public class MyOwnHashTable
{

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) 
	{
		Scanner scanner = new Scanner( System.in );													//create a scanner object to get user input
		try																							//this try block is to catch the inevitable exception caused by the user quitting 
		{
			int t = scanner.nextInt();																//get number of test cases
            
            while( t > 0 )																			//So long as there are more test cases
			{		
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}