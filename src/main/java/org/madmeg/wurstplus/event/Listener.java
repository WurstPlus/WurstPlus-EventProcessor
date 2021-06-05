package org.madmeg.wurstplus.event;

import java.lang.reflect.Method;

/**
 * @author Madmegsox1
 * @since 05/06/2021
 *  Class that contains the Listener Method, Class, Event, Priority
 */

public class Listener {
    Method method;
    Object object;
    Class<?> event;
    EventPriority priority;

    public Listener(Method method, Object object, Class<?> event, EventPriority priority){
        this.method = method;
        this.object = object;
        this.event = event;
        this.priority = priority;
    }
}
