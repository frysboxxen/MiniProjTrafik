
public class Light {
	private boolean green;
	private boolean yellow;
	private boolean red;
	private long yellowTime = 3000; // Delay time.
	
	public Light() {
		green = false;
		yellow = false;
		red = true;
	}
	
	public boolean setRed() throws InterruptedException{
		if(green){
			yellow = true;
			green = false;
			Thread.sleep(yellowTime);
			yellow = false;
			red = true;
		}
		return true;
	}
	
	public boolean setGreen() throws InterruptedException{
		if(red){
			yellow = true;
			Thread.sleep(yellowTime);
			yellow = false;
			green = true;
		}
		return true;
	}
	
	public boolean[] status(){
		boolean[] status = new boolean[3];
		
	}
	
}
