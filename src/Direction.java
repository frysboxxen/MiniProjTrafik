import java.util.Queue;

public class Direction implements Runnable{
	private Queue<Car> straight;
	private Queue<Car> turnLeft;
	private Queue<Car> emergency;
	private Light light;
	
	public Direction(){
		light = new Light();
	}
	
	public void run(){
		while(light.getGreen()){
			this.greenLight();
		}
	}
	
	public void enqueueLeft(Car car){
		if(car.isEmergency()){
			emergency.add(car);
		}
		turnLeft.add(car);
		
	}
	
	public void enqueueStraight(Car car){
		if(car.isEmergency()){
			emergency.add(car);
		}
		straight.add(car);
		
	}
	
	public void greenLight(){
			straight.remove();
			if(light.getRed()){
				turnLeft.remove();
			}
			
			Thread.sleep(1200);
		
	}
	public boolean getEmergencyStatus(){
		return emergency.isEmpty();
	}
	
	
}
