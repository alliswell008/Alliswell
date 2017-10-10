package org.alliswell.core.mgruser.service;

import org.alliswell.core.mgruser.model.dto.UserDto;

/**
 * @ Title: UserService
 * @ Package org.org.alliswell.core.service.mgruser
 * @ Description: TODO(用一句话描述该文件做什么)
 * @ author org.alliswell
 * @ date 2016/11/21 23:12
 * @ version V1.0
 * @ Update_Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public interface UserService {

    void addUser(UserDto userDto);
    UserDto getUser(String userId);
}
