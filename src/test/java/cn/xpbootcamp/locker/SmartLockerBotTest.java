package cn.xpbootcamp.locker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SmartLockerBotTest {

    @Test
    public void should_return_ticket_when_smart_locker_robot_save_bag_given_a_locker_with_10_capacity_and_bag() {
        Locker locker = new Locker(10);
        SmartLockerBot smartLockerBot = new SmartLockerBot(Collections.singletonList(locker));

        Receipt receipt = smartLockerBot.storeBag();

        assertNotNull(receipt);
    }

    @Test
    public void should_return_ticket_and_save_bag_in_1st_locker_when_smart_locker_robot_save_bag_given_1st_locker_with_10_capacity_and_2nd_with_5_capacity_and_bag() {
        Locker firstLocker = new Locker(10);
        Locker secondLocker = new Locker(5);
        SmartLockerBot smartLockerBot = new SmartLockerBot(Arrays.asList(firstLocker, secondLocker));

        Receipt receipt = smartLockerBot.storeBag();

        assertNotNull(receipt);
        assertEquals(true, firstLocker.takePackage(receipt));
    }

    @Test
    public void should_return_ticket_and_bag_in_2nd_locker_when_smart_locker_robot_save_bag_given_1st_10_capacity_locker_and_2nd_20_capacity_locker_and_bag() {
        Locker firstLocker = new Locker(10);
        Locker secondLocker = new Locker(20);
        SmartLockerBot smartLockerBot = new SmartLockerBot(Arrays.asList(firstLocker, secondLocker));

        Receipt receipt = smartLockerBot.storeBag();

        assertNotNull(receipt);
        assertEquals(true, secondLocker.takePackage(receipt));
    }

    @Test
    public void should_return_ticket_and_bag_in_1st_locker_when_smart_locker_robot_save_bag_given_1st_10_capacity_locker_and_2nd_10_capacity_locker_and_bag() {
        Locker firstLocker = new Locker(10);
        Locker secondLocker = new Locker(10);
        SmartLockerBot smartLockerBot = new SmartLockerBot(Arrays.asList(firstLocker, secondLocker));

        Receipt receipt = smartLockerBot.storeBag();

        assertNotNull(receipt);
        assertEquals(true, firstLocker.takePackage(receipt));
    }

    @Test
    public void should_fail_when_smart_locker_robot_save_bag_given_two_lockers_with_0_free_capacity_and_bag() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        firstLocker.storePackage();
        secondLocker.storePackage();
        SmartLockerBot smartLockerBot = new SmartLockerBot(Arrays.asList(firstLocker, secondLocker));

        assertNull(smartLockerBot.storeBag());
    }

    @Test
    public void should_take_bag_successfully_when_smart_locker_robot_take_bag_given_1_locker_and_valid_ticket() {
        Locker locker = new Locker(10);
        SmartLockerBot smartLockerBot = new SmartLockerBot(Collections.singletonList(locker));
        Receipt receipt = smartLockerBot.storeBag();

        assertEquals(true, smartLockerBot.takeBag(receipt));
    }

    @Test
    public void should_throw_ticket_is_invalid_when_smart_locker_robot_take_bag_given_a_locker_invalid_ticket() {
        Locker locker = new Locker(10);
        SmartLockerBot smartLockerBot = new SmartLockerBot(Collections.singletonList(locker));
        smartLockerBot.storeBag();

        smartLockerBot.takeBag(new Receipt());
    }
}
