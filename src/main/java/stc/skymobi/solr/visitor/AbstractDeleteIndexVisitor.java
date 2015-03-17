package stc.skymobi.solr.visitor;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;

import stc.skymobi.solr.Group;
import stc.skymobi.solr.inf.SolrVisitor;

public abstract class AbstractDeleteIndexVisitor extends AbstractVisitor{

	
	public boolean deleteByIds(Group group, List<String> ids) throws SolrServerException, IOException{
		Map<String, SolrServer> currentServers = group.getServers();
		Iterator<SolrServer> iterator = currentServers.values().iterator();
		while(iterator.hasNext()){
			SolrServer temp = iterator.next();
			temp.deleteById(ids);
			temp.commit();
		}
		return true;
	}
	
	

}
