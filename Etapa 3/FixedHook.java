import java.util.*;

/**
 * Esta clase define el elemento fisico FixedHook
 * Se implementa la interfaz SpringAttachable para que tenga esos in
 * @version 05/05/2014/Final
 * @author Daniel Veas, Matias Lacasia, Carlos Polanco
 */
public class FixedHook extends PhysicsElement implements SpringAttachable{
private static int id=0;
   private final double pos_t;     // current position at time t
   private ArrayList<Spring> springs; 
   
   /**
    * Constructor de la clase FixedHook
    * @param position indica la posicipn que se colocara el FixedHook
    */
   public FixedHook(double position){
	      super(id++);
	      pos_t = position;
	      springs = new ArrayList<Spring>();
   }
   
   /**
    * Metodo que une un spring a un FixedHook.
    * Guarda el FixedHook en el spring dado.
    * @param sa Spring que se unira al FixedHook
    */
   public void attachSpring(Spring spring){
	   springs.add(spring);		
   }
   
   /**
    * No se implementa este metodo ya que no es necesario
    */
   public void computeNextState(double delta_t, MyWorld myworld){
   }

   /**
    * No se implementa este metodo ya que no es necesario
    */
   public void updateState(){
   }
   
   /**
    * Metodo que entrega la descripcion del FixedHook	
    * @return String con la id del FixedHook
    */
   public String getDescription(){
	   String s = "Hook"+this.getId();
	   return s;
   }
   
   /**
    * Metodo que entrega el estado actual de la posicion.
    * @return String con la posicion actual
    */
   public String getState(){
	   String s;
	   s= String.valueOf(this.pos_t);
	   return  s ;
   }
   
   /**
    * Metodo que retorna la posicion actual del FixedHook.
    * Notar que este es fijo y no se mueve nunca.
    * @return Posicion del FixedHook en el momento actual
    */
   public double getPosition(){
	   return pos_t;
   }
   
} 