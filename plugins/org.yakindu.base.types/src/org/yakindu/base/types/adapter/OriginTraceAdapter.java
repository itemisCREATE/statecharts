/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	Axel Terfloth - itemis AG
*
*/
package org.yakindu.base.types.adapter;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * This adapter implementation is used to trace to the element from which this element was derived during a transformation. 
 * 
 * @author terfloth
 *
 */
public class OriginTraceAdapter extends AdapterImpl {

	protected Object origin;
	
	
	public OriginTraceAdapter(Object origin) {
		super();
		this.origin = origin;
	}

	
	public Object getOrigin() {
		return origin;
	}
}
