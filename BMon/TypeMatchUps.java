import java.util.Arrays;
import java.util.EnumMap;

/**
 * This enum class represents all of the elemental types in BMon.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class TypeMatchUps
{
    
    // These arrays represent defense
    // Types are balanced such that each type has 3 strengths, 3 neutrals, and 3 weaknesses
    // This makes all single types have a net power of zero ( 0 + 0 + 0 + 1 + 1 + 1 - 1 - 1 - 1 = 0 )
    // Also all dual types have a net power of zero.
    // Analysis shows that of all possible dual types the most -2 = 2, -1 = 5, 0 = 7,  1= 4, 2 = 2      -   excluding the Dark/Light dual type that is 9 zeros
    private final static Integer[] LIGHT =      { -1, -1, 0, 0, 0, -1, 1, 1, 1 };
    private final static Integer[] FIRE =       { -1, 0, -1, 1, 1, 0, -1, 1, 0 };
    private final static Integer[] AIR =        { 1, 0, -1, 1, -1, 1, -1, 0, 0 }; 
    private final static Integer[] WATER =      { 0, -1, 1, 0, -1, 1, 1, 0, -1 };
    private final static Integer[] NEUTRAL =    { 0, 1, 1, -1, 0, -1, 1, -1, 0 };
    private final static Integer[] ELECTRIC =   { 0, -1, 0, -1, 1, -1, 0, 1, 1 };
    private final static Integer[] PLANT =      { -1, 1, -1, -1, 1, 0, 0, 0, 1 };
    private final static Integer[] ROCK =       { 1, 0, 1, 1, -1, 0, 0, -1, -1 };
    private final static Integer[] DARK =       { 1, 1, 0, 0, 0, 1, -1, -1, -1 };
    
    // This enum map has each element as a key with its defense array as the value
    // With this if one wants to know how a WATER attack would affect fire type BMon do this:
    // TYPES.get(FIRE)[WATER.ordinal()];
    // To explain: The BMon is of type FIRE, so use that as the key to the TYPES map, the attack was WATER so use its ordinal to find the affect of water on fire.
    private static final EnumMap< Elements, Integer[] > TYPES = new EnumMap<>( Elements.class );
    
    /**
     * Default constructor
     * Puts all of the elemental types with their defense array into the TYPES map
     */
    public TypeMatchUps()
    {
        TYPES.put( Elements.FIRE, FIRE );
        TYPES.put( Elements.WATER, WATER );
        TYPES.put( Elements.PLANT, PLANT );
        TYPES.put( Elements.AIR, AIR );
        TYPES.put( Elements.ELECTRIC, ELECTRIC );
        TYPES.put( Elements.ROCK, ROCK );
        TYPES.put( Elements.LIGHT, LIGHT );
        TYPES.put( Elements.DARK, DARK );
        TYPES.put( Elements.NEUTRAL, NEUTRAL );
    }
    
    /**
     * This method will combine two elemental defense arrays into a new dual-type
     * @param one the first elemental type
     * @param two the second elemental type
     * @return an array of defense for the specified dual type
     */
    public Integer[] getDualType( Elements one, Elements two )
    {
        Integer[] result = new Integer[ Elements.values().length ];
        for( int i = 0; i < Elements.values().length; ++i )
        {
            result[i] = TYPES.get( one )[ i ] + TYPES.get( two )[ i ];
        }
        return result;
    }
    
    /**
     * This method will print the arrays showing a dual type BMon's defense array
     * It can also be made to show how an inbound attack would affect this BMon
     * @param withInboundAttacks when true this method will also print the affect of each type of inbound attack
     */
    public void printAllDualTypes( boolean withInboundAttacks )
    {
        for( Elements e: Elements.values() )
        {           
            Elements x = e.nextLinear();
            while( x != null )
            {
                Integer[] temp = getDualType( e, x );
                System.out.println( e.name() + "/" + x.name() + ": " + Arrays.toString( temp ) );
                     
                if( withInboundAttacks )
                {
                    for( Elements atk: Elements.values() )
                    {
                        System.out.println( atk.name() + " attack vs " + e.name() + "/" + x.name() + ": " + temp[ atk.ordinal() ] );
                    }
                }
                x = x.nextLinear();
            }
        } 
    }

    /**
     * This method will print which dual types have the most match ups (highest -2s, -1s, 0s, 1s, and 2s )
     * @param typeArray 
     */
    public void potentDualTypes()
    {
        String negTwo = "Negative Twos: ", negOne = "Negative Ones: ", zeros = "Zeros: ", ones = "Ones: ", twos = "Twos: ";
        for( Elements e: Elements.values() )
        {           
            Elements x = e.nextLinear();
            while( x != null )
            {
                Integer[] temp = getDualType( e, x );
                int neg2 = 0, neg1 = 0, zero = 0, one = 0, two = 0;
                for( int i = 0; i < temp.length; ++i )
                {
                    if( temp[ i ] == -2 )
                        neg2++;
                    if( temp[ i ] == -1 )
                        neg1++;
                    if( temp[ i ] == 0 )
                        zero++;
                    if( temp[ i ] == 1 )
                        one++;
                    if( temp[ i ] == 2 )
                        two++;
                }
                
                // The constants here are values that were calculated previously for the max occurance of various strengths and weaknesses
                // The purpose of this method is to find all of the dual types that have the specified quantities of strengths and weaknesses
                if( neg2 == 2 )
                    negTwo += e.name() + "/" + x.name() + " ";
                if( neg1 == 5 )
                    negOne += e.name() + "/" + x.name() + " ";
                if( zero == 7 )
                    zeros += e.name() + "/" + x.name() + " ";
                if( one == 4 )
                    ones += e.name() + "/" + x.name() + " ";
                if( two == 2 )
                    twos += e.name() + "/" + x.name() + " ";
                
                x = x.nextLinear();
            }
        }
        
        System.out.println( negTwo );
        System.out.println( negOne );
        System.out.println( zeros );
        System.out.println( ones );
        System.out.println( twos );
    }
}