package cn.wutao.aigou.client;

import cn.wutao.aigou.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisFallBankFactory implements FallbackFactory<RedisClinet>{
    @Override
    public RedisClinet create(Throwable throwable) {
        return new RedisClinet() {
            @Override
            public AjaxResult set(String key, String value) {
                return AjaxResult.me().setSuccess(false).setMsg("系统维护中");
            }

            @Override
            public AjaxResult get(String key) {
                return AjaxResult.me().setSuccess(false).setMsg("系统维护中");
            }
        };
    }
}
