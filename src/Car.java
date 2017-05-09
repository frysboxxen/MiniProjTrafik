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
	double x;
	double y;
	int speed;
	
	
	
	public Car(boolean isEmergency, Color carColor, int delay, double a, double b){
		this.isEmergency = isEmergency;
		this.carColor = carColor;
		this.delay = delay;
		x = a;
		y = b;
		speed = 5;
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
