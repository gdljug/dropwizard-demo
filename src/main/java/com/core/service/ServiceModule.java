package com.core.service;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ServiceModule extends AbstractBinder {

    @Override
    protected void configure() {
        bind(HelloPersonServiceImpl.class).to(HelloPersonService.class).in(Singleton.class);
    }
}
