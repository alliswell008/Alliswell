package alliswell.testspringboot.component;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class TestInterceptor extends HandlerInterceptorAdapter {

    public TestInterceptor() {
        System.out.println("TestInterceptor类加载了...");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        String uri = request.getRequestURI();
        String urL = request.getRequestURL().toString();
        System.out.println("ip = "+ip);
        System.out.println("uri = "+uri);
        System.out.println("urL = "+urL);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("appId", "jjj");
        map.values();
        System.out.println(map.values());
    }
}
