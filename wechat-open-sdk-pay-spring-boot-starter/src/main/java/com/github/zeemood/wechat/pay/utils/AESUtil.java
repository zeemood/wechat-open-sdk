package com.github.zeemood.wechat.pay.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * <p>
 * AES加解密工具
 * 在这段代码可以运行之前，还有一个问题需要解决。
 * Java本身限制密钥的长度最多128位，而AES256需要
 * 的密钥长度是256位，因此需要到Java官网上下载一
 * 个Java Cryptography Extension (JCE) Unlimited
 * Strength Jurisdiction Policy Files。在Java SE
 * 的下载页面（http://www.oracle.com/technetwork
 * /java/javase/downloads/index.html）下面的
 * Additional Resources那里会有下载链接。下载后
 * 打开压缩包，里面有两个jar文件。把这两个jar文件
 * 解压到JRE目录下的lib/security文件夹，覆盖原来
 * 的文件。这样Java就不再限制密钥的长度了。
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 2:20
 */
public class AESUtil {
    public static boolean initialized = false;

    public static final String ALGORITHM = "AES/ECB/PKCS7Padding";

    /**
     * @param str 要被加密的字符串
     * @param key 加/解密要用的长度为32的字节数组（256位）密钥
     * @return byte[]  加密后的字节数组
     */
    public static byte[] Aes256Encode(String str, byte[] key) {
        initialize();
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); //生成加密解密需要的Key
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            result = cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param bytes 要被解密的字节数组
     * @param key   加/解密要用的长度为32的字节数组（256位）密钥
     * @return String  解密后的字符串
     */
    public static String Aes256Decode(byte[] bytes, byte[] key) {
        initialize();
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); //生成加密解密需要的Key
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decoded = cipher.doFinal(bytes);
            result = new String(decoded, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void initialize() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

}
