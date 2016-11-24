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
 ******************************************************
 */
package org.alliswell.core.mgruser.controller;

import org.alliswell.core.mgruser.service.UserService;

/**
 * @author org.alliswell
 * @ClassName: UserController
 * @Description: 用户管理模块
 * @date 2016/9/25 17:21
 * <p/>
 * ${TAGS}
 */
public class UserController
{
    private UserService userService;

    public void regist(String userInfo)
    {
        System.out.println("注册成功");
    }

    public void login(String userAccount, String userPasswd)
    {

    }

    public void modifyUserInfo(String userInfo)
    {
    }
}
