package simonwessel;

import java.util.Scanner;

import simonwessel.MonsterTruck.Heading;

public class Simulator {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("How big should the room be?");
			System.out.println("Enter width and length in integer form separated with a space.");
			String roomInput = "";
			System.out.print(">> ");
			roomInput = in.nextLine();
			while (!roomInput.trim().matches("^\\d+\\s+\\d+$")) {
				System.out.println("Incorrect input. Remember - two integers separated by space.");
				System.out.print(">> ");
				roomInput = in.nextLine();
			}
			String[] roomParams = roomInput.split("\\s+");
			if (roomParams.length != 2) {
				System.out.println("Something went wrong during room parameter parsing. Terminating simulation.");
				System.exit(-1);
			}
			Room room = new Room(Integer.valueOf(roomParams[0]), Integer.valueOf(roomParams[1]));

			System.out.println("Where should the car start and what direction should it face?");
			System.out.println("Enter x (0-" + (room.getX() - 1) + ") and y (0-" + (room.getY() - 1)
					+ ") coordinates as integers and a direction (N/S/W/E), separated by spaces.");
			String carInput = "";
			System.out.print(">> ");
			carInput = in.nextLine();
			while (!carInput.trim().matches("^\\d+\\s+\\d+\\s+[NSWE]$")) {
				System.out.println(
						"Incorrect input. Remember - two integers and one letter (N/S/W/E), separated by spaces.");
				System.out.print(">> ");
				carInput = in.nextLine();
			}
			String[] carParams = carInput.split("\\s+");
			if (carParams.length != 3) {
				System.out.println("Something went wrong during car parameter parsing. Terminating simulation.");
				System.exit(-1);
			}
			Heading heading;
			switch (carParams[2]) {
			case "N":
				heading = Heading.NORTH;
				break;
			case "S":
				heading = Heading.SOUTH;
				break;
			case "W":
				heading = Heading.WEST;
				break;
			case "E":
				heading = Heading.EAST;
				break;
			default:
				System.out.println("Failed to parse direction. Using North as default.");
				heading = Heading.NORTH;
			}
			MonsterTruck car = new MonsterTruck(room, Integer.valueOf(carParams[0]), Integer.valueOf(carParams[1]),
					heading);

			System.out.println(
					"Enter command sequence. Valid characters are F (forward), B (backward), L (left) and R (right)");
			String commandInput = "";
			System.out.print(">> ");
			commandInput = in.nextLine();
			while (!commandInput.trim().matches("^[FBLR]+$")) {
				System.out.println("Incorrect input. Remember - only the letters F, B, L and R. No spaces.");
				System.out.print(">> ");
				commandInput = in.nextLine();
			}
			for (char c : commandInput.toCharArray()) {
				switch (c) {
				case 'F':
					car.forward();
					break;
				case 'B':
					car.backward();
					break;
				case 'L':
					car.left();
					break;
				case 'R':
					car.right();
					break;
				}
			}
			System.out.println("Simulation ran successfully. The MonsterTruck ended at (" + car.getX() + ", "
					+ car.getY() + "), facing " + car.getHeading() + ".");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Terminating simulation.");
			System.exit(-1);
		}
	}
}
