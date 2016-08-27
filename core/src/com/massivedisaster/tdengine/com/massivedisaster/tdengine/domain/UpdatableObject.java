package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

/**
 * Interface to be implemented by all classes that are updatable.
 * @param <T> The type of the class that must be provided for the update.
 */
public interface UpdatableObject<T> {
    public void update(T object);
}
