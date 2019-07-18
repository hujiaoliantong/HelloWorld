package com.iweb.springboot1.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iweb.springboot1.bean.User;
import com.iweb.springboot1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {

   @Autowired
    private UserMapper userMapper;

   @GetMapping("/getUsers")
    public ModelAndView getUsers(){
         /*
        pageHelper的使用：
        https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
        目前：我们的分页参数是写死的
        实际上：应该是从前端传递过来的
        使用pageHelper的基本步骤
        1.设置分页参数：PageHelper.offsetPage(0,2);
        2.XxxMapper的查询方法（可能带条件）：
            userMapper.getUsers()
        3.将2的查询结果封装到PageInfo中
            PageInfo<User> pageInfo = new PageInfo<>(users);
            PageInfo中就封装了分页的所有数据
            比如：当前页，总页数，每页的记录数，是否有下一页等等
        * */
         PageHelper.offsetPage(0,2);
         List<User> users = userMapper.getUsers();
         PageInfo<User> pageInfo = new PageInfo<>(users);
         //mysql中分页参数:limit (当前页数-1)*每页的条数,每页的条数
         ModelAndView mv = new ModelAndView();
         mv.addObject("users",pageInfo);
         mv.setViewName("index.html");
         return mv;
   }
}
