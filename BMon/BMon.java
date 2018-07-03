
import java.util.Arrays;

/**
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
        TypeMatchUps tmu = new TypeMatchUps();             
        //tmu.printAllDualTypes( false );
        System.out.println( "D/N: " + Arrays.toString( tmu.getDualType( Elements.DARK, Elements.NEUTRAL ) ) );
        System.out.println( "L/N: " + Arrays.toString( tmu.getDualType( Elements.LIGHT, Elements.NEUTRAL ) ) );
        System.out.println( "D/L: " + Arrays.toString( tmu.getDualType( Elements.DARK, Elements.LIGHT ) ) );
    }
}
