import java.net.NoRouteToHostException;

public class Junction {

	static Direction north;
	static Direction east;
	static Direction west;
	static Direction south;

	private static void setDir() {
		north = new Direction(400, 480);
//		south = new Direction(400, 320);
//		east = new Direction(480, 400);
//		west = new Direction(320, 400);
	}
	private static void threadSetup(){
		Thread northT = new Thread(north, "north");
//		Thread southT = new Thread(south, "south");
//		Thread westT  = new Thread(west, "west");
//		Thread eastT  = new Thread(east, "east");
		
		northT.start();
//		southT.start();
//		westT.start();
//		eastT.start();
//		System.out.println("threadsetup");
	}

	private static void setBack() {
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 800);
		StdDraw.setYscale(0, 800);
	}

	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		setDir();
		setBack();
//		StdDraw.picture(400, 400, "korsning.png", 800, 800);
		threadSetup();
//		north.shiftLight();
//		north.shiftLight();
		north.setLightRed();
//		int less = 0;
		north.newCar();
	
		while (true) {
			StdDraw.clear();
			StdDraw.picture(400, 400, "korsning.png", 800, 800);
//			if (less == 10) {
//				east.newCar();
//				west.newCar();
//				south.newCar();
//				less = 0;
//				System.out.println("car created");
//			}
//			less++;
			StdDraw.show();
			StdDraw.pause(20);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
