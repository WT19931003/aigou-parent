package cn.wutao.aigou.service.impl;

import cn.wutao.aigou.PageList;
import cn.wutao.aigou.domain.Brand;
import cn.wutao.aigou.mapper.BrandMapper;
import cn.wutao.aigou.query.BrandQuery;
import cn.wutao.aigou.service.IBrandService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author wutao
 * @since 2019-07-31
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {


    @Autowired
    private BrandMapper brandMapperr;

    //分页+关联查询
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public PageList<Brand> queryPage(BrandQuery query) {

        Page<Brand> page = new Page<>(query.getPageNum(),query.getPageSize());
        IPage<Brand> iPage = brandMapperr.queryPage(page, query);

        return new PageList<>(iPage.getTotal(),iPage.getRecords());
    }
}
