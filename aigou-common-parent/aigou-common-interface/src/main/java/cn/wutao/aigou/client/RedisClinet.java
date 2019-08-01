package cn.wutao.aigou.client;

import cn.wutao.aigou.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "common",fallback = RedisFallBankFactory.class)
public interface RedisClinet {

    /**
     * redis存值
     */
    @PostMapping("/redis")
    AjaxResult set(@RequestParam("key") String key, @RequestParam("value")String value);

    /**
     * redis取值
     */
    @GetMapping("/redis")
    AjaxResult get(@RequestParam("key")String key);
}
