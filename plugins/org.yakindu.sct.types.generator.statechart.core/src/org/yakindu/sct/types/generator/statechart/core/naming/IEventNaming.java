/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.statechart.core.naming;

public interface IEventNaming {
	public String nameEventRaiser(CharSequence s);

	public String nameEventRaised(CharSequence s);

	public String nameEventValue(CharSequence s);

	public String nameEventValueGetter(CharSequence s);

	public String nameEventIsRaised(CharSequence s);
}
