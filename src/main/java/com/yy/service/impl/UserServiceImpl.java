package com.yy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.entity.User;
import com.yy.mapper.UserMapper;
import com.yy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by hyy on 2018/1/3.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectListByExample(User param) throws Exception{
        logger.info("查询用户列表,参数 "+JSON.toJSONString(param));
        PageHelper.orderBy("created desc");
        List<User> list = userMapper.select(param);
        return list;
    }

    @Override
    @Transactional
    public User saveOrUpdate(User user) throws Exception{
        logger.info("添加或修改用户信息,参数 "+ JSON.toJSONString(user));
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public PageInfo<User> selectPageList(User user, Integer pageNum, Integer pageSize) throws Exception{
        logger.info("分页查询用户信息");
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("created desc");
        List<User> list = userMapper.select(user);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }

    @Override
    public User selectUserByExample(User user) throws Exception {
        logger.info("查询用户信息,参数 "+JSON.toJSONString(user));
        User res = userMapper.selectOne(user);
        return res;
    }



}
