package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class hiController {

    //将UserMapper实例化
    @Autowired
    private UserMapper userMapper;


    //页面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //1、添加用户
    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request){
        String userName = request.getParameter("userName");      //从页面得到数据
        String passWord = request.getParameter("passWord");

        //先查找
        User user = userMapper.getUser(userName);

        //控制有效的输入
        if(user==null&&passWord!=null){
            //添加用户
            userMapper.addUser(userName,passWord);
            System.out.println("添加成功");
        }else{
            System.out.println("用户已经存在或者密码为空");
        }

        return "register";
    }

    //2、查找用户
    @RequestMapping("/getUser")
    public User getUser(HttpServletRequest request){
        String userName = request.getParameter("userName");

        User user = userMapper.getUser(userName);
        return user;
    }

    //3、删除用户
    @RequestMapping("/delUser")
    public String delUser(HttpServletRequest request){
        String userName = request.getParameter("userName");
        //查找
        User user = userMapper.getUser(userName);
        if(user!=null){
            //不为空，可以删除
            System.out.println("删除成功");
            userMapper.delUser(userName);
        }else{
            System.out.println("没有该用户");
        }

        return "register";
    }

    //4、修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        //先查找
        User user = userMapper.getUser(userName);
        if(user!=null){
            //有该用户，可以修改
            userMapper.updateUser(userName,passWord);
            System.out.println("修改成功");
        }else{
            System.out.println("没有该用户");
        }
        return "register";
    }


}
