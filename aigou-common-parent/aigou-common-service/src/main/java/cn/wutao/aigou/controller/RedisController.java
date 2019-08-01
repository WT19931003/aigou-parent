package cn.wutao.aigou.controller;

import cn.wutao.aigou.AjaxResult;
import cn.wutao.aigou.RedisUtils;
import cn.wutao.aigou.client.RedisClinet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController implements RedisClinet{

    /**
     * redis存值
     */
    @PostMapping("/redis")
    public AjaxResult set(@RequestParam("key") String key, @RequestParam("value") String value){
        try {
            RedisUtils.INSTANCE.set(key, value);
            return AjaxResult.me().setSuccess(true).setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("操作失败："+e.getMessage());
        }
    }

    /**
     * redis取值
     */
    @GetMapping("/redis")
    public AjaxResult get(@RequestParam("key") String key){
        try {
            String s = RedisUtils.INSTANCE.get(key);
            return AjaxResult.me().setSuccess(true).setMsg("操作成功").setData(s);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("操作失败："+e.getMessage());
        }
    }
}
