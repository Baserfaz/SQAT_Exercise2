import java.util.Arrays;
import java.util.*;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {
	
	public enum Facing {
		N, W, E, S
	}
	
	private Facing myFacing = Facing.N;
	
	// myPosition[0] => X-axis
	// myPosition[1] => Y-axis
	private int[] myPosition = { 0 , 0 };
	
	// map of all obstacles in a map
	// true => it's an obstacle.
	private boolean[][] obstacleMap;
	
	// these are needed for the borders
	private int mapWidth = 0;
	private int mapHeight = 0;
	
	// this is a list of obstacles we hit.
	private List<int[]> hitObstacles = new ArrayList<int[]>();
	
	public PlanetExplorer(int x, int y, String obstacles){
		
		mapHeight = y;
		mapWidth = x;
		obstacleMap = new boolean[x][y];
		
		// fill the empty map with false.
		// -> later we fill the true values.
		for (boolean[] row: obstacleMap)
		    Arrays.fill(row, false);
		
		// create a character array of obstacle's positional information.
		char[] oArr = obstacles.toLowerCase().toCharArray();
		
		// TODO:
		// extremely naive way to populate a map.
		// 1. error handling.
		
		// loop through obstacle character array and populate obstacleMap.
		for(int i = 0; i < oArr.length; i++) {
			
			int xpos = 0;
			int ypos = 0;
			boolean isObstacle = false;
			
			// the second char is x-pos.
			// the third char is y-pos.
			// -'0' => converting char to int.
			if(oArr[i] == '(') {
				isObstacle = true;
				xpos = oArr[i+1] - '0'; 
				ypos = oArr[i+3] - '0';
			}
			
			// populate obstacleMap with obstacles
			if(isObstacle)
				obstacleMap[xpos][ypos] = true;
			
			isObstacle = false;
		}
	}
	
	public boolean IsObstacle(int x, int y) {
		if(obstacleMap[x][y] == true) return true; 
		return false;
	}
	
	public String executeCommand(String command) throws PlanetExplorerException{
		
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
	
	// TODO:
	// check if there is an obstacle if we wrap around some axis.
	// -> can we even wrap around.
	
	private void moveUp() {
		
		// check for obstacles
		try {
			if(IsObstacle(myPosition[0], myPosition[1] + 1) == true) {
				hitObstacles.add(new int[] { myPosition[0], myPosition[1] + 1 });
				return;
			}
		} catch (IndexOutOfBoundsException e) {
			// do something here.
		}
		
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
		
		String obstacleString = "";
		
		if(hitObstacles.size() > 0) {
			
			for(int[] arr : hitObstacles) {
				
			}
			
		}
		
		return "(" + x + ", " + y + ", " + myFacing + ")";
	}
}
