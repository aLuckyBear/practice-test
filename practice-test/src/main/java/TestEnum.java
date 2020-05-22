import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TestEnum {

    TEST1("test1Key", "test1Value", "desc1"),
    TEST2("test2Key", "test2Value", "desc2"),
    TEST3("test3Key", "test3Value", "desc3");

    private String key;

    private String value;

    private String desc;

}
