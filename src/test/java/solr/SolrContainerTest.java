package solr;

import stc.skymobi.solr.DefaultSolrContainerLoader;
import stc.skymobi.solr.LanguageParser;
import stc.skymobi.solr.SolrContainer;
import stc.skymobi.solr.inf.SolrContainerLoader;
import stc.skymobi.solr.visitor.AnotionSolrEntityReslover;

public class SolrContainerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SolrContainerLoader loader = new DefaultSolrContainerLoader();
		SolrContainer container = null;
		container =	loader.initContainer(container);
		AnotionSolrEntityReslover reslover = new AnotionSolrEntityReslover();
		reslover.setParser(new LanguageParser());
		OverseaIndexVisitor visitor = new OverseaIndexVisitor();
		visitor.setReslover(reslover);	
		container.visit(visitor);
	}

}
