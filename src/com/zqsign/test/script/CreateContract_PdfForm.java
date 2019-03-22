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
		map.put("no", "test_contract_017");//自行创建合同编号，该值不可重复使用
		map.put("name", "测试合同017");//商户平台合同名称
		map.put("t_no", "79bd10804c2b439f8a5284e15d54c41c");//商户平台存储在众签平台的合同模板编号
		map.put("contract_val", "{\"jsonVal\":[{\"甲方\":\"北京房屋租赁公司\",\"乙方\":\"北京某某科技公司\",\"位置\":\"北京市海淀区\",\"房产证编号\":\"FCZ123456643243\",\"建筑面积\":\"2000\",\"类型\":\"写字楼\",\"用途\":\"办公\",\"交付年\":\"2019\",\"交付月\":\"4\",\"交付日\":\"1\",\"租赁起始年\":\"2019\",\"租赁起始月\":\"4\",\"租赁起始日\":\"1\",\"租赁截止年\":\"2022\",\"租赁截止月\":\"3\",\"租赁截止日\":\"31\",\"免租装修起始年\":\"2019\",\"免租装修起始月\":\"4\",\"免租装修起始日\":\"1\",\"免租装修截止年\":\"2019\",\"免租装修截止月\":\"5\",\"免租装修截止日\":\"1\",\"免租时间\":\"1\",\"租金标准\":\"30000元/月\",\"每月付款日\":\"20\",\"保证金月数\":\"2\",\"保证金额\":\"60000\",\"出租方\":\"北京房屋租赁公司\",\"出租方签署\":\"company_test_001\",\"出租方签署日期\":\"2019年3月22日\",\"承租方\":\"北京某某科技公司\",\"承租方签署\":\"company_test_002\",\"承租方签署日期\":\"2019年3月22日\"}]}");//表单的json串
		
		/*map.put("t_no", "cf86f823d0b94bf7835d36557b50a896");//商户平台存储在众签平台的合同模板编号
		map.put("contract_val", "{\"jsonVal\":[{\"乙方\":\"北京某某科技公司\",\"课程\":\"办公室里办事办得不错\",\"年\":\"1\",\"月\":\"0\",\"日\":\"0\",\"天\":\"365\",\"费用\":\"30000\",\"Signer1\":\"company_test_001\",\"Signer2\":\"company_test_002\",\"时间\":\"2019年3月22日\",\"时间1\":\"2019年3月22日\"}]}");*/
		
		String sign_val = ed.encrptData(map,private_key);//对请求进行签名加密
		
		map.put("sign_val", sign_val); //请求参数的签名值
		String response_str = HttpRequest.sendPost(request_url, map);//向服务端发送请求，并接收请求结果
		System.out.println("请求结果：" + response_str);//输出服务器响应结果
			
	}
}
