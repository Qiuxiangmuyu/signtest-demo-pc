package com.zqsign.test.script;

import java.util.HashMap;
import java.util.Map;

import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;

/**
 * 
 * @ClassName: SignAutoNI   
 * @Description: 后台自动签署（无签章），在合同PDF上不显示当前签署用户的签章图片
 * @date: 2017年6月9日 上午11:05:20   
 *
 */
public class SignAutoNI {

	public static void main(String[] agrs) throws Exception{
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "signAutoNI";
		String zqid = ZqsignManage.Zqid.ZQID;

		EncryptData ed = new EncryptData();

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("zqid",zqid);//商户的zqid,该值需要与private_key对应
		map.put("no", "需用户修改");//已存在的合同编号
		map.put("signers", "需用户修改");//签署人user_code

	    String sign_val = ed.encrptData(map,private_key);

		map.put("sign_val", sign_val); //请求参数的签名值
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
	}
}
