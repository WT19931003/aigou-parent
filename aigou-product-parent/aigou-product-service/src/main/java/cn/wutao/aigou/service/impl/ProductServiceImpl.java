package cn.wutao.aigou.service.impl;

import cn.wutao.aigou.domain.Product;
import cn.wutao.aigou.mapper.ProductMapper;
import cn.wutao.aigou.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
