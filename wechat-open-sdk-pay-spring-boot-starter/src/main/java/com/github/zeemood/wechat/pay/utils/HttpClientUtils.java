package com.github.zeemood.wechat.pay.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * 网络请求工具
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/13 22:35
 */
public class HttpClientUtils {

    public static String postXml(String xml, String url) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient build = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HttpHeaders.CONTENT_TYPE, "text/xml;charset=UTF-8");

        httpPost.setEntity(new StringEntity(xml, "UTF-8"));
        CloseableHttpResponse execute = build.execute(httpPost);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return EntityUtils.toString(execute.getEntity());
        }
        return "";
    }

    public static String postXmlWithCertificate(String url, String xmlStr, String certificatePath, String password) {

        try (
                FileInputStream instream = new FileInputStream(new File(certificatePath));
        ) {
            //加载证书
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(instream, password.toCharArray());
            // Trust own CA and all self-signed certs
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext
                    , new String[]{"TLSv1"}
                    , null,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier()
            );
            try (CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();) {
                HttpPost post = new HttpPost(url);
                post.setEntity(new StringEntity(xmlStr, "UTF-8"));
                CloseableHttpResponse response = httpClient.execute(post);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    String s = EntityUtils.toString(entity);
                    return s;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }
}
