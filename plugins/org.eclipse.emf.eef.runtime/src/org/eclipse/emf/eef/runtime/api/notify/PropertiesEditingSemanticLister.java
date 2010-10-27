/**
 * 
 */
package org.eclipse.emf.eef.runtime.api.notify;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class PropertiesEditingSemanticLister extends EContentAdapter {
	
	private IPropertiesEditionComponent component;
	private IPropertiesEditionPart part;

	/**
	 * @param component
	 */
	public PropertiesEditingSemanticLister(IPropertiesEditionComponent component) {
		this.component = component;
	}

	/**
	 * @return the part
	 */
	public IPropertiesEditionPart getPart() {
		return part;
	}

	/**
	 * @param part the part to set
	 */
	public void setPart(IPropertiesEditionPart part) {
		this.part = part;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(final Notification notification) {
		if (part == null)
			component.dispose();
		else {
			Runnable updateRunnable = new Runnable() {
				public void run() {
					runUpdateRunnable(notification);
				}
			};
			if (null == Display.getCurrent()) {
				PlatformUI.getWorkbench().getDisplay().syncExec(updateRunnable);
			} else {
				updateRunnable.run();
			}
		}
	}

	/**
	 * Performs update in the views
	 * @param notification the model notification
	 */
	public abstract void runUpdateRunnable(Notification notification);

}
