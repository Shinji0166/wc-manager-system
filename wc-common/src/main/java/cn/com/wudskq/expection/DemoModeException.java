package cn.com.wudskq.expection;


/**
 * @author chenfangchao
 * @title: DemoModeException
 * @projectName wc-manager-system
 * @description: TODO
 * @date 2022/7/29 11:25 PM
 */
public class DemoModeException extends RuntimeException{

    private int code;
    private String msg;

    public DemoModeException(){
    }

    public DemoModeException(int code, String msg){
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
