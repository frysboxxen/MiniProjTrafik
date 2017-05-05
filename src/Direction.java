import java.util.Queue;

public class Direction implements Runnable {
	private Queue<Car> straight;
	private Queue<Car> turnLeft;
	private Queue<Car> emergency;
	private Light light;

	public Direction() {
		light = new Light();
	}

	public void run() {
		while (light.isGreen()) {
			try {
				this.greenLight();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void enqueueLeft(Car car) {
		if (car.isEmergency()) {
			emergency.add(car);
		}
		turnLeft.add(car);

	}

	public void enqueueStraight(Car car) {
		if (car.isEmergency()) {
			emergency.add(car);
		}
		straight.add(car);

	}

	public void greenLight() throws InterruptedException {
		straight.remove();
		if (light.isRed()) {
			turnLeft.remove();
		}

		Thread.sleep(1000);

	}

	public boolean getEmergencyStatus() {
		return emergency.isEmpty();
	}

}
