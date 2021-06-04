# WurstPlus-EventProcessor
A lightweight Event Processor for Java

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

Below is how to Commit an Event (Source from Wurst Plus 3)
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

For any more help loot at Wurst Plus 3 [Source](https://github.com/WurstPlus/wurst-plus-three), or dm me on discord Madmeg#4882
