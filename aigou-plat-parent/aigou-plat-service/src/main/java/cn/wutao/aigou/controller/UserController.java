package cn.wutao.aigou.controller;

import cn.wutao.aigou.AjaxResult;
import cn.wutao.aigou.domain.User;
import cn.wutao.aigou.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){

        System.out.println("用户名："+user.getName()+"   密码："+user.getPassword());
        if (!StringUtils.isEmpty(user.getName())&&!StringUtils.isEmpty(user.getPassword())){
            if ("wutao".equals(user.getName()) && "123456".equals(user.getPassword())){

                User all = userService.findAll();
                return AjaxResult.me().setSuccess(true).setMsg("登录成功").setData(all);
            }else {
                return AjaxResult.me().setSuccess(false).setMsg("用户名或密码错误");
            }
        }
        return AjaxResult.me().setSuccess(false).setMsg("用户名或密码不能为空");

    }
}
