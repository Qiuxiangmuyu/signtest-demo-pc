package com.zqsign.test.script;


import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.zqsign.method.dependency.EncryptData;
import com.zqsign.method.dependency.HttpRequest;
import com.zqsign.test.script.ZqsignManage;

/**
 * 
 * @ClassName: DownloadPdf   
 * @Description: 模拟PDF格式的合同下载，将请求结果放在.html文件中进行请求，就能拿到当前合同编号的.pdf格式文件。
 * @date: 2017年6月7日 上午11:05:59   
 *
 */
public class DownloadPdf {

	public static void main(String[] args) throws Exception {
		String private_key = ZqsignManage.Key.PRIVATE_KEY;
	    String request_url = ZqsignManage.Url.REQUEST_URL + "getPdf";
	    String zqid = ZqsignManage.Zqid.ZQID;
	    
	    EncryptData ed = new EncryptData();
	    
	  
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("zqid", zqid);//商户的zqid,该值需要与private_key对应
	    map.put("no", "test_contract_017");//已存在的合同编号
	    String sign_val = ed.encrptData(map,private_key);//对请求进行签名加密
	    
	    map.put("sign_val", sign_val);//添加签名值
	    byte[] response_str = HttpRequest.sendPostReturnByte(request_url, map);
	    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zqsign\\Desktop\\文档\\测试\\合同\\房屋租赁合同4.pdf");//存储路径
	    //FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zqsign\\Desktop\\文档\\测试\\合同\\中英普拉提学院学员协议1.pdf");//存储路径
	    IOUtils.write(response_str, fileOutputStream);
	    System.out.println("当前文件流已转成PDF文件放在源文件目录下");
				
	}

}
