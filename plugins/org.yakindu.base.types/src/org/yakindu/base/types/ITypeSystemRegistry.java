package org.yakindu.base.types;

import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultTypeSystemRegistry.class)
public interface ITypeSystemRegistry {

	public ITypeSystem getTypeSystem(String uriScheme);

	public void addTypeSystem(String uriScheme, ITypeSystem system);

	public void removeTypeSystem(String uriScheme);
	
	public Iterable<ITypeSystem> getAllTypeSystems();
}
