package solr;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.solr.client.solrj.beans.Field;

import stc.skymobi.solr.anotation.SolrKey;

public class SearchEntity {
	private String key;
	private String id;
	private int classId;
	private String name;
	//private String pinyinName;
	private int fileSize;
	private int price;
	private String description;
	private String appPackage;
	private int appVer;
	private String appShowVer;
	private List<String> tag;
	private int promotion;
	private float hot;
	private float commentScore;
	private String searchWeight;
	private String author;
	private int appType;
	private int searchType;
	private String appAlias ;
	private String iconFileId;
	private int bizSrc;
	
	@SolrKey
	private  String type;

	public int getSearchType() {
		return searchType;
	}

	@Field
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public int getAppType() {
		return appType;
	}

	public void setAppType(int appType) {
		this.appType = appType;
	}

	public String getAuthor() {
		return author;
	}

	@Field
	public void setAuthor(String author) {
		this.author = author;
	}

	@Field
	private Float score;

	public String getKey() {

		return key;
	}

	@Field
	public void setKey(String key) {
		this.key = key;

	}

	public void setKey(int type) {
		this.key = id + "_" + type;

	}

	public String getId() {
		return id;
	}

	@Field
	public void setId(String id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	@Field
	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	@Field
	public void setName(String name) {
		this.name = name;
	}
/*
	public String getPinyinName() {
		return pinyinName;
	}

	@Field
	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName;
	}
   
	

	public void setPinyinName() {
		if (!StringUtils.isBlank(this.name)) {
			String pinyin = PinyinUtil.toPinyin(name, true);
			List<String> pinyins = PinyinUtil.splitPinyin(pinyin);
			if (pinyins != null) {
				StringBuilder builder = new StringBuilder();
				for (String s : pinyins) {
					builder.append(s).append(' ');
				}
				this.pinyinName = builder.toString();
			}
		}
	}
*/
	public String getIconFileId() {
		return iconFileId;
	}
	@Field
	public void setIconFileId(String iconFileId) {
		this.iconFileId = iconFileId;
	}

	public String getDescription() {
		return description;
	}

	@Field
	public void setDescription(String description) {
		this.description = description;
	}

	public String getAppPackage() {
		return appPackage;
	}

	@Field
	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	public int getAppVer() {
		return appVer;
	}

	@Field
	public void setAppVer(int appVer) {
		this.appVer = appVer;
	}

	public String getAppShowVer() {
		return appShowVer;
	}

	@Field
	public void setAppShowVer(String appShowVer) {
		this.appShowVer = appShowVer;
	}


	public int getPromotion() {
		return promotion;
	}

	@Field
	public void setPromotion(int promotion) {

		this.promotion = promotion;
	}

	public void setPromotion() {
		promotion = appType > 0 ? 1 : 0;
		this.promotion = promotion;
	}

	public float getHot() {

		return hot;
	}

	@Field
	public void setHot(float hot) {
		this.hot = hot;
	}

	public float getCommentScore() {
		return commentScore;
	}

	@Field
	public void setCommentScore(float commentScore) {
		this.commentScore = commentScore;
	}

	public void setHot() {
		if (searchWeight == null || "".equals(searchWeight)) {
			this.hot = hot;
		} else {
			int idx = searchWeight.indexOf('%');
			String numStr = searchWeight;
			if (idx > -1) {
				numStr = searchWeight.substring(0, idx);
			}
			float coef = 0;
			try {
				coef = Float.valueOf(numStr);
			} catch (Exception e) {
				this.hot = hot;
			}
			if (idx > -1) {// 按百分比相对调整
				hot = hot * (1 + coef / 100);
			} else {// 绝对调整
				hot += coef;
			}
		}
	}

	public String getSearchWeight() {
		return searchWeight;
	}

	public void setSearchWeight(String searchWeight) {
		this.searchWeight = searchWeight;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public int getFileSize() {
		return fileSize;
	}
    @Field
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getPrice() {
		return price;
	}
	@Field
	public void setPrice(int price) {
		this.price = price;
	}

	public String getAppAlias() {
		return appAlias;
	}

	public void setAppAlias(String appAlias) {
		this.appAlias = appAlias;
	}

	public List<String> getTag() {
		return tag;
	}
	@Field
	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public int getBizSrc() {
		return bizSrc;
	}

	public void setBizSrc(int bizSrc) {
		this.bizSrc = bizSrc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
