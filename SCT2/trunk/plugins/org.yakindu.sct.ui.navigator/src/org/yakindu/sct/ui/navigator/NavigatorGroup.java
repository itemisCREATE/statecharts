package org.yakindu.sct.ui.navigator;

import java.util.Collection;
import java.util.LinkedList;
@SuppressWarnings("rawtypes")

public class NavigatorGroup extends AbstractNavigatorItem {

	private String myGroupName;

	private String myIcon;

	private Collection<Object> myChildren = new LinkedList<Object>();

	NavigatorGroup(String groupName, String icon, Object parent) {
		super(parent);
		myGroupName = groupName;
		myIcon = icon;
	}

	public String getGroupName() {
		return myGroupName;
	}

	public String getIcon() {
		return myIcon;
	}

	public Object[] getChildren() {
		return myChildren.toArray();
	}

	public void addChildren(Collection children) {
		myChildren.addAll(children);
	}

	public void addChild(Object child) {
		myChildren.add(child);
	}

	public boolean isEmpty() {
		return myChildren.size() == 0;
	}

	public boolean equals(Object obj) {
		if (obj instanceof NavigatorGroup) {
			NavigatorGroup anotherGroup = (NavigatorGroup)obj;
			if (getGroupName().equals(anotherGroup.getGroupName())) {
				return getParent().equals(anotherGroup.getParent());
			}
		}
		return super.equals(obj);
	}
	
	public int hashCode() {
		return getGroupName().hashCode();
	}

}
