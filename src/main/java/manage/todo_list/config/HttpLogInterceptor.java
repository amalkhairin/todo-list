package manage.todo_list.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HttpLogInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(HttpLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("HTTP Method: {}, URL: {}, Request Body: {}", request.getMethod(), request.getRequestURL(), request.getQueryString());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("HTTP Method: {}, URL: {}, Status: {}, Response Body: {}", request.getMethod(), request.getRequestURL(), response.getStatus(), response.getContentType());
    }
}
