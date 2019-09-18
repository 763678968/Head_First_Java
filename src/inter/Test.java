package inter;

public class Test {
    public static void main(String[] args) {
        TheftProofDoor door = new TheftProofDoor();
        // 回家： 开锁 开门 关门 关锁
        door.openLock();
        door.openDoor();
        door.closeDoor();
        door.closeLock();
    }
}
