/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.gwt.editor.widget;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedImage;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * @author glefur
 *
 */
public class ModelViewerCell extends AbstractCell<Object> {
	
	private AdapterFactoryItemDelegator itemDelegator;

	/**
	 * @param consumedEvents
	 * @param itemDelegator
	 */
	public ModelViewerCell(AdapterFactoryItemDelegator itemDelegator) {
		this.itemDelegator = itemDelegator;
	}

	@Override
	public void render(Context context, Object value, SafeHtmlBuilder safeHtmlBuilder) {
		StringBuilder sb = new StringBuilder();
		Object image = itemDelegator.getImage(value);
		if (image instanceof ImageResource) {
			ImageResource imageResource = (ImageResource) image;
			sb.append("<div style='position:relative;padding-left:");
			sb.append(imageResource.getWidth() + 6);
			sb.append("px;'>");
			sb.append("<div style=\"position:absolute;left:0px;top:0px;height:100%;");
			sb.append("width:").append(imageResource.getWidth()).append("px;");
			sb.append("background:url('").append(imageResource.getURL()).append("') ");
			sb.append("no-repeat scroll center center transparent;");
			sb.append("\"></div>");
			sb.append(itemDelegator.getText(value));
			sb.append("</div>");
		} else if (image instanceof ComposedImage) {
			ComposedImage composedImage = (ComposedImage) image;
			List<ComposedImage.Size> sizes = new ArrayList<ComposedImage.Size>();
			List<Object> images = new ArrayList<Object>(composedImage.getImages());
			List<ImageData> nestedImagesData = new ArrayList<ImageData>();
			for (Object nestedImage : images) {
				ImageData nestedImageData = getImageData(nestedImage);
				ComposedImage.Size size = new ComposedImage.Size();
				size.height = nestedImageData.height;
				size.width = nestedImageData.width;
				sizes.add(size);
				nestedImagesData.add(nestedImageData);
			}
			ComposedImage.Size size = composedImage.getSize(sizes);
			sb.append("<div style='position:relative;padding-left:");
			sb.append(size.width + 6);
			sb.append("px;'>");
			List<ComposedImage.Point> drawPoints = composedImage.getDrawPoints(size);
			int i = 0;
			for (ComposedImage.Point drawPoint : drawPoints) {
				ImageResource nestedImage = (ImageResource) images.get(i++);
				sb.append("<div style=\"position:absolute;left:").append(drawPoint.x).append("px;top:").append(drawPoint.y).append("px;height:100%;");
				sb.append("width:").append(nestedImage.getWidth()).append("px;");
				sb.append("background:url('").append(nestedImage.getURL()).append("') ");
				sb.append("no-repeat scroll center center transparent;");
				sb.append("\"></div>");
			}
			sb.append(itemDelegator.getText(value));
			sb.append("</div>");
		} else {
			sb.append(itemDelegator.getText(value));
		}
		safeHtmlBuilder.appendHtmlConstant(sb.toString());
	}
	
	protected ImageData getImageData(Object image) {
		ImageData imageData = new ImageData();
		if (image instanceof ImageResource) {
			ImageResource imageResource = (ImageResource) image;
			imageData.height = imageResource.getHeight();
			imageData.width = imageResource.getWidth();
		} else if (image instanceof ComposedImage) {
			ComposedImage composedImage = (ComposedImage) image;
			List<ComposedImage.Size> sizes = new ArrayList<ComposedImage.Size>();
			List<Object> images = new ArrayList<Object>(composedImage.getImages());
			List<ImageData> nestedImagesData = new ArrayList<ImageData>();
			for (Object nestedImage : images) {
				ImageData nestedImageData = getImageData(nestedImage);
				ComposedImage.Size size = new ComposedImage.Size();
				size.height = nestedImageData.height;
				size.width = nestedImageData.width;
				sizes.add(size);
				nestedImagesData.add(nestedImageData);
			}
		}
		return imageData;
	}

	public static class ImageData {
		public int width;
		public int height;
	}



}
