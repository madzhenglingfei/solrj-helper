package stc.skymobi.solr;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import stc.skymobi.solr.inf.SolrContainerLoader;


public class DefaultSolrContainerLoader implements SolrContainerLoader{
	
	private static Properties groupProperties;
	
	private static final String DEFAULT_GROUP_PATH = "solr/group.properties";
	private static final String DEFAULT_SOLR_PATH = "solr/solr.xml";

	private Object ContainerLoadLock = new Object();

	//静态加载group.properties配置文件
	static{
		
		try {
			ClassPathResource resource = new ClassPathResource(DEFAULT_GROUP_PATH);
			groupProperties = PropertiesLoaderUtils.loadProperties(resource);
		} 
		catch (IOException ex) {
			throw new IllegalStateException("不能加载 'group.properties': " + ex.getMessage());
		}

		
	}
	
	
	public SolrContainer initContainer(SolrContainer container){
		if(container == null){
			synchronized(ContainerLoadLock){
				if(container == null){
					container = creteContainer();
				}
			}
		}
		return container;
	}
	
	public SolrContainer creteContainer(){
		SolrContainer container = new SolrContainer();
		
		//通过applicationContext的方式获取
		ApplicationContext solrContext = new ClassPathXmlApplicationContext(DEFAULT_SOLR_PATH);
		Map<String, SolrServer> solrServers = solrContext.getBeansOfType(SolrServer.class);
		container.setSolrServers(solrServers);
		solrContext = null;
		
		//处理solrServer组
		Map<String, Group> groupMap = new HashMap<String, Group>();
		Enumeration<Object> groupKeys =  groupProperties.keys();
		while (groupKeys.hasMoreElements()) {
			String key = (String) groupKeys.nextElement();
			String groupStr = groupProperties.getProperty(key);
			String[] groupElements = groupStr.split(",");
			
			Map<String, SolrServer> groupTemp = new HashMap<String, SolrServer>();
			for (String element : groupElements) {
				groupTemp.put(element, solrServers.get(element));
			}
			Group group = new Group(groupTemp, key);
			groupMap.put(key, group);
		}
		container.setGroups(groupMap);
		return container;
	}
	
}
