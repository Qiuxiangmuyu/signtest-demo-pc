package com.zqsign.test.script;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;

/**
 * 
 * @ClassName: RegEnterprise   
 * @Description: 模拟企业用户颁发数字证书
 * @date: 2017年6月7日 上午11:07:09   
 *
 */
public class RegEnterprise {
	
	public static void main(String[] args) throws IOException {
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "entpReg";
		String zqid = ZqsignManage.Zqid.ZQID;

		EncryptData ed = new EncryptData();
	
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("zqid", zqid);//商户的zqid,该值需要与private_key对应
	    map.put("user_code", "company_test_002");//用户唯一标示，该值不能重复
	    map.put("name", "北京某某科技公司");//企业名称
	    map.put("certificate", "YYZZ43345453131");//营业执照号或社会统一代码
	    map.put("address", "北京市海淀区"); //企业注册地址
	    map.put("contact", "赵华");//联系人
	    map.put("mobile", "18678499392");//联系电话（手机号码）
	
	    String sign_val = ed.encrptData(map,private_key);
	
		map.put("sign_val", sign_val); //请求参数的签名值
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
		}
	}