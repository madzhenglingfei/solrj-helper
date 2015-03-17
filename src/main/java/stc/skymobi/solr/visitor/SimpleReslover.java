package stc.skymobi.solr.visitor;

import stc.skymobi.solr.inf.EntityServerMappingParser;
import stc.skymobi.solr.inf.SolrEntityReslover;

public class SimpleReslover implements SolrEntityReslover{
	
	private EntityServerMappingParser parser;
	
	@Override
	public <T> String resolveEntityServerKey(T entity) {
		return parser.mapToServer((String)entity);
	}

	public EntityServerMappingParser getParser() {
		return parser;
	}

	public void setParser(EntityServerMappingParser parser) {
		this.parser = parser;
	}
	
}
