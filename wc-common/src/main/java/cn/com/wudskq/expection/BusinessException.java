package cn.com.wudskq.expection;
 

public class BusinessException extends RuntimeException{
 
    private int code;
    private String msg;
 
    public BusinessException(int code, String msg){
        super(msg);
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
 
}

