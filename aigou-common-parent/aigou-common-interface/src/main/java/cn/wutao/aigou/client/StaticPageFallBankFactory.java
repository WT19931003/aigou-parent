package cn.wutao.aigou.client;

import cn.wutao.aigou.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StaticPageFallBankFactory implements FallbackFactory<StaticPageClient>{

    @Override
    public StaticPageClient create(Throwable throwable) {
        return new StaticPageClient() {
            @Override
            public AjaxResult genStaticPage(Map<String, Object> map) {
                return AjaxResult.me().setSuccess(false).setMsg("系统维护中");
            }
        };
    }
}
