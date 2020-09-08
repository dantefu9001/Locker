package cn.xpbootcamp.locker;

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
    public void should_fail_when_saving_bags_given_lockers_with_no_capacity(){
        Locker locker = new Locker(1);
        LockerBotManager lockerBotManager = new LockerBotManager(Collections.singletonList(locker));
        lockerBotManager.storeBag();
        assertNull(lockerBotManager.storeBag());
    }
}
