package cn.wutao.aigou.controller;

import cn.wutao.aigou.AjaxResult;
import cn.wutao.aigou.FastDfsApiOpr;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件统一处理
 */
@RestController
public class FastDfsController {
    /**
     * 上传
     * @return
     */
    @PostMapping("/fastdfs")
    public AjaxResult uploadFile(@RequestBody MultipartFile file)  {

        try {
            byte[] bytes = file.getBytes();
            //获取原文件名 filename:dasdad.jpg
            String filename = file.getOriginalFilename();
            //获取文件后缀。
            String extName = filename.substring(filename.lastIndexOf(".") + 1);

            //System.out.println(extName);
            //System.out.println("filename:"+filename);
            //byte[] file,String extName

            String s = FastDfsApiOpr.upload(bytes, extName);
            System.out.println(s);
            return AjaxResult.me().setSuccess(true).setMsg("文件上传成功").setData(s);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("文件上传失败");
        }
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("delfastdfs")
    public AjaxResult deleteFile(@RequestParam("filePath") String filePath){
            System.out.println(filePath);
        try {
            //"/group1/M00/00/01/wKgrYl1FZm-AX4NnAAAPfHhh5mc146.jpg"
            //截取第一个‘/’之后的路径
            String path = filePath.substring(1);
            System.out.println("path:"+path);
            //截取分组名称
            String groupName = path.substring(0,path.indexOf("/"));
            System.out.println(groupName);
            //截取文件路径
            String fileName = path.substring(path.indexOf("/")+1);
            System.out.println(fileName);
            FastDfsApiOpr.delete(groupName, fileName);
            return AjaxResult.me().setSuccess(true).setMsg("文件删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("文件删除失败");
        }
    }
}
