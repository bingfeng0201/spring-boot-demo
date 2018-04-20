package com.imxiaomai.bms;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yy.entity.User;
import com.yy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by hyy on 2018/1/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest{

    private static Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Resource
    private UserService userService;

    @Test
    public void testPageList() throws Exception {
        PageInfo<User> pageInfo = userService.selectPageList(null,1,10);
        System.out.println("-----"+JSON.toJSONString(pageInfo));
    }
}
