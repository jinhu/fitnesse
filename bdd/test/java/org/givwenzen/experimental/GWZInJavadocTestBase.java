package org.givwenzen.experimental;

import org.junit.Test;

public class GWZInJavadocTestBase {
	
	@Test
	public void specification() throws Exception {
	    new GWZInJavadoc(this, "src/test/java").execute();
	}
}