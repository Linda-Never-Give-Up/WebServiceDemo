package com.qhxk.webservicedemo.constant;

/**
 * 创建者     WLD
 * 创建时间   2018/8/14 14:06
 * 描述	     存储静态常
 * 更新描述
 */
public class Constant {
    public static final String WEB_SERVER_URL = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";

    // 健康档案判断接口
    public static final String RECORDGENERAL            = "http://192.168.1.115:12307/chis/RecordGeneralWSService?wsdl";
    // 健康档案命名空间
    public static final String RECORDGENERAL_NAMESPACE  = "http://ws.source.chis/";
    // 健康档案接口的方法名
    public static final String RECORDGENERAL_METHODNAME = "envelope";
}
