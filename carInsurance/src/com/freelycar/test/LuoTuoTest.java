package com.freelycar.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.freelycar.util.Constant;
import com.freelycar.util.HttpClientUtil;
import com.freelycar.util.Tools;

public class LuoTuoTest {
	/**
	 * 测试的时候 把对应字段改掉
	 * 具体看注释
	 */
	
	//访问的域名 该域名要在骆驼那边注册
	private static final String BASEURL = Constant.INTERFACE_BASE_URL;
	/*private static String licenseNumber = "苏AB660C";
	private static String ownerName = "陈雯";*/
	private static String licenseNumber = "苏AE1B98";//车牌
	private static String ownerName = "李哲";//车主姓名
	private static String idNumber = "42108119840914002X";//身份证
	private static String forceInsuranceStartTime = "1524239999";//续保信息中强制险的止保日期
	private static String insuranceStartTime = "1524239999";//续保信息中商业险的止保日期
	private static String phone = "13505143481";//手机号
	private static String offerId = "109-20180625135214-d7416";//报价推送过来的编号
	private static String openId = "oziV35LSeMzPGl2kY5-8EAY181no";//随便找个数据库中 已存在 的用户的openId，模拟用户登陆
	
	
	@Test
	public void testXunBao() throws ClientProtocolException, IOException{
		JSONObject obj = new JSONObject();
		obj.put("licenseNumber", licenseNumber);
		obj.put("ownerName", ownerName);
		obj.put("openId", openId);
		obj.put("carTypeCode", "02");//该字段后台不传默认02
	/*	obj.put("licenseNumber", "苏A129B0");
		obj.put("ownerName", "朱祥珍");*/
		/*		obj.put("licenseNumber", "苏A4PZ99");
		obj.put("ownerName", "刘扬");
*/		HttpClientUtil.httpPost(BASEURL+"insurance/queryLastYear", obj);
	}
//{"errorMsg":{"code":"success","message":"操作成功"},"data":"{\"ciInfo\":{\"insuranceCompany\":\"人保保险\",\"insuranceCompanyId\":2,\"policyNo\":\"PDZA20173201000300301315\",\"totalAmount\":\"855.00\",\"insuranceEndTime\":\"2018-04-2023:59:59\",\"planCode\":\"C51\"},\"needCompleteCarInfo\":false,\"biInfo\":{\"insuranceCompany\":\"人保保险\",\"insuranceCompanyId\":2,\"policyNo\":\"PDAA20173201000300270296\",\"totalAmount\":\"3340.19\",\"insuranceEndTime\":\"2018-04-2023:59:59\",\"planCode\":\"C01\",\"insurances\":[{\"insuranceId\":1,\"insuranceName\":\"车辆损失险\",\"type\":2,\"isToubao\":\"1\",\"compensation\":true,\"price\":1,\"englishName\":\"车损\",\"state\":1,\"retCode\":0,\"remark\":\"{\\\"buyingRate\\\":\\\"86.19%\\\",\\\"description\\\":\\\"承保本车车辆损失，强烈推荐购买\\\",\\\"insuranceCoverage\\\":\\\"您自己的车辆因碰撞、倾覆、火灾、爆炸、自然灾害、外界物体坠落或倒塌等发生的损失，保险公司按照条款规定进行赔偿。\\\"}\",\"amountStr\":\"投保\",\"isSupported\":true,\"weixinSource\":\"xiaoma\",\"dependRuleJson\":\"\"},{\"insuranceId\":2,\"insuranceName\":\"第三者责任险\",\"type\":3,\"isToubao\":\"1\",\"compensation\":true,\"price\":1000000,\"options\":\"50000,100000,200000,300000,500000,1000000\",\"englishName\":\"三者\",\"state\":1,\"retCode\":0,\"remark\":\"{\\\"buyingRate\\\":\\\"93.67%\\\",\\\"description\\\":\\\"承保车外第三方人身财产损失，强烈推荐购买\\\",\\\"insuranceCoverage\\\":\\\"若发生意外事故，保险公司将按照条款规定进行赔偿您对第三者造成的人身伤亡与财产损失。\\\"}\",\"amountStr\":\"100万\",\"isSupported\":true,\"weixinSource\":\"xiaoma\",\"dependRuleJson\":\"\"}]}}","time":null,"successful":true}
	
	@Test//询价
	public void testcreateEnquiry(){
		JSONObject obj = new JSONObject();
		//Map<String,Object> obj = new HashMap<>();
		//obj.put("phone", "18362981113");
		obj.put("openId", openId);
		obj.put("licenseNumber", licenseNumber);
		obj.put("ownerName", ownerName);
		obj.put("cityCode", "32010003");//很重要！！！！
		obj.put("cityName", "南京");
		obj.put("insuranceCompanyId", "2");
		obj.put("forceInsuranceStartTime", forceInsuranceStartTime);
		obj.put("insuranceStartTime", insuranceStartTime);
		obj.put("carTypeCode", "02");
		/*obj.put("phone", "13913980918");
		obj.put("licenseNumber", "苏A2F6S5");
		obj.put("cityCode", "32010003");
		obj.put("cityName", "南京");
		obj.put("ownerName", "王惺嫱");
		obj.put("insuranceCompanyId", "2");*/
		/*obj.put("phone", "18252085210");
		obj.put("licenseNumber", "苏A4PZ99");
		obj.put("cityCode", "32010003");
		obj.put("cityName", "南京");
		obj.put("ownerName", "刘扬");
		obj.put("insuranceCompanyId", "2");
		obj.put("forceInsuranceStartTime", "1524067199");*/
		
		
		//obj.put("insurances", "[{\"englishName\":\"车损\",\"compensation\":\"true\",\"isSupported\":\"false\",\"price\":\"1\",\"isToubao\":\"1\",\"amountStr\":\"投保\",\"quotesPrice\":\"0\",\"state\":\"1\",\"isHot\":\"false\",\"insuranceId\":\"1\",\"type\":\"0\",\"insuranceName\":\"车辆损失险\"},{\"englishName\":\"三者\",\"compensation\":\"true\",\"isSupported\":\"false\",\"price\":\"500000\",\"isToubao\":\"1\",\"amountStr\":\"50万\",\"quotesPrice\":\"0\",\"state\":\"1\",\"isHot\":\"false\",\"insuranceId\":\"2\",\"type\":\"0\",\"insuranceName\":\"第三者责任险\"}]");
		obj.put("insurances", "[{\"compensation\":\"true\",\"price\":\"1\",\"isToubao\":\"1\",\"insuranceId\":\"1\"},{\"compensation\":\"true\",\"price\":\"500000\",\"isToubao\":\"1\",\"insuranceId\":\"2\"}]");
		//obj.put("insurancesList", "[{"englishName":"车损","compensation":true,"isSupported":false,"price":1,"isToubao":"1","amountStr":"投保","quotesPrice":0,"state":1,"isHot":false,"insuranceId":1,"type":0,"insuranceName":"车辆损失险"},{"englishName":"三者","compensation":true,"isSupported":false,"price":500000,"isToubao":"1","amountStr":"50万","quotesPrice":0,"state":1,"isHot":false,"insuranceId":2,"type":0,"insuranceName":"第三者责任险"}]");
		//obj.put("insuranceBeginTime", "0");
		
		
		try {
			System.out.println("----");
			HttpClientUtil.httpPost(BASEURL+"insurance/queryPrice", obj);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HttpClientUtil.httpPost("http://localhost:8080/carInsurance/api/insurance/queryPrice", obj);
	}
	
	@Test//核保
	public void testsubmitProposal(){
		
		//Map<String,Object> obj = new HashMap<>();
		JSONObject obj = new JSONObject();
		
		obj.put("payee","111");  //收款人姓名","111");
		obj.put("account","111");  //收款人卡","111");
	    obj.put("bankname","111");  //开户行","111");
	    obj.put("openId",openId);//微信openId
	    obj.put("reciver","111");  //收件人","111");
	    obj.put("reciverPhone","111");  //手机号码","111");
	    obj.put("provincesCities","江苏省南京市");  //省市","111");
	    obj.put("addressDetail","玄武区苏宁青创园D206");  //详细","111");
	    obj.put("invoiceType","111");  //发票信息","111");
	    obj.put("invoiceTitle","111");  //发表抬头","111");
	    obj.put("invoicePhone","111");  //手机号码","111");
		
		
		obj.put("licenseNumber", licenseNumber);
		obj.put("offerId", offerId);
		obj.put("ownerName", ownerName);
		obj.put("idCard", idNumber);
		obj.put("phone", phone);
		obj.put("contactAddress", "江苏南京");
		/*obj.put("offerId", offerId);
		obj.put("ownerName", "朱祥珍");
		obj.put("idCard", "320113196303202013");
		obj.put("phone", "13705159506");
		obj.put("contactAddress", "江苏南京");
		/*obj.put("offerId", offerId);
		obj.put("ownerName", "刘扬");
		obj.put("idCard", "320112198807021630");
		obj.put("phone", "13705159506");
		obj.put("contactAddress", "江苏南京");*/
		try {
			HttpClientUtil.httpPost(BASEURL+"insurance/submitProposal", obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HttpClientUtil.httpPost("http://localhost:8080/carInsurance/api/insurance/queryPrice", obj);
	}
	
	
	@Test//确认承保
	public void testconfirmChengbao(){
		
		Map<String,Object> obj = new HashMap<>();
		obj.put("orderId", offerId);
		
		HttpClientUtil.httpPost(BASEURL+"insurance/confirmChengbao", obj);
		//HttpClientUtil.httpPost("http://localhost:8080/carInsurance/api/insurance/queryPrice", obj);
	}
	@Test
	public void testDate(){
		System.out.println((int)Math.pow(10, 7));
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//Date parse = formate.parse("2018-04-18 23:59:59");
			//Date parse = formate.parse("2018-08-09 00:00:00");//朱
			Date parse = formate.parse("2018-07-29 23:59:59");//胡
			System.out.println(parse.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//java test
	@Test
	public void testTimeExecutor(){
		final Map<String,Thread> map = new HashMap<>();
		
		for(int i=0; i<10; i++){
			Constant.getTimeExecutor().scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					//System.out.println(Thread.currentThread().getName());
					map.put(Thread.currentThread().getName(), Thread.currentThread());
					System.out.println("-----"+Thread.currentThread().getName()+Tools.date2Str(new Date()));
				}
			},0, 2, TimeUnit.SECONDS);
		}
		
		System.out.println("#########");
		//Constant.getTimeExecutor().shutdown();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ddddddddddd");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test(){
		Map<String, Object> param = new HashMap<>();
		param.put("api_key", "5ff016f97cea4adc9b8ae8ccad6a7f84HLDD");
		param.put("ownerName", "李哲");
		param.put("licenseNumber", "苏AE1B98");
		param.put("carTypeCode", "02");

		JSONObject resultJson = HttpClientUtil.httpGet("http://wechat.bac365.com/carRisk/car_risk/carApi/queryLatestPolicy", param);
		System.out.println(resultJson);
	}

	@Test
	public void testConfirmPay() throws IOException{
		Map<String, Object> param = new HashMap<>();
		param.put("api_key", Constant.LUOTUOKEY);
		param.put("orderId", "109-20180625135214-d7416");
		JSONObject resultJson = HttpClientUtil.httpGet(Constant.LUOTUO_INTERFACE_URL + "confirmPay", param);
		System.out.println(resultJson);


	}
}
