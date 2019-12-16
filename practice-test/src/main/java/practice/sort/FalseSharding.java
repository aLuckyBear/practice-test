package practice.sort;

/**
 * @author ：shujie
 * @date ：2019/12/11
 * @description: 伪共享
 */
public class FalseSharding {

    private static ValuePadding[] longs;

    public static void main(String[] args) {
        longs = new ValuePadding[10];
    }


    public final static class ValuePadding {
        protected long p1, p2, p3, p4, p5, p6, p7;
        protected volatile long value = 0L;
        protected long p9, p10, p11, p12, p13, p14;
        protected long p15;
    }

}
