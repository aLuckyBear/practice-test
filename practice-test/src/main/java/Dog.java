/**
 * @author ：shujie
 * @date ：2020/04/29
 * @description:
 */
public class Dog extends Animal {

    private Integer test;

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    @Override
    public String toString() {
        super.toString();
        return "Dog{" +
                "test=" + test +
                '}';
    }
}
