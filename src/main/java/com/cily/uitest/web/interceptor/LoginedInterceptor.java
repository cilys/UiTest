package com.cily.uitest.web.interceptor;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.cily.uitest.web.utils.ResUtils;
import com.cily.utils.base.StrUtils;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by admin on 2018/2/6.
 */
public class LoginedInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        String userId = inv.getController().getHeader(SQLParam.USER_ID);
        String token = inv.getController().getHeader(Param.TOKEN);
        if (StrUtils.isEmpty(userId)){
            inv.getController().renderJson(ResUtils.res(Param.C_USER_ID_NULL, null, null));
            return;
        }
        if (StrUtils.isEmpty(token)){
            inv.getController().renderJson(
                    ResUtils.res(Param.C_TOKEN_NULL, null, null));
            return;
        }
        //TODO 数据库验证token是否有效
        inv.invoke();
    }
}