/**
* Copyright (c) 2016 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	Andreas Muelder - itemis AG
*
*/
package org.yakindu.sct.types.generator.c.typesystem;

import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.GenericTypeValueProvider;
import org.yakindu.base.types.typesystem.ITypeValueProvider;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CTypeValueProvider extends GenericTypeValueProvider implements ITypeValueProvider {

	@Override
	public Object defaultValue(Type type) {
		type = type.getOriginType();
		
		if (is(type, CTypeSystem.UNSUPPORTED_TYPE) || is(type, CTypeSystem.ANY)) {
			return new Any();
		}
		
		return super.defaultValue(type);
	}
}
