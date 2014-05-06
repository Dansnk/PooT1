public class PhysicsLab {
   public static void main(String[] args) {
      if (args.length != 3)  {
        System.out.println("usage: java PhysicsLab <delta_time[s]> <end_time[s]> <sampling_time[s]>");
        System.exit(-1);
      }
      
      double deltaTime = Double.parseDouble(args[0]);    // [s]
      double endTime = Double.parseDouble(args[1]);      // [s]
      double samplingTime = Double.parseDouble(args[2]); // [s]
      MyWorld world = new MyWorld(System.out);
      
      double mass = 1.0;      // 1 [kg] 
      double radius = 0.1;    // 10 [cm] 
      
      Ball b1 = new Ball(mass, radius, 1, 0);
      FixedHook f1 = new FixedHook(0);
      Spring spring1 = new Spring(1.5, 0.5);
      
      Ball b2 = new Ball(mass, radius, 2, 0);
      FixedHook f2= new FixedHook(3);
      Spring spring2 = new Spring(1.5, 0.5);
      
      spring1.attachEnd(f1);
      spring1.attachEnd(b1);
      spring2.attachEnd(b2);
      spring2.attachEnd(f2);
      
      world.addElement(spring1);
      world.addElement(f1);
      world.addElement(spring2);
      world.addElement(f2);
      world.addElement(b1);
      world.addElement(b2);
      
      world.simulate(deltaTime, endTime, samplingTime); // delta time[s], total simulation time [s].
   }
}