package org.yakindu.sct.generator.c;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public class GeneratorEntryAccess {
	public static void setGeneratorEntry(EObject obj, GeneratorEntry entry) {
		ProxyAdapter<?> adapter = (ProxyAdapter<?>) EcoreUtil.getAdapter(
				obj.eAdapters(), ProxyAdapter.class);
		if (adapter != null) {
			throw new IllegalStateException("One Adapter was already added");
		}
		obj.eAdapters().add(new ProxyAdapter<GeneratorEntry>(entry));
	}

	public static GeneratorEntry getGeneratorEntry(EObject obj) {
		ProxyAdapter<?> adapter = (ProxyAdapter<?>) EcoreUtil.getAdapter(
				obj.eAdapters(), ProxyAdapter.class);
		if (adapter != null) {
			Object entry = adapter.getEntry();
			if (entry instanceof GeneratorEntry) {
				return (GeneratorEntry) entry;
			}
		}
		return null;
	}

	public static class ProxyAdapter<T> implements Adapter {
		private final T entry;

		public ProxyAdapter(T entry) {
			this.entry = entry;
		}

		public T getEntry() {
			return entry;
		}

		public void notifyChanged(Notification notification) {
		}

		public Notifier getTarget() {
			return null;
		}

		public void setTarget(Notifier newTarget) {
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}
	}
}
