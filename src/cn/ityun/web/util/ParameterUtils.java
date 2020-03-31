package cn.ityun.web.util;

public class ParameterUtils {
    /**
     * @desc 判断是否为数字
     * @param key
     * @return
     */
    public static boolean isNumber(String key) {
        if (key != null && key.length() > 0) {
            return key.matches("^[0-9]+$");
        } else {
            return false;
        }
    }

}
