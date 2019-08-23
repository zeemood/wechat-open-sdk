package com.github.zeemood.wechat.pay.utils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Xml工具类
 *
 * @author zeemoo
 * @since 2019/8/13 23:59
 */
public class XmlUtils {

    /**
     * xml转对象
     *
     * @param xml
     * @param objClass
     * @return
     */
    public static <T> T toObject(String xml, Class<T> objClass) {
        Serializer serializer = new Persister();
        try {
            return serializer.read(objClass, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * obj 转 xml
     *
     * @param obj
     * @return
     */
    public static String toXml(Object obj) {
        Serializer serializer = new Persister();
        StringWriter output = new StringWriter();
        try {
            serializer.write(obj, output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    /**
     * xml 转 map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> toMap(String strXML) {
        try {
            Map<String, String> data = new TreeMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
