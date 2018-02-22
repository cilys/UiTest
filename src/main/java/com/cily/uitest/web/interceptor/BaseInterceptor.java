package com.cily.uitest.web.interceptor;

import com.cily.uitest.web.conf.Param;
import com.cily.uitest.web.conf.SQLParam;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by admin on 2018/2/22.
 */
public abstract class BaseInterceptor implements Interceptor {

    protected String getParam(Invocation inv, String paramKey, String defValue){
        if (inv == null){
            return null;
        }
        return inv.getController().getPara(paramKey, defValue);
    }

    protected String getParam(Invocation inv, String paramKey){
        return getParam(inv, paramKey, null);
    }

    protected String getDeviceImei(Invocation inv){
        return getHead(inv, Param.DEVICE_IMEI);
    }
    protected String getDeviceImeiFromAttr(Invocation inv){
        return inv.getController().getAttr(Param.DEVICE_IMEI);
    }
    protected String getUserId(Invocation inv){
        return getHead(inv, SQLParam.USER_ID);
    }
    protected String getToken(Invocation inv){
        return getHead(inv, SQLParam.TOKEN);
    }

    protected String getHead(Invocation inv, String key){
        if (inv == null){
            return null;
        }
        return inv.getController().getHeader(key);
    }

}
