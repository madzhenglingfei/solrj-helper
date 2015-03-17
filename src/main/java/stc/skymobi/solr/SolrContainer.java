package stc.skymobi.solr;

import java.util.Map;

import org.apache.solr.client.solrj.SolrServer;

import stc.skymobi.solr.inf.SolrVisitor;
/**
 * solr连接管理的核心容器，内部维护一个solrserver map和solr组
 * （如：冒泡游戏，冒泡市场，海外市场就是不同组）
 * @author mad.zheng
 *
 */
public class SolrContainer {
	
	Map<String, SolrServer> solrServers = null;
	
	Map<String, Group> groups = null;

	/**
	 * 访问者模式访问solr容器资源
	 * @param visitor
	 */
	public Object visit(SolrVisitor<?> visitor){
		return visitor.visit(this);
	}
	
	
	public Map<String, SolrServer> getSolrServers() {
		return solrServers;
	}

	public void setSolrServers(Map<String, SolrServer> solrServers) {
		this.solrServers = solrServers;
	}

	public Map<String, Group> getGroups() {
		return groups;
	}

	public void setGroups(Map<String, Group> groups) {
		this.groups = groups;
	}

	
}

