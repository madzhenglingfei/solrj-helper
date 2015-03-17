package solr;

import java.util.ArrayList;
import java.util.List;

import stc.skymobi.solr.Group;
import stc.skymobi.solr.SolrContainer;
import stc.skymobi.solr.inf.SolrVisitor;
import stc.skymobi.solr.visitor.AbstractIndexVisitor;

public class OverseaIndexVisitor extends AbstractIndexVisitor<SearchEntity> implements SolrVisitor{

	public Object visit(SolrContainer container) {
		Group overseaGroup = container.getGroups().get("oversea");
		rebuildIndex(overseaGroup, null);
		return null;
		
	}

	@Override
	public List<SearchEntity> getIndexList() {
		SearchEntity entity = new SearchEntity();
		entity.setName("sdsssdssdddd");
		entity.setType("ch");
		entity.setAppPackage("com.com221sd2");
		entity.setKey("aaaa11ddaa");
		
		List<SearchEntity> list = new ArrayList<SearchEntity>();
		list.add(entity);
		return list;
	}
	
}
