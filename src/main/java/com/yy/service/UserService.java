package com.yy.service;

import com.github.pagehelper.PageInfo;
import com.yy.entity.User;

import java.util.List;

/**
 * Created by hyy on 2018/1/3.
 */
public interface UserService {

    /**
     * 查询用户列表
     * @param param
     * @return
     */
    List<User> selectListByExample(User param) throws Exception;

    /**
     * 添加或修改用户信息,用户名必传,且用户名不能重复
     * @param user
     * @return
     */
    User saveOrUpdate(User user) throws Exception;

    /**
     * 分页查询
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<User> selectPageList(User user,Integer pageNum,Integer pageSize) throws Exception;


    /**
     * 条件查询用户信息
     * @param user
     * @return
     * @throws Exception
     */
    User selectUserByExample(User user) throws Exception;


}
