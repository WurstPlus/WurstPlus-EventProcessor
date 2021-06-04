package org.madmeg.wurstplus.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Madmegsox1
 * @since 04/06/2021
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CommitEvent {
    public EventPriority priority() default EventPriority.NONE;
}
