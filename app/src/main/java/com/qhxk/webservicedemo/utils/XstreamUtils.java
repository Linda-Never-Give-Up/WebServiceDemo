package com.qhxk.webservicedemo.utils;

import com.qhxk.webservicedemo.entity.TestBean;
import com.thoughtworks.xstream.XStream;

/**
 * 创建者     WLD
 * 创建时间   2018/8/20 14:48
 * 描述	     XML--> bean 转换类
 * 更新描述   $$$$
 */
public class XstreamUtils {

    public static String javabeanToXml() {

        TestBean bean = new TestBean();
        bean.setUser("DCYTJ");
        bean.setPassword("202cb962ac59075b964b07152d234b70");
        bean.setRole("chis.33");
        bean.setWsCode("YTJ");// 服务Code YBSJK(医博士),JSFUJK(金石妇幼),YTJ(一体机)
        bean.setAreaCode("530102");// 县区编码五华区
        bean.setCompanyCode("DCYTJ");// 公司代码：YBS(医博士) ，CDJS(成都金石),DCYTJ(东川一体机)
        bean.setRecordType("01");// 个人健康档案
        bean.setCertificateType("01");
        bean.setCertificateNo("530102199003076530");

        XStream xstream = new XStream();
        // 设置 类型 别名
        /*xstream.alias("req", RequestReq.class);
        xstream.alias("h", RequestH.class);
        xstream.alias("item", RequestItem.class);
        // 设置 子标签 别名
        xstream.aliasField("items", RequestReq.class, "items");
        // 设置 标签属性 别名
        xstream.aliasAttribute(RequestReq.class, "op", "op");*/

        xstream.alias("Request", TestBean.class);

        // javabean to xml
        String xml = xstream.toXML(bean);
        System.out.println(xml);
        return xml;
    }

    /**
     * convert xml to java bean.
     */
    public void xmlToJavabean() {
        // 给  xml 赋值
       /* javabeanToXml();
        XStream xStream = new XStream();

        // 设置 类型 别名
        xStream.alias("req", RequestReq.class);
        xStream.alias("h", RequestH.class);
        xStream.alias("item", RequestItem.class);
        // 设置 子标签 别名
        xStream.aliasField("items", RequestReq.class, "items");
        // 设置 标签属性 别名
        xStream.aliasAttribute(RequestReq.class, "op", "op");

        // xml to javabean
        RequestReq req = (RequestReq)xStream.fromXML(xml);
        System.out.println(req);*/
        // RequestReq [op=sms_01send, h=RequestH [ver=1.0, user=test, pass=123], items=[RequestItem [id=, content=短信验证码,
        // tele=12345678901, model=1, timing=2017-58-03 09:05:22, reply=1, priority=0]]]

    }

    /**
     * 请求的报文
     *
     * @return
     */
    public static String requestSoap(String soapenv, String ws) {
        StringBuilder sb = new StringBuilder();
        sb.append("<soapenv:Envelope xmlns:soapenv=\"");
        sb.append(soapenv);
        sb.append("\" xmlns:ws=\"");
        sb.append(ws);
        sb.append("\"><soapenv:Header/><soapenv:Body><ws:execute><arg0><![CDATA[");
        sb.append(javabeanToXml());
        sb.append("]]></arg0></ws:execute></soapenv:Body></soapenv:Envelope>");

        return sb.toString();
    }
}
