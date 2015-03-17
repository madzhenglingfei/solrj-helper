package stc.skymobi.solr.build;

import org.springframework.beans.factory.FactoryBean;

import stc.skymobi.solr.LanguageParser;
import stc.skymobi.solr.visitor.AnotionSolrEntityReslover;

public class IndexResloverFactorybean implements FactoryBean<AnotionSolrEntityReslover> {

	@Override
	public AnotionSolrEntityReslover getObject() throws Exception {
		AnotionSolrEntityReslover reslover = new AnotionSolrEntityReslover();
		reslover.setParser(new LanguageParser());
		return reslover;
	}

	@Override
	public Class<?> getObjectType() {
		return AnotionSolrEntityReslover.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
