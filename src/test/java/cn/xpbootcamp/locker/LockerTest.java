package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

public class LockerTest {

    @Test
    public void should_open_an_empty_locker_given_request_to_store_when_having_empty_lockers(){
        Locker locker = new Locker();
        Receipt receipt = locker.openEmptyLocker();
        Assert.assertNotNull(receipt);
    }
}
