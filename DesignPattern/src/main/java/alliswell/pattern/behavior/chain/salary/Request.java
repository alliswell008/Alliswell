package alliswell.pattern.behavior.chain.salary;

/**
 * 申请
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Request {

    /**
     * 申请类型
     */
    private String requestType;
    /**
     * 申请类容
     */
    private String requestContent;
    /**
     * 申请数量
     */
    private int number;

    public Request(String requestType, String requestContent, int number) {
        this.requestType = requestType;
        this.requestContent = requestContent;
        this.number = number;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
