/**
 * Esta clase define el elemento fisico Resorte (Spring)
 * @version 05/05/2014/Final
 * @author Daniel Veas, Matias Lacasia, Carlos Polanco
 */

public class Spring extends PhysicsElement {
   private static int id=0;  // Spring identification
   protected final double restLength;
   private final double stiffness;
   protected PhysicsElement a_end, b_end;

   private Spring(){   // nobody can create a block without state
      this(0,0);
   }

   /**
    * Constructor de la clase Spring, la cual posee una posicion en reposo y una constante de resorte.
    * Ademas de dos indicadores para las bolas que se unan
    * @param restLength Es el largo en reposo que posee el resorte.
    * @param stiffness Es la constante de resorte K.
    */
   public Spring(double restLength, double stiffness){
      super(id++);
      this.restLength = restLength;
      this.stiffness = stiffness;
      a_end = b_end = null;
   }
   
   /**
    * Metodo que une un spring a una bola.
    * Guarda la bola en el spring dado.
    * @param sa Spring que se unira a la bola
    */
   public void attachEnd (Ball sa) {  
      if(a_end==null){               
         a_end = sa;
      	 sa.attachSpring(this);
      } else {
    	  if (b_end==null){
    	  b_end = sa;
      	  sa.attachSpring(this);
    	  }
      }
   }
   
   /**
    * Metodo que une un Spring a un FixedHook.
    * Guarda el FixedHook en el spring dado.
    * @param fx FixedHook que se unira a la bola
    */
   public void attachEnd (FixedHook fx) {
	      if(a_end==null){          
	         a_end = fx;
	      	 fx.attachSpring(this);
	      } else {
	    	  if (b_end==null){
	    	  b_end = fx;
	      	  fx.attachSpring(this);
	    	  }
	      }
	   }
   
   /**
    * Metodo que obtiene la posicion del inicio del resorte
    * @return Posicion donde se encuentra el comienzo del resorte en ese momento
    */
   private double getAendPosition() {
      if (a_end != null){
         return a_end.getPosition();
      } else {
    	  if (b_end != null)
         return b_end.getPosition()-this.restLength;
      }
      return 0;
   }
  
   /**
    * Metodo que obtiene la posicion final del resorte
    * @return Posicion donde se encuentra el final del resorte en ese momento
    */
   public double getBendPosition() {
	   if (b_end != null){
		   return b_end.getPosition();
	   } else {
		   if (a_end != null)
		   return a_end.getPosition() + this.restLength;
	   }
	   return this.restLength;
   }
   
   /**
    * Metodo que ayuda a obtener la fuerza ejercida a una bola, por el resorte actual.
    * Se calcula la fuerza usando F = K*(Largo actual - Largo reposo)
    * El negativo o positivo va a depender de los ejes tomados o donde se encuentre la bola
    * @param ball Bola a la cual se le desea calcular su fuerza.
    * @return force o -force dependiendo del sentido del eje positivo
    */
   public double getForce(Ball ball) {
	   double force = 0;
	   force=(Math.abs(getAendPosition()-getBendPosition())-restLength)*stiffness;
	      if((getAendPosition() < getBendPosition())^ (ball==a_end))
	    	  return -force;
	      else return force;
   }
   
   /**
    * No implementada debido a que no era necesaria.
    */
   public void computeNextState(double delta_t, MyWorld w){
	   }
   
   /**
    * No implementada debido a que no era necesaria
    */
   public void updateState(){
   }
   
   /**
    * No implementada debido a que no era necesaria
    */
   public double getPosition(){
	   return 0;
   }
   
   /**
    * Metodo que entrega la descripcion del spring
    * @return String con la id de la posicion A y B de un resorte
    */   
   public String getDescription() {
      return "Spring_"+ this.getId() +":a_end\tb_end";
   }
   
   public String getState() {
	   String line;
	   line = "\t"+ this.getAendPosition() + "\t"+ this.getBendPosition();
	   return line;
   }
}