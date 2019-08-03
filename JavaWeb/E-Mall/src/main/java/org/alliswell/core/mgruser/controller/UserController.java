/**
 * @Title: UserController
 * @Package com.allis.core.mgrmenu.user
 * @Description: 用户管理模块
 * @author org.alliswell
 * @date 2016/9/25 17:21
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.core.mgruser.controller;

import org.alliswell.core.mgruser.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author org.alliswell
 * @ClassName: UserController
 * @Description: 用户管理模块
 * @date 2016/9/25 17:21
 * <p/>
 * ${TAGS}
 */
@Controller
@RequestMapping("UserController")
public class UserController {

	private UserService userService;

	public void regist(String userInfo) {
		System.out.println("注册成功");
	}

	public void login(String userAccount, String userPasswd) {
		System.out.println("登录成功");
	}

	public void modifyUserInfo(String userInfo) {
		System.out.println("修改成功");
	}
}
