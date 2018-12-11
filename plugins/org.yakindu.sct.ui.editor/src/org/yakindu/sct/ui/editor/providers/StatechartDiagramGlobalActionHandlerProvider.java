/**
 * This is a copy of
 * {@link org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandlerProvider}.
 *
 * We had to copy the original class because it is final, so we cannot subclass
 * it.
 *
 * The only purpose of this copy is to return
 * {@link org.yakindu.sct.ui.editor.providers.StatechartDiagramGlobalActionHandler}
 * which returns our own copy command
 * {@link org.yakindu.sct.ui.editor.providers.SubdiagramAwareCopyCommand} to
 * copy sub diagrams when states get copied.
 */

package org.yakindu.sct.ui.editor.providers;

import java.util.Hashtable;

import org.eclipse.gmf.runtime.common.ui.services.action.global.AbstractGlobalActionHandlerProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author kutz
 */
@SuppressWarnings("rawtypes")
public class StatechartDiagramGlobalActionHandlerProvider extends AbstractGlobalActionHandlerProvider {
	
	/**
	 * List that contains all the IGlobalActionHandlers mapped to the
	 * IWorkbenchParts
	 */
	private Hashtable handlerList = new Hashtable();
	
	/**
	 * Constructor for DiagramGlobalActionHandlerProvider.
	 */
	public StatechartDiagramGlobalActionHandlerProvider() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerProvider#getGlobalActionHandler(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public IGlobalActionHandler getGlobalActionHandler(
			final IGlobalActionHandlerContext context) {
		/* create the handler */
		if (!getHandlerList().containsKey(context.getActivePart())) {

			// PATCH START
			getHandlerList().put(context.getActivePart(),
					new StatechartDiagramGlobalActionHandler());
			// PATCH END

			/*
			 * register as a part listener so that the cache can be cleared when
			 * the part is disposed
			 */
			context.getActivePart().getSite().getPage().addPartListener(
					new IPartListener() {
						
						private IWorkbenchPart localPart = context.getActivePart();
						
						/**
						 * @see org.eclipse.ui.IPartListener#partActivated(IWorkbenchPart)
						 */
						@Override
						public void partActivated(IWorkbenchPart part) {
							// NULL implementation
						}
						
						/**
						 * @see org.eclipse.ui.IPartListener#partBroughtToTop(IWorkbenchPart)
						 */
						@Override
						public void partBroughtToTop(IWorkbenchPart part) {
							// NULL implementation
						}
						
						/**
						 * @see org.eclipse.ui.IPartListener#partClosed(IWorkbenchPart)
						 */
						@Override
						public void partClosed(IWorkbenchPart part) {
							/* remove the cache associated with the part */
							if (part != null && part == localPart
									&& getHandlerList().containsKey(part)) {
								getHandlerList().remove(part);
								localPart.getSite().getPage().removePartListener(
										this);
								localPart = null;
							}
						}
						
						/**
						 * @see org.eclipse.ui.IPartListener#partDeactivated(IWorkbenchPart)
						 */
						@Override
						public void partDeactivated(IWorkbenchPart part) {
							// NULL implementation
						}
						
						/**
						 * @see org.eclipse.ui.IPartListener#partOpened(IWorkbenchPart)
						 */
						@Override
						public void partOpened(IWorkbenchPart part) {
							// NULL implementation
						}
					});
		}
		return (DiagramGlobalActionHandler) getHandlerList().get(
				context.getActivePart());
	}
	
	/**
	 * Returns the handlerList.
	 *
	 * @return Hashtable
	 */
	private Hashtable getHandlerList() {
		return handlerList;
	}

}
