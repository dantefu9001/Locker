package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LockerBotTest {

    @Test
    public void should_return_success_given_locker_with_free_capacity_when_store_bag() {
        LockerBot robot = new LockerBot();
        Locker locker = new Locker(10);
        Receipt receipt = robot.storeBag(locker);
        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_return_success_given_two_empty_lockers_when_store_bag() {
        LockerBot bot = new LockerBot();
        Locker lockerA = new Locker(10);
        Locker lockerB = new Locker(10);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);
        Receipt receipt = bot.storeBag(lockers);
        Assert.assertNotNull(receipt);
        Assert.assertEquals(lockerA, receipt.getLocker());
    }

    @Test
    public void should_store_in_second_locker_given_two_locker_with_first_full_and_second_empty_when_store_bag() {
        LockerBot bot = new LockerBot();
        Locker lockerA = new Locker(0);
        Locker lockerB = new Locker(10);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);
        Receipt receipt = bot.storeBag(lockers);
        Assert.assertEquals(lockerB, receipt.getLocker());
    }

    @Test
    public void should_get_bag_given_two_locker_and_valid_ticket_when_take_bag() {
        LockerBot lockerBot = new LockerBot();
        Locker lockerA = new Locker(10);
        Locker lockerB = new Locker(10);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);
        Receipt receipt = lockerBot.storeBag(lockers);
        Assert.assertTrue(lockerBot.takeBag(receipt));
    }

    @Test
    public void should_not_get_bag_given_two_locker_and_invalid_ticket_when_take_bag() {
        LockerBot lockerBot = new LockerBot();
        Locker lockerA = new Locker(10);
        Locker lockerB = new Locker(10);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);
        lockerBot.storeBag(lockers);
        Receipt receipt = new Receipt();
        Assert.assertFalse(lockerBot.takeBag(receipt));
    }

    @Test
    public void should_not_get_bag_given_two_locker_and_used_ticket_when_take_bag() {
        LockerBot lockerBot = new LockerBot();
        Locker lockerA = new Locker(10);
        Locker lockerB = new Locker(10);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);
        Receipt receipt = lockerBot.storeBag(lockers);
        lockerBot.takeBag(receipt);
        Assert.assertFalse(lockerBot.takeBag(receipt));
    }
}
