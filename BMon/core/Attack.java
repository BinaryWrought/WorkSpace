package core;

/**
 * This class represents a BMon creature's attack.
 * Each creature can have up to four attacks.
 * Attacks can have up to 1 of each:
 * A positive buff for the user
 * A negative debuff for the receiver
 * A negative status effect for the receiver
 * 
 * @todo Use a builder class such that Attacks require name, type, and power but could have any or all of buff, debuff, status effect.
 * @author jhazelle
 */
public class Attack 
{
    private final String name;
    private final Elements type;
    private final double power;
    private final Buffs buff;
    private final Debuffs debuff;
    private final Statuses statusEffect;
    
    /**
     * 
     * @param n
     * @param t
     * @param p 
     */
    public Attack( String n, Elements t, double p )
    {
        name = n;
        type = t;
        power = p;
        buff = null;
        debuff = null;
        statusEffect = null;
    }
    
    public Attack( String n, Elements t, double p, Buffs b )
    {
        name = n;
        type = t;
        power = p;
        buff = b;
        debuff = null;
        statusEffect = null;
    }
        
    public Attack( String n, Elements t, double p, Debuffs d )
    {
        name = n;
        type = t;
        power = p;
        buff = null;
        debuff = d;
        statusEffect = null;
    }
            
    public Attack( String n, Elements t, double p, Statuses se )
    {
        name = n;
        type = t;
        power = p;
        buff = null;
        debuff = null;
        statusEffect = se;
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @return the type
     */
    public Elements getType() 
    {
        return type;
    }

    /**
     * @return the strength
     */
    public double getPower() 
    {
        return power;
    }

    /**
     * @return the buff
     */
    public Buffs getBuff() 
    {
        return buff;
    }

    /**
     * @return the debuff
     */
    public Debuffs getDebuff() 
    {
        return debuff;
    }

    /**
     * @return the statusEffect
     */
    public Statuses getStatusEffect() 
    {
        return statusEffect;
    }
}
