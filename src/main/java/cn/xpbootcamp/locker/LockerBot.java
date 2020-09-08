package cn.xpbootcamp.locker;

import java.util.List;
import java.util.Objects;

public class LockerBot extends BaseLockerBot{

    public LockerBot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Receipt storeBag() {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.storePackage();
            }
        }
        return null;
    }
}
