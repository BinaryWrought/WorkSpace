/*
 * This is free to use as it was only made for practice.
 */

import java.util.*;

/**
 * This is an implementation of a weighted graph.
 * The nodes can be any object, so can the weights.
 * Testing was done specifically with String nodes and Integer weights.
 * When printing the contents of the graph it calls the node's toString function so be sure that is
 * defined with a desirable format.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 * @param <E> this is the object of the nodes in the graph
 * @param <W> this is the object of the weights of the edges
 */
public class VersatileGraph<E, W> 
{
    private boolean directed = true;
    private int initialCapacity = 16;    
    private float loadFactor = 0.75f;
    private final HashMap< E, HashMap< E, W > > nodes;
        
    /**
     * Default constructor uses default initial capacity and load factor
     */
    VersatileGraph()
    {
        nodes = new HashMap<>( initialCapacity, loadFactor );
    }
    
    /**
     * Default constructor uses default initial capacity and load factor
     * @param d indicate if this graph is directed (true) or undirected (false)
     */
    VersatileGraph( boolean d )
    {
        directed = d;
        nodes = new HashMap<>( initialCapacity, loadFactor );
    }
    
    /**
     * Constructor where the user supplies the initial capacity but load factor uses the default
     * @param ic the initial capacity of the graph
     */
    VersatileGraph( int ic )
    {
        initialCapacity = ic;
        nodes = new HashMap<>( ic, loadFactor );
    }
    
    /**
     * Constructor where the user supplies the initial capacity but load factor uses the default
     * @param d indicate if this graph is directed (true) or undirected (false)
     * @param ic the initial capacity of the graph
     */
    VersatileGraph( boolean d, int ic )
    {
        directed = d;
        initialCapacity = ic;
        nodes = new HashMap<>( ic, loadFactor );
    }
    
    /**
     * Constructor where the user specifies both the initial capacity and the load factor
     * @param ic the initial capacity of the graph
     * @param lf the load factor for the graph
     */
    VersatileGraph( int ic, float lf )
    {
        loadFactor = lf;
        initialCapacity = ic;
        nodes = new HashMap<>( ic, lf );
    }
    
    /**
     * Constructor where the user specifies both the initial capacity and the load factor
     * @param d indicate if this graph is directed (true) or undirected (false)
     * @param ic the initial capacity of the graph
     * @param lf the load factor for the graph
     */
    VersatileGraph( boolean d, int ic, float lf )
    {
        directed = d;
        loadFactor = lf;
        initialCapacity = ic;
        nodes = new HashMap<>( ic, lf );
    }
    
    /**
     * Method to add edges between nodes.
     * @param src the source node of the edge
     * @param dest the destination node of the edge
     * @param wt the weight for this edge
     */
    public void addEdge( E src, E dest, W wt )
    {
        if( !nodes.containsKey( src ) )
            nodes.put( src, new HashMap<>( initialCapacity, loadFactor ) );
        if( !nodes.containsKey( dest ) )
            nodes.put( dest, new HashMap<>( initialCapacity, loadFactor ) );

        nodes.get( src ).put(dest, wt);
        if( !directed )
            nodes.get( dest ).put( src, wt );
    }

    /**
     * Method to add a new vertex (node) to the graph
     * @param node the node (vertex) being added.
     */
    public void addVertex( E node )
    {
        if( !nodes.containsKey( node ) )
            nodes.put( node, new HashMap<>( initialCapacity, loadFactor ) );
    }
    
    /**
     * Method to demonstrate breadth first traversal through the graph
     * @param start the node to start the traversal from
     * @return A string that is the result of the bread first traversal
     */
    public String breadthFirstTraversal( E start )
    {
        if( !nodes.containsKey( start ) )   //the specified node doesn't exist
            return "The given start node does not exist in the graph.";

        String result = "";
                
        //all vertices start as "not visited"
        HashSet<E> visited = new HashSet<>( size() );
        Queue<E> queue = new LinkedList<>();
        
        //Mark the current node as visited and queue it
        visited.add( start );
        queue.add( start );
        
        while( !queue.isEmpty() )
        {
            //dequeue a vertex and print it
            start = queue.poll();
            result += start.toString() + " ";
            
            //Get adjacent vertices of dequeued vertex
            //if adjacent has not been visited then mark it as visited
            for( E e : nodes.get( start ).keySet() )
            {
                if( !visited.contains( e ) )
                {
                    visited.add( e );
                    queue.add( e );
                }
            }
        }
        return result;
    }
    
    /**
     * Method to get the total number of edges connected to the specified node
     * @param src the node for which degree is sought
     * @return the number of edges connected to the given node
     */
    public int degree( E src )
    {
        if( !nodes.containsKey( src ) )
            return 0;
        else return nodes.get( src ).size();
    }
    
    /**
     * Method to illustrate a depth first traversal algorithm
     * @param start the node at which to start the depth first traversal
     */
    public String depthFirstTraversal( E start )
    {
        if( !nodes.containsKey( start ) )
            return "Given node not found in graph.";

        HashSet<E> marked = new HashSet<>( size() );
        return depthFirstTraversal( start, marked );
    }
    
    /**
     * This method gets the shortest path to every node from the specified start node.
     * @param start the node from which the pathing should start
     */
    public void dijkstraPath( E start, HashMap< E, E > parents, HashMap< E, Integer > distances )
    { 
        int initCap = (int)( size() / loadFactor ) + 1;
        
        // added.contains(e) will be true if 
        // vertex e is included / in shortest path tree
        // or shortest distance from src to e is finalized
        HashSet< E > added = new HashSet<>( initCap );
 
        // Initialize all distances as INFINITE
        for( E e: nodes.keySet() )
            distances.put( e, Integer.MAX_VALUE );
         
        // Distance of source vertex from itself is always 0
        distances.put( start, 0 ); 
        // The starting vertex does not have a parent
        parents.put( start, null );
 
        // Find shortest path for all vertices
        for (int i = 1; i < size(); i++)
        {
            // Pick the minimum distance vertex from the set of vertices not yet processed. 
            // nearestVertex is always equal to startNode in first iteration.
            E nearestVertex = null;
            int shortestDistance = Integer.MAX_VALUE;
            for( E e: nodes.keySet() )
            {
                if ( !added.contains( e ) && distances.get( e ) < shortestDistance ) 
                {
                    nearestVertex = e;
                    shortestDistance = distances.get( e );
                }
            }
 
            // Mark the picked vertex as processed
            added.add( nearestVertex );
            
            HashMap< E, W > neighbors = nodes.get( nearestVertex );
 
            // Update dist value of the adjacent vertices of the picked vertex.
            for( Map.Entry<E, W> m: neighbors.entrySet()) 
            {
                int edgeDistance = (Integer)m.getValue();

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < distances.get( m.getKey() ) ) ) 
                {
                    parents.put( m.getKey(), nearestVertex );
                    distances.put( m.getKey(), shortestDistance + edgeDistance );
                }
            }
        }       
    }
            
    /**
     * Method to get a string representation of each node on its own line with its edges, and their weights
     * @return the string representation of the graph
     */
    public String getGraphAsString()
    {
        String result = "";
        for( Map.Entry< E, HashMap< E, W > > m : nodes.entrySet() )
        {
            result += m.getKey() + ": ";
            for( Map.Entry< E, W > n : m.getValue().entrySet() )
            {
                result += n.getKey() + "(" + n.getValue() + ") ";
            }
        }
        return result;
    }
    
    /**
     * Method to test if an edge exists between the two nodes
     * @param src the source node to check from which there is an edge
     * @param dest the destination not to check if it is connected from the source
     * @return true if there is an edge from source to destination
     */
    public boolean isEdge( E src, E dest )
    {
        if( !nodes.containsKey( src ) )
            return false;
        else return nodes.get( src ).containsKey( dest );
    }
    
    /**
     * Method to determine if a path exists from some source node to some destination node.
     * This uses breadth-first to traverse the graph
     * @param src the node to start the traversal from
     * @param dest the desired end node of the path
     * @return true when a path between the specified nodes exists, otherwise false
     */
    public boolean pathExists( E src, E dest )
    {
        if( src.equals( dest ) )                                            //source and destination are the same so the path exists - trivial case
            return true;
        
        if( !nodes.containsKey( src ) || !nodes.containsKey( dest ) )       //either node doesn't even exist
            return false;
        
        //all vertices start as "not visited"
        HashSet<E> visited = new HashSet<>( size() );
        Queue<E> queue = new LinkedList<>();
        
        //Mark the current node as visited and queue it
        visited.add( src );
        queue.add( src );
        
        while( !queue.isEmpty() )
        {
            //dequeue a vertex and print it
            E node = queue.poll();
            if( node.equals( dest ) )   //proved a path exists
                return true;
            
            //Get adjacent vertices of dequeued vertex
            //if adjacent has not been visited then mark it as visited
            for( E e : nodes.get( node ).keySet() )
            {
                if( !visited.contains( e ) )
                {
                    visited.add( e );
                    queue.add( e );
                }
            }
        }
        //if we made it here without finding the destination edge, then the path does not exist
        return false;
    }
    
    /**
     * Recursive method to print the path to the node specified
     * @param cNode the node to which the path is sought
     * @param parents a map of the shortest path parents to each node
     */
    public void printPath( E cNode, HashMap< E, E > parents )
    {
        if( parents.get( cNode ) == null )
            return;
        printPath( parents.get( cNode ), parents );
        System.out.print( cNode.toString() + " " );
    }
    
    /**
     * Recursive method to print the path to the node specified
     * @param cNode the node to which the path is sought
     * @param parents a map of the shortest path parents to each node
     * @return a string representing the path
     */
    public String getPathString( E cNode, HashMap< E, E > parents )
    {
        StringBuilder sb = new StringBuilder("");
        sb.append( cNode + " " );
        if( parents.get( cNode ) != null )
            sb.insert( 0, getPathString( parents.get( cNode ), parents ) );

        return sb.toString();        
    }
    
    /**
     * Method to remove a connecting edge from the source specified to the specified destination
     * @param src the node from which the edge is to be removed
     * @param dest the node to which the edge is to be removed
     */
    public void removeEdge( E src, E dest )
    {
        nodes.get( src ).remove( dest );
        if( !directed )
            nodes.get( dest ).remove( src );
    }
    
    /**
     * Method to remove an entire node from the graph.
     * @param src the node to be removed
     */
    public void removeNode( E src )
    {
        for( Map.Entry< E, HashMap< E, W > > m : nodes.entrySet() )
            m.getValue().remove( src );

        nodes.remove( src );
    }
        
    /**
     * Method to get the total number of nodes currently in the graph.
     * @return the number of nodes in the graph
     */
    public int size()
    {
        return nodes.size();
    }
    
    /**
     * Recursive method to demonstrate a depth first algorithm.
     * @param v the node being visited on this recursive call
     * @param marked a set of nodes that has already been visited
     * @return a string representing the node at the current depth in this recursive call
     */
    private String depthFirstTraversal( E v, HashSet<E> marked )
    {
        StringBuilder sb = new StringBuilder("");
        
        marked.add( v );
        sb.append( v.toString() + " " );
        
        //Traverse all the neighbors looking for unmarked vertices
        for( E next: nodes.get( v ).keySet() )
        {
            if( !marked.contains( next ) )
                sb.append( depthFirstTraversal( next, marked ) );
        }
        return sb.toString();
    }
}
