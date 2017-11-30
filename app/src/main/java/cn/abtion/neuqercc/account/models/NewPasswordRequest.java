package cn.abtion.neuqercc.account.models;

import cn.abtion.neuqercc.base.models.BaseModel;

/**
 * Created by 41061 on 2017/10/18.
 */

public class NewPasswordRequest extends BaseModel{


    private String phone;
    private String password;

    public NewPasswordRequest(){

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
