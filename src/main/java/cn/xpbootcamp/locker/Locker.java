package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class Locker {

    private final boolean IS_FULL = true;

    private int lockerCapacity;
    private List<Receipt> receipts;
    private String errorMessage = "";

    public Locker() {
        receipts = new ArrayList<>(lockerCapacity);
        lockerCapacity = 10;
    }

    public Locker(int lockerCapacity){
        receipts = new ArrayList<>(lockerCapacity);
        this.lockerCapacity = lockerCapacity;
    }

    private boolean capacityCheck() {
        if (receipts.size() == lockerCapacity) {
            return IS_FULL;
        }
        return !IS_FULL;
    }

    public Receipt storePackage() {
        if (capacityCheck() == IS_FULL) {
            errorMessage = MessageConstant.NO_MORE_EMPTY_LOCKER;
            return null;
        } else {
            Receipt receipt = new Receipt(this);
            receipts.add(receipt);
            return receipt;
        }
    }

    public boolean takePackage(Receipt receipt) {
        if (receipts.contains(receipt)) {
            receipts.remove(receipt);
            return true;
        } else {
            errorMessage = MessageConstant.INVALID_RECEIPT;
            return false;
        }
    }

    public boolean isFull() {
        return capacityCheck();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getFreeCapacity(){
        if(this.isFull()) {
            return 0;
        }
        return lockerCapacity - receipts.size();
    }
}
