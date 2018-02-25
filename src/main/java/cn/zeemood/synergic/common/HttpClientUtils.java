package cn.zeemood.synergic.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;

import cn.zeemood.synergic.pay.wechat.utils.WechatPayConfigurations;

@SuppressWarnings("all")
public class HttpClientUtils {

	@SuppressWarnings("deprecation")
	public static String connectWithXMLAndSSLByPost(URI uri, Document doc, String sslPath, String password)
			throws Exception {
		String ret="";
		String xml = doc.asXML();
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		try (FileInputStream instream = new FileInputStream(
				new File(WechatPayConfigurations.getRefundCertificatePath()));) {
			keyStore.load(instream, password.toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		try (CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();) {
			HttpPost post = new HttpPost(uri);
			post.setEntity(new StringEntity(xml,"UTF-8"));
			try(CloseableHttpResponse response = httpClient.execute(post);){
				HttpEntity entity = response.getEntity();
				if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String text;
                    while ((text = bufferedReader.readLine()) != null) {
                        ret+=text;
                    }
                }
                EntityUtils.consume(entity);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return ret;
	}

	/**
	 * 使用post方法发送xml
	 * 
	 * @param uri
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	public static String connectWithXMLByPost(URI uri, Document doc) throws Exception {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpPost post = new HttpPost(uri);
			post.addHeader("Content-Type", "text/xml;charset=UTF-8");
			StringEntity xml = new StringEntity(doc.asXML(), "UTF-8");
			post.setEntity(xml);
			try (CloseableHttpResponse response = httpClient.execute(post)) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 使用get方法链接客户端
	 * 
	 * @param uri
	 * @return
	 * @throws Exception
	 */
	public static String connectByGet(URI uri) throws Exception {
		// TODO Auto-generated method stub
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(uri);
			try (CloseableHttpResponse response = httpClient.execute(httpGet)) {

				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity);

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
