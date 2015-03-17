package stc.skymobi.solr.build;

import org.springframework.beans.factory.FactoryBean;

import stc.skymobi.solr.DefaultSolrContainerLoader;
import stc.skymobi.solr.SolrContainer;
import stc.skymobi.solr.inf.SolrContainerLoader;

public class ContainerFactorybean implements FactoryBean<SolrContainer> {

	@Override
	public SolrContainer getObject() throws Exception {
		SolrContainerLoader loader = new DefaultSolrContainerLoader();
		SolrContainer container = null;
		container =	loader.initContainer(container);
		return container;
	}

	@Override
	public Class<?> getObjectType() {
		return SolrContainer.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
		
}
