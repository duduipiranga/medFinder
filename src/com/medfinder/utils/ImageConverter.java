package com.medfinder.utils;

import java.io.ByteArrayInputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class ImageConverter {
	
	public StreamedContent getImage(byte[] bytes) {
		
	    byte[] imageInByteArray = bytes;
	    return new DefaultStreamedContent(new ByteArrayInputStream(imageInByteArray), "image/png");
	}

}
