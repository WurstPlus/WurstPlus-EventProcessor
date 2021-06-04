package org.madmeg.wurstplus.event;

/**
 * @author Madmegsox1
 * @since 04/06/2021
 */

public class Pair<T, S> {

    T key;
    S value;

    public Pair(T key, S value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public S getValue() {
        return value;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(S value) {
        this.value = value;
    }

}