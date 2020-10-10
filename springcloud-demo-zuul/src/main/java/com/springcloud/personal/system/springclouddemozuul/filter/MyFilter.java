package com.springcloud.personal.system.springclouddemozuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: springcloud-demo-pom
 * @description:
 * @author: bo.hu
 * @create: 2020-10-10 19:47
 **/
@Component
public class MyFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        System.out.println(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken=request.getParameter("token");
        if(accessToken==null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }
        return null;
    }
}
