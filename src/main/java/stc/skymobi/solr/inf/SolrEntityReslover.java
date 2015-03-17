package stc.skymobi.solr.inf;
/**
 * 通过构建index的entity实体解析所属solr serverkey的接口
 * @author mad.zheng
 *
 */
public interface SolrEntityReslover {
	/**
	 * 
	 * @param <T>
	 * @param entity
	 * @return
	 */
	public<T>  String resolveEntityServerKey(T entity);
}
