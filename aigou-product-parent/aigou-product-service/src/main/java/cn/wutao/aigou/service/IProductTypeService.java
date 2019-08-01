package cn.wutao.aigou.service;

import cn.wutao.aigou.domain.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author wutao
 * @since 2019-07-31
 */
public interface IProductTypeService extends IService<ProductType> {

    //树菜单
    List<ProductType> loadTypeTree();
}
