package bmon;

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
    // For example a FIRE type is attacked by FIRE = 0, by WATER = 1, by PLANT = -1 ... etc
    // Types are balanced such that each type has 3 strengths, 3 neutrals, and 3 weaknesses
    // This makes all single types have a net power of zero ( 0 + 0 + 0 + 1 + 1 + 1 - 1 - 1 - 1 = 0 )
    // Also all dual types have a net power of zero.
    private final static Integer[] AIR =        { 1, 1, -1, -1, 1, 0, 0, 0, -1 };
    private final static Integer[] DARK =       { 1, -1, 0, 0, 1, -1, 1, -1, 0 };
    private final static Integer[] EARTH =      { 0, 1, 1, 1, 0, -1, -1, -1, 0 };
    private final static Integer[] ELECTRIC =   { 0, 1, 0, -1, -1, 1, 0 ,1, -1 };
    private final static Integer[] FIRE =       { 0, 1, -1, -1, 0, 1, 0, 1, -1 };
    private final static Integer[] LIGHT =      { -1, 1, 1, 0, -1, 1, -1, 0, 0 };
    private final static Integer[] NEUTRAL =    { 1, -1, -1, 0, -1, 0, 1, 1, 0 };
    private final static Integer[] PLANT =      { 1, -1, 0, 0, 0, -1, -1, 1, 1 };
    private final static Integer[] WATER =      { 0, -1, 1, -1, 0, 1, 1, -1, 0 };
    // With the above type mapping:
    // most Super Absorbs = 3 = FIRE/AIR
    // most Absorbs = 5 = FIRE/LIGHT & AIR/DARK
    // most Neutral = 7 = WATER/EARTH & LIGHT/DARK
    // most Vulnerable = 4 = FIRE/AIR & WATER/AIR & PLANT/EARTH & EARTH/DARK
    // most Super Vulnerable = 3 = FIRE/ELECTRIC
    
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
        TYPES.put( Elements.EARTH, EARTH );
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
}