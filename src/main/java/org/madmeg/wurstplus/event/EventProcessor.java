package org.madmeg.wurstplus.event;


import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Madmegsox1
 * @since 04/06/2021
 */

public final class EventProcessor {

    private final List<Listener> events;

    public EventProcessor() {
        events = new ArrayList<>();
    }

    /**
     * @param object the class that the events are in
     * @throws IllegalArgumentException
     */
    public final void addEventListener(@NotNull Object object) throws IllegalArgumentException {
        getEvents(object);
    }

    public final void removeEventListener(@NotNull Object object) {
        events.removeIf(listener -> listener.object == object);
    }

    /**
     * @param object takes the class where the events are committed
     */
    private void getEvents(@NotNull Object object) {
        Class<?> clazz = object.getClass();
        Arrays.stream(clazz.getDeclaredMethods()).spliterator().forEachRemaining(method -> {
            if (method.isAnnotationPresent(CommitEvent.class)) {
                Class<?>[] prams = method.getParameterTypes();
                if (prams.length != 1) {
                    throw new IllegalArgumentException("Method " + method + " doesnt have any event parameters");
                }
                if (!Event.class.isAssignableFrom(prams[0])) {
                    throw new IllegalArgumentException("Method " + method + " doesnt have any event parameters only non event parameters");
                }
                this.events.add(new Listener(method, object, prams[0], getPriority(method)));
                this.events.sort(Comparator.comparing(o -> o.priority));
            }
        });
    }

    /**
     * @param event the event that you are listening for
     * @return if the event was posted or not at a boolean
     */
    public final boolean postEvent(@NotNull Event event) {
        events.spliterator().forEachRemaining(listener -> {
            if(listener.event == event.getClass()){
                try {
                    listener.method.setAccessible(true);
                    listener.method.invoke(listener.object, event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }

    private EventPriority getPriority(@NotNull Method method) {
        return method.getAnnotation(CommitEvent.class).priority();
    }
}
