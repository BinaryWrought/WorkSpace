package bmon;

/**
 *
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public enum Elements
{   
    //Note that the ordinals of the types corresponds to their position type defense arrays
    //DO NOT CHANGE THE ORDER OF THESE ELEMENTS OR THE TYPE ARRAYS WILL BE WRONG
    FIRE, WATER, PLANT, AIR, ELECTRIC, EARTH, LIGHT, DARK, NEUTRAL;
    
    // Supposedly every call to values() does a copy, as such making a fixed static array of that is lower overhead
    // and the static array will be used for getting other elements
    private static final Elements[] vals = values();

    /**
     * Method to get the next element after this one, non-circular so will return null if this is the last element
     * @return the next element from the enum, or null if this is the last element
     */
    public Elements nextLinear()
    {
        if( this.ordinal() < vals.length - 1 )
        {
            return vals[this.ordinal() + 1];
        }
        else
        {
            return null;
        }
    }

    /**
     * Method to get the previous element before this one, non-circular so will return null if this is the first element
     * @return the previous element from the enum, or null if this is the first element
     */
    public Elements prevLinear()
    {
        if( this.ordinal() == 0 )
        {
            return null;
        }
        else
        {
            return vals[this.ordinal() - 1];
        }
    }

    /**
     * Method to get the next element after this one, circular so will return the first element if this is the last element
     * @return the next element from the enum, or the first if this is the last element
     */
    public Elements nextCircular()
    {
        return vals[( this.ordinal() + 1 ) % vals.length];
    }

    /**
     * Method to get the previous element before this one, circular so will return the last element if this is the first element
     * @return the previous element from the enum, or the last if this is the first element
     */
    public Elements prevCircular()
    {
        if( this.ordinal() == 0 )
        {
            return vals[vals.length - 1];
        }
        else
        {
            return vals[( this.ordinal() - 1 )];
        }
    }
    
}
