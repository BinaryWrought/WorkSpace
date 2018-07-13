package core.creaturepackage;

import java.math.BigDecimal;

/**
 * This class contains all the stats used for battle calculations by each BMon.
 * 
 * @author jhazelle
 */
public class Stats
{
    private BigDecimal health;
    private double maxHealth;
    private double speed;
    private double attack;
    private double defense;
    
    public Stats( BigDecimal h, double mh, double s, double a, double d )
    {
        health = h;
        maxHealth = mh;
        speed = s;
        attack = a;
        defense = d;
    }
    
    public Stats( Stats s )
    {
        health = s.health;
        maxHealth = s.maxHealth;
        speed = s.speed;
        attack = s.attack;
        defense = s.defense;
    }

    /**
     * @return the health
     */
    public BigDecimal getHealth()
    {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(BigDecimal health)
    {
        this.health = health;
    }

    /**
     * @return the maxHealth
     */
    public double getMaxHealth()
    {
        return maxHealth;
    }

    /**
     * @param maxHealth the maxHealth to set
     */
    public void setMaxHealth(double maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    /**
     * @return the speed
     */
    public double getSpeed()
    {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    /**
     * @return the attack
     */
    public double getAttack()
    {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(double attack)
    {
        this.attack = attack;
    }

    /**
     * @return the defense
     */
    public double getDefense()
    {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    public void setDefense(double defense)
    {
        this.defense = defense;
    }
}
