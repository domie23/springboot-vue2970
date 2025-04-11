
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 马病
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/mabing")
public class MabingController {
    private static final Logger logger = LoggerFactory.getLogger(MabingController.class);

    @Autowired
    private MabingService mabingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        params.put("mabingDeleteStart",1);params.put("mabingDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = mabingService.queryPage(params);

        //字典表数据转换
        List<MabingView> list =(List<MabingView>)page.getList();
        for(MabingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MabingEntity mabing = mabingService.selectById(id);
        if(mabing !=null){
            //entity转view
            MabingView view = new MabingView();
            BeanUtils.copyProperties( mabing , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MabingEntity mabing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,mabing:{}",this.getClass().getName(),mabing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<MabingEntity> queryWrapper = new EntityWrapper<MabingEntity>()
            .eq("mabing_uuid_number", mabing.getMabingUuidNumber())
            .eq("mabing_name", mabing.getMabingName())
            .eq("mabing_types", mabing.getMabingTypes())
            .eq("zhengzhuang_text", mabing.getZhengzhuangText())
            .eq("zhiliaofangan_text", mabing.getZhiliaofanganText())
            .eq("yufangfangan_text", mabing.getYufangfanganText())
            .eq("mabing_clicknum", mabing.getMabingClicknum())
            .eq("shangxia_types", mabing.getShangxiaTypes())
            .eq("mabing_delete", mabing.getMabingDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MabingEntity mabingEntity = mabingService.selectOne(queryWrapper);
        if(mabingEntity==null){
            mabing.setMabingClicknum(1);
            mabing.setShangxiaTypes(1);
            mabing.setMabingDelete(1);
            mabing.setInsertTime(new Date());
            mabing.setCreateTime(new Date());
            mabingService.insert(mabing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MabingEntity mabing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,mabing:{}",this.getClass().getName(),mabing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<MabingEntity> queryWrapper = new EntityWrapper<MabingEntity>()
            .notIn("id",mabing.getId())
            .andNew()
            .eq("mabing_uuid_number", mabing.getMabingUuidNumber())
            .eq("mabing_name", mabing.getMabingName())
            .eq("mabing_types", mabing.getMabingTypes())
            .eq("zhengzhuang_text", mabing.getZhengzhuangText())
            .eq("zhiliaofangan_text", mabing.getZhiliaofanganText())
            .eq("yufangfangan_text", mabing.getYufangfanganText())
            .eq("mabing_clicknum", mabing.getMabingClicknum())
            .eq("shangxia_types", mabing.getShangxiaTypes())
            .eq("mabing_delete", mabing.getMabingDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MabingEntity mabingEntity = mabingService.selectOne(queryWrapper);
        if("".equals(mabing.getMabingPhoto()) || "null".equals(mabing.getMabingPhoto())){
                mabing.setMabingPhoto(null);
        }
        mabing.setUpdateTime(new Date());
        if(mabingEntity==null){
            mabingService.updateById(mabing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<MabingEntity> list = new ArrayList<>();
        for(Integer id:ids){
            MabingEntity mabingEntity = new MabingEntity();
            mabingEntity.setId(id);
            mabingEntity.setMabingDelete(2);
            list.add(mabingEntity);
        }
        if(list != null && list.size() >0){
            mabingService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<MabingEntity> mabingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            MabingEntity mabingEntity = new MabingEntity();
//                            mabingEntity.setMabingUuidNumber(data.get(0));                    //马病编号 要改的
//                            mabingEntity.setMabingName(data.get(0));                    //马病名称 要改的
//                            mabingEntity.setMabingPhoto("");//照片
//                            mabingEntity.setMabingTypes(Integer.valueOf(data.get(0)));   //病因类型 要改的
//                            mabingEntity.setZhengzhuangText(data.get(0));                    //基本症状 要改的
//                            mabingEntity.setZhiliaofanganText(data.get(0));                    //治疗方案 要改的
//                            mabingEntity.setYufangfanganText(data.get(0));                    //预防方案 要改的
//                            mabingEntity.setMabingClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            mabingEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            mabingEntity.setMabingDelete(1);//逻辑删除字段
//                            mabingEntity.setMabingContent("");//照片
//                            mabingEntity.setInsertTime(date);//时间
//                            mabingEntity.setUpdateTime(new Date(data.get(0)));          //最后更新时间 要改的
//                            mabingEntity.setCreateTime(date);//时间
                            mabingList.add(mabingEntity);


                            //把要查询是否重复的字段放入map中
                                //马病编号
                                if(seachFields.containsKey("mabingUuidNumber")){
                                    List<String> mabingUuidNumber = seachFields.get("mabingUuidNumber");
                                    mabingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> mabingUuidNumber = new ArrayList<>();
                                    mabingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("mabingUuidNumber",mabingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //马病编号
                        List<MabingEntity> mabingEntities_mabingUuidNumber = mabingService.selectList(new EntityWrapper<MabingEntity>().in("mabing_uuid_number", seachFields.get("mabingUuidNumber")).eq("mabing_delete", 1));
                        if(mabingEntities_mabingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MabingEntity s:mabingEntities_mabingUuidNumber){
                                repeatFields.add(s.getMabingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [马病编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        mabingService.insertBatch(mabingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = mabingService.queryPage(params);

        //字典表数据转换
        List<MabingView> list =(List<MabingView>)page.getList();
        for(MabingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MabingEntity mabing = mabingService.selectById(id);
            if(mabing !=null){

                //点击数量加1
                mabing.setMabingClicknum(mabing.getMabingClicknum()+1);
                mabingService.updateById(mabing);

                //entity转view
                MabingView view = new MabingView();
                BeanUtils.copyProperties( mabing , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody MabingEntity mabing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,mabing:{}",this.getClass().getName(),mabing.toString());
        Wrapper<MabingEntity> queryWrapper = new EntityWrapper<MabingEntity>()
            .eq("mabing_uuid_number", mabing.getMabingUuidNumber())
            .eq("mabing_name", mabing.getMabingName())
            .eq("mabing_types", mabing.getMabingTypes())
            .eq("zhengzhuang_text", mabing.getZhengzhuangText())
            .eq("zhiliaofangan_text", mabing.getZhiliaofanganText())
            .eq("yufangfangan_text", mabing.getYufangfanganText())
            .eq("mabing_clicknum", mabing.getMabingClicknum())
            .eq("shangxia_types", mabing.getShangxiaTypes())
            .eq("mabing_delete", mabing.getMabingDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MabingEntity mabingEntity = mabingService.selectOne(queryWrapper);
        if(mabingEntity==null){
            mabing.setMabingDelete(1);
            mabing.setInsertTime(new Date());
            mabing.setCreateTime(new Date());
        mabingService.insert(mabing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
