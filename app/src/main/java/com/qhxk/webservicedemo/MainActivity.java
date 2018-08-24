package com.qhxk.webservicedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.qhxk.webservicedemo.constant.Constant;
import com.qhxk.webservicedemo.entity.TestBean;
import com.qhxk.webservicedemo.utils.ComProtocol;
import com.qhxk.webservicedemo.utils.HaseMapUtils;
import com.qhxk.webservicedemo.utils.WebServiceUtils;
import com.qhxk.webservicedemo.utils.XstreamUtils;

import org.ksoap2.serialization.SoapObject;

import java.util.HashMap;

/**
 * 创建者     WLD
 * 创建时间   2018/8/14 14:02
 * 描述	     测试安卓调用 webService 接口
 * 更新描述
 */
public class MainActivity extends Activity implements ComProtocol.okResponse {
    private static final String NAMESPACE  = "http://WebXml.com.cn/";
    private static final String METHODNAME = "getSupportProvince";

    private HashMap<String, Object> respone;
    private TestBean                bean;

    private TextView tv;

    private String soapenv = "http://schemas.xmlsoap.org/soap/envelope/";
    private String ws      = "http://ws.source.chis/";

    private ComProtocol mComProtocol;
    private static final int SUCCESS = 0X12;
    private static final int FAILE   = 0X13;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS:
                    String result = (String) msg.obj;
                    Log.i("TAG","请求的数据---->"+result);
                    tv.setText(result);
                    break;

                case FAILE:
                    Toast.makeText(MainActivity.this, "请求失败---->" + (String) msg.obj, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        String xml = XstreamUtils.requestSoap(soapenv, ws);
        Log.i("MainActivity---->", xml);
       /* try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        init();*/
        getData();
    }

    private void init() {


        //通过工具类调用WebService接口
        WebServiceUtils.callWebService(Constant.RECORDGENERAL, Constant.RECORDGENERAL_NAMESPACE, Constant
                .RECORDGENERAL_METHODNAME, respone, new WebServiceUtils.WebServiceCallBack() {

            //WebService接口返回的数据回调到这个方法中
            @Override
            public void callBack(SoapObject result) {
                //关闭进度条
                if (result != null) {
                    Log.i("TAG", "请求的数据---->" + result.toString());
                    tv.setText(result.toString());
                } else {
                    Toast.makeText(MainActivity.this, "请求失败 -- 请联系管理员", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initData() throws Exception {
        respone = new HashMap<>();
        bean = new TestBean();
        bean.setUser("DCYTJ");
        bean.setPassword("202cb962ac59075b964b07152d234b70");
        bean.setRole("管理员");
        bean.setWsCode("YTJ");// 服务Code YBSJK(医博士),JSFUJK(金石妇幼),YTJ(一体机)
        bean.setAreaCode("530102");// 县区编码五华区
        bean.setCompanyCode("YBS");// 公司代码：YBS(医博士) ，CDJS(成都金石)
        bean.setRecordType("01");// 个人健康档案
        bean.setCertificateType("01");
        bean.setCertificateNo("530102199003076530");

        respone = HaseMapUtils.objectToMap(bean);
        Log.i("TAG", "构造的HaseMap 数据---- >" + respone.toString());
    }

    private void getData() {
        String xml = XstreamUtils.requestSoap(soapenv, ws);
        mComProtocol = new ComProtocol(Constant.RECORDGENERAL, xml, this);
        mComProtocol.getHttpClientResult();
    }

    @Override
    public void onSuccess(String str) {
        System.out.println("-------->成功");
        mHandler.obtainMessage(SUCCESS, str).sendToTarget();
    }

    @Override
    public void onFaile(String str) {
        System.out.println("-------->失败");
        mHandler.obtainMessage(FAILE, str).sendToTarget();
    }
}
