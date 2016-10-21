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
	
	
	
}

