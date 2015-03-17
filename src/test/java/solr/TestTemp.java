package solr;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import stc.skymobi.solr.DefaultSolrContainerLoader;
import stc.skymobi.solr.LanguageParser;
import stc.skymobi.solr.SolrContainer;
import stc.skymobi.solr.anotation.SolrKey;
import stc.skymobi.solr.inf.SolrContainerLoader;
import stc.skymobi.solr.visitor.AnotionSolrEntityReslover;


public class TestTemp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchEntity entity = new SearchEntity();
		entity.setType("sdsd");
		
		try {
			Class clazz = entity.getClass();
			Field[] fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				if(field.getName().equals("type")){
					//反射，通过调用get方法得到值
					String getMethordName = field.getName();
					getMethordName = getMethordName.substring(0, 1).toUpperCase()  
				                + getMethordName.substring(1);  
					getMethordName = "get"+getMethordName;
					Method getMethod = clazz.getMethod(getMethordName);
					System.out.println(getMethod.invoke(entity));
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
