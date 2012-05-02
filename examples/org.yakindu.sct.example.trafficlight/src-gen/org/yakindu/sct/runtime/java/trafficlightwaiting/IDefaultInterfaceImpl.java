/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.trafficlightwaiting;

import org.yakindu.sct.runtime.java.Event;

public interface IDefaultInterfaceImpl extends DefaultInterface {

	public Event<Events> getEventKeypress1();

	public Event<Events> getEventKeypress2();

}
