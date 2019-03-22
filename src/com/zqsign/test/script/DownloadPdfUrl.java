package com.zqsign.test.script;

import java.util.HashMap;
import java.util.Map;

import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;

/**
 * 
 * @ClassName: DownloadPdfUrl   
 * @Description: 返回合同pdf的地址，用户拿该地址能够去浏览器获得合同文件，链接有效时间5min
 * @date: 2017年6月9日 上午11:04:29   
 *
 */
public class DownloadPdfUrl {

	public static void main(String[] args) throws Exception {
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "getPdfUrl";
		String zqid = ZqsignManage.Zqid.ZQID;
		
		EncryptData ed = new EncryptData();

		Map<String, String> map = new HashMap<String, String>();
		map.put("zqid", zqid);//商户的zqid,该值需要与private_key对应
		map.put("no", "需要用户修改");//已存在的合同编号

		String sign_val = ed.encrptData(map,private_key);//对请求进行签名加密
		
		map.put("sign_val", sign_val);//添加签名值
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
				
	}

}
