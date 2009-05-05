/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.nonreg.parts.forms.EclipseSummitPropertiesEditionPartForm;
import org.eclipse.emf.eef.nonreg.parts.impl.EclipseSummitPropertiesEditionPartImpl;
import org.eclipse.emf.eef.nonreg.parts.forms.PersonPropertiesEditionPartForm;
import org.eclipse.emf.eef.nonreg.parts.impl.PersonPropertiesEditionPartImpl;
import org.eclipse.emf.eef.nonreg.parts.forms.TalkPropertiesEditionPartForm;
import org.eclipse.emf.eef.nonreg.parts.impl.TalkPropertiesEditionPartImpl;
import org.eclipse.emf.eef.nonreg.parts.forms.TopicPropertiesEditionPartForm;
import org.eclipse.emf.eef.nonreg.parts.impl.TopicPropertiesEditionPartImpl;
import org.eclipse.emf.eef.nonreg.parts.forms.PresencePropertiesEditionPartForm;
import org.eclipse.emf.eef.nonreg.parts.impl.PresencePropertiesEditionPartImpl;
import org.eclipse.emf.eef.nonreg.parts.forms.SitePropertiesEditionPartForm;
import org.eclipse.emf.eef.nonreg.parts.impl.SitePropertiesEditionPartImpl;
import org.eclipse.emf.eef.nonreg.parts.forms.AccessPropertiesEditionPartForm;
import org.eclipse.emf.eef.nonreg.parts.impl.AccessPropertiesEditionPartImpl;

/**
 * 
 *
 */
public class NonregPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == NonregViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == NonregViewsRepository.EclipseSummit.class) {
			if (kind == NonregViewsRepository.SWT_KIND)
				return new EclipseSummitPropertiesEditionPartImpl(component);
			if (kind == NonregViewsRepository.FORM_KIND)
				return new EclipseSummitPropertiesEditionPartForm(component);
		}
		if (key == NonregViewsRepository.Person.class) {
			if (kind == NonregViewsRepository.SWT_KIND)
				return new PersonPropertiesEditionPartImpl(component);
			if (kind == NonregViewsRepository.FORM_KIND)
				return new PersonPropertiesEditionPartForm(component);
		}
		if (key == NonregViewsRepository.Talk.class) {
			if (kind == NonregViewsRepository.SWT_KIND)
				return new TalkPropertiesEditionPartImpl(component);
			if (kind == NonregViewsRepository.FORM_KIND)
				return new TalkPropertiesEditionPartForm(component);
		}
		if (key == NonregViewsRepository.Topic.class) {
			if (kind == NonregViewsRepository.SWT_KIND)
				return new TopicPropertiesEditionPartImpl(component);
			if (kind == NonregViewsRepository.FORM_KIND)
				return new TopicPropertiesEditionPartForm(component);
		}
		if (key == NonregViewsRepository.Presence.class) {
			if (kind == NonregViewsRepository.SWT_KIND)
				return new PresencePropertiesEditionPartImpl(component);
			if (kind == NonregViewsRepository.FORM_KIND)
				return new PresencePropertiesEditionPartForm(component);
		}
		if (key == NonregViewsRepository.Site.class) {
			if (kind == NonregViewsRepository.SWT_KIND)
				return new SitePropertiesEditionPartImpl(component);
			if (kind == NonregViewsRepository.FORM_KIND)
				return new SitePropertiesEditionPartForm(component);
		}
		if (key == NonregViewsRepository.Access.class) {
			if (kind == NonregViewsRepository.SWT_KIND)
				return new AccessPropertiesEditionPartImpl(component);
			if (kind == NonregViewsRepository.FORM_KIND)
				return new AccessPropertiesEditionPartForm(component);
		}
		return null;
	}

}

