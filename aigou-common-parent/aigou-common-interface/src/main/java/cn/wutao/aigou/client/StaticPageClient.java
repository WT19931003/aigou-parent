package cn.wutao.aigou.client;

import cn.wutao.aigou.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(value = "common",fallback = StaticPageFallBankFactory.class)
public interface StaticPageClient {

    /**
     * 静态页面生成
     * @param map
     */
    @PostMapping("/home")
    AjaxResult genStaticPage(@RequestBody Map<String,Object> map);
}
