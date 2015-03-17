package stc.skymobi.solr.inf;
/**
 * solr实体对象和solr server的解析器，
 * 根据solr实体对象的solrkey（语言，标识等等，目前只有语言）映射对应的solrj
 * @author mad.zheng
 *
 */
public interface EntityServerMappingParser {

	public String mapToServer(String solrKey);  

}
