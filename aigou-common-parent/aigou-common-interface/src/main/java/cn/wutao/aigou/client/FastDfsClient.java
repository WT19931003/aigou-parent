package cn.wutao.aigou.client;

import cn.wutao.aigou.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "common",fallback =FastDfsFallBankFactory.class )
public interface FastDfsClient {

    /**
     * 上传
     * @return
     */
    @PostMapping("/fastdfs")
    AjaxResult uploadFile(@RequestBody MultipartFile file);

    /**
     * 删除
     * @return
     */
    @DeleteMapping("fastdfs")
    AjaxResult deleteFile(@RequestParam("filePath") String filePath);
}
