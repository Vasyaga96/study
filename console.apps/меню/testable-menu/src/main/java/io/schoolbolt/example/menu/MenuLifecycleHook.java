package io.schoolbolt.example.menu;

@FunctionalInterface
public interface MenuLifecycleHook {
    void run() throws Exception;
}
