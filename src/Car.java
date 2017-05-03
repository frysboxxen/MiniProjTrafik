import java.awt.Color;

public class Car {
	
	private boolean isEmergency;
	private Color carColor;
	private int delay;
	
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
