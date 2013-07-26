package net.grimjeer.graph;

import java.util.Set;

public interface Graphable<V,E> {
	
	/**
	 * addVertex - add a new vertex to graph
	 * @param v V
	 * @return true if vertex added to graph, false if already present
	 * @throws NullPointerException if v null
	 */
	public boolean addVertex(V v);

	/**
	 * removeVertex - remove vertex from graph, along with any edges containing vertex
	 * @param v V
	 * @return true if vertex removed from graph, false if vertex null or not present
	 */
	public boolean removeVertex(V v);
	
	/**
	 * removeAllVertices
	 */
	public void removeAllVertices();
	
	/**
	 * containsVertex
	 * @param v V
	 * @returns true if graph contains v, false if null or not present
	 */
	public boolean containsVertex(V v);
	
	/**
	 * getAllVertices
	 * @return Set<V>
	 */
	public Set<V> getAllVertices();
	
	/**
	 * addEdge - add edge between two vertices.  add vertices as necessary
	 * @param v1 V
	 * @param v2 V
	 * @param e E
	 * @return true if edge added to graph, false if already present
	 * @throws NullPointerException if either vertex or the edge is null
	 */
	public boolean addEdge(V v1, V v2, E e);
	
	/**
	 * removeEdge - remove edge between two vertices.
	 * @param v1 V
	 * @param v2 V
	 * @return true if edge removed, false if not present
	 */
	public boolean removeEdge(V v1, V v2);
	
	/**
	 * removeAllEdges
	 */
	public void removeAllEdges();
	
	/**
	 * containsEdge
	 * @param v1 V
	 * @param v2 V
	 * @returns true if edge exists between v1 and v2, otherwise false
	 */
	public boolean containsEdge(V v1, V v2);
	
	/**
	 * getEdge - return Edge between two vertices
	 * @param v1 V
	 * @param v2 V
	 * @return E | null
	 */
	public E getEdge(V v1, V v2);
}
