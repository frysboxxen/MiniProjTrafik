import java.util.Queue;

public class Direction implements Runnable {
	private Queue<Car> straight;
	private boolean hasEmergency =false;
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
		checkEmergency();
	}


	public void enqueueStraight(Car car) {
		if (car.isEmergency()) {
			hasEmergency = true;
		}
		straight.add(car);

	}

	public void greenLight() throws InterruptedException {
		straight.remove();
		Thread.sleep(1000);

	}
	
	public void checkEmergency(){
		hasEmergency = false;
		while(straight.hasNext()){
			if(straight.nextA.isEmergency){
				hasEmergency =true;
			}
		}
	}

	public boolean getEmergencyStatus() {
		return hasEmergency;
	}

}
