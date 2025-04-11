package com.dao;

import com.entity.MabingLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MabingLiuyanView;

/**
 * 马病留言 Dao 接口
 *
 * @author 
 */
public interface MabingLiuyanDao extends BaseMapper<MabingLiuyanEntity> {

   List<MabingLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
