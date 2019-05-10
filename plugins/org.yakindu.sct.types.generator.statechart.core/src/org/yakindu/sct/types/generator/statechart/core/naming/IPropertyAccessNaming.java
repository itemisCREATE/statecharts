/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.statechart.core.naming;

import org.yakindu.base.types.Property;

public interface IPropertyAccessNaming {

	String nameReadAccess(Property prop);
	
	String nameWriteAccess(Property prop);
	
	String nameAssign(Property prop);
}
