package ranjiajie.bwie.com.ranjiajie20171221.bean;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class MsgBean<T> {
    private String msg;
    private String code;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
