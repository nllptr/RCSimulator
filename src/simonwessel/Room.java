package simonwessel;

public class Room {

	private int x, y;

	public Room(int width, int length) {
		this.x = width;
		this.y = length;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean exists(int x, int y) {
		return x >= 0 && x < this.x && y >= 0 && y < this.y;
	}
}
