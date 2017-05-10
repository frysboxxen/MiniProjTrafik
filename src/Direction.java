import java.awt.Color;
import java.util.*;

public class Direction  {
	private ArrayQueue<Car> straight;
	private boolean hasEmergency =false;
	private Light light;
	//H�ller koll p� vart bil v�gen �r f�r denna riktningen, 
	private double a;
	private double b;
	private ArrayList emergencyList;

	public Direction(double x, double y) {
		light = new Light(x, y);
		straight = new ArrayQueue<Car>();
		
		//Best�mmer vilken v�g det �r utifr�n vad v�g ljusen �r.
		if(x == 400 && y == 480){
			a = x-30;
			b = 800;
		}else if(x==400 && y==320){
			a = x+30;
			b = 0;
		}else if(x==480 && y == 400){
			a = 800;
			b = y+30;
		}else if(x==320 && y == 400){
			a = 0;
			b = 400-30;
		}
	
	}

	public void run() {
		light.drawLight();
		if(light.isGreen()){
			
			go();
		}else if(light.isRed() || light.isYellow()){
			//stop();
		}
		/*while (light.isGreen()) {
			try {
				this.greenLight();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		checkEmergency();*/
	}
	//H�mtar bilarna i queuen och �ndrar p� bilarnas x eller y v�rde beroende p� vart v�gen ligger.
	private void go(){
		if(!straight.isEmpty()){
		Iterator<Car> get = straight.iterator();
		Car temp;
		while(get.hasNext()){
			temp = get.next();
			if(b == 800){
				temp.y -=temp.speed;
			}else if(b == 0){
				temp.y += temp.speed;
			}else if(a == 800){
				temp.x -= temp.speed;
			}else if(a == 0){
				temp.x += temp.speed;
			}
			
			StdDraw.filledCircle(temp.x, temp.y, 10);
		}
		
			temp = straight.getFront();
			//Kollar east, west, south, north(I den ordningen)
			if(temp.y == 430 && temp.x < 480 || temp.y == 370 && 320 < temp.x  || 320 < temp.y && temp.x == 430 || temp.y < 480 && temp.x == 370){
				straight.dequeue();
			}
		}
	}


	/*public void enqueueStraight(Car car) {
		if (car.isEmergency()) {
			hasEmergency = true;
		}
		straight.enqueue(car);

	}*/

	public void greenLight() throws InterruptedException {
		straight.dequeue();
		//Thread.sleep(1000);

	}
	//Tar emot indexen f�r "emergency" som en lista.
	public void checkEmergency(){
		
		if(hasEmergency){
			emergencyList = straight.findEmergency();
		}
	}

	public boolean getEmergencyStatus() {
		return hasEmergency;
	}
	
	//S�tter till en ny bil till queuen.
	public void newCar(){
		boolean type = false;
		if(0.9<Math.random()){
			if(0.9<Math.random()){
				type = true;
				hasEmergency = true;
			}
			straight.enqueue(new Car(type, new Color(255,255,255), 0, a, b));
		}
	}
	//Byter ljuset utifr�n f�rra statuset f�r ljuset.
	public void shiftLight(){
		light.changeColor();
	}

}
