# WurstPlus-EventProcessor
A lightweight Event Processor for Java

## How to use the EventProcessor


To Commit a Event to the processor use the annotation `@CommitEvent`

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
