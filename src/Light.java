import java.awt.Color;

public class Light implements Runnable{
	private boolean green;
	private boolean yellow;
	private boolean red;
	private double xPos;
	private double yPos;
	private Color color;
	private long yellowTime = 3000; // Delay time.
	private int was;
	
	public Light(double x, double y) {
		green = false;
		yellow = false;
		red = true;
		xPos = x;
		yPos = y;
		color = new Color(255, 0, 0);
		
	}
	
	public boolean setRed() throws InterruptedException{
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
		
	}
	public void changeColor() throws InterruptedException{
		
		if(isRed() ){
			was=2;
			color = new Color(255, 255, 0);
			yellow = true;
			red = false;
			return;
		}
		else if(isYellow()){
			if(was == 2){
				was = 0;
				color = new Color(0,255,0);
				yellow = false;
				green = true;
				return;
			}
			else if(was == 1){
				was = 0;
				color = new Color(255,0,0);
				yellow = false;
				red= true;
				return;
			}
		}
		else if(isGreen()){
			was = 1;
			color = new Color(255, 255, 0);
			green = false;
			yellow = true;
			return;
		}
		
		
	}
	public boolean isYellow(){
		return yellow;
	}
	
	public boolean setGreen() throws InterruptedException{
		if(red){
			yellow = true;
			color = new Color (255, 255, 0);
			
			Thread.sleep(yellowTime);
			yellow = false;
			green = true;
			color = new Color (0, 255, 0);
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

		
		StdDraw.show();

	}
	
}
