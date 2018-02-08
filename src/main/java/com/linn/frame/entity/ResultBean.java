package com.linn.frame.entity;

/**
 * Created by Administrator on 2018-02-08.
 */
public class ResultBean {
    private Integer errNo;
    private String errMsg;

    public  ResultBean(){}

    public ResultBean(int errNo,String errMsg){
        this.errNo = errNo;
        this.errMsg = errMsg;
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

    @Override
    public String toString() {
        return "ResultBean{" +
                "errNo=" + errNo +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
