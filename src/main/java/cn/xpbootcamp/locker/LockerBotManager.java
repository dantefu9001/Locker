package cn.xpbootcamp.locker;

import java.util.List;

public class LockerBotManager extends BaseLockerBot{

    public LockerBotManager(List<Locker> lockers) {
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


    public Receipt askBotToStoreBag(BaseLockerBot lockerBot) {
        return lockerBot.storeBag();
    }

    public boolean askBotToTakeBag(BaseLockerBot lockerBot, Receipt smartReceipt) {
        return lockerBot.takeBag(smartReceipt);
    }

}
