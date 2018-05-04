package cn.loverqi.star.core.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 加密算法
 * @author LoverQi
 * @date 2018年3月5日
 */
public class PasswordEncoderUtil {

    public static final String KEY_SHA = "LOVERQI_STAR_SHA";

    /**
     * 将明文密码加密为密文密码
     * @param rawPassword 明文密码
     * @return 密文密码
     */
    public static String encode(String rawPassword) {

        BigInteger sha = null;
        byte[] inputData = rawPassword.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
        } catch (Exception e) {
            return rawPassword;
        }

        return sha.toString(32);
    }

    /**
     * 密码验证是否相等
     * @param rawPassword 明文密码
     * @param encodedPassword 密文密码
     * @return 是否相等
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

    /**
     * @param password 需要验证的密码
     * @param min 密码的最大长度， 0为不限制
     * @param max 密码的最小长度， 0为不限制
     * @return
     */
    public static boolean checkPasswordLength(String password, int min, int max) {
        boolean flag = false;
        if (StringUtil.isNotNull(password)) {
            int length = password.length();
            if (min > 0 && max >= min) {
                flag = length >= min && length <= max;
            } else if (min == 0 && max == 0) {
                flag = true;
            } else if (min == 0 && max > 0) {
                flag = length <= max;
            } else if (max == 0 && min > 0) {
                flag = length >= min;
            }
        }

        return flag;
    }

    /**
     * @param password 需要验证的密码
     * @param min 密码的最大长度， 0为不限制
     * @param max 密码的最小长度， 0为不限制
     * @return
     */
    public static boolean checkPasswordComplexity(String password, String complexityValue) {
        Pattern pattern = Pattern.compile(complexityValue);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    private PasswordEncoderUtil() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

}
