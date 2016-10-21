
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:



public class PlanetExplorer {
	
	public enum Facing {
		N, W, E, S
	}
	
	private Facing myFacing = Facing.N;
	
	// myPosition[0] => X
	// myPosition[1] => Y
	private int[] myPosition = { 0 , 0 };
	
	// map
	private boolean[][] obstacleMap;
	
	// these are needed for the borders
	private int mapWidth = 0;
	private int mapHeight = 0;
	
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		
		mapHeight = y;
		mapWidth = x;
		obstacleMap = new boolean[x][y];
		
		// populate obstacleMap with obstacles
		char[] obstacleCharArr = new char();
		
	}
	
	public boolean IsObstacle(int x, int y) {
		boolean b = false;
		
		
		
		
		return b;
	}
	
	public String executeCommand(String command) throws PlanetExplorerException{
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		// create a character array of the commands.
		char[] commands = command.toLowerCase().toCharArray();
		
		// loop through them.
		for(int i = 0; i < commands.length; i++) {
			
			// forwards
			if(commands[i] == 'f'){
				
				switch(myFacing) {
				case N:
					moveUp();
					break;
				case W:
					moveLeft();
					break;
				case E:
					moveRight();
					break;
				case S:
					moveDown();
					break;
				}
				
			// backwards
			} else if(commands[i] == 'b') {
				
				switch(myFacing) {
				case N:
					moveDown();
					break;
				case W:
					moveRight();
					break;
				case E:
					moveLeft();
					break;
				case S:
					moveUp();
					break;
				}
				
			// turn right = clockwise
			} else if (commands[i] == 'r') {
				
				rotateClockwise();
				
			// turn left = counterclockwise
			} else if (commands[i] == 'l') {
				
				rotateCounterClockwise();
				
			// else incorrect input
			} else {
				throw new PlanetExplorerException();
			}
		}
		
		// create a string and return it.
		return CreateReturnString(myPosition[0], myPosition[1]);
		
	}
	
	private void CheckForObstacle() {
		
	}
	
	private void moveUp() {
		
		// check if the explorer is in the top most cell
		//  -> wrap around the map
		
		if(myPosition[1] == mapHeight - 1)
			myPosition[1] = 0;
		else
			myPosition[1] += 1;
	}
	
	private void moveDown() {
		
		// check if the explorer is in the bottom most cell
		//  -> wrap around the map
		
		if(myPosition[1] == 0)
			myPosition[1] = mapHeight - 1;
 		else
			myPosition[1] -= 1;
	}
	
	private void moveLeft() {
		
		// check if the explorer is in the left most cell
		//  -> wrap around the map
		
		if(myPosition[0] == 0) 
			myPosition[0] = mapWidth - 1;
		else 
			myPosition[0] -= 1;
	}
	
	private void moveRight() {
		
		// check if the explorer is in the right most cell
		// -> wrap.
		
		if(myPosition[0] == mapWidth - 1)
			myPosition[0] = 0;
		else
			myPosition[0] += 1;
 	}
	
	private void rotateClockwise() {
		switch(myFacing) {
		case N:
			myFacing = Facing.E;
			break;
		case S:
			myFacing = Facing.W;
			break;
		case W:
			myFacing = Facing.N;
			break;
		case E:
			myFacing = Facing.S;
			break;
		}
	}
	
	private void rotateCounterClockwise() {
		switch(myFacing) {
		case N:
			myFacing = Facing.W;
			break;
		case S:
			myFacing = Facing.E;
			break;
		case W:
			myFacing = Facing.S;
			break;
		case E:
			myFacing = Facing.N;
			break;
		}
	}
	
	private String CreateReturnString(int x, int y) {
		return "(" + x + ", " + y + ", " + myFacing + ")";
	}
}
