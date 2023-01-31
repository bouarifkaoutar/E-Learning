package com.example.elearningproject;

import java.io.Serializable;

public class Message implements Serializable {
    String sender;
    String msg;
    public Message(String s,String msg){
        this.sender=s;
        this.msg=msg;
    }

    public String getSender() {
        return sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
