package com.yun.filter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class FeignClientsExtendInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(null != attributes){
            HttpServletRequest request = attributes.getRequest();
            if(null != request){
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null){
                    while (headerNames.hasMoreElements()){
                        requestTemplate.header(headerNames.nextElement(),request.getHeader(headerNames.nextElement()));
                    }
                }
            }
        }
    }
}
