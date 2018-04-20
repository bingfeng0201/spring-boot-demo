package com.yy.web;

import com.github.pagehelper.PageInfo;
import com.yy.entity.User;
import com.yy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 *
 * @author hyy
 * @date 2018/1/2
 */
@Controller
@RequestMapping("/user")
public class UserController{

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;


    @GetMapping("list")
    public String userList(User user, ModelMap modelMap){
        logger.info("查询用户列表");
        try {
            PageInfo<User> pageInfo = userService.selectPageList(user,1, 10);
            modelMap.put("userPage",pageInfo);
            return "user/list";
        } catch (Exception e) {
            return "error";
        }
    }


}
