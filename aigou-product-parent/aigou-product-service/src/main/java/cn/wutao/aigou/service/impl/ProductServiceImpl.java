package cn.wutao.aigou.service.impl;

import cn.wutao.aigou.domain.Product;
import cn.wutao.aigou.domain.ProductExt;
import cn.wutao.aigou.mapper.ProductExtMapper;
import cn.wutao.aigou.mapper.ProductMapper;
import cn.wutao.aigou.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author wutao
 * @since 2019-07-31
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductExtMapper productExtMapper;

    @Override
    public boolean save(Product entity) {
        //设置创建时间
        entity.setCreateTime(new Date().getTime());
        //先保存主表
        boolean save = super.save(entity);
        //在保存关联表
        ProductExt productExt = entity.getProductExt();
        //关联
        Long productId = entity.getId();
        productExt.setProductId(productId);

        productExtMapper.insert(productExt);
        return save;
    }
}
