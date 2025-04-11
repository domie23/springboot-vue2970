package com.entity.view;

import com.entity.MabingCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 马病收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("mabing_collection")
public class MabingCollectionView extends MabingCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String mabingCollectionValue;



		//级联表 mabing
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
				* 病因类型的值
				*/
				private String mabingValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer mabingDelete;
			/**
			* 马病详细介绍
			*/
			private String mabingContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public MabingCollectionView() {

	}

	public MabingCollectionView(MabingCollectionEntity mabingCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, mabingCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getMabingCollectionValue() {
				return mabingCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setMabingCollectionValue(String mabingCollectionValue) {
				this.mabingCollectionValue = mabingCollectionValue;
			}













				//级联表的get和set mabing
					/**
					* 获取： 马病编号
					*/
					public String getMabingUuidNumber() {
						return mabingUuidNumber;
					}
					/**
					* 设置： 马病编号
					*/
					public void setMabingUuidNumber(String mabingUuidNumber) {
						this.mabingUuidNumber = mabingUuidNumber;
					}
					/**
					* 获取： 马病名称
					*/
					public String getMabingName() {
						return mabingName;
					}
					/**
					* 设置： 马病名称
					*/
					public void setMabingName(String mabingName) {
						this.mabingName = mabingName;
					}
					/**
					* 获取： 马病照片
					*/
					public String getMabingPhoto() {
						return mabingPhoto;
					}
					/**
					* 设置： 马病照片
					*/
					public void setMabingPhoto(String mabingPhoto) {
						this.mabingPhoto = mabingPhoto;
					}
					/**
					* 获取： 病因类型
					*/
					public Integer getMabingTypes() {
						return mabingTypes;
					}
					/**
					* 设置： 病因类型
					*/
					public void setMabingTypes(Integer mabingTypes) {
						this.mabingTypes = mabingTypes;
					}


						/**
						* 获取： 病因类型的值
						*/
						public String getMabingValue() {
							return mabingValue;
						}
						/**
						* 设置： 病因类型的值
						*/
						public void setMabingValue(String mabingValue) {
							this.mabingValue = mabingValue;
						}
					/**
					* 获取： 基本症状
					*/
					public String getZhengzhuangText() {
						return zhengzhuangText;
					}
					/**
					* 设置： 基本症状
					*/
					public void setZhengzhuangText(String zhengzhuangText) {
						this.zhengzhuangText = zhengzhuangText;
					}
					/**
					* 获取： 治疗方案
					*/
					public String getZhiliaofanganText() {
						return zhiliaofanganText;
					}
					/**
					* 设置： 治疗方案
					*/
					public void setZhiliaofanganText(String zhiliaofanganText) {
						this.zhiliaofanganText = zhiliaofanganText;
					}
					/**
					* 获取： 预防方案
					*/
					public String getYufangfanganText() {
						return yufangfanganText;
					}
					/**
					* 设置： 预防方案
					*/
					public void setYufangfanganText(String yufangfanganText) {
						this.yufangfanganText = yufangfanganText;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getMabingClicknum() {
						return mabingClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setMabingClicknum(Integer mabingClicknum) {
						this.mabingClicknum = mabingClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getMabingDelete() {
						return mabingDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setMabingDelete(Integer mabingDelete) {
						this.mabingDelete = mabingDelete;
					}
					/**
					* 获取： 马病详细介绍
					*/
					public String getMabingContent() {
						return mabingContent;
					}
					/**
					* 设置： 马病详细介绍
					*/
					public void setMabingContent(String mabingContent) {
						this.mabingContent = mabingContent;
					}










				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}






}
