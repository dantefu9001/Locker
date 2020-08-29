package cn.xpbootcamp.locker;

import java.util.Date;
import java.util.Objects;

public class Receipt {

    private String timeStamp;

    public Receipt(){
        Date date = new Date();
        this.timeStamp = String.valueOf(date.getTime());
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
}
