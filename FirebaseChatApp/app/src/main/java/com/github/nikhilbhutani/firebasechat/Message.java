package com.github.nikhilbhutani.firebasechat;


/**
 * Created by Nikhil Bhutani on 7/3/2016.
 */
public class Message {

    public String msg;
    public String device;


    public Message()
    {

    }

    public Message(String mymessage, String mydevice)
    {
        this.msg = mymessage;
        this.device = mydevice;
    }

}
