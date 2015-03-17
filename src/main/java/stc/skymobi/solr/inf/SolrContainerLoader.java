package stc.skymobi.solr.inf;

import stc.skymobi.solr.SolrContainer;

public interface SolrContainerLoader {
	
	/**
	 * 初始化solr容器的方法
	 * @param container
	 */
	public SolrContainer initContainer(SolrContainer container);

}
