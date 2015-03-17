package stc.skymobi.solr.inf;

import stc.skymobi.solr.SolrContainer;
/**
 * stc-solr对solrj连接进行了封装
 * @author mad.zheng
 * @param <T>
 *
 */
public interface SolrVisitor<T> {
	
	public  T visit(SolrContainer container) ;
}
