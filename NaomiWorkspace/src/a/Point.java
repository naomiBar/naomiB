package a;

public class Point {
	private int x; //0-1000
	private int y; //0-1000

	public Point() {
	}

	public Point(int x, int y) {
		setX(x);
		setY(y);
	}

	public void printPoint() {
		System.out.println("(" + this.x + "," + this.y + ")");
	}

	public void moveRight() {
		setX(this.x + 1);
	}

	public void moveLeft() {
		setX(this.x - 1);
	}

	public void moveUp() {
		setY(this.y - 1);
	}

	public void moveDown() {
		setY(this.y + 1);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		if (x >= 0 && x <= 1000) {
			this.x = x;
		}
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		if (y >= 0 && y <= 1000) {
			this.y = y;
		}
	}
}