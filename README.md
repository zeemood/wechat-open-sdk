# synergic-developing
java版的支付工具类（支付宝/微信），三方登录工具类
使用方法(v1.1.0):
1.添加支付宝支付的服务端sdk，免去mvn安装。
2.使用方法重载的思路，把微信支付助手和支付宝支付助手两个工具类合并在成PayAssistant，把应答远端服务器的方法名改成echo
3.完善了微信登录的工具类和配置文件模版
====================================================
使用方法（v1.0.1，详见https://www.imooc.com/article/23605）：
1.使用前准备：maven安装支付宝支付的java服务端sdk，指令参考：
安装jar：mvn install:install-file -Dfile=d:/alipay-sdk-java20180104135026.jar -DgroupId=com.alipay -DartifactId=sdk -Dversion=20180104135026 -Dpackaging=jar

安装源码：mvn install:install-file -Dfile=d:/alipay-sdk-java20180104135026-source.jar -DgroupId=com.alipay -DartifactId=sdk -Dversion=20180104135026 -Dpackaging=sources

2.配置文件，payConfigure.properties和synergicLogin.properties,已经写好注释，使用配置项切换测试环境和生产环境的回调地址，省去改代码的麻烦

3.支付宝支付工具类使用时调用AlipayAssistant工具类的对应方法，model使用AlipayModelUtils去获取，已经封装好请求时必填的业务参数，省去看api的麻烦

4.微信支付同样，调用WechatPayAssistant的对应方法，model可以直接new出来，然后在实例化的时候在构造器里填入必填参数

5.三方登录目前只有微信，比较简单，看注释，不再赘述，流程看官网
