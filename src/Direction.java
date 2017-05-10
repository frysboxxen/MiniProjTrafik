import java.awt.Color;
import java.util.*;

public class Direction implements Runnable {
	private ArrayQueue<Car> straight;
	private boolean hasEmergency = false;
	private Light light;
	// Håller koll på vart bil vägen är för denna riktningen,
	private double a;
	private double b;
	private ArrayList emergencyList;
	// Thread T;

	public Direction(double x, double y) {
		light = new Light(x, y);
		straight = new ArrayQueue<Car>();
		// T = new Thread(this, "north");

		// Bestämmer vilken väg det är utifrån vad väg ljusen är.
		if (x == 400 && y == 480) {
			a = x - 30;
			b = 800;
		} else if (x == 400 && y == 320) {
			a = x + 30;
			b = 0;
		} else if (x == 480 && y == 400) {
			a = 800;
			b = y + 30;
		} else if (x == 320 && y == 400) {
			a = 0;
			b = 400 - 30;
		}

	}

	public void run(){

		while (true) {
			while (light.isGreen()) {
				light.drawLight();
				go();
			
			}

			while (light.isRed() || light.isYellow()) {
				light.drawLight(); 
				stop();

				
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * while (light.isGreen()) { try { this.greenLight(); } catch
		 * (InterruptedException e) { e.printStackTrace(); } } checkEmergency();
		 */
	}

	// Hämtar bilarna i queuen och ändrar på bilarnas x eller y värde beroende
	// på vart vägen ligger.
	private void go() {
		if (!straight.isEmpty()) {
			Iterator<Car> get = straight.iterator();
			Car temp;
			while (get.hasNext()) {
				temp = get.next();
				if (b == 800) {
					temp.y -= temp.speed;
				} else if (b == 0) {
					temp.y += temp.speed;
				} else if (a == 800) {
					temp.x -= temp.speed;
				} else if (a == 0) {
					temp.x += temp.speed;
				}

				StdDraw.filledCircle(temp.x, temp.y, 10);
				StdDraw.show();
			}
			temp = straight.getFront();
			// Kollar east, west, south, north(I den ordningen)
			if (temp.y == 430 && temp.x < 480 || temp.y == 370 && 320 < temp.x || 320 < temp.y && temp.x == 430
					|| temp.y < 480 && temp.x == 370) {
				straight.dequeue();
			}
		}

	}

	private void stop() {

		double offset = 0;

		Car current;
		if (!straight.isEmpty()) {
			Iterator<Car> get = straight.iterator();
			Car temp;
			while (get.hasNext()) {
				temp = get.next();
				if (b == 800) {
					if (temp.y <= offset) {

					} else {
						temp.y -= temp.speed;
						offset += 20;
					}
				} else if (b == 0) {
					temp.y += temp.speed;
				} else if (a == 800) {
					temp.x -= temp.speed;
				} else if (a == 0) {
					temp.x += temp.speed;
				}

				StdDraw.filledCircle(temp.x, temp.y, 10);
				current = temp;
			}

		}

	}

	/*
	 * public void enqueueStraight(Car car) { if (car.isEmergency()) {
	 * hasEmergency = true; } straight.enqueue(car);
	 * 
	 * }
	 */

	public void greenLight() throws InterruptedException {
		straight.dequeue();
		// Thread.sleep(1000);

	}

	// Tar emot indexen fï¿½r "emergency" som en lista.
	public void checkEmergency() {

		if (hasEmergency) {
			emergencyList = straight.findEmergency();
		}
	}

	public boolean getEmergencyStatus() {
		return hasEmergency;
	}

	// Sätter till en ny bil till queuen.
	public void newCar() {
		boolean type = false;
		if (0.9 < Math.random()) {
			if (0.9 < Math.random()) {
				type = true;
				hasEmergency = true;
			}
			straight.enqueue(new Car(type, new Color(255, 255, 255), 0, a, b));
		}
	}

	// Byter ljuset utifrï¿½n fï¿½rra statuset fï¿½r ljuset.
	public void shiftLight() {
		light.changeColor();
	}

}
