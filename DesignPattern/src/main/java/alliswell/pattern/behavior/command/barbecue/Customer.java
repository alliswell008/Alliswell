package alliswell.pattern.behavior.command.barbecue;

/**
 * 烧烤客户
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class Customer {

    public static void main(String[] args) {

        Waiter waiter = new Waiter();
        Barbecuer barbecuer = new Barbecuer();

        // 点10个烤面筋
        waiter.setOrder("0001", barbecuer, BakeMenu.Gluten, 10);

        // 点5个烤羊肉
        waiter.setOrder("0002", barbecuer, BakeMenu.Mutton, 2);

        // 点5个烤羊肉
        waiter.setOrder("0001", barbecuer, BakeMenu.Mutton, 5);

        // 取消2个烤羊肉
        waiter.setOrder("0001", barbecuer, BakeMenu.Mutton, -2);

        // 取消1个烤羊肉
        waiter.setOrder("0002", barbecuer, BakeMenu.Mutton, -1);
    }
}
