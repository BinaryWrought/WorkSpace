/*
 * This is free to use as it was only made for practice.
 */

/**
 * This a heap utility class.
 * 
 * One can pass an array to an instance of this class to get the array as a max heap or a min heap.
 * Also, one can sort the array using heap sort into ascending or descending order.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class HeapUtility 
{

    /**
     * Method to sort the heap into ascending order
     * @param arr the array that is to be sorted
     * @return the sorted array
     */
    public int[] heapSortAscending( int arr[] )
    {
        int n = arr.length;
        
        for( int i = n / 2 - 1; i >= 0; i-- )   //this loop converts the array into a max heap
            maxHeapify( arr, n, i );
        
        for( int i = n - 1; i >= 0; i-- )       //this loop does the sorting by swapping the root with the last node and then reheapifying
        {
            // Move current root to end
            int temp = arr[ 0 ];
            arr[ 0 ] = arr[ i ];
            arr[ i ] = temp;
 
            // call heapify on the reduced heap
            maxHeapify( arr, i, 0 );
        }
        return arr;
    }
    
    /**
     * Method to sort the heap into descending order
     * @param arr the array to be sorted
     * @return the sorted array
     */
    public int[] heapSortDescending( int arr[] )
    {
        int n = arr.length;
        
        for( int i = n / 2 - 1; i >= 0; i-- )   //this loop converts the array into a min heap
            minHeapify( arr, n, i );
        
        for( int i = n - 1; i >= 0; i-- )         //this loop does the sorting by swapping the root with the last node then reheapifying
        {
            // Move current root to end
            int temp = arr[ 0 ];
            arr[ 0 ] = arr[ i ];
            arr[ i ] = temp;
 
            // call heapify on the reduced heap
            minHeapify( arr, i, 0 );
        }
        return arr;
    }
    
    /**
     * Method to turn an array into a max heap
     * @param arr the array that is to be converted to a max heap
     * @param n the size of the subtree currently being heapified
     * @param i the index of the element that violates the heap
     */
    public void maxHeapify( int[] arr, int n, int i ) 
    {
        int largest = i;        // Initialize largest as root
        int l = left( i );      // left = 2*i + 1
        int r = right( i );     // right = 2*i + 2
 
        // If left child is larger than root
        if( l < n && arr[ l ] > arr[ largest ] )
            largest = l;
 
        // If right child is larger than largest so far
        if( r < n && arr[ r ] > arr[ largest ] )
            largest = r;
 
        // If largest is not root
        if( largest != i )
        {
            int swap = arr[ i ];
            arr[ i ] = arr[ largest ];
            arr[ largest ] = swap;
 
            // Recursively heapify the affected sub-tree
            maxHeapify( arr, n, largest );
        }
    }
    
    /**
     * Method to turn an array into a min heap
     * @param arr the array that is to be converted to a min heap
     * @param n the size of the subtree currently being heapified
     * @param i the index of the element that violates the heap
     */
    public void minHeapify( int[] arr, int n, int i ) 
    {
        int smallest = i;       // Initialize smallest as root
        int l = left( i );      // left = 2*i + 1
        int r = right( i );     // right = 2*i + 2
 
        // If left child is smaller than root
        if( l < n && arr[ l ] < arr[ smallest ] )
            smallest = l;
 
        // If right child is smaller than largest so far
        if( r < n && arr[ r ] < arr[ smallest ] )
            smallest = r;
 
        // If smallest is not root
        if( smallest != i )
        {
            int swap = arr[ i ];
            arr[ i ] = arr[ smallest ];
            arr[ smallest ] = swap;
 
            // Recursively heapify the affected sub-tree
            minHeapify( arr, n, smallest );
        }
    }
    
    /**
     * Get the index of the node's left child
     * @param i the node for which a left child is sought
     * @return the index of the left child
     */
    private int left( int i )
    {
        return ( 2 * i + 1 );
    }
    
    /**
     * Get the index of the node's right child
     * @param i the node for which a right child is sought
     * @return the index of the right child
     */
    private int right( int i )
    {
        return ( 2 * i + 2 );
    }
    
}
