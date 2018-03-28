package cn.loverqi.star.core.bean;

import java.io.Serializable;

/**
 * Response的返回值类型
 * @author loverqi
 * @date 2018年1月5日
 */
public class ResponseDate<T> implements Serializable {

    private static final long serialVersionUID = -4988435676311767997L;
    private int code;
    private String message;
    private T data;

    public ResponseDate() {

        //默认为操作成功
        this.code = ResponseDateCode.SUCCESS;
        this.message = ResponseDateCode.SUCCESS_MESSAGE;
    }
    
    public ResponseDate(int code, String message) {

        //默认为操作成功
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
