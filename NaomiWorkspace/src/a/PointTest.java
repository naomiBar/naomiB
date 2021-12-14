package a;

public class PointTest {

	public static void main(String[] args) {
		
		// create a point instance
		Point p1 = new Point();
		p1.setX(8);
		p1.setY(8);
		// print the point state
		System.out.println("P1.x: " + p1.getX());
		System.out.print("P1: ");
		p1.printPoint();
		
		
		Point p2 = new Point(2, 2);
		// print the point state
		System.out.print("P2: ");
		p2.printPoint();
		// move the point
		p2.moveRight();
		p2.moveRight();
		p2.moveRight();
		p2.moveDown();
		p2.moveDown();
		p2.moveDown();
		// print the point state again
		System.out.print("P2: ");
		p2.printPoint();
	}
}
