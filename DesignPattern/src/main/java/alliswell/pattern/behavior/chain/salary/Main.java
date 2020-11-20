package alliswell.pattern.behavior.chain.salary;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Main {
    public static void main(String[] args) {
        CommonManager jl = new CommonManager("经理");
        MajorManager zj = new MajorManager("总监");
        GeneralManager zjl = new GeneralManager("总经理");

        jl.setSuperior(zj);
        zj.setSuperior(zjl);

        Request requset = new Request("请假", "小明请假", 1);
        jl.requestApplications(requset);

        requset = new Request("请假", "小明请假", 4);
        jl.requestApplications(requset);

        requset = new Request("加薪", "小明加薪", 500);
        jl.requestApplications(requset);

        requset = new Request("加薪", "小明加薪", 1000);
        jl.requestApplications(requset);

    }
}
