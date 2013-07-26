package net.grimjeer.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimpleWeightedGraph {

	@Test
	public void testAddVertexNotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = "Hello";
		// pre
		assertFalse("testAddVertexNotPresent - containsVertex", g.containsVertex(v) );
		// test
		assertTrue("testAddVertexNotPresent - addVertex", g.addVertex(v) );
		// post
		assertTrue("testAddVertexNotPresent - containsVertex", g.containsVertex(v) ); 
	}
	
	@Test
	public void testAddVertexPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = "Hello";
		// pre
		assertFalse("testAddVertexPresent - containsVertex", g.containsVertex(v) );
		assertTrue("testAddVertexPresent - addVertex notPresent", g.addVertex(v) );
		assertTrue("testAddVertexPresent - containsVertex", g.containsVertex(v) );
		// test
		assertFalse("testAddVertexPresent - addVertecx Present", g.addVertex(v) );
		// post
		assertTrue("testAddVertexPresent - containsVertex", g.containsVertex(v) );
	}
	
	@Test
	public void testAddVertexNull() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = null;
		try {
			assertFalse("testAddVertexNull - addVertex Null", g.addVertex(v) );
		} catch (NullPointerException npe) {
			assertTrue("testAddVertexNull", true);
		}
	}

	@Test
	public void testRemoveVertexPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = "Hello";
		// pre
		assertTrue("testRemoveVertexPresent - addVertex", g.addVertex(v) );
		// test
		assertTrue("testRemoveVertexPresent - removeVertex", g.removeVertex(v) );
		// post
		assertFalse("testRemoveVertexPresent - containsVertex", g.containsVertex(v) );
	}
	
	@Test
	public void testRemoveVertexNotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = "Hello";
		// pre
		assertFalse("testRemoveVertexPresent - containsVertex", g.containsVertex(v) );
		// test
		assertFalse("testRemoveVertexPresent - removeVertex", g.removeVertex(v) );
	}
	
	@Test
	public void testRemoveVertexNull() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = null;
		// pre
		assertFalse("testRemoveVertexNull - containsVertex", g.containsVertex(v) );
		// test
		assertFalse("testRemoveVertexNull - removeVertex", g.removeVertex(v) );
	}
	
	@Test
	public void testContainsVertexPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		String v = "Hello";
		// pre
		assertTrue("testContainsVertexPresent - addVertex", g.addVertex(v) );
		// test
		assertTrue("testContainsVertexPresent - containsVertex", g.containsVertex(v) );
	}
	
	@Test
	public void testContainsVertexNotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = "Hello";
		assertFalse("testContainsVertexNotPresent - containsVertex", g.containsVertex(v) );
	}

	@Test
	public void testContainsVertexNull() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v = null;
		assertFalse("testContainsVertexNull - containsVertex", g.containsVertex(v) );
	}

	
	@Test
	public void testAddEdgeNotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		final Double e = 2.0;
		// pre
		assertFalse("testAddEdgeNotPresent - containsEdge not present ", g.containsEdge(v1, v2) );
		assertFalse("testAddEdgeNotPresent - containsVertex not present " + v1, g.containsVertex(v1) );
		assertFalse("testAddEdgeNotPresent - containsVertex not present " + v2, g.containsVertex(v2) );
		// test
		assertTrue("testAddEdgeNotPresent - addEdge " + v1, g.addEdge(v1, v2, e) );
		// post
		assertTrue("testAddEdgeNotPresent - containsEdge present v1 v2", g.containsEdge(v1, v2) );
		assertTrue("testAddEdgeNotPresent - containsEdge present v2 v1", g.containsEdge(v2, v1) );
	}
	
	@Test
	public void testAddEdgeV1Present() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		final Double e = 2.0;
		// pre
		assertTrue("testAddEdgeV1Present - addVertex v1 " + v1, g.addVertex(v1) );
		assertTrue("testAddEdgeV1Present - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testAddEdgeV1Present - containsVertex not present " + v1, g.containsVertex(v2) );
		// test
		assertTrue("testAddEdgeV1Present - addEdge " + v1, g.addEdge(v1, v2, e) );
		// post
		assertTrue("testAddEdgeV1Present - contextVertex v1 " + v1, g.containsVertex(v1) );
		assertTrue("testAddEdgeV1Present - containsEdge present v1 v2", g.containsEdge(v1, v2) );
		assertTrue("testAddEdgeV1Present - containsEdge present v2 v1", g.containsEdge(v2, v1) );
	}
	
	@Test
	public void testAddEdgeV2Present() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		final Double e = 2.0;
		// pre
		assertTrue("testAddEdgeV2Present - addVertex v2 " + v2, g.addVertex(v2) );
		assertTrue("testAddEdgeV2Present - containsVertex v2 " + v2, g.containsVertex(v2) );
		assertFalse("testAddEdgeV2Present - containsVertex not present v1 " + v1, g.containsVertex(v1) );
		// test
		assertTrue("testAddEdgeV2Present - addEdge " + v1, g.addEdge(v1, v2, e) );
		// post
		assertTrue("testAddEdgeV2Present - containsVertex v1 " + v1, g.containsVertex(v1) );
		assertTrue("testAddEdgeV2Present - containsVertex v2 " + v2, g.containsVertex(v2) );
		assertTrue("testAddEdgeV2Present - containsEdge present v1 v2", g.containsEdge(v1, v2) );
		assertTrue("testAddEdgeV2Present - containsEdge present v2 v1", g.containsEdge(v2, v1) );
	}
	
	@Test
	public void testAddEdgeV1V2Present() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		final Double e = 2.0;
		// pre
		assertTrue("testAddEdgeV1V2Present - addVertex v1 " + v1, g.addVertex(v1) );
		assertTrue("testAddEdgeV1V2Present - containsVertex " + v1, g.containsVertex(v1) );
		assertTrue("testAddEdgeV1V2Present - addVertex v2 " + v2, g.addVertex(v2) );
		assertTrue("testAddEdgeV1V2Present - containsVertex " + v2, g.containsVertex(v2) );
		// test
		assertTrue("testAddEdgeV1V2Present - addEdge " + v1, g.addEdge(v1, v2, e) );
		// post
		assertTrue("testAddEdgeV1V2Present - containsEdge present v1 v2", g.containsEdge(v1, v2) );
		assertTrue("testAddEdgeV1V2Present - containsEdge present v2 v1", g.containsEdge(v2, v1) );
	}
	
	@Test
	public void testAddEdgeV1V2EPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		final Double e = 2.0;
		// pre
		assertTrue("testAddEdgeV1V2EPresent - addVertex v1 " + v1, g.addVertex(v1) );
		assertTrue("testAddEdgeV1V2EPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertTrue("testAddEdgeV1V2EPresent - addVertex v2 " + v2, g.addVertex(v2) );
		assertTrue("testAddEdgeV1V2EPresent - containsVertex " + v2, g.containsVertex(v2) );
		// test
		assertTrue("testAddEdgeV1V2EPresent - addEdge not present ", g.addEdge(v1, v2, e) );
		// post
		assertTrue("testAddEdgeV1V2EPresent - containsEdge present v1 v2", g.containsEdge(v1, v2) );
		assertTrue("testAddEdgeV1V2EPresent - containsEdge present v2 v1", g.containsEdge(v2, v1) );
		assertFalse("testAddEdgeV1VE2Present - addEdge present ", g.addEdge(v1, v2, e) );
	}
	
	@Test 
	public void testAddEdgeV1V2Equal() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = v1;
		final Double e = 2.0;
		// pre
		assertTrue("testAddEdgeV1V2Equal - addVertex v1 " + v1, g.addVertex(v1) );
		assertTrue("testAddEdgeV1V2Equal - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testAddEdgeV1V2Equal - addVertex v1 " + v2, g.addVertex(v2) );
		assertTrue("testAddEdgeV1V2Equal - containsVertex " + v2, g.containsVertex(v2) );
		// test
		try {
			assertFalse("testAddEdgeV1V2Equal - addEdge not present ", g.addEdge(v1, v2, e) );
		} catch (IllegalArgumentException iae) {
			assertTrue("testAddEdgeV1V2Equal - IllegalArgumentException", true);
		}
		// post
		assertFalse("testAddEdgeV1V2Equal - containsEdge not present v1 v2", g.containsEdge(v1, v2) );
		assertFalse("testAddEdgeV1V2Equal - containsEdge not present v2 v1", g.containsEdge(v2, v1) );
	}
	
	@Test
	public void testAddEdgeV1VNull() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = null;
		final String v2 = "Goodbye";
		final Double e = 2.0;
		// test
		try {
			assertTrue("testAddEdgeV1Null - addEdge " + v1, g.addEdge(v1, v2, e) );
		} catch (NullPointerException npe) {
			assertTrue("testAddEdgeV1Null", true);
		}
		// post
		assertFalse("testAddEdgeV1Null - containsEdge not present v1 v2", g.containsEdge(v1, v2) );
		assertFalse("testAddEdgeV1Null - containsEdge not present v2 v1", g.containsEdge(v2, v1) );
	}
	
	@Test
	public void testAddEdgeV2VNull() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = null;
		final Double e = 2.0;
		// test
		try {
			assertTrue("testAddEdgeV2Null - addEdge " + v2, g.addEdge(v1, v2, e) );
		} catch (NullPointerException npe) {
			assertTrue("testAddEdgeV2Null", true);
		}
		// post
		assertFalse("testAddEdgeV2Null - containsEdge not present v1 v2", g.containsEdge(v1, v2) );
		assertFalse("testAddEdgeV2Null - containsEdge not present v2 v1", g.containsEdge(v2, v1) );
	}
	
	public void testAddEdgeEVNull() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		final Double e = null;
		// test
		try {
			assertTrue("testAddEdgeENull - addEdge " + e, g.addEdge(v1, v2, e) );
		} catch (NullPointerException npe) {
			assertTrue("testAddEdgeENull", true);
		}
	}
	
	@Test
	public void testRemoveEdgeV1NotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		// pre
		assertFalse("testRemoveEdgeV1NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testRemoveEdgeV1NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertTrue("testRemoveEdgeV1NotPresent - addVertex notPresent", g.addVertex(v2) );
		assertTrue("testRemoveEdgeV1NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertFalse("testRemoveEdgeV1NotPresent - containsEdge not present v1", g.containsEdge(v1, v2) );
		assertFalse("testRemoveEdgeV1NotPresent - containsEdge not present v1", g.containsEdge(v2, v1) );
		// test
		assertFalse("testRemoveEdgeV1NotPresent - removeEdge not present v1", g.removeEdge(v1, v2) );
		assertFalse("testRemoveEdgeV1NotPresent - removeEdge not present v1", g.removeEdge(v2, v1) );
		// post
		assertTrue("testRemoveEdgeV1NotPresent - containsVertex " + v2, g.containsVertex(v2) );
	}
	
	@Test
	public void testRemoveEdgeV2NotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		// pre
		assertFalse("testRemoveEdgeV2NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertFalse("testRemoveEdgeV2NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertTrue("testRemoveEdgeV2MotPresent - addVertex notPresent", g.addVertex(v1) );
		assertTrue("testRemoveEdgeV2NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testRemoveEdgeV2NotPresent - containsEdge not present v2", g.containsEdge(v1, v2) );
		assertFalse("testRemoveEdgeV2NotPresent - containsEdge not present v2", g.containsEdge(v2, v1) );
		// test
		assertFalse("testRemoveEdgeV2NotPresent - removeEdge not present v2", g.removeEdge(v1, v2) );
		assertFalse("testRemoveEdgeV2NotPresent - removeEdge not present v2", g.removeEdge(v2, v1) );
		// post
		assertTrue("testRemoveEdgeV2NotPresent - containsVertex " + v1, g.containsVertex(v1) );
	}
	
	@Test
	public void testRemoveEdgeENotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		// pre
		assertFalse("testRemoveEdgeENotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertTrue("testRemoveEdgeEMotPresent - addVertex notPresent", g.addVertex(v1) );
		assertTrue("testRemoveEdgE2NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testRemoveEdgeENotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertTrue("testRemoveEdgeEMotPresent - addVertex notPresent", g.addVertex(v2) );
		assertTrue("testRemoveEdgE2NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertFalse("testRemoveEdgeENotPresent - containsEdge not present v2", g.containsEdge(v1, v2) );
		assertFalse("testRemoveEdgeENotPresent - containsEdge not present v2", g.containsEdge(v2, v1) );
		// test
		assertFalse("testRemoveEdgeENotPresent - removeEdge not present v2", g.removeEdge(v1, v2) );
		assertFalse("testRemoveEdgeENotPresent - removeEdge not present v2", g.removeEdge(v2, v1) );
		// post
		assertTrue("testRemoveEdgeENotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertTrue("testRemoveEdgeENotPresent - containsVertex " + v2, g.containsVertex(v2) );
	}

	@Test
	public void testRemoveEdgeNotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		assertFalse("testRemoveEdgeNotPresent - containsEdge ", g.containsEdge(v1, v2) );
	}
	
	@Test
	public void testGetEdgeNotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		// pre
		assertFalse("testGetEdgeNotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testGetEdgeNotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertFalse("testGetEdgeNotPresent - containsEdge ", g.containsEdge(v1, v2) );
		assertFalse("testGetEdgeNotPresent - containsEdge ", g.containsEdge(v2, v1) );
		// test
		assertNull("testGetEdgeNotPresent - getEdge ", g.getEdge(v1, v2) );
		assertNull("testGetEdgeNotPresent - getEdge ", g.getEdge(v2, v1) );
	}
	
	@Test
	public void testGetEdgeV1NotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		// pre
		assertFalse("testGetEdgeV1NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testGetEdgeV1NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertTrue("testGetEdgeV1NotPresent - addVertex " + v1, g.addVertex(v1) );
		assertTrue("testGetEdgeV1NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testGetEdgeV1NotPresent - containsEdge ", g.containsEdge(v1, v2) );
		assertFalse("testGetEdgeV1NotPresent - containsEdge ", g.containsEdge(v2, v1) );
		// test
		assertNull("testGetEdgeV1NotPresent - getEdge ", g.getEdge(v1, v2) );
		assertNull("testGetEdgeV1NotPresent - getEdge ", g.getEdge(v2, v1) );
		// post
		assertTrue("testGetEdgeV1NotPresent - containsVertex " + v1, g.containsVertex(v1) );
	}
	
	@Test
	public void testGetEdgeV2NotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		// pre
		assertFalse("testGetEdgeV2NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testGetEdgeV2NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertTrue("testGetEdgeV2NotPresent - addVertex " + v2, g.addVertex(v2) );
		assertTrue("testGetEdgeV2NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertFalse("testGetEdgeV2NotPresent - containsEdge ", g.containsEdge(v1, v2) );
		assertFalse("testGetEdgeV2NotPresent - containsEdge ", g.containsEdge(v2, v1) );
		// test
		assertNull("testGetEdgeV2NotPresent - getEdge ", g.getEdge(v1, v2) );
		assertNull("testGetEdgeV2NotPresent - getEdge ", g.getEdge(v2, v1) );
		// post
		assertTrue("testGetEdgeV2NotPresent - containsVertex " + v2, g.containsVertex(v2) );	
	}
	
	@Test
	public void testGetEdgeENotPresent() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		// pre
		assertFalse("testGetEdgeV2NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertTrue("testGetEdgeV2NotPresent - addVertex " + v1, g.addVertex(v1) );
		assertTrue("testGetEdgeV2NotPresent - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testGetEdgeV2NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertTrue("testGetEdgeV2NotPresent - addVertex " + v2, g.addVertex(v2) );
		assertTrue("testGetEdgeV2NotPresent - containsVertex " + v2, g.containsVertex(v2) );
		assertFalse("testGetEdgeV2NotPresent - containsEdge ", g.containsEdge(v1, v2) );
		assertFalse("testGetEdgeV2NotPresent - containsEdge ", g.containsEdge(v2, v1) );
		// test
		assertNull("testGetEdgeV2NotPresent - getEdge ", g.getEdge(v1, v2) );
		assertNull("testGetEdgeV2NotPresent - getEdge ", g.getEdge(v2, v1) );
		// post
		assertTrue("testGetEdgeV2NotPresent - containsVertex " + v2, g.containsVertex(v2) );
	}
	
	@Test
	public void testGetEdge() {
		final Graphable<String,Double> g = new SimpleWeightedGraph<String,Double>();
		final String v1 = "Hello";
		final String v2 = "Goodbye";
		final Double e = 2.0;
		// pre
		assertFalse("testGetEdge - containsVertex " + v1, g.containsVertex(v1) );
		assertTrue("testGetEdge - addVertex " + v1, g.addVertex(v1) );
		assertTrue("testGetEdge - containsVertex " + v1, g.containsVertex(v1) );
		assertFalse("testGetEdge - containsVertex " + v2, g.containsVertex(v2) );
		assertTrue("testGetEdge - addVertex " + v2, g.addVertex(v2) );
		assertTrue("testGetEdge - containsVertex " + v2, g.containsVertex(v2) );
		assertTrue("testGetEdge - addEdge", g.addEdge(v1, v2, e) );
		assertTrue("testGetEdge - containsEdge ", g.containsEdge(v1, v2) );
		assertTrue("testGetEdge - containsEdge ", g.containsEdge(v2, v1) );
		// test
		assertNotNull("testGetEdge - getEdge ", g.getEdge(v1, v2) );
		assertNotNull("testGetEdge - getEdge ", g.getEdge(v2, v1) );
		assertSame("testGetEdge - getEdge ", e, g.getEdge(v2, v1) );
		// post
		assertTrue("testGetEdge - containsVertex " + v1, g.containsVertex(v2) );
		assertTrue("testGetEdge - containsVertex " + v2, g.containsVertex(v1) );
		assertTrue("testGetEdge - containsEdge ", g.containsEdge(v1, v2) );
		assertTrue("testGetEdge - containsEdge ", g.containsEdge(v2, v1) );
	}
}
