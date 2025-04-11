package com.dao;

import com.entity.MabingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MabingView;

/**
 * 马病 Dao 接口
 *
 * @author 
 */
public interface MabingDao extends BaseMapper<MabingEntity> {

   List<MabingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
