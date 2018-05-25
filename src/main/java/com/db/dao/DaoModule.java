package com.db.dao;

import org.glassfish.hk2.utilities.binding.AbstractBinder;


public class DaoModule extends AbstractBinder {

    PersonDao dao;

    public DaoModule(PersonDao dao){
        this.dao = dao;
    }

    @Override
    public void configure() {
        bind(dao).to(PersonDao.class);
    }
}
