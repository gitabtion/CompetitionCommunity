package cn.abtion.neuqercc.account.models;

import cn.abtion.neuqercc.base.models.BaseModel;

/**
 * Created by 41061 on 2017/10/23.
 */

public class RegisterResponse extends BaseModel {

    private String captcha;

    public RegisterResponse(String captcha){
        this.captcha=captcha;
    }

    public String getCaptcha(){
        return captcha;
    }

    public void setCaptcha(String captcha){
        this.captcha=captcha;
    }
}
