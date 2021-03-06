package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

public class LockerTest {

    private static final boolean IS_FULL = true;

    @Test
    public void should_open_an_empty_locker_given_request_to_store_when_having_empty_lockers(){
        Locker locker = new Locker();
        Receipt receipt = locker.storePackage();
        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_not_open_a_locker_given_request_to_store_when_having_no_empty_lockers(){
        Locker locker = new Locker();
        while(locker.isFull()!=IS_FULL){
            locker.storePackage();
        }
        Receipt receipt = locker.storePackage();
        Assert.assertEquals(locker.getErrorMessage(),MessageConstant.NO_MORE_EMPTY_LOCKER);
        Assert.assertNull(receipt);
    }

    @Test
    public void should_open_the_corresponding_locker_given_a_valid_receipt_for_the_first_time(){
        Locker locker = new Locker();
        Receipt receipt = locker.storePackage();
        Assert.assertTrue(locker.takePackage(receipt));
    }

    @Test
    public void should_not_open_the_corresponding_locker_given_an_used_receipt(){
        Locker locker = new Locker();
        Receipt receipt = locker.storePackage();
        locker.takePackage(receipt);
        Assert.assertFalse(locker.takePackage(receipt));
        Assert.assertEquals(locker.getErrorMessage(),MessageConstant.INVALID_RECEIPT);
    }

    @Test
    public void should_not_open_the_corresponding_locker_given_a_invalid_receipt(){
        Locker locker = new Locker();
        Receipt receipt = new Receipt();
        Assert.assertFalse(locker.takePackage(receipt));
        Assert.assertEquals(locker.getErrorMessage(),MessageConstant.INVALID_RECEIPT);
    }
}
