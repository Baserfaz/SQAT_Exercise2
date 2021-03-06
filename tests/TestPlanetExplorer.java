import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void createPlanetMap() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertNotNull(pe);
	}
	
	@Test
	public void executeCommand_start() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,N)", pe.executeCommand(""));
	}
	
	@Test
	public void executeCommand_f() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,1,N)", pe.executeCommand("f"));
	}
	
	@Test
	public void executeCommand_r() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,E)", pe.executeCommand("r"));
	}
	
	@Test (expected = PlanetExplorerException.class)
	public void executeCommand_input_error() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		pe.executeCommand("o123");
	}
	
	@Test 
	public void executeCommand_rrrr() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,N)", pe.executeCommand("rrrr"));
	}
	
	@Test
	public void executeCommand_rlrl() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,N)", pe.executeCommand("rlrl"));
	}
	
	@Test
	public void executeCommand_ffrf() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(1,2,E)", pe.executeCommand("ffrf"));
	}
	
	@Test
	public void executeCommand_ffrfff() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,2,E)", pe.executeCommand("ffrfff"));
	}
	
	@Test
	public void executeCommand_wrap_left_to_right() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(2,0,W)", pe.executeCommand("lf"));
	}
	
	@Test
	public void executeCommand_wrap_right_to_left() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,E)", pe.executeCommand("rfff"));
	}
	
	@Test
	public void executeCommand_wrap_top_to_bottom() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,N)", pe.executeCommand("fff"));
	}
	
	@Test
	public void executeCommand_wrap_bottom_to_top() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,2,N)", pe.executeCommand("b"));
	}
	
	@Test
	public void isObstacle_1_1_true() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(1,1)");
		assertEquals(true, pe.IsObstacle(1,1));
	}
	
	@Test
	public void isObstacle_2_1_true() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(2,1)");
		assertEquals(true, pe.IsObstacle(2,1));
	}
	
	@Test
	public void isObstacle_2_1_false() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(2,1)");
		assertEquals(false, pe.IsObstacle(1,1));
	}
	
	@Test
	public void executeCommand_ffrf_one_obstacle_0_2() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(0,2)");
		assertEquals("(1,1,E)(0,2)", pe.executeCommand("ffrf"));
	}
	
	@Test
	public void executeCommand_ffrf_two_obstacles_0_2_and_1_1() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(0,2)(1,1)");
		assertEquals("(0,1,E)(0,2)(1,1)", pe.executeCommand("ffrf"));
	}
	
	@Test
	public void executeCommand_flff_one_obstacle_1_1() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(1,1)");
		assertEquals("(2,1,W)(1,1)", pe.executeCommand("flff"));
	}
	
	@Test
	public void executeCommand_frfrf_one_obstacle_1_0() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(1,0)");
		assertEquals("(1,1,S)(1,0)", pe.executeCommand("frfrf"));
	}
	
	@Test
	public void executeCommand_ffrfllfrbb_two_obstacles_1_2_and_2_0() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(1,2)(2,0)");
		assertEquals("(2,1,N)(1,2)(2,0)", pe.executeCommand("ffrfllfrbb"));
	}
	
}

