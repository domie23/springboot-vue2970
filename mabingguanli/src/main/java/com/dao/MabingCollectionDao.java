package com.dao;

import com.entity.MabingCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MabingCollectionView;

/**
 * 马病收藏 Dao 接口
 *
 * @author 
 */
public interface MabingCollectionDao extends BaseMapper<MabingCollectionEntity> {

   List<MabingCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
