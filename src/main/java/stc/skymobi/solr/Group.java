package stc.skymobi.solr;

import java.util.Map;

import org.apache.solr.client.solrj.SolrServer;
/**
 * solr分组，如：海外市场相关的servers在一组
 * @author mad.zheng
 *
 */
public class Group {
	Map<String, SolrServer> servers = null;
	
	String groupKey = null;
	
	public Group(Map<String, SolrServer> servers, String groupKey){
		this.servers = servers;
		this.groupKey = groupKey;
	}
	
	public Map<String, SolrServer> getServers() {
		return servers;
	}

	public void setServers(Map<String, SolrServer> servers) {
		this.servers = servers;
	}
	
}
