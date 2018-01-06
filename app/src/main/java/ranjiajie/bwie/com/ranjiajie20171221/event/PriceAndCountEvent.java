package ranjiajie.bwie.com.ranjiajie20171221.event;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class PriceAndCountEvent {
    private double price;
    private int count;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}