package com.system.management.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.system.management.utils.Msg;
import com.system.management.utils.Protocol;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  登陆拦截与放行
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在请求被处理之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userNumber = request.getSession().getAttribute("userNumber");
//        if (null == userNumber || !(userNumber instanceof String)) {
//            //  异步拦截
//            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有，x-requested-with
//                Msg msg = new Msg();
//                msg.setStatus(Protocol.INVALIATE | Protocol.ACCOUNT);
//            }else{
//                //  同步拦截
//                response.sendRedirect("/loginPage");
//            }
//            // 未登录，重定向到登录页
//
//            System.out.println("执行拦截器");
//            return false;
//        }
        return true;
    }

    /**
     * 在请求被处理后，视图渲染之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束后调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}


