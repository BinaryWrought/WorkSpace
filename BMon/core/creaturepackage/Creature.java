package core.creaturepackage;

import core.*;
import java.math.*;

/**
 * This is a class representing a BMon creature.
 * It extends the Stats class which contains all of the battle stats.
 * This class just contains type and name.
 * 
 * @author jhazelle
 */
public class Creature extends Stats
{
    private final String creatureClass;
    private String name;
        
    private final Elements typeOne;
    private final Elements typeTwo;
    
    private final Attack[] attackSet = new Attack[4];
    private final Integer[] typeDefenses;

    /**
     * Default constructor, requires certain fields to be populated in order to create a BMon
     * @param c the creature's class and default name
     * @param one the first elemental type of this creature
     * @param two the second elemental type of this creature (or null if it is a single type)
     * @param s the stats of this creature
     */
    public Creature( String c, Elements one, Elements two, Stats s )
    {
        super(s);
        creatureClass = name = c;
        typeOne = one;
        typeTwo = two;
        if( two != null )
            typeDefenses = TypeMatchUps.getDualType( one, two );
        else
            typeDefenses = TypeMatchUps.getSingleType( one );
    }
    
    /**
     * Method to get his BMon's name
     * @return the name assigned to this BMon
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to set this BMon's name
     * @param n the name to assign to this BMon
     */
    public void setName( String n )
    {
        name = n;
    }
    
    public String getClassName()
    {
        return creatureClass;
    }
    
    /**
     * Method to give this BMon a new attack (up to a maximum of four)
     * @param a the new attack for this BMon
     * @return true if the attack was learned by the BMon, false if not (because it already knows four attacks)
     */
    public boolean addAttack( Attack a )
    {
        for( int i = 0; i < attackSet.length; ++i )
        {
            if( attackSet[i] == null )
            {
                attackSet[i] = a;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method to attack some other BMon using this BMon's attack
     * Attack damage is calculated as: TotalDamage = Power * ( Base + Attack + TypeBonus )
     * 
     * @param i this index of the attack to use
     * @param target the BMon being attacked by this BMon
     */
    public void attack( int i, Creature target )
    {
        double typeBonus = 0;
        if( attackSet[i].getType() == typeOne || attackSet[i].getType() == typeTwo )
            typeBonus = 0.5;      
        
        BigDecimal atkBonus = new BigDecimal( 1.0 );
        atkBonus = atkBonus.add( new BigDecimal( getAttack() ) );
        atkBonus = atkBonus.add( new BigDecimal( typeBonus ) );
        
        BigDecimal atkPow = new BigDecimal( attackSet[i].getPower() );
        BigDecimal totalPow = atkPow.multiply(atkBonus);
                
        target.defend( attackSet[i], totalPow );
    }
    
    /**
     * Method to defend from an incoming attack
     * Attack defense is calculated as: TotalMitigation = TypeDefense * ( Base - Defense )
     * Actual Damage is then: AttackDamage * AttackDefense
     * 
     * @param atk the incoming attack (includes name of attack, elemental type, and attack strength )
     * @param totalPow the total attack power calculated by the attacking BMon
     */
    public void defend( Attack atk, BigDecimal totalPow )
    {
        double defAlignment = (double)typeDefenses[ atk.getType().ordinal() ];        
        BigDecimal mitigation = new BigDecimal( 1.0 );
        mitigation = mitigation.subtract( new BigDecimal( getDefense() ) );
        mitigation = mitigation.multiply( new BigDecimal( defAlignment ) );        
        BigDecimal totalDamage = totalPow.multiply( mitigation );        
                
        System.out.println( name + " hit by: " + atk.getName() + " for " + totalDamage.doubleValue() + "." );
        
        MathContext mc = new MathContext(3);
        
        BigDecimal currentHealth = getHealth();
        currentHealth = currentHealth.subtract( totalDamage, mc );        
        setHealth( currentHealth );        
        
        if( getHealth().compareTo( new BigDecimal( getMaxHealth() ) ) > 0 )
            setHealth( new BigDecimal( getMaxHealth() ) );
        
        printHitResult( atk.getType() );
        printHealth();
               
    }
    
    /**
     * Method to print the current health of the BMon or notify that it has died.
     * Currently this method is private because it is only called by the BMon itself when defending an attack.
     */
    private void printHealth()
    {       
        if( getHealth().doubleValue() <= 0 )
            System.out.println( name + " has died!" );
        else
            System.out.println( "Remaining health: " + getHealth().doubleValue() ); 
    }
    
    /**
     * Method to print the result of a hit to this BMon.
     * Currently this method is private because it is only called by the BMon itself when it was hit by an attack.
     * @param e 
     */
    private void printHitResult( Elements e )
    {
        int defAlignment = typeDefenses[ e.ordinal() ];
        switch (defAlignment)
        {
            case -2:
                System.out.println( name + " really likes that!" );
                break;
            case -1:
                System.out.println( name + " likes that." );
                break;
            case 0:
                System.out.println( name + " didn't feel that." );
                break;
            case 1:
                System.out.println( name + " doesn't like that." );
                break;
            case 2:
                System.out.println( name + " really doesn't like that!" );
                break;
            default:
                System.out.println( "ERROR!" );
                break;
        }
    }
}
