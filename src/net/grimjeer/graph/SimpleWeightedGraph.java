package net.grimjeer.graph;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * SimpleWeightedGraph<V,E> -
 * Simple: undirected, no loops, single edges between vertices
 * Weighted: non-negative weight on edges
 *  
 * @author jbgreer
 *
 * @param <V> Vertex Type
 * @param <E> Edge Type
 */
public class SimpleWeightedGraph<V,E> implements Graphable<V,E> {

	/*
	 * Graph is represented as a Map of Vertices(Key) to an associated Map(Values).
	 * The Values Map is an association of Vertices(Key) to Edges(Values).
	 * That is, we have a vertex with zero or edges linking to other vertices.
	 * 
	 * We start with an empty graph.
	 */
	private final HashMap<V,HashMap<V,E> > g = new HashMap<V, HashMap<V,E> >();

	/**
	 * SimpleWeightedGroup - constructor
	 */
	public SimpleWeightedGraph() { }
	
	/**
	 * addVertex - add a new vertex to graph
	 * @param v V
	 * @return true if vertex added to graph, false if already present
	 * @throws NullPointerException if v null
	 */
	public boolean addVertex(V v) {
		if (v != null) {
			if (! containsVertex(v) ) {
				g.put(v, new HashMap<V,E>() );
				return true;
			} else {
				return false;
			}
		} else {
			throw new NullPointerException("addVertex: Vertex Null");
		}
	}
	
	/**
	 * removeVertex - remove vertex from graph, along with any edges containing vertex
	 * @param v V
	 * @return true if vertex removed from graph, false if vertex null or not present
	 */
	public boolean removeVertex(V v) {
		
		// assume that if vertex doesn't exist in graph, no edge contains it
		if (containsVertex(v) ) {
			
			// remove edges starting at a vk (a destination from v)
				for (V vk : g.keySet() ) {
					removeEdge(vk, v);
				}

			// remove v itself
			g.remove(v);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * containsVertex
	 * @param v V
	 * @returns true if graph contains v, false if null or not present
	 */
	public boolean containsVertex(V v) {
		return g.containsKey(v);
	}
	
	/**
	 * getAllVertices
	 * @returns Set<V>
	 */
	public Set<V> getAllVertices() {
		return g.keySet();
	}
	
	/**
	 * removeAllVertices
	 */
	public void removeAllVertices() {
		for (V v : g.keySet() ) {
			removeVertex(v);
		}
	}
	
	/**
	 * addEdge - add edge between two vertices, adding vertices as necessary
	 * @param v1 V
	 * @param v2 V
	 * @param e E
	 * @return true if edge added to graph, false if already present
	 * @throws NullPointerException if either vertex or the edge is null
	 * @throws IllegalArgumentException if v1 == v2
	 */
	public boolean addEdge(V v1, V v2, E e) {
		
		if (v1 == null) {
			throw new NullPointerException("addEdge : NullPointerException v1");
		}
		if (v2 == null) {
			throw new NullPointerException("addEdge : NullPointerException v2");
		}
		if (e == null) {
			throw new NullPointerException("addEdge : NullPointerException e");
		}
		if (v1 == v2) {
			throw new IllegalArgumentException("addEdge : IllegalArgumentException");
		}
		
		// represented as two edges (one from v1 to v2, another from v2 to v1)
		boolean f = addEdgeBetweenVertices(v1, v2, e);
		return addEdgeBetweenVertices(v2, v1, e) || f;
	}
	
	/**
	 * addEdgeBetweenVertices - adds vertices as necessary and an edge from v1 to v2
	 * @param v1 V
	 * @param v2 V
	 * @param e E
	 * @return true if either vertex added or edge, false otherwise
	 */
	private boolean addEdgeBetweenVertices(V v1, V v2, E e) {
		boolean f = addVertex(v1);
		f = addVertex(v2) || f;
	
		Map<V,E> es = g.get(v1);
		if (! es.containsKey(v2) ) {
			f = true;
		}
		es.put(v2, e);
	
		return f;
	}
	
	/**
	 * removeEdge - remove edge between two vertices.
	 * @param v1 V
	 * @param v2 V
	 * @return true if edge removed, false if not present
	 */
	public boolean removeEdge(V v1, V v2) {
		boolean f = removeEdgeBetweenVertices(v1, v2);
		return removeEdgeBetweenVertices(v2, v1) || f;
	}
	
	/**
	 * removeAllEdges
	 */
	public void removeAllEdges() {
		for (V v1 : getAllVertices() ) {
			for (V v2 : getAllVertices() ) {
				removeEdge(v1, v2);
			}
		}
	}
	
	/**
	 * removeEdgeBetweenVertices - remove edge from v1 to v2
	 * @param v1 V
	 * @param v2 V
	 * @return true if edge removed, false otherwise
	 */
	private boolean removeEdgeBetweenVertices(V v1, V v2) {
		if (containsVertex(v1) ) {
			final Map<V,E> es = g.get(v1);
			if (es.containsKey(v2) ) {
				es.remove(v2);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * containsEdge - check for presence of edge between two vertices
	 * @param v1 V
	 * @param v2 V
	 * @return false if v1 or v2 or edge not present, otherwise true
	 */
	public boolean containsEdge(V v1, V v2) {
		if (containsVertex(v1) ) {
			Map<V,E> es = g.get(v1);
			return es.containsKey(v2);
		} else {
			return false;
		}
	}
	
	/**
	 * getEdge - return Edge between two vertices
	 * @param v1 V
	 * @param v2 V
	 * @return E | null
	 */
	public E getEdge(V v1, V v2) {
		if (containsVertex(v1) && containsVertex(v2) && containsEdge(v1, v2) ) {
			return g.get(v1).get(v2);
		} else {
			return null;
		}
	}
	
	/**
	 * getAllEdges
	 * @param v V
	 * @return Set<V>
	 */
	public Set<V> getAllEdges(V v) {
		if (containsVertex(v) ) {
			Map<V,E> es = g.get(v);
			return Collections.unmodifiableSet(es.keySet() );
		} else
			return new HashSet<V>();
	}
	
	/**
	 * toString - return string representation of graph
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		// walk through set of vertices
		for (V vk : g.keySet() ) {
			
			// and for each list out adjacent nodes and their weights
			sb.append(vk + " : ");
			Map<V,E> es = g.get(vk);
			for (V ek : es.keySet() ) {
				sb.append("[" + ek + " : " + es.get(ek));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
