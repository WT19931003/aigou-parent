package cn.wutao.aigou.client;

import cn.wutao.aigou.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FastDfsFallBankFactory implements FallbackFactory<FastDfsClient>{

    @Override
    public FastDfsClient create(Throwable throwable) {
        return new FastDfsClient() {
            @Override
            public AjaxResult uploadFile(MultipartFile file) {
                return AjaxResult.me().setSuccess(false).setMsg("系统维护中");

            }

            @Override
            public AjaxResult deleteFile(String filePath) {
                return AjaxResult.me().setSuccess(false).setMsg("系统维护中");
            }
        };
    }
}
