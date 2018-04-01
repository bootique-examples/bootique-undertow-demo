package io.bootique.undertow.demo;

import com.google.inject.Module;
import io.bootique.BQModuleProvider;
import io.bootique.undertow.UndertowModule;
import io.bootique.undertow.UndertowModuleProvider;

import java.util.Collection;

import static java.util.Collections.singletonList;

/**
 * Defines Application module, and their dependencies.
 *
 * @author Ibragimov Ruslan
 */
public class ApplicationModuleProvider implements BQModuleProvider {
    @Override
    public Module module() {
        return new ApplicationModule();
    }

    @Override
    public Collection<Class<? extends Module>> overrides() {
        return singletonList(UndertowModule.class);
    }

    @Override
    public Collection<BQModuleProvider> dependencies() {
        return singletonList(new UndertowModuleProvider());
    }
}
