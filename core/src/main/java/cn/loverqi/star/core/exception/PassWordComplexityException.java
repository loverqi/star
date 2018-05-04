package cn.loverqi.star.core.exception;

/**
 * 密码复杂度不符合要求异常
 * @author loverqi
 * @date 2018年1月9日
 */
public class PassWordComplexityException extends Exception {

    private static final long serialVersionUID = 6846686878331148551L;

    public PassWordComplexityException(String msg) {
        super(msg);
    }

    public PassWordComplexityException(String msg, Throwable e) {
        super(msg, e);
    }
}