package stc.skymobi.solr;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import stc.skymobi.solr.inf.EntityServerMappingParser;

public class LanguageParser implements EntityServerMappingParser{

	private static Properties lanMappedProperties;
	private static final String DEFAULT_LAN_MAP_PATH = "solr/languageMap.properties";
	private static final String DEFAULT_SOLR_KEY = "default";
	public LanguageParser(){
		ClassPathResource resource = new ClassPathResource(DEFAULT_LAN_MAP_PATH);
		try {
			lanMappedProperties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException ex) {
			throw new IllegalStateException("不能加载 'languageMap.properties': " + ex.getMessage());
		}
	}
	
	@Override
	public String mapToServer(String solrKey) {
		String serverKey = lanMappedProperties.getProperty(solrKey);
		//缺省key
		if(StringUtils.isBlank(serverKey)){
			serverKey = lanMappedProperties.getProperty(DEFAULT_SOLR_KEY);
		}
		return serverKey;
	}
	
}
