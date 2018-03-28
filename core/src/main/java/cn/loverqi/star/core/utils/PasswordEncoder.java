package cn.loverqi.star.core.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 加密算法
 * @author LoverQi
 * @date 2018年3月5日
 */
public class PasswordEncoder {

    public static final String KEY_SHA = "SHA";

    /**
     * 加密算法
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
     * 密码验证
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

}
