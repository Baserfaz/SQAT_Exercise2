import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void createPlanetMap() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		
		assertNotNull(pe);
	}
	
	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}
}
