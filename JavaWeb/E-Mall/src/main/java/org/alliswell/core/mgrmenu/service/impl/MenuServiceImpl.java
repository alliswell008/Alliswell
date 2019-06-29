/**
 * @Title: UserServiceImpl
 * @Package com.allis.core.service.impl.controller
 * @Description: 用户管理service业务层TODO(用一句话描述该文件做什么)
 * @author org.alliswell
 * @date 2016/9/25 17:38
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package org.alliswell.core.mgrmenu.service.impl;

import org.alliswell.core.mgrmenu.service.MenuService;
import org.alliswell.core.mgruser.model.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author org.alliswell
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2016/9/25 17:38
 * <p/>
 * ${TAGS}
 */
@Service("UserService")
public class MenuServiceImpl implements MenuService
{
    @Autowired
    public void addUser(UserDto userDto) {
        System.out.println("add user into database.");
    }
    public UserDto getUser(String id)
    {

        return null;
    }

    public static void main(String[] args)
    {
    }
}
