package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

public class LockerTest {

    private static final boolean IS_FULL = true;

    @Test
    public void should_open_an_empty_locker_given_request_to_store_when_having_empty_lockers(){
        Locker locker = new Locker();
        locker.setStatus(!IS_FULL);
        Receipt receipt = locker.openEmptyLocker();
        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_not_open_a_locker_given_request_to_store_when_having_no_empty_lockers(){
        Locker locker = new Locker();
        locker.setStatus(IS_FULL);
        Receipt receipt = locker.openEmptyLocker();
        Assert.assertNull(receipt);
    }
}
