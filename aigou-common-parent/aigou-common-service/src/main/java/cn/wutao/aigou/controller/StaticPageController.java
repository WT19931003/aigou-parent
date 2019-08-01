package cn.wutao.aigou.controller;

import cn.wutao.aigou.AjaxResult;
import cn.wutao.aigou.VelocityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StaticPageController {

    @PostMapping("/home")
    public AjaxResult genStaticPage(@RequestBody Map<String, Object> map) {
        Object model = map.get("model");
        String templatePath = (String) map.get("templatePath");
        String targetPath = (String) map.get("targetPath");

        try {
            VelocityUtils.staticByTemplate(model,templatePath,targetPath);
            return AjaxResult.me().setSuccess(true).setMsg("生成成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("生成失败:"+e.getMessage());
        }

    }
}
