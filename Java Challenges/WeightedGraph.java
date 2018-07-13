/*
 * This is free to use as it was only made for practice.
 */

import java.util.*;

/**
 * This is an implementation of a weighted graph.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 * @param <E> the object that will represent nodes
 */
public class WeightedGraph<E> 
{
    private LinkedList< LinkedList< Edge > > adjacencyList;
    private LinkedList< E > labels;
    
    /**
     * Default constructor
     */
    WeightedGraph()
    {
        adjacencyList = new LinkedList<>();
        labels = new LinkedList<>();
    }        
    
    /**
     * Method to add an edge to the graph
     * @param src the source node from which the edge will extend
     * @param dest the destination node to which the edge will go
     * @param wt the weight of the new edge
     * @throws ArrayIndexOutOfBoundsException 
     */
    public void addEdge( int src, int dest, int wt ) throws ArrayIndexOutOfBoundsException
    {
        if( src >= labels.size() || dest >= labels.size() )
            throw new ArrayIndexOutOfBoundsException( "Given vertex does not exist." );
        else
        {
            Edge edge = new Edge( src, dest, wt );
            adjacencyList.get( src ).add(edge);
        }
    }

    /**
     * Method to add a new vertex (node) to the graph
     * @param e the new node to be added to the graph
     */
    public void addVertex( E e )
    {
        labels.add( e );
        adjacencyList.add( new LinkedList<>() );
    }

    /**
     * Method to print the entire contents of the graph including the weights of the edges.
     */
    public void printGraph()
    {
        for( int i = 0; i < labels.size(); ++i )
        {
            LinkedList<Edge> list = adjacencyList.get( i );
            for( int j = 0; j < list.size(); ++j )
            {
                System.out.println( labels.get( i ) + " is connected to " + labels.get( list.get( j ).destination ) + " with weight " + list.get( j ).weight );
            }
        }
    }
    
    /**
     * Method to remove an edge from the graph.
     * @param src the node from which the edge to be removed
     * @param dest the destination of the edge that is being removed
     * @throws ArrayIndexOutOfBoundsException 
     */
    public void removeEdge( int src, int dest ) throws ArrayIndexOutOfBoundsException
    {
        if( src >= labels.size() || dest >= labels.size() )
            throw new ArrayIndexOutOfBoundsException( "Given vertex does not exist." );
        else
        {
            for( int i = 0; i < adjacencyList.get( src ).size(); ++i )
            {
                if( adjacencyList.get( src ).get( i ).destination == dest )
                    adjacencyList.get( src ).remove( i );
            }
        }
    }
    
    /**
     * Private class to represent an edge in the graph
     */
    private static class Edge
    {
        int destination;
        int source;
        int weight;
        
        /**
         * Constructor for an edge requires the source, destination and weight of the edge.
         * @param src the source node from which the edge will go
         * @param dest the destination node to which the edge will go
         * @param wt the weight of this edge
         */
        Edge( int src, int dest, int wt )
        {
            source = src;
            destination = dest;
            weight = wt;
        }
    }
}
