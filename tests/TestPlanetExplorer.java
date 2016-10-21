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
		assertEquals("(0, 0, N)", pe.executeCommand(""));
	}
	
	@Test
	public void executeCommand_f() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0, 1, N)", pe.executeCommand("f"));
	}
	
	@Test
	public void executeCommand_r() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0, 0, E)", pe.executeCommand("r"));
	}
	
	@Test (expected = PlanetExplorerException.class)
	public void executeCommand_input_error() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		pe.executeCommand("o,123");
	}
	
	@Test 
	public void executeCommand_rrrr() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0, 0, N)", pe.executeCommand("rrrr"));
	}
	
	@Test
	public void executeCommand_rlrl() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0, 0, N)", pe.executeCommand("rlrl"));
	}
	
	@Test
	public void executeCommand_ffrf() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(1, 2, E)", pe.executeCommand("ffrf"));
	}
	
	@Test
	public void executeCommand_ffrfff() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0, 2, E)", pe.executeCommand("ffrfff"));
	}
	
	@Test
	public void executeCommand_wrap_left_to_right() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(2, 0, E)", pe.executeCommand("lf"));
	}
	
}

