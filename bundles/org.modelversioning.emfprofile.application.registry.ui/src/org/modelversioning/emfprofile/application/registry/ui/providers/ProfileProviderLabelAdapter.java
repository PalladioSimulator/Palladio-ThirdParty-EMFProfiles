package org.modelversioning.emfprofile.application.registry.ui.providers;

import java.net.URL;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.modelversioning.emfprofile.Stereotype;
import org.modelversioning.emfprofile.application.registry.ProfileApplicationDecorator;
import org.modelversioning.emfprofile.application.registry.ui.views.EMFProfileApplicationsView;
import org.modelversioning.emfprofileapplication.StereotypeApplicability;
import org.modelversioning.emfprofileapplication.StereotypeApplication;

public class ProfileProviderLabelAdapter implements ILabelProvider {

	private AdapterFactoryLabelProvider provider;

	public ProfileProviderLabelAdapter(ComposedAdapterFactory adapterFactory) {
		provider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	private ILabelProvider getLabelProvider(Object element) {
		return (ILabelProvider) provider;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		provider.addListener(listener);
	}

	@Override
	public void dispose() {
		provider.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		provider.removeListener(listener);
	}

	@Override
	public Image getImage(Object element) {
		Stereotype stereotype = null;
		if(element instanceof StereotypeApplication){
			stereotype = ((StereotypeApplication)element).getStereotype();
		}else if(element instanceof StereotypeApplicability){
			stereotype = ((StereotypeApplicability)element).getStereotype();	
		}
		
		if(stereotype != null && stereotype.hasIcon()){
			URL url = getPlatformURLToImageOfStereotype(stereotype);
			if(url != null){
				try {
					Image image = EMFProfileApplicationsView.createImage(ImageDescriptor.createFromURL(url));
					return image;
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
				
			}
		}
		return getLabelProvider(element).getImage(element);
	}
	
	/*
	 * This gets the URI of the profile resource (which can also be a proxy) and strips the URI to something like this:
	 * platform:/resource/ProjectName
	 * Then it adds to it the relative path to the image and returns a URL of it.
	 */
	private URL getPlatformURLToImageOfStereotype(Stereotype stereotype){
		URL url = null;
		try{
			String uriToProfileResource = EcoreUtil.getURI(stereotype.getProfile()).toString();
			String strResource = "resource/";
			String result = uriToProfileResource.substring(0, uriToProfileResource.indexOf("/", uriToProfileResource.indexOf(strResource)+strResource.length() + 1)+1);
			result += stereotype.getIconPath();
			url = new URL(result);
		}catch (Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return url;
	}

	@Override
	public String getText(Object element) {
		if(element instanceof ProfileApplicationDecorator){
			ProfileApplicationDecorator profileApplicationDecorator = (ProfileApplicationDecorator) element;
			return profileApplicationDecorator.isDirty() ? "*"+profileApplicationDecorator.getName() : profileApplicationDecorator.getName();
		}
		return getLabelProvider(element).getText(element);
	}

}
