package cn.wutao.aigou.service;

import cn.wutao.aigou.PageList;
import cn.wutao.aigou.domain.Brand;
import cn.wutao.aigou.query.BrandQuery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author wutao
 * @since 2019-07-31
 */
public interface IBrandService extends IService<Brand> {

    //分页+关联查询
    PageList<Brand> queryPage(BrandQuery query);
}
