package alliswell.pattern.behavior.chain.salary;

import java.text.MessageFormat;

/**
 * 总监
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class MajorManager extends Manager{

    public MajorManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request){
        if ("请假".equals(request.getRequestType()) && request.getNumber() <= 5) {
            System.out.println(MessageFormat.format("{0}:{1}数量{2}被批准", name, request.getRequestContent(), request.getNumber()));
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}
