import java.net.NoRouteToHostException;

public class Junction {

	static Direction north;
	static Direction east;
	static Direction west;
	static Direction south;

	private static void setDir() {
		north = new Direction(400, 480);
		south = new Direction(400, 320);
		east = new Direction(480, 400);
		west = new Direction(320, 400);
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
		StdDraw.picture(400, 400, "korsning.png", 800, 800);
		north.shiftLight();
		north.shiftLight();
		int less = 0;
		while (true) {
			StdDraw.clear();
			if (less == 10) {
				north.newCar();
				east.newCar();
				west.newCar();
				south.newCar();
				less = 0;
			}
			StdDraw.picture(400, 400, "korsning.png", 800, 800);
			north.run();
			south.run();
			east.run();
			west.run();
			StdDraw.show();
			less++;
		}
	}
}
