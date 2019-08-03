package cn.wutao.aigou.service.impl;

import cn.wutao.aigou.AjaxResult;
import cn.wutao.aigou.client.RedisClinet;
import cn.wutao.aigou.client.StaticPageClient;
import cn.wutao.aigou.domain.ProductType;
import cn.wutao.aigou.mapper.ProductTypeMapper;
import cn.wutao.aigou.service.IProductTypeService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author wutao
 * @since 2019-07-31
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Autowired
    private RedisClinet redisClinet;

    @Autowired
    private StaticPageClient staticPageClient;

    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * redis缓存
     * @return
     */
    @Override
    public List<ProductType> loadTypeTree() {
        //第一次：查询redis
        AjaxResult result = redisClinet.get("productTypes");
        String resultData = (String) result.getData();
        //将获取的数据存入集合
        List<ProductType> productTypes = JSON.parseArray(resultData, ProductType.class);

        //判断集合是否有数据
        if (productTypes==null || productTypes.size()<=0){
            //没有数据,到数据库查放到redis
            productTypes = loop();
            redisClinet.set("productTypes", JSON.toJSONString(productTypes));
        }
        return productTypes;
    }

    /**
     * 静态页面生成
     */
    @Override
    public void genHomePage() {
        Map<String,Object> map = new HashMap<>();

        String templatePath = "D:/ideawork/aigou-parent/aigou-parent/aigou-product-parent/aigou-product-service/src/main/resources/template/product.type.vm";
        String targetPath = "D:/ideawork/aigou-parent/aigou-parent/aigou-product-parent/aigou-product-service/src/main/resources/template/product.type.vm.html";
        List<ProductType> productTypes = loadTypeTree();

        map.put("model", productTypes);
        map.put("templatePath", templatePath);
        map.put("targetPath", targetPath);

        staticPageClient.genStaticPage(map);

        map = new HashMap<>();
        templatePath ="D:/ideawork/aigou-parent/aigou-parent/aigou-product-parent/aigou-product-service/src/main/resources/template/home.vm";
        targetPath="D:/ideawork/aigou-web-parent/aigou-web-home/home.html";
        Map<String,Object> model = new HashMap<>();
        model.put("staticRoot", "D:/ideawork/aigou-parent/aigou-parent/aigou-product-parent/aigou-product-service/src/main/resources/");

        map.put("model", productTypes);
        map.put("templatePath", templatePath);
        map.put("targetPath", targetPath);

        staticPageClient.genStaticPage(map);

        /*Map<String,Object> map = new HashMap<>();
        List<ProductType> model = loadTypeTree();

        map.put("model",model);
        String templatePath = "D:/ideawork/aigou-parent/aigou-parent/aigou-product-parent/aigou-product-service/src/main/resources/template";
        String targetPath ="D:/ideawork/aigou-web-parent/aigou-web-home/home.html";
        staticPageClient.genStaticPage(map);*/
    }

    //树形菜单
    private List<ProductType> loop() {

        List<ProductType> productTypes = productTypeMapper.selectList(null);

        List<ProductType> list = new ArrayList<>();

        Map<Long,ProductType> map = new HashMap<>();
        for (ProductType productType : productTypes) {
            map.put(productType.getId(),productType );
        }

        for (ProductType productType2 : productTypes) {
            if (productType2.getPid() == 0){
                list.add(productType2);
            }else {
                //处理空数组
                ProductType parent = map.get(productType2.getPid());

                List<ProductType> children = parent.getChildren();
                if (children==null){
                    children = new ArrayList<>();
                }
                children.add(productType2);
                parent.setChildren(children);
            }
        }

        return list;
    }
}
