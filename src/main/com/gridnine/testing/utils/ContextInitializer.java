package main.com.gridnine.testing.utils;

import java.util.Set;

public class ContextInitializer {
    public Set<Class> getContext() {
        AccessingAllClassesInPackage instance = new AccessingAllClassesInPackage();

        Set<Class> classes = instance.findAllClassesUsingClassLoader(
                "main.com.gridnine.testing.filters.impl");
        return classes;
    }
}
