package com.yy.mapper;


import com.yy.entity.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<Role> selectUserRoleByUserId(Integer userId);

}