package cn.xpbootcamp.locker;

import java.util.Comparator;
import java.util.List;

public class SmartLockerBot extends BaseLockerBot{

    public SmartLockerBot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Receipt storeBag() {
        return lockers.stream()
                .filter(locker -> !locker.isFull())
                .max(Comparator.comparing(Locker::getFreeCapacity)).map(Locker::storePackage).orElse(null);
    }

}
