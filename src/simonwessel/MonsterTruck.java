package simonwessel;

public class MonsterTruck {

	private Room room;
	private int x, y;
	private Heading heading;

	public MonsterTruck(Room room, int x, int y, Heading heading) throws Exception {
		if (room == null) {
			throw new Exception("Room cannot be null!");
		}
		this.room = room;
		if (!room.exists(x, y)) {
			throw new Exception("Car cannot be placed outside the room borders");
		}
		this.x = x;
		this.y = y;
		if (heading == null) {
			throw new Exception("Heading cannot be null!");
		}
		this.heading = heading;
	}

	private void move(boolean reverse) throws Exception {
		int[] next;
		switch (heading) {
		case NORTH:
			next = new int[] { x, reverse ? y - 1 : y + 1 };
			break;
		case WEST:
			next = new int[] { reverse ? x + 1 : x - 1, y };
			break;
		case SOUTH:
			next = new int[] { x, reverse ? y + 1 : y - 1 };
			break;
		case EAST:
			next = new int[] { reverse ? x - 1 : x + 1, y };
			break;
		default:
			next = new int[] { x, y };
		}

		if (room.exists(next[0], next[1])) {
			x = next[0];
			y = next[1];
		} else {
			throw new Exception("The MonsterTruck hit the wall at (" + x + ", " + y + ").");
		}
	}

	private void move() throws Exception {
		move(false);
	}

	public void forward() throws Exception {
		move();
	}

	public void backward() throws Exception {
		move(true);
	}

	public void left() {
		heading = heading.left();
	}

	public void right() {
		heading = heading.right();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public enum Heading {
		NORTH, EAST, SOUTH, WEST;

		public Heading right() {
			return Heading.values()[(this.ordinal() + 1) % 4];
		}

		public Heading left() {
			// "+ 3" is "- 1 + 4" simplified. "+ 4" is needed to deal with negative values
			// (e.g. turning left while facing NORTH (value 0), which would result in -1 and
			// IndexOutOfBounds)
			return Heading.values()[(this.ordinal() + 3) % 4];
		}
	}

	public Heading getHeading() {
		return heading;
	}

}
