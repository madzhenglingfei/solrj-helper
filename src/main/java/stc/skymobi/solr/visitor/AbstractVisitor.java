package stc.skymobi.solr.visitor;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;

import stc.skymobi.solr.Group;
import stc.skymobi.solr.inf.SolrVisitor;

public abstract class AbstractVisitor implements SolrVisitor{
	/**
	 * 删除群组索引
	 * @param group
	 */
	public void deleteIndex(Group group){
		
		Map<String, SolrServer> servers = group.getServers();
		Iterator<SolrServer> iterator = servers.values().iterator();
		while(iterator.hasNext()){
			SolrServer temp = iterator.next();
			try {
				temp.deleteByQuery("*:*");
				temp.commit();
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
