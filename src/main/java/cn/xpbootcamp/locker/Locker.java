package cn.xpbootcamp.locker;

public class Locker {

    private final boolean IS_FULL = true;

    private boolean status;

    public Receipt openEmptyLocker() {
        if (status == IS_FULL) {
            return null;
        } else {
            return new Receipt();
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
