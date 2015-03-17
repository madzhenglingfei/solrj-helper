package stc.skymobi.solr.build;

import org.springframework.beans.factory.FactoryBean;

import stc.skymobi.solr.LanguageParser;
import stc.skymobi.solr.visitor.SimpleReslover;

public class SearchFactorybean implements FactoryBean<SimpleReslover>{

	@Override
	public SimpleReslover getObject() throws Exception {
		SimpleReslover reslover = new SimpleReslover();
		reslover.setParser(new LanguageParser());
		return reslover;
	}

	@Override
	public Class<?> getObjectType() {
		return SimpleReslover.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
