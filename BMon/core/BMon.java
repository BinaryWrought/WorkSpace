package core;

import core.creaturepackage.*;
import java.math.BigDecimal;

/**
 * This is a driver class to test various BMon mechanics.
 * If the game were finished today, this would be the MAIN main.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class BMon 
{

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) 
    {        
        // The test below covers all nine possible attack combination match ups.
        // Consider that there is the potential for five different defense values: 2, 1, 0, -1, -2
        // Also, attacks can have two strengths: without a type boost (+0) and with a type boost (+/-.5).
        // 0 isn't affected by type boost.
        // Therefore all the possible match ups are:
        // (2 + 0), (2 + .5), (1 + 0), (1 + .5), (0), (-1 + 0), (-1 -.5), (-2 + 0), (-2 - .5)
        
        Stats s = new Stats( new BigDecimal(100), 100, 1, 0.1, 0.1 );
        Creature fire = new Creature( "FireType", Elements.FIRE, null, s );
        fire.addAttack( new Attack( "Fire attack", Elements.FIRE, 20 ) );
        
        Creature plant = new Creature( "PlantType", Elements.PLANT, null, s );
        plant.addAttack( new Attack( "Fire attack", Elements.FIRE, 20 ) );
        plant.addAttack( new Attack( "Dark attack", Elements.DARK, 20 ) );
        
        Creature dark = new Creature( "DarkType", Elements.DARK, null, s );
        dark.addAttack( new Attack( "Dark attack", Elements.DARK, 20 ) );
        
        Creature neutral = new Creature( "NeutralType", Elements.NEUTRAL, null, s );
        neutral.addAttack( new Attack( "Neutral attack", Elements.NEUTRAL, 20 ) );
        neutral.addAttack( new Attack( "Light attack", Elements.LIGHT, 20 ) );
        
        Creature light = new Creature( "LightType", Elements.LIGHT, null, s );
        light.addAttack( new Attack( "Light attack", Elements.LIGHT, 20 ) );
        
        Creature lightFire = new Creature( "LightFireType", Elements.FIRE, Elements.LIGHT, s );
        Creature electricPlant = new Creature( "ElectricPlantType", Elements.ELECTRIC, Elements.PLANT, s );
    
        plant.attack( 0, plant );
        fire.attack( 0, plant );
        plant.attack( 1, electricPlant );
        dark.attack( 0, electricPlant );
        
        neutral.attack( 0, neutral );
        
        neutral.attack( 1, light );
        light.attack( 0, light );
        neutral.attack( 1, lightFire );
        light.attack( 0, lightFire );
    }
}
