package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全过滤器
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger logger =  LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 该过滤器在一次请求过程中执行的顺序
     * pre,routing,post,error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 该过滤器在所有过滤器中的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否启用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 该过滤器具体的执行逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null){
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                throwMyExcetpion();
            }catch (Exception e){
                ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                ctx.set("error.exception",e);
            }
            return null;
        }
        logger.info("access token ok");
        return null;
    }

    private void throwMyExcetpion(){
        throw new RuntimeException("Exist some errors ....");
    }
}
