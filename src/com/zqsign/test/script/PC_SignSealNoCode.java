package com.zqsign.test.script;

import java.util.HashMap;
import java.util.Map;

import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.ZqSubmit;

/**
 * 
 * @ClassName: PC_SignSealNoCode   
 * @Description: 模拟PC端签章不验证签署，将请求结果放在.html文件中进行请求，就能显示当前签署方式的页面。
 * @date: 2017年6月7日 上午11:06:36   
 *
 */
public class PC_SignSealNoCode {

	public static void main(String[] args) throws Exception {
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "signView";
		String zqid = ZqsignManage.Zqid.ZQID;
		
		EncryptData ed = new EncryptData();

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("zqid", zqid);//商户的zqid,该值需要与private_key对应
		map.put("no", "需要用户修改");//已存在的合同编号
		map.put("user_code", "需要用户修改");//签署人的user_code
		map.put("sign_type", "SIGNATURE");//签章不验证签署
		map.put("return_url", "http://127.0.0.1:8080");//同步回调地址:签署成功后,服务器会主动调用该地址,并将请求结果一并返回，若关闭该页面，请求通知结果也会关闭。
		map.put("notify_url", "http://127.0.0.1:8080");//异步回调地址:若用户关闭同步通知调用该页面，后台每三分钟向后台发送请求直到用户拿到success结果。

		String sign_val = ed.encrptData(map,private_key);//对请求进行签名加密
		
		map.put("sign_val", sign_val);//添加签名值
		String requestHtmlText = ZqSubmit.buildRequest(map,request_url, private_key);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + requestHtmlText);//输出服务器响应结果

	}

}
