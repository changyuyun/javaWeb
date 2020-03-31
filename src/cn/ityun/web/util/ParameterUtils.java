package cn.ityun.web.util;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * @desc 获取int数字
     * @param request
     * @param key
     * @param def
     * @return
     */
    public static int getInt(HttpServletRequest request, String key, int def) {
        String temp = request.getParameter(key);
        int rs = def;
        if (temp != null && isNumber(temp)) {
            rs = Integer.parseInt(temp);
        }
        return rs;
    }

    public static String getString(HttpServletRequest request, String key, String def) {
        String temp = request.getParameter(key);
        String rs = def;
        if (temp != null && !"".equals(temp)) {
            rs = temp;
        }
        return rs;
    }

}
