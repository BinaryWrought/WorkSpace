/*
 * This is free to use as it was only made for practice.
 */

/**
 * This is an implementation of a Max Binary Heap.
 * A max heap has its largest element at the root and each node is larger than its children.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class MaxHeap 
{
    private final int capacity;
    private final int[] data;
    private int size = 0;    
    
    /**
     * Default constructor
     * @param cap the maximum capacity of the heap
     */
    MaxHeap( int cap )
    {
        capacity = cap;
        data = new int[cap];
    }
    
    MaxHeap( int[] dat )
    {
        capacity = dat.length;
        data = new int[ dat.length ];
        for( int i = 0; i < dat.length; ++i )
        {
            insertKey( dat[ i ] );
        }        
    }
            
    /**
     * Method to return the data structure to a heap after adding a new element
     * @param i the last index of the heap that contains data
     */
    public void heapifyUp( int i )
    {
        int temp = data[ i ];
        while( temp > data[ parent( i ) ] && i > 0 )
        {
            data[ i ] = data[ parent( i ) ];
            i = parent( i );
        }
        data[ i ] = temp;
    }
    
    /**
     * Method to get the heap as a string with its elements space separated
     * @return a string representation of the current contents of the heap
     */
    @Override
    public String toString()
    {
        String result = "";
        for( int i = 0; i < size; ++i )
        {
            result += data[ i ] + " ";
        }
        return result;
    }
    
    /**
     * Method to remove the element at the specified index
     * @param i
     */
    void deleteKeyAt(int i)
    {
        data[ i ] = Integer.MIN_VALUE; 
        heapifyUp( i );
        extractMin();
    } 
 
    /**
     * Method to remove the lowest element from the heap
     * @return the lowest element from the heap, or Integer.MAX_VALUE if heap is empty
     */
    int extractMin()
    {
        if ( size <= 0 )
            return Integer.MAX_VALUE;
        if ( size == 1 )
        {
            size--;
            return data[ 0 ];
        }

        // Store the minimum value, and remove it from heap
        int root = data[ 0 ];
        data[ 0 ] = data[ size - 1 ];
        size--;
        heapifyDown( 0 );

        return root;
    }
 
    /**
     * Get the value of the root node
     * @return the value of the root node
     */
    int getMin() 
    { 
        return data[ 0 ]; 
    }
    
    /**
     * Method to turn an array into a max heap
     * @param dat
     * @param n
     * @param i 
     */
    void maxHeapify( int[] dat, int n, int i ) 
    {
        int largest = i;  // Initialize largest as root
        int l = left(i);  // left = 2*i + 1
        int r = right(i);  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && dat[l] > dat[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && dat[r] > dat[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = dat[i];
            dat[i] = dat[largest];
            dat[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            maxHeapify(dat, n, largest);
        }
    }
    
    /**
     * Method to recursively return the data structure to a heap
     * @param i the node currently being checked for heap consistency 
     */
    void heapifyDown( int i )
    {
        int l = left( i );
        int r = right( i );
        int smallest = i;
        if( l < size && data[ l ] > data[ i ] )
            smallest = l;
        if( r < size && data[ r ] > data[ smallest ] )
            smallest = r;
        if( smallest != i )
        {
            int temp = data[ i ];
            data[ i ] = data[ smallest ];
            data[ smallest ] = temp;
            heapifyDown( smallest );
        }
    }
    
    /**
     * Method to sort the heap into ascending order
     * @param arr
     * @return 
     */
    public int[] heapSortAscending( int arr[] )
    {
        int n = arr.length;
        
        for( int i = n / 2 - 1; i >= 0; i-- )
            maxHeapify( arr, n, i );
        
        for( int i = size-1; i >= 0; i-- )
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call heapify on the reduced heap
            maxHeapify( arr, i, 0 );
        }
        return arr;
    }
    
    /**
     * Method to add a new element to the heap
     * @param k the value of the element to be added to the heap
     */
    void insertKey( int k )
    {
        if ( isFull() )
            return;
        
        // First insert the new key at the end
        size++;
        int i = size - 1;
        data[ i ] = k;
        
        // Fix the heap property if it is violated
        heapifyUp( i );
    }
    
    /**
     * Method to check if the heap is currently empty
     * @return true if the heap is empty, false if not
     */
    boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * Method to check if the heap is full
     * @return true if the heap is full, false if not
     */
    boolean isFull()
    {
        return size == capacity;
    }
    
    /**
     * Get the index of the node's left child
     * @param i
     * @return
     */
    int left( int i )
    {
        return ( 2 * i + 1 );
    }
    
    /**
     * Get the index of the parent node of the given child
     * @param c the index of the child for which the parent is sought
     * @return the index of c's parent node
     */
    int parent( int c )
    {
        return ( c - 1 ) / 2;
    }
    
    /**
     * Get the index of the node's right child
     * @param i
     * @return
     */
    int right( int i )
    {
        return ( 2 * i + 2 );
    }
}