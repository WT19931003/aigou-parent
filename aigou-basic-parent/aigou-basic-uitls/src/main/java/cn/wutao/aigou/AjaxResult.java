package cn.wutao.aigou;

public class AjaxResult {

    private boolean success = true;

    private String msg;

    private Object data;

    private Integer errorCode;

    //设置链式编程
    public static AjaxResult me(){
        return new AjaxResult();
    }

    public AjaxResult() {
    }


    public Integer getErrorCode() {
        return errorCode;
    }

    public AjaxResult setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AjaxResult setData(Object data) {
        this.data = data;
        return this;
    }


}
