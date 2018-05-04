package cn.loverqi.star.core.exception;

/**
 * 持久层通用的异常类
 * @author loverqi
 * @date 2018年1月9日
 */
public class PojoStructureException extends RuntimeException {

    private static final long serialVersionUID = 6846686878331148551L;

    public PojoStructureException(String msg) {
        super(msg);
    }

    public PojoStructureException(String msg, Throwable e) {
        super(msg, e);
    }
}