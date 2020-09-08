package cn.xpbootcamp.locker;

import java.util.List;

public class PrimaryLockerBot extends BaseLockerBot {

    public PrimaryLockerBot(List<Locker> lockers) {
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
