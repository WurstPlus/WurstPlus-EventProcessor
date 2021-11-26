# WurstPlus-EventProcessor
A lightweight Event Processor for Java

Speeds up to `~5 nano seconds` for high priority events

## How to use the EventProcessor


To Commit an Event to the processor use the annotation `@CommitEvent` above the method, The method has to have
a parameter of a class that extends `Event.java`. 

To set the priority of the event do `@CommitEvent(priority = EventPriority.HIGH)`


Below is how to Commit an Event (Source from Wurst Plus 3)
```java
    @CommitEvent
    public void onPacket(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketTimeUpdate && time.getValue()) {
            event.setCancelled(true);
        }
        if (event.getPacket() instanceof SPacketUpdateBossInfo && bossbar.getValue()) {
            event.setCancelled(true);
        }
    }
```    

To Make a new Event Class extend `Event.java`.
To Cancel an event do `event.setCancelled(true)`


```java
public class EventStage extends Event {
    private int stage;

    public EventStage() {
    }

    public EventStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return this.stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
```

Make sure to initialize the EventProcessor class. When you want to add a new event to listen
for make sure to post the event `WurstplusThree.EVENT_PROCESSOR.postEvent(event);`!

For any more help look at Wurst Plus 3 [Source](https://github.com/WurstPlus/wurst-plus-three), or dm me on discord Madmeg#4882
