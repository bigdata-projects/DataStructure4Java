package linear.array;

/**
 * Created by Administrator on 2017/7/26.
 */
public class CustArray {
    private PeopleDO[] arrayList;

    private int len;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public CustArray(int size) {
        this.arrayList = new PeopleDO[size];
    }
}
