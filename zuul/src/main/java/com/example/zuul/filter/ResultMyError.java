package com.example.zuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 定制最终的返回的错误信息
 */
@Component
public class ResultMyError extends DefaultErrorAttributes {

    private Logger logger = LoggerFactory.getLogger(ResultMyError.class);
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        logger.info(errorAttributes.toString());
        Map<String,Object> result = new HashMap<>();
        result.put("error","my error");
        return result;
    }
}
