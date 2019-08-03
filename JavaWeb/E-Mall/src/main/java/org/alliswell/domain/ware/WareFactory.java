package org.alliswell.domain.ware;

/**
 * 商品工厂
 * Created by cxs on 2017/8/31.
 */
public class WareFactory {


	/**
	 * 商品工厂创建商品
	 *
	 * @param type     商品类型
	 * @param wareJson 商品json参数
	 * @return
	 */
	public static Ware createWare(String type, String wareJson) {
		Ware ware = null;

		switch (type) {
			case "PAA":
//                ware = new PAAWareVO();
				break;

			case "PCZ":
//                ware = new PCZWareVO();
				break;

			default:
				break;
		}

		return ware;
	}
}
