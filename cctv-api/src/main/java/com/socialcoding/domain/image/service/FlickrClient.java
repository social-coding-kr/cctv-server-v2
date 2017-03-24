package com.socialcoding.domain.image.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.socialcoding.config.image.FlickrProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("request")
public class FlickrClient {

	private Flickr client;

	private final FlickrProperties flickrProperties;

	@Autowired
	private FlickrClient(FlickrProperties flickrProperties) {
		this.flickrProperties = flickrProperties;
	}

	@PostConstruct
	public void initialize() {
		REST transport = new REST();
		this.client = new Flickr(flickrProperties.getApiKey(), flickrProperties.getApiSecret(), transport);
	}

}
