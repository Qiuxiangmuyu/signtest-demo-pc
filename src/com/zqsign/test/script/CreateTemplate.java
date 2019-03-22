package com.zqsign.test.script;

import java.util.HashMap;
import java.util.Map;

import com.zqsign.method.dependency.Base64Utils;
import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;

/**
 * 
 * @ClassName: CreateTemplate   
 * @Description: 创建合同模板
 * @date: 2019年3月22日 
 *
 */

public class CreateTemplate {
	public static void main(String[] agrs) throws Exception{
		//
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "createTemplate";
		String zqid = ZqsignManage.Zqid.ZQID;
		
		byte[] fileToByte = Base64Utils.fileToByte("C:\\Users\\zqsign\\Desktop\\文档\\测试\\合同\\房屋租赁合同模板_表单域.pdf");
		//byte[] fileToByte = Base64Utils.fileToByte("C:\\Users\\zqsign\\Desktop\\文档\\测试\\合同\\中英普拉提学院学员协议.pdf");
		String encode = Base64Utils.encode(fileToByte);
		
		EncryptData ed = new EncryptData();
				
		Map<String, String> map = new HashMap<String, String>();
		map.put("zqid", zqid);//众签提供给开发者的应用标识码,该值需要与private_key对应
		map.put("contract", encode);//Base64编码的PDF模板
		//map.put("t_name", "房屋租赁合同模板");//模板名称
		map.put("t_name", "课程合同模板");//模板名称
		
		String sign_val = ed.encrptData(map,private_key);//对请求进行签名加密
		map.put("sign_val", sign_val); //请求参数的签名值
		
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
			
	}
}
