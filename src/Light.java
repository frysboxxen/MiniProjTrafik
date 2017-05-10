import java.awt.Color;

public class Light implements Runnable{
	private boolean green;
	private boolean yellow;
	private boolean red;
	private double xPos;
	private double yPos;
	private Color color;
//	private long yellowTime = 3000; // Delay time.
	private int was = 0;
	
	public Light(double x, double y) {
		green = false;
		yellow = false;
		red = true;
		xPos = x;
		yPos = y;
		color = new Color(255, 0, 0);
		
	}
	
	/*public boolean setRed() throws InterruptedException{

		
		if(green){
			yellow = true;
			color = new Color (255, 255, 0);
			green = false;
			Thread.sleep(yellowTime);
			yellow = false;
			red = true;
			color = new Color (255, 0, 0);
		}
		return true;
		
	}*/
	/**
	 * Switches between Traffic lights depending on the previous state. 
	 */
	public void changeColor(){
		switch(was){
		case 0:
			if(isGreen()){
				yellow = true;
				green = false;
				was = 1;
				
			}else if(isRed()){
				yellow = true;
				red = false;
				was = 2;
			}
			color = new Color(255,255,0);
			break;
		case 1:
			was = 0;
			yellow = false;
			red = true;
			color = new Color(255,0,0);
			break;
		case 2:
			was = 0;
			yellow = false;
			green = true;
			color = new Color(0,255,0);
			break;
		}	
		
		
		
	}
	public boolean isYellow(){
		return yellow;
	}
	
	public boolean setGreen() {
		if(red){
			yellow = true;
			color = new Color (255, 255, 0);
			
//			Thread.sleep(yellowTime);
			yellow = false;
			green = true;
			color = new Color (0, 255, 0);
		}
		return true;
	}
	
	public boolean setRed() {
		if(green){
			yellow = true;
			color = new Color (255, 255, 0);
			green = false;
//			Thread.sleep(yellowTime);
			yellow = false;
			red = true;
			color = new Color (255, 0, 0);
		}
		return true;
	}
	
	
	public boolean isRed(){
		return red;
	}
	
	public boolean isGreen(){
		return green;
	}

	public boolean[] status(){
		boolean[] status = {red, yellow, green};
		return status;
	}

	@Override
	public void run() {
		
	}
	public void drawLight(){
		StdDraw.setPenColor(color);
		StdDraw.filledSquare(xPos, yPos, 10);

		
		

	}
	
}
