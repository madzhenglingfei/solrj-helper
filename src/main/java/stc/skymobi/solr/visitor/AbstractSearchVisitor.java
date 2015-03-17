package stc.skymobi.solr.visitor;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;

import stc.skymobi.solr.Group;
import stc.skymobi.solr.inf.SolrEntityReslover;
import stc.skymobi.solr.inf.SolrVisitor;

public abstract class AbstractSearchVisitor extends AbstractVisitor{
	
	protected SolrEntityReslover reslover ;
	
	public QueryResponse query(Group group, String solrKey, SolrQuery sq, METHOD method) throws SolrServerException{
		String key = reslover.resolveEntityServerKey(solrKey);
		SolrServer server = group.getServers().get(key);
		return server.query(sq, method);
		
	}
	
	public SolrEntityReslover getReslover() {
		return reslover;
	}
	public void setReslover(SolrEntityReslover reslover) {
		this.reslover = reslover;
	}
}
