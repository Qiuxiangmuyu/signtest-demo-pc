package com.zqsign.test.script;

import java.util.HashMap;
import java.util.Map;

import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;

/**
 * 
 * @ClassName: SignAuto   
 * @Description: 模拟后台自动自动签署
 * @date: 2017年6月7日 上午11:07:28   
 *
 */
public class SignAuto {

	public static void main(String[] agrs) throws Exception{
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "signAuto";
		String zqid = ZqsignManage.Zqid.ZQID;
		EncryptData ed = new EncryptData();

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("zqid", zqid);//商户的zqid,该值需要与private_key对应
		map.put("no", "2d12e8f9b0924fcaabc2a89e6d167ccb");//已存在的合同编号
		map.put("signers", "fengwei003,fengwei002");//签署人user_code

	    String sign_val = ed.encrptData(map,private_key);

		map.put("sign_val", sign_val); //请求参数的签名值
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
	}
}
