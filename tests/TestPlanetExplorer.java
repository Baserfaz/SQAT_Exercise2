import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void createPlanetMap() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertNotNull(pe);
	}
	
	@Test
	public void executeCommand_start() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("0, 0, N", pe.executeCommand(""));
	}
	
	@Test
	public void executeCommand_f() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("0, 1, N", pe.executeCommand("f"));
	}
	
	@Test
	public void executeCommand_r() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("0, 0, W", pe.executeCommand("r"));
	}
	
	@Test
	public void executeCommand_input_error() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("0, 0, W", pe.executeCommand("o,123"));
		
	}
	
}

