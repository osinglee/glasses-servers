package come.glasses.utils;

/**
 * 正则表达式验证Pattern
 */
public class RegexpPattern {

    /**
     * 数字
     */
    public static final String NUMERIC = "^\\d+$";

    /**
     * 英字
     */
    public static final String ALPHABET = "^[a-zA-Z]+$";

    /**
     * 英数字
     */
    public static final String ALPHANUMERIC = "^[a-zA-Z\\d]+$";

    /**
     * 汉字
     */
    public static final String HANZI = "^[\\u4e00-\\u9fa5]+$";

    /**
     * 手机号码
     */
    public static final String PHONE = "^1(3|4|5|7|8|9)\\d{9}$";
}
