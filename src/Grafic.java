import java.awt.*;


public class Grafic {

	static Light north = new Light (400, 480);
	static Light east = new Light (480, 400);
	static Light west = new Light (320, 400);
	static Light south = new Light (400, 320);
	
	
	public static void main(String[]args){
		
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 800);
		StdDraw.setYscale(0, 800);
		
		StdDraw.picture(400, 400, "korsning.png", 800, 800);
		

		
		while(true){
			run();	
			
		}
	
	}

	public  static void run() {
		try{
			
			
			north.drawLight();
			south.drawLight();
			
			east.drawLight();			
			west.drawLight();
			
			north.changeColor();
			south.changeColor();
			StdDraw.pause(1000);
			
			StdDraw.show();
			}
			catch(InterruptedException e){
				
			}
		
	}
	
}
