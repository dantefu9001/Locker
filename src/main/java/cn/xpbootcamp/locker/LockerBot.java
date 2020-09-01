package cn.xpbootcamp.locker;

import java.util.List;
import java.util.Objects;

public class LockerBot {

    private Locker locker;

    public Receipt storeBag(Locker locker) {
        this.locker = locker;
        return locker.storePackage();
    }

    public Receipt storeBag(List<Locker> lockers) {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                this.locker = locker;
                return locker.storePackage();
            }
        }
        return null;
    }

    public boolean takeBag(Receipt receipt) {
        return Objects.nonNull(locker) && locker.takePackage(receipt);
    }
}
