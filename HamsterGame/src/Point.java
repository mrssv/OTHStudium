

public class Point {
	Integer x = 0;
	Integer y = 0;

	public Point() {
	}
	
	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void setXY(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public void setXY(Point pos) {
		this.x = pos.x;
		this.y = pos.y;
	}

	public boolean clone(Point other) {
		if (other == null)
			return false;
		else {
			this.x = other.x;
			this.y = other.y;
			return true;
		}
	}
}