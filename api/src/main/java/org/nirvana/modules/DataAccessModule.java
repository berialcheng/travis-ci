package org.nirvana.modules;

import com.google.inject.AbstractModule;
import org.nirvana.dataAccess.EchoRepo;
import org.nirvana.dataAccess.interfaces.DbRepo;

public class DataAccessModule extends AbstractModule {

    @Override protected void configure() {
        bind(DbRepo.class).to(EchoRepo.class);
    }
}
