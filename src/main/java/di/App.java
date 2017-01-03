package di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import di.module.ConfigurationModule;
import di.module.RepositoryModule;

/**
 * Created by Solus on 03/01/2017.
 */
public class App
{
    private static Injector injector;

    public static Injector getInjector() {
        if (App.injector == null) {
            Module module = Modules.combine(new ConfigurationModule(), new RepositoryModule());
            App.injector = Guice.createInjector(module);
        }

        return App.injector;
    }

    public static void setInjector(Injector injector) {
        App.injector = injector;
    }
}
