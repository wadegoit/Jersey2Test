package com.wade.resource.impl;

import org.glassfish.jersey.server.ResourceConfig;

public class RestConfig extends ResourceConfig{
	 public RestConfig() {
	        super(BookResourceImpl.class);
	    }
}
