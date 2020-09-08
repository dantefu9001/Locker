package cn.xpbootcamp.locker;

import java.util.List;
import java.util.Objects;

public abstract class BaseLockerBot {
    protected final List<Locker> lockers;

    public BaseLockerBot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Receipt storeBag();

    public boolean takeBag(Receipt receipt){
        return Objects.nonNull(lockers) && lockers.stream().anyMatch(locker -> locker.takePackage(receipt));
    }
}
