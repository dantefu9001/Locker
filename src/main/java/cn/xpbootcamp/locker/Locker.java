package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class Locker {

    private final boolean IS_FULL = true;
    private int lockerCapacity = 10;

    private boolean status;
    private List<Receipt> receipts;

    public Locker() {
        receipts = new ArrayList<>(lockerCapacity);
    }

    private boolean capacityCheck() {
        if (receipts.size() == lockerCapacity)
            return IS_FULL;
        return !IS_FULL;
    }

    public Receipt openAnEmptyLocker() {
        if (capacityCheck() == IS_FULL) {
            return null;
        } else {
            Receipt receipt = new Receipt();
            receipts.add(receipt);
            return receipt;
        }
    }

    public boolean isStatus(){
        return capacityCheck();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean scanAReceipt(Receipt receipt) {
        if (receipts.contains(receipt)) {
            receipts.remove(receipt);
            return true;
        }
        return false;
    }
}
