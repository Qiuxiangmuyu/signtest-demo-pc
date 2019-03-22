package com.zqsign.test.script;

import java.util.HashMap;
import java.util.Map;
import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;

/**
 * 
 * @ClassName: CreateContract_PdfForm   
 * @Description: 模板创建合同
 * @date: 2017年6月7日 上午10:47:56   
 *
 */

public class CreateContract_PdfForm {

	public static void main(String[] agrs) throws Exception{
		//
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
		String request_url = ZqsignManage.Url.REQUEST_URL + "pdfTemplate";
		String zqid = ZqsignManage.Zqid.ZQID;

		EncryptData ed = new EncryptData();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("zqid", zqid);//众签提供给开发者的应用标识码,该值需要与private_key对应
		map.put("no", "test_contract_001");//自行创建合同编号，该值不可重复使用
		map.put("name", "测试合同001");//商户平台合同名称
		map.put("t_no", "temp_");//商户平台存储在众签平台的合同模板编号
		map.put("contract_val", "");//表单的json串
		
		String sign_val = ed.encrptData(map,private_key);//对请求进行签名加密
		
		map.put("sign_val", sign_val); //请求参数的签名值
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
			
	}
}
