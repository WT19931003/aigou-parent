package cn.wutao.aigou.controller;

import cn.wutao.aigou.LetterUtil;
import cn.wutao.aigou.PageList;
import cn.wutao.aigou.service.IBrandService;
import cn.wutao.aigou.domain.Brand;
import cn.wutao.aigou.query.BrandQuery;
import cn.wutao.aigou.AjaxResult ;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    public IBrandService brandService;

    /**
    * 保存和修改公用的
    * @param brand  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Brand brand){
        try {
            if( brand.getId()!= null){
                brandService.updateById(brand);
            }else{
                //录入时间
                brand.setCreateTime(new Date().getTime());
                //获取首字母
                String firstLetter = LetterUtil.getFirstLetter(brand.getName());
                brand.setFirstLetter(firstLetter.toUpperCase());
                brandService.save(brand);
            }
            return AjaxResult.me().setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Integer id){
        try {
            brandService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMsg("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Brand get(@RequestParam(value="id",required=true) Long id)
    {
        return brandService.getById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Brand> list(){

        return brandService.list(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Brand> json(@RequestBody BrandQuery query)
    {
      /* Page<Brand> page = new Page<Brand>(query.getPageNum(),query.getPageSize());
        IPage<Brand> iPage = brandService.page(page);
        return new PageList<>(iPage.getTotal(),iPage.getRecords());*/

        //关联查询
           return   brandService.queryPage(query);
    }
}
