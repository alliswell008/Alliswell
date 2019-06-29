package restful;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WebResponse<T> extends HttpServletResponseWrapper {
    public WebResponse(HttpServletResponse response) {
        super(response);
    }

    public static WebResponse getSuccessResponse(Object o) {
        return (WebResponse) o;
    }
}
