package com.entity.model;

import com.entity.MabingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 马病
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MabingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 马病编号
     */
    private String mabingUuidNumber;


    /**
     * 马病名称
     */
    private String mabingName;


    /**
     * 马病照片
     */
    private String mabingPhoto;


    /**
     * 病因类型
     */
    private Integer mabingTypes;


    /**
     * 基本症状
     */
    private String zhengzhuangText;


    /**
     * 治疗方案
     */
    private String zhiliaofanganText;


    /**
     * 预防方案
     */
    private String yufangfanganText;


    /**
     * 点击次数
     */
    private Integer mabingClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer mabingDelete;


    /**
     * 马病详细介绍
     */
    private String mabingContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 最后更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：马病编号
	 */
    public String getMabingUuidNumber() {
        return mabingUuidNumber;
    }


    /**
	 * 设置：马病编号
	 */
    public void setMabingUuidNumber(String mabingUuidNumber) {
        this.mabingUuidNumber = mabingUuidNumber;
    }
    /**
	 * 获取：马病名称
	 */
    public String getMabingName() {
        return mabingName;
    }


    /**
	 * 设置：马病名称
	 */
    public void setMabingName(String mabingName) {
        this.mabingName = mabingName;
    }
    /**
	 * 获取：马病照片
	 */
    public String getMabingPhoto() {
        return mabingPhoto;
    }


    /**
	 * 设置：马病照片
	 */
    public void setMabingPhoto(String mabingPhoto) {
        this.mabingPhoto = mabingPhoto;
    }
    /**
	 * 获取：病因类型
	 */
    public Integer getMabingTypes() {
        return mabingTypes;
    }


    /**
	 * 设置：病因类型
	 */
    public void setMabingTypes(Integer mabingTypes) {
        this.mabingTypes = mabingTypes;
    }
    /**
	 * 获取：基本症状
	 */
    public String getZhengzhuangText() {
        return zhengzhuangText;
    }


    /**
	 * 设置：基本症状
	 */
    public void setZhengzhuangText(String zhengzhuangText) {
        this.zhengzhuangText = zhengzhuangText;
    }
    /**
	 * 获取：治疗方案
	 */
    public String getZhiliaofanganText() {
        return zhiliaofanganText;
    }


    /**
	 * 设置：治疗方案
	 */
    public void setZhiliaofanganText(String zhiliaofanganText) {
        this.zhiliaofanganText = zhiliaofanganText;
    }
    /**
	 * 获取：预防方案
	 */
    public String getYufangfanganText() {
        return yufangfanganText;
    }


    /**
	 * 设置：预防方案
	 */
    public void setYufangfanganText(String yufangfanganText) {
        this.yufangfanganText = yufangfanganText;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getMabingClicknum() {
        return mabingClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setMabingClicknum(Integer mabingClicknum) {
        this.mabingClicknum = mabingClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMabingDelete() {
        return mabingDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setMabingDelete(Integer mabingDelete) {
        this.mabingDelete = mabingDelete;
    }
    /**
	 * 获取：马病详细介绍
	 */
    public String getMabingContent() {
        return mabingContent;
    }


    /**
	 * 设置：马病详细介绍
	 */
    public void setMabingContent(String mabingContent) {
        this.mabingContent = mabingContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：最后更新时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：最后更新时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
