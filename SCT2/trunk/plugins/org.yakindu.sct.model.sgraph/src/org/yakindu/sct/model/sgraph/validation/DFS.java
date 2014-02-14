package org.yakindu.sct.model.sgraph.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** This class implements a generic depth first search algorithm,
 * which can be applied to any structure which can be interpreted as a
 * graph. Since the interpretation of an application specific structure as a graph can't be
 * done by this algorithm implementation, you must implement a subclass
 * .
 * The current implementation only allows to perform the algorithm once.
 *
 * @author Axel Terfloth
 */
@SuppressWarnings("all")
abstract public class DFS {

	/** Indicates whether the algorithm has been performed or not.*/
	private boolean done;

 	/** A map of all visited elements. */
	private Map myVisitedElements;

 	/** An iterator of root elements */
	protected Iterator myElements;

 	/** The number of traversed links. */
	public int linkCount;


	/** Default algorithm constructor. */
	public DFS() {
		done = false;
		myVisitedElements = new HashMap();
		myElements = null;
		linkCount = 0;
	}

	/** Performs the depth first traversion of all elements */
	private synchronized void perform() {
		if (done) return;

		while (myElements.hasNext()) {
			Object element = myElements.next();

			if (!isVisited(element)) {
				visit(element, 1);
			}
		}
	}

	/** Performs the graph traversion with all elements which are contained in the
	 * specified collection. This means that every element of this collection and all
	 * elements which are reachable from these elements will be visited. */
	public synchronized void perform(Collection collection) {
		this.perform(collection.iterator());
	}

	/** Performs the graph traversion with all elements which are contained in the
	 * specified iterator. This means that every element of this collection and all
	 * elements which are reachable from these elements will be visited. */
	public synchronized void perform(Iterator iterator) {
		myElements = iterator;

		this.perform();
	}

	/** Performs the graph traversion with a single root element. So this root element and
	 * all elements which are reachable from this root elements will be visited. */
	public synchronized void perform(Object rootElement) {
		List list = new ArrayList();
		list.add(rootElement);

		this.perform(list.iterator());
	}


	/** Visits an element. */
	private int visit(Object element, int depth) {
		int minDepth = depth;

		if (isVisited(element)) {
			return getVisitedDepth(element);
		}

		setVisited(element, depth);

		beginVisit(element, depth);

		Iterator itr = getElementLinks(element);
		if (itr != null) {
			while (itr.hasNext()) {
				int childDepth = visit(itr.next(), depth + 1);
				minDepth = ((childDepth < minDepth) && (childDepth > -1)) ? childDepth : minDepth;
				linkCount++;
			}
		}

		setVisited(element, -1);

		endVisit(element, depth, minDepth);

		return (minDepth < depth) ? minDepth : depth;
	}

	/** This hook method will be invoked when the DFS begins the visit of an element.
	 * Since there is no return parameter this method will not effect the algorithms
	 * behaviour.
	 *
	 * @param element The element wich will be visited.
	 * @param depth The distance to a root element of the graph traversion.
	 */
	public void beginVisit(Object element, int depth) {
	}

	/** This hook method will be invoked when the DFS finishes the visit of an element.
	 * Since there is no return parameter this method will not effect the algorithms
	 * behaviour.
	 *
	 * @param element The element wich will be visited.
	 * @param depth The distance to a root element of the graph traversion.
	 * @param minDepth If this parameter is smaller than the depth parameter then
	 * an element is reachable from the current element from which the current element is
	 * reachable, which means there is a reachablitiy cycle within the graph.
	 */
	public void endVisit(Object element, int depth, int minDepth) {
	}


	/** This hook method will be invoked to provide an iterator of off elements
	 * which are directly reachable from the current element.
	 *
	 * Subclasses must overwrite this method.
	 *
	 * @param element The current element.
	 * @return An iterator of directly reachable elements.
	 */
	public abstract Iterator getElementLinks(Object element);


	/** Returns true if this element was already visited. */
	public boolean isVisited(Object element) {
		return myVisitedElements.containsKey(element);
	}

	/** */
	private void setVisited(Object element, int depth) {
		myVisitedElements.put(element, new Integer(depth));
	}


	/** Returns the path depth number if the element is in the current path or -1 if it isn't.*/
	public int getVisitedDepth(Object element) {
		if (myVisitedElements.containsKey(element)) {
			return ((Integer) myVisitedElements.get(element)).intValue();
		}

		return -1;
	}

}