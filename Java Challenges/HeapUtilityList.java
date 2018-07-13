/*
 * This is free to use as it was only made for practice.
 */

import java.util.*;

/**
 * This a heap utility class.
 * 
 * One can pass an array to an instance of this class to get the array as a max heap or a min heap.
 * Also, one can sort the array using heap sort into ascending or descending order.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class HeapUtilityList 
{

    /**
     * Method to sort the heap into ascending order
     * @param arr the array that is to be sorted
     * @return the sorted array
     */
    public List<Integer> heapSortAscending( List<Integer> arr )
    {
        int n = arr.size();
        
        for( int i = n / 2 - 1; i >= 0; i-- )   //this loop converts the array into a max heap
            maxHeapify( arr, n, i );
        
        for( int i = n - 1; i >= 0; i-- )       //this loop does the sorting by swapping the root with the last node and then reheapifying
        {
            // Move current root to end
            int temp = arr.get( 0 );
            arr.set( 0, arr.get( i ) );
            arr.set( i, temp );
 
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
    public List<Integer> heapSortDescending( List<Integer> arr )
    {
        int n = arr.size();
        
        for( int i = n / 2 - 1; i >= 0; i-- )   //this loop converts the array into a min heap
            minHeapify( arr, n, i );
        
        for( int i = n - 1; i >= 0; i-- )         //this loop does the sorting by swapping the root with the last node then reheapifying
        {
            // Move current root to end
            int temp = arr.get( 0 );
            arr.set( 0, arr.get( i ) );
            arr.set( i, temp );
 
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
    public void maxHeapify( List<Integer> arr, int n, int i ) 
    {
        int largest = i;        // Initialize largest as root
        int l = left( i );      // left = 2*i + 1
        int r = right( i );     // right = 2*i + 2
 
        // If left child is larger than root
        if( l < n && arr.get( l ) > arr.get( largest ) )
            largest = l;
 
        // If right child is larger than largest so far
        if( r < n && arr.get( r ) > arr.get( largest ) )
            largest = r;
 
        // If largest is not root
        if( largest != i )
        {
            int swap = arr.get( i );
            arr.set( i, arr.get( largest ) );
            arr.set( largest, swap );
 
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
    public void minHeapify( List<Integer> arr, int n, int i ) 
    {
        int smallest = i;       // Initialize smallest as root
        int l = left( i );      // left = 2*i + 1
        int r = right( i );     // right = 2*i + 2
 
        // If left child is smaller than root
        if( l < n && arr.get( l ) < arr.get( smallest ) )
            smallest = l;
 
        // If right child is smaller than largest so far
        if( r < n && arr.get( r ) < arr.get( smallest ) )
            smallest = r;
 
        // If smallest is not root
        if( smallest != i )
        {
            int swap = arr.get( i );
            arr.set( i, arr.get( smallest ) );
            arr.set( smallest, swap );
 
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
