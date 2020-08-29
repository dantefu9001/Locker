package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

public class LockerTest {

    private static final boolean IS_FULL = true;

    @Test
    public void should_open_an_empty_locker_given_request_to_store_when_having_empty_lockers(){
        Locker locker = new Locker();
        locker.setStatus(!IS_FULL);
        Receipt receipt = locker.openAnEmptyLocker();
        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_not_open_a_locker_given_request_to_store_when_having_no_empty_lockers(){
        Locker locker = new Locker();
        locker.setStatus(IS_FULL);
        Receipt receipt = locker.openAnEmptyLocker();
        Assert.assertNull(receipt);
    }

    @Test
    public void should_open_the_corresponding_locker_given_a_valid_receipt_for_the_first_time(){
        Locker locker = new Locker();
        Receipt receipt = locker.openAnEmptyLocker();
        Assert.assertTrue(locker.scanAReceipt(receipt));
    }

    @Test
    public void should_not_open_the_corresponding_locker_given_a_used_receipt(){
        Locker locker = new Locker();
        Receipt receipt = locker.openAnEmptyLocker();
        locker.scanAReceipt(receipt);
        Assert.assertFalse(locker.scanAReceipt(receipt));
    }

    @Test
    public void should_not_open_the_corresponding_locker_given_a_invalid_receipt(){
        Locker locker = new Locker();
        Receipt receipt = new Receipt();
        Assert.assertFalse(locker.scanAReceipt(receipt));
    }
}
