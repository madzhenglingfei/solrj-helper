package stc.skymobi.solr.visitor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import stc.skymobi.solr.anotation.SolrKey;
import stc.skymobi.solr.inf.EntityServerMappingParser;
import stc.skymobi.solr.inf.SolrEntityReslover;

public class AnotionSolrEntityReslover implements SolrEntityReslover{

	private EntityServerMappingParser parser;
	
	@Override
	public <T> String resolveEntityServerKey(T entity) {
		try {
			Class clazz = entity.getClass();
			Field[] allFields = clazz.getDeclaredFields();
			for (Field field : allFields) {
				if (field.isAnnotationPresent(SolrKey.class)) {
					//反射，通过调用get方法得到值
					String getMethordName = field.getName();
					getMethordName = getMethordName.substring(0, 1).toUpperCase()  
				                + getMethordName.substring(1);  
					getMethordName = "get"+getMethordName;
					Method getMethod = clazz.getMethod(getMethordName);
				
					return parser.mapToServer((String)getMethod.invoke(entity));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}


	public EntityServerMappingParser getParser() {
		return parser;
	}


	public void setParser(EntityServerMappingParser parser) {
		this.parser = parser;
	}
	
	
}
