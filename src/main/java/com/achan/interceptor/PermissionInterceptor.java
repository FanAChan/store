package com.achan.interceptor;

import com.achan.entity.PermissionVo;
import com.achan.entity.UserVo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;

/**
 * @author AChan
 * @title: PermissionInterceptor
 * @date 2019/5/6
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
//        HttpSession session = request.getSession();
//        HashSet permissionSet = (HashSet<String>) session.getAttribute("permissions");
//        //用户权限中包含请求路径
//        if (permissionSet.contains(servletPath)) {
//            return true;
//        }
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
