package stc.skymobi.solr.visitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;

import stc.skymobi.solr.Group;
import stc.skymobi.solr.inf.SolrEntityReslover;
import stc.skymobi.solr.inf.SolrVisitor;
/**
 * index visitor的模板封装
 * @author mad.zheng
 * @param <T>
 *
 */
public abstract class AbstractIndexVisitor<T> extends AbstractVisitor{
	
	protected SolrEntityReslover reslover ;
	
	/**
	 * 索引更新通用流程，封装部分逻辑，部分在子类实现
	 * @param group
	 */
	public void  rebuildIndex(Group group, List<T> out){
		if(out == null){
			out = getIndexList();
		}
		updateIndex(group, out);
	}
	
	
	/**
	 *获取建立索引需要的lsit，告诉子类实现 
	 * @param <T>
	 * @return
	 */
	public abstract List<T> getIndexList();
	
	/**
	 * 更新索引
	 * @param group
	 */
	public void updateIndex(Group group, List<T> indexList){
		Map<String, SolrServer> servers = group.getServers();
		
		//map存储不同solr server的实例，分开更新索引
		Map<String, List<T>> serverEntitys =new HashMap<String, List<T>>();
		for (T entity : indexList) {
			String key = reslover.resolveEntityServerKey(entity);
			if(serverEntitys.containsKey(key)){
				serverEntitys.get(key).add(entity);
			}
			else{
				List<T> temp = new ArrayList<T>();
				temp.add(entity);
				serverEntitys.put(key, temp);
			}
		}
		
		//更新索引
		Iterator<String> keys = serverEntitys.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			List<T> singleEntities = serverEntitys.get(key);
			if(singleEntities != null && singleEntities.size() > 0){
				try {
					SolrServer server =servers.get(key);
					if(server == null){
						continue;
					}
					server.addBeans(singleEntities, 1);
				} catch (SolrServerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	public SolrEntityReslover getReslover() {
		return reslover;
	}
	public void setReslover(SolrEntityReslover reslover) {
		this.reslover = reslover;
	}
	
	
}
