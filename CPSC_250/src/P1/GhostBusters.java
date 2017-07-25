package P1;
/**
 * @class GhostBusters
 * 
 * This class handles the deployment of a ghost trap
 * 
 * Students will write methods 1, 2, and 3 below.
 * Students may optionally  write additional utility methods as needed.
 * 
 * All methods should work with arrays of any rectangular size (all rows have same width).
 * 
 * The code should protect against null arrays, and return reasonable values
 * 
 * You are strongly encouraged to review all code first, then code incrementally, and 
 * test frequently.
 * 
 * Commit to git often, and definitely after any major milestone (e.g. numGhosts is working).
 * Push your code to the gitlab server regularly (definitely at end of a programming sesson for backup)
 * 
 */

/**
 * 
 * 
 * @author Raymond Sutton
 * 
 *
 */
public class GhostBusters {

	/**
	 * The numCapturedGhosts method determines the number of ghosts that will be
	 * caught if the trap is deployed at (row, col)
	 * 
	 * The trap sends beams out in : North (same column with row indices less
	 * than current row) South (same column with row indices greater than
	 * current row) East (same row with column indices greater than current
	 * column) West (same row with column indices less than current column)
	 * 
	 * Any ghosts encountered can be trapped. The beams stops if it reaches the
	 * room boundary or encounters a wall
	 * 
	 * The ghosts cannot escape the trap, UNLESS the trap lands on a cell
	 * occupied by a ghost. Then the ghost can disable the trap before it works,
	 * and we lose our one and only trap (0 ghosts caught).
	 * 
	 * If the trap hits a wall it is destroyed and 0 ghosts are caught.
	 * 
	 * An invalid room or invalid index traps 0 ghosts.
	 * 
	 * @param room
	 *            - 2D array of characters that models our room
	 * @param row
	 *            - index into row of 2D matrix
	 * @param col
	 *            - index int column of 2D matrix
	 * @return the integer number of ghost encountered by all four beams
	 */

	public static int numCapturedGhosts(char[][] room, int row, int col) {
		if (room == null) {
			return 0;
		}

		int counter = 0;
		int disUp = (room.length - (room.length - row)) + 1;
		int disDown = room.length - row;
		int disRight = room[0].length - col;
		int disLeft = (room[0].length - (room[0].length - col)) + 1;

		try { 
			if (room[row][col] == 'W') {
				return counter;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return counter;
		}
		// N
		for (int i = 1; i < disUp; i++) {
			if (room[row - i][col] == 'G') {
				counter++;
				
			}
			if (room[row - i][col] == 'W') {
				break;
			}
		}
		// S
		for (int i = 1; i < disDown; i++) {
			if (room[row + i][col] == 'G') {
				counter++;
			}
			if (room[row + i][col] == 'W') {
				break;
			}
		}
		// E
		for (int i = 1; i < disRight; i++) {
			if (room[row][col + i] == 'G') {
				counter++;
			}
			if (room[row][col + i] == 'W') {
				break;
			}
		}
		// W
		for (int i = 1; i < disLeft; i++) {
			if (room[row][col - i] == 'G') {
				counter++;
			}
			if (room[row][col - i] == 'W') {
				break;
			}
		}
		return counter;
	}

	/**
	 * Determines the (row, column) location to deploy the trap in order to
	 * catch the MAXIMUM number of ghosts.
	 * 
	 * @param room
	 *            - 2D array of characters that models our room
	 * @return A Location class instance containing the best location to deploy
	 *         the trap (-1, -1) for invalid room or no ghosts can be captured
	 */

	public static Location findBestLocation(char[][] room) {
		int counter = 0;
		int rowValue = 0;
		int colValue = 0;
		int testMaxValue = 0;
		if (room == null) {
			rowValue = -1;
			colValue = -1;
			return new Location(rowValue, colValue);
		}
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[0].length; j++) {
				counter = numCapturedGhosts(room, i, j);
				if (counter > testMaxValue) {
					rowValue = i;
					colValue = j;
					testMaxValue = counter;
				}
			}
		}

		return new Location(rowValue, colValue);
	}

	/**
	 * Creates a deep copy of the room (does not modify the original) and
	 * deploys the trap.
	 * 
	 * If the trap activates, the new array is modified to show all cells
	 * touched by the beam (use Room.DEPLOYED character).
	 * 
	 * determines the (row, column) location to deploy the trap in order to
	 * catch the maximum number of ghosts.
	 * 
	 * @param room
	 *            - 2D array of characters that models our room
	 * @param row
	 *            - index into row of 2D matrix
	 * @param col
	 *            - index int column of 2D matrix
	 * @return A new character array modeling the final room after the trap is
	 *         deployed.
	 */

	public static char[][] deployTrap(char[][] room, int row, int col) {
		if (room == null) {
			return null;
		}
		
		int disUp = (room.length - (room.length - row)) + 1;
		int disDown = room.length - row;
		int disRight = room[0].length - col;
		int disLeft = (room[0].length - (room[0].length - col)) + 1;


		if (room[row][col] == 'W') {
			return room;
		}
		if (room[row][col] == 'G') {
			room[row][col] = '@';
		}
		if (room[row][col] == '.') {
			room[row][col] = '@';
		}
		// N
		for (int i = 1; i < disUp; i++) {
			if (room[row - i][col] == '.') {
				room[row - i][col] = '@';
			}
			if (room[row - i][col] == 'G') {
				room[row - i][col] = '@';
			}
			if (room[row - i][col] == 'W') {
				break;
			}
		}
		// S
		for (int i = 1; i < disDown; i++) {
			if (room[row + i][col] == '.') {
				room[row + i][col] = '@';
			}
			if (room[row + i][col] == 'G') {
				room[row + i][col] = '@';
			}
			if (room[row + i][col] == 'W') {
				break;
			}
		}
		// E
		for (int i = 1; i < disRight; i++) {
			if (room[row][col + i] == '.') {
				room[row][col + i] = '@';
			}
			if (room[row][col + i] == 'G') {
				room[row][col + i] = '@';
			}
			if (room[row][col + i] == 'W') {
				break;
			}
		}
		// W
		for (int i = 1; i < disLeft; i++) {
			if (room[row][col - i] == '.') {
				room[row][col - i] = '@';
			}
			if (room[row][col - i] == 'G') {
				room[row][col - i] = '@';
			}
			if (room[row][col - i] == 'W') {
				break;
			}
		}

		return room;
	}

	// --------- Space to put any utility (helper) functions you might choose to
	// create (not required) -----

	// @todo put any optional utility functions here

	// --------------------------------------------------------------------------------------
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] room = Room.createFixedRoom(1); // Current implementation
													// supports 1, 2, or 3
													// choice
		// char[][] room = Room.createRandomRoom(30,20,16,30);
		Room.displayRoom(room);
		System.out.println(" Original room contains " + Room.countGhosts(room) + " ghosts!");

		int nGhosts = numCapturedGhosts(room, 2, 0); // example usage
		System.out.println(" Number of trapped ghosts from location (2,0) =" + nGhosts);
		System.out.println("                           (For fixed room 1 this should be 3)");

		Location loc = findBestLocation(room); // example usage
		System.out.println("  The best location is " + loc.toString() + " num captured Ghosts="
				+ numCapturedGhosts(room, loc.row, loc.col));

		char[][] newRoom = deployTrap(room, loc.row, loc.col); // example usage

		Room.displayRoom(newRoom); // display the final room
		System.out.println(" New      room contains " + Room.countGhosts(newRoom) + " ghosts!");
		System.out.println("                           (For fixed room 1 this should be 1)");

	}

}
