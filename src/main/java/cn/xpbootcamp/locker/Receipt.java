package cn.xpbootcamp.locker;

import java.util.Date;
import java.util.Objects;

public class Receipt {

    private String timeStamp;
    private Locker locker;

    public Receipt(){
        Date date = new Date();
        this.timeStamp = String.valueOf(date.getTime());
    }

    public Receipt(Locker locker) {
        this.timeStamp = String.valueOf(new Date().getTime());
        this.locker = locker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(timeStamp, receipt.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp);
    }

    public Locker getLocker() {
        return locker;
    }
}
