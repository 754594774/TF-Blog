package com.linn.frame.entity;

/**
 * Created by Administrator on 2018-02-08.
 */
public class ResultBean {
    private Integer errNo;
    private String errMsg;
    private Object data;

    public  ResultBean(){}

    public ResultBean(int errNo,String errMsg){
        this.errNo = errNo;
        this.errMsg = errMsg;
    }

    public ResultBean(Integer errNo, String errMsg, Object data) {
        this.errNo = errNo;
        this.errMsg = errMsg;
        this.data = data;
    }

    public Integer getErrNo() {
        return errNo;
    }

    public void setErrNo(Integer errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "errNo=" + errNo +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
