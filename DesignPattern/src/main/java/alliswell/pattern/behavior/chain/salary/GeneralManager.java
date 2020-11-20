package alliswell.pattern.behavior.chain.salary;

import java.text.MessageFormat;

/**
 * 总经理
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class GeneralManager extends Manager{

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request){
        if ("请假".equals(request.getRequestType())) {
            System.out.println(MessageFormat.format("{0}:{1}数量{2}被批准", name, request.getRequestContent(), request.getNumber()));
        } else if ("加薪".equals(request.getRequestType()) && request.getNumber() <= 500){
            System.out.println(MessageFormat.format("{0}:{1}数量{2}被批准", name, request.getRequestContent(), request.getNumber()));
        } else if ("加薪".equals(request.getRequestType()) && request.getNumber() > 500){
            System.out.println(MessageFormat.format("{0}:{1}数量{2}再说吧", name, request.getRequestContent(), request.getNumber()));
            System.out.println(String.format("%s:%s数量%s再说吧", name, request.getRequestContent(), request.getNumber()));
        }
    }
}
