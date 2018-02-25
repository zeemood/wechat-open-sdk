package cn.zeemood.synergic.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

/**
 * XML工具类（dom4j）
 * @author zhang.shushan
 * @date 2018年1月26日
 */
public class XMLUtils {
	
	/**
	 * 从request读取xml
	 * @param request
	 * @return
	 */
	public static String readXmlFromRequest(HttpServletRequest request) {
		StringBuilder xmlSb = new StringBuilder();
		try(
				ServletInputStream in = request.getInputStream();
				InputStreamReader inputStream = new InputStreamReader(in);
				BufferedReader buffer = new BufferedReader(inputStream);
				){
			String line = null;
			while((line=buffer.readLine())!=null){
				xmlSb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlSb.toString();
	}
	
	/**
	 * 将获取的Map转换成xml
	 * @param map
	 * @return
	 */
	public static Document convertMap2Xml(Map<String,Object> map){
		Document doc = DocumentHelper.createDocument();
		try {
			Element root = doc.addElement("xml");
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Element ele = root.addElement(key);
				ele.addCDATA(map.get(key).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	/**
	 * xml文档Document转对象
	 * 
	 * @param document
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object convertXml2Bean(Document document, Class<?> clazz) {
		Map<String,String> map = new HashMap<>();
		// 获取根节点
		Element root = document.getRootElement();
		try {
			List<Element> properties = root.elements();
			for (Element pro : properties) {
				String propName = pro.getName();
				String propValue = pro.getText();
				map.put(propName, propValue);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//处理map里的JSON字符串字段,防止解析错误
		Map<String,Object> objMap = new TreeMap<>();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String str = map.get(key);
			
			try {
				//如果是JSON字符串，则转换成对象，再添加到objMap中
				objMap.put(key, JSON.parse(str));
			} catch (JSONException e) {
				//如果不是JSON字符串，则直接添加到objMap中
				objMap.put(key, str);
			} catch (Exception e){
				//其余错误抛出
				e.printStackTrace();
			}
			
		}
		
		return JSON.parseObject(JSON.toJSONString(map),clazz);
	}

	/**
	 * xml字符串转对象
	 * 
	 * @param xmlString
	 * @param clazz
	 * @return
	 */
	public static Object convertXml2Bean(String xmlString, Class<?> clazz) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(xmlString);
		} catch (DocumentException e) {
			throw new RuntimeException("获取Document异常" + xmlString);
		} // 获取根节点
		return convertXml2Bean(document, clazz);
	}

	/**
	 * 对象转xml文件
	 * 
	 * @param b
	 * @return
	 */
	public static Document convertBean2Xml(Object b) {
		Document document = DocumentHelper.createDocument();
		try {
			// 创建根节点元素
			Element root = document.addElement(b.getClass().getSimpleName());
			// 获取实体类b的所有属性，返回Field数组
			Field[] field = b.getClass().getDeclaredFields();
			// 遍历所有有属性
			for (int j = 0; j < field.length; j++) {
				String name = field[j].getName(); // 获取属属性的名字
				if (!name.equals("serialVersionUID")) {// 去除串行化序列属性
					name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
					Method m = b.getClass().getMethod("get" + name);
					String propValue = (String) m.invoke(b);// 获取属性值
					Element propertie = root.addElement(name);
					propertie.setText(propValue);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return document;
	}

	/**
	 * 对象转xml格式的字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String getXmlString(Object b) {
		return convertBean2Xml(b).asXML();
	}

}
