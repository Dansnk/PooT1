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
      Ball b2 = new Ball(mass, radius, 2, 0);

      Spring spring = new Spring(1.5, 0.5);
      spring.attachEnd(f1);
      spring.attachEnd(b1);
      
      world.addElement(spring);
      world.addElement(f1);
      world.addElement(b1);
      world.addElement(b2);
      
      world.simulate(deltaTime, endTime, samplingTime); // delta time[s], total simulation time [s].
   }
}