package cn.xpbootcamp.locker;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Receipt {

    private UUID uuid;
    private Locker locker;

    public Receipt(){
        this.uuid = UUID.randomUUID();
    }

    public Receipt(Locker locker) {
        this.uuid = UUID.randomUUID();
        this.locker = locker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(uuid, receipt.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    public Locker getLocker() {
        return locker;
    }
}
