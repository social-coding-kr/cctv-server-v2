package com.socialcoding.config.image;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("image.flickr")
public class FlickrProperties {

	private String apiKey;

	private String apiSecret;

}
