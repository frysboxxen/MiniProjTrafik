import java.awt.Color;

public class Car {
	
	/**
	 * - Car class. 
	 * - To add X and Y cords.
	 * - 
	 */
	
	private boolean isEmergency;
	private Color carColor;
	private int delay;
	private int x;
	private int y;
	private int speed;
	
	
	
	public Car(boolean isEmergency, Color carColor, int delay){
		this.isEmergency = isEmergency;
		this.carColor = carColor;
		this.delay = delay;
	}

	public boolean isEmergency() {
		return isEmergency;
	}

	public Color getCarColor() {
		return carColor;
	}

	public int getDelay() {
		return delay;
	}
}
