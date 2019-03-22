package com.zqsign.test.script;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.zqsign.method.dependency.Base64Utils;
import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;


/**
 * 
 * @ClassName: CreateContract_UploadPdf   
 * @Description: 模拟上传Word文件创建合同
 * @date: 2017年6月7日 上午10:49:00   
 *
 */
public class CreateContract_UploadWord {

	public static void main(String[] agrs) throws Exception{
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "createForWord";
		String zqid = ZqsignManage.Zqid.ZQID;
		String no = UUID.randomUUID().toString().replace("-","");

		
		EncryptData ed = new EncryptData();
		
		Map<String, String> map = new HashMap<String, String>();
		byte[] fileToByte = Base64Utils.fileToByte("C:\\Users\\zqsign\\Desktop\\房屋租赁合同.doc");//转义字符
		String encode = Base64Utils.encode(fileToByte);
		map.put("zqid", zqid);//众签提供给开发者的应用标识码,该值需要与private_key对应
		map.put("no", no);//自行创建合同编号，该值不可重复使用
		map.put("name", "房屋租赁合同");//商户平台合同名称
		map.put("contract", encode);//合同文件的base64/平台方合同文件的网络地址
		System.out.println(no);

		String sign_val = ed.encrptData(map,private_key);//对请求进行签名加密
		
		map.put("sign_val", sign_val); //请求参数的签名值
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
	    System.out.println(no);
			
	}
}
