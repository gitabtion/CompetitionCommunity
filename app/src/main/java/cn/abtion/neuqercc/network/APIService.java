package cn.abtion.neuqercc.network;

import cn.abtion.neuqercc.account.models.LoginRequest;
import cn.abtion.neuqercc.account.models.UpdatePasswordRequest;
import cn.abtion.neuqercc.account.models.RegisterRequest;
import cn.abtion.neuqercc.account.models.SmsRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * retrofit service interface.
 * @author abtion.
 * @since 17/9/22 18:04.
 * email caiheng@hrsoft.net
 */

public interface APIService {
    /**
     * 登录
     */
    @POST("saiyou/public/index.php/login")
    Call<APIResponse> login(@Body LoginRequest loginRequest);

    /**
     * 验证码
     */

    @POST("saiyou/public/index.php/sms")
    Call<APIResponse> captch(@Body SmsRequest smsRequest);

    /**
     * 注册
     */
    @POST("saiyou/public/index.php/register")
    Call<APIResponse> register(@Body RegisterRequest registerRequest);

    /**
     * 重新设置密码
     */
    @POST("saiyou/public/index.php/forgot")
    Call<APIResponse> updatePassword(@Body UpdatePasswordRequest updatePasswordRequest);


}
