package test;

public class Robot {
	int currentPosition = 0;

	/** mainメソッド */
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.report();
		robot.move(10);
		robot.report();
	}

	// ロボットの現在位置を表示
	void report() {
		System.out.println("Current Position = " + currentPosition);
	}

	void move(int moveDistance) {
		currentPosition = currentPosition + moveDistance;
	}
}