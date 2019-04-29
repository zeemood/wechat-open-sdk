# wechat-open-jdk

----------------------------

java版的支付工具类（支付宝/微信），三方登录工具类

版本 | 1.0.0 | 1.1.2 |1.1.4
---- | --- | --- |---
微信扫码支付 | ✔ | ✔ | ✔ 
微信公众号支付 | △ | △ | ✔ 
微信APP支付| ✔ | ✔ | ✔ 
微信退款| ✔ | ✔  | ✔ 
支付宝APP支付| ✔ | ✔ | ✔ 
支付宝电脑网页支付| ✔ | ✔ | ✔ 
支付宝wap支付| △ | △ | △ 
支付宝退款| ✔ | ✔ | ✔  
微信登录(公众号授权)| △ | ✔ | ✔ 
订单号生成器|△|✔ | ✔ 
备注|△代表未测试| |   

--------

## 新版本预告

重构的版本将在4月份之前发布，会使用jitpack发布。代码会更规范友好，和易于维护

----------
## 更新说明

删去alipay sdk源码，增加官方alipay依赖。

------------------------------------------------------------

## 更新说明(v.1.1.4)

1. 替换掉MD5Utils的工具类，使用内置的DigestUtils进行md5加密，因为在测试过程中发现打包之后MD5Utils加密出现签名失败的诡异情况，在idea上跑完全没问题

2. 公众号支付openid原来是必填的，修改了工具类，在进行公众号支付时检测有没有填写openid

3. 如果微信的APP支付以及公众号支付你们的前端不想做二次加签，可以调用WechatPayAssistant里的sign4App和sign4WxH5进行二次加签返回给前端

------------------------------------------------------------

## 使用方法(v1.1.2,详见https://www.imooc.com/article/23605):


1. 添加支付宝支付的服务端sdk，免去mvn安装。

2. 使用方法重载的思路，把微信支付助手和支付宝支付助手两个工具类合并在成PayAssistant，把应答远端服务器的方法名改成echo

3. 完善了微信登录的工具类和配置文件模版

4. 提供可以复制粘贴的demo，传送门https://www.imooc.com/article/23635

5. 将支付宝APP预支付方法修改了，不太会用我说的那种后缀的方法配回调地址的，可以直接填入自定义回调地址

6. 完善订单号生成器，具体使用方法见https://www.imooc.com/article/23666 里的第三点SnGenarator

7. 测试了微信登录和公众号授权（其实是一个东西）

8. 更新预告：发现小伙伴们获取配置文件的方法五花八门，考虑出新版本2.0，自由去配置或修改参数，就是把工具包sdk咯，开发可以灵活一点

------------------------------------------------------------------

## 使用方法（v1.0.0，详见https://www.imooc.com/article/23605）：

1. 使用前准备：maven安装支付宝支付的java服务端sdk，指令参考：
安装jar：mvn install:install-file -Dfile=d:/alipay-sdk-java20180104135026.jar -DgroupId=com.alipay -DartifactId=sdk -Dversion=20180104135026 -Dpackaging=jar

安装源码：mvn install:install-file -Dfile=d:/alipay-sdk-java20180104135026-source.jar -DgroupId=com.alipay -DartifactId=sdk -Dversion=20180104135026 -Dpackaging=sources

2. 配置文件，payConfigure.properties和synergicLogin.properties,已经写好注释，使用配置项切换测试环境和生产环境的回调地址，省去改代码的麻烦

3. 支付宝支付工具类使用时调用AlipayAssistant工具类的对应方法，model使用AlipayModelUtils去获取，已经封装好请求时必填的业务参数，省去看api的麻烦

4. 微信支付同样，调用WechatPayAssistant的对应方法，model可以直接new出来，然后在实例化的时候在构造器里填入必填参数
