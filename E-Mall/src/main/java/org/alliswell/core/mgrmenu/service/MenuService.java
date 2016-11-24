package org.alliswell.core.mgrmenu.service;

import com.allis.core.mgruser.model.dto.UserDto;

/**
 * @author org.alliswell
 * @ClassName: MenuService
 * @Description: 用户管理模块service接口层
 * @date 2016/9/25 17:33
 * <p/>
 * ${TAGS}
 */
public interface MenuService
{
    UserDto getUser(String id);

    void addUser(UserDto userDto);
}
