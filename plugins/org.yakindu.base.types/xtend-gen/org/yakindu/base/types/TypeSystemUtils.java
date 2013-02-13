package org.yakindu.base.types;

import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.ITypeSystem;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Type;

@SuppressWarnings("all")
public class TypeSystemUtils {
  public Collection<EnumerationType> getEnumerationTypes(final ITypeSystem ts) {
    List<Type> _types = ts.getTypes();
    Iterable<EnumerationType> _filter = Iterables.<EnumerationType>filter(_types, EnumerationType.class);
    return IterableExtensions.<EnumerationType>toList(_filter);
  }
  
  public Collection<PrimitiveType> getPrimitiveTypes(final ITypeSystem ts) {
    List<Type> _types = ts.getTypes();
    Iterable<PrimitiveType> _filter = Iterables.<PrimitiveType>filter(_types, PrimitiveType.class);
    return IterableExtensions.<PrimitiveType>toList(_filter);
  }
  
  public Collection<ComplexType> getComplexTypes(final ITypeSystem ts) {
    List<Type> _types = ts.getTypes();
    Iterable<ComplexType> _filter = Iterables.<ComplexType>filter(_types, ComplexType.class);
    return IterableExtensions.<ComplexType>toList(_filter);
  }
}
