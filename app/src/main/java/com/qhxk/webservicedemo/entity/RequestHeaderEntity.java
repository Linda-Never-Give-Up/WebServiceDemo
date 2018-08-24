package com.qhxk.webservicedemo.entity;

/**
 * 创建者     WLD
 * 创建时间   2018/8/20 14:52
 * 描述	     请求头的实体类
 * 更新描述   $$$$
 */
public class RequestHeaderEntity {

    /**<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.source.chis/">

    <soapenv:Header/>
    <soapenv:Body>
    <ws:execute>

    <arg0><![CDATA[<Request><areaCode>530129</areaCode><companyCode>YBS</companyCode>
    <password>202cb962ac59075b964b07152d234b70</password><role>chis.33</role><user>YBS</user>
    <wsCode>YBSJK</wsCode><certificateNo>53240119360313062X</certificateNo>
    <certificateType>01</certificateType><ipi/><recordType>01</recordType></Request>
            ]]></arg0>

    </ws:execute>
    </soapenv:Body>
    </soapenv:Envelope>*/

    private String soapenv;
    private String ws;
}
