package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LockerBotManagerTest {
    @Test
    public void should_success_when_saving_bags_given_lockers_with_free_capacity() {
        Locker lockerC = new Locker(10);
        LockerBotManager lockerBotManager = new LockerBotManager(Collections.singletonList(lockerC));
        assertNotNull(lockerBotManager.storeBag());
    }

    @Test
    public void should_fail_when_saving_bags_given_lockers_with_no_capacity() {
        Locker locker = new Locker(1);
        LockerBotManager lockerBotManager = new LockerBotManager(Collections.singletonList(locker));
        lockerBotManager.storeBag();
        assertNull(lockerBotManager.storeBag());
    }

    @Test
    public void should_success_when_ask_other_bot_to_save() {
        Locker primaryLocker = new Locker(10);
        Locker smartLocker = new Locker(10);
        Locker managerLocker = new Locker(10);
        PrimaryLockerBot primaryLockerBot = new PrimaryLockerBot(Collections.singletonList(primaryLocker));
        SmartLockerBot smartLockerBot = new SmartLockerBot(Collections.singletonList(smartLocker));
        LockerBotManager lockerBotManager = new LockerBotManager(Collections.singletonList(managerLocker));
        assertNotNull(lockerBotManager.askBotToStoreBag(primaryLockerBot));
        assertNotNull(lockerBotManager.askBotToStoreBag(smartLockerBot));
        Assert.assertEquals(primaryLocker.getFreeCapacity(), 9);
        Assert.assertEquals(smartLocker.getFreeCapacity(), 9);
    }

}
