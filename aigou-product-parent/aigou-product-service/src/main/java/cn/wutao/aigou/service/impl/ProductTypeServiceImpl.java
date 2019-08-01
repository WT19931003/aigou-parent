package cn.wutao.aigou.service.impl;

import cn.wutao.aigou.domain.ProductType;
import cn.wutao.aigou.mapper.ProductTypeMapper;
import cn.wutao.aigou.service.IProductTypeService;
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
    private ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> loadTypeTree() {
        return loop();
    }

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
                ProductType parent = map.get(productType2.getPid());
                parent.getChildren().add(productType2);
            }
        }

        return list;
    }
}
