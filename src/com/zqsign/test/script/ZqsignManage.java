package com.zqsign.test.script;
/**
 * 
 * @author shehongli
 * 一定要注意测试环境与生产环境作切换前，需要更改ZQID PRIVATE_KEY REQUEST_URL三处。
 */
public class ZqsignManage {
	
	public class Zqid{
		//生产环境zqid
//		public static final String ZQID = "";
		//测试环境zqid
		public static final String ZQID = "ZQ96C7984779F842A09CACF17956483CA9";
	}
	public class Key{
		//生产环境私钥
//		public static final String PRIVATE_KEY = "";
		//测试环境key
		public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJZ8xy7rLFl185ifrMev3yHPTYp7Zju1bkPNXQirPc5jBvtqun/yX3QIyNmzjAje/anX8MVcQiJP+HO9X82TZO5/iw16hSUWzYiWr9HgwgsEFrdHW/K4Oyg40QwTwdvJ9H5YHuYWvKd0iS1YiYjiGDW6ALxbnRKK12AhsEdw6eZ5AgMBAAECgYB8sHrht16R6ZejWHpzIphBjWD0Y3a79oKcj2aMrkaR4Z+BZleNeCf7HuQ87fYTy6BmwFPxU5ZAk/6K99iPn5c6bpzzEvHBu2fng8MW+Hktkx/kzOGD5n++Tvx4O6Y8Y+Xw27I8s30y31KgqP1cvN9I2wOopRNFHT6TO2dDzmmOAQJBAPzIIPzXWSDwqc7aeaI1MEpWvSsegP9LMjCfi9csufDtKYHxwDjWuKfmek5ePVHBxfuaFUFGOoRsxvs6JIk2iRkCQQCYZz/hGeTnRM718lDYRp6RmGoQStRRm/6GHFPfsp2gtYr4As+avNcyXVxEzAdCxtGtxCjF5U+2EOjjqAvkGhRhAkEArqgQsuKQgMQIcBZgaIVbomGgPwTKmJp6SUJTuw76Qs97GH/TEvK5j7kd1LwknjLG+vsRqJI/qHQIYFliGTSHMQJANWIVMhgL4iZsCCJ0xw0VhhJJNKPBc0SdBwTtLDI4nI56uxzg82aqSm4BX+fHs1BJKgDH92m3XiLWMMgwQhoQgQJBAIDHDOcwdZCc960P/FK+d3ocHD6PDxFo4wshhB9+GOT4z191H6FQxXOQxihCrjzO3/hrD7s2W6HNzifR+VoEznw=";
	}

	public class Url{
		//正式服务器连接
//		public static final String REQUEST_URL = "";
		//测试环境服务器连接
		public static final String REQUEST_URL = "https://signtest.zqsign.com/";
	}


	public class SignType{
		//签章不验证
		public static final String SIGNATURE = "SIGNATURE";
		//签章验证
		public static final String SIGNATURECODE = "SIGNATURECODE";
		//签字不验证
		public static final String WRITTEN = "WRITTEN";
		//签字验证
		public static final String WRITTENCODE = "WRITTENCODE";
	}

	public class Result{

		//请求成功
		public static final String SUCCESS = "操作成功";
		public static final String REQUESR_SUCCESS = "请求成功";

		//用户唯一标识格式不正确
		public static final String USERCODE_IDINCORRECT = "用户ID格式不正确";
		//用户唯一标识已经存在
		public static final String USERCODE_EXIST = "用户已存在";
		//用户唯一标识不存在
		public static final String USERCODE_NOEXIST = "用户不存在";
		//用户唯一标识不能为空
		public static final String USERCODE_NOTNULL = "用户ID不能为空";
		//用户唯一标识不能为空
		public static final String USERCODE_NOSTYLE = "用户ID与需要更新的用户类型不匹配";
		//用户姓名格式不正确
		public static final String NAME_INCORRECT = "用户姓名格式不正确";
		//用户姓名不能为空
		public static final String NAME_NOTNULL = "用户姓名不能为空";
		//企业名称不能为空
		public static final String ENTERPRISENAME_NOTNULL = "企业名称不能为空";
		//用户身份证号格式不正确
		public static final String IDCARDNO_INCORRECT = "身份证号码格式不正确";
		//用户身份证号不能为空
		public static final String IDCARDNO_NOTNULL = "身份证号码不能为空";
		//用户电话号码格式不正确
		public static final String MOBILE_INCORRECT = "手机号码格式不正确";
		//用户电话号码不能为空
		public static final String MOBILE_NOTNULL = "手机号码不能为空";

		//企业注册证件号格式不正确
		public static final String CERTIFICATE_INCORRECT = "企业机构代码格式不正确";
		//企业注册证件号格式不正确
		public static final String CERTIFICATE_NOTNULL = "企业机构代码不能为空";
		//企业地址不能为空
		public static final String ADDRESS_NOTNULL = "企业注册地址不能为空";
		//联系人不能为空
		public static final String CONTACT_NOTNULL = "企业联系人不能为空";
		//联系人电话号码格式不正确
		public static final String CONTACT_MOBILE_INCORRECT = "联系人电话格式不正确";
		//联系人电话号码不能为空
		public static final String CONTACT_MOBILE_NOTNULL = "联系人电话不能为空";


		//验证码不能为空
		public static final String CODE_NOTNULL = "验证码不能为空";
		//验证码格式不正确
		public static final String CODE_INCORRECT = "验证码格式不正确";
		//验证码与验证id不匹配
		public static final String CODE_NO_MATCH = "验证码不匹配";
		//验证码id不能为空
		public static final String SMS_ID_NOTNULL = "验证码id不能为空";
		//验证码id格式不正确
		public static final String SMS_ID_INCORRECT = "验证码id格式不正确";
		//合同不存在
		public static final String CONTRACT_NOTNULL = "合同编号不能为空";
		//合同不存在
		public static final String CONTRACT_NOEXIST = "合同编号不存在";
		//合同编号格式不正确
		public static final String CONTRACT_INCORRECT = "合同编号格式不正确";
		//pdf_width不能为空
		public static final String PDF_WIDTH_NOTNULL = "PDF宽不能为空";
		//pdf_width格式不正确
		public static final String PDF_WIDTH_INCORRECT = "PDF宽格式不正确";
		//pdf_width不能为空
		public static final String PDF_HEIGHT_NOTNULL = "PDF高不能为空";
		//pdf_width格式不正确
		public static final String PDF_HEIGHT_INCORRECT = "PDF高格式不正确";
		//leftzb不能为空
		public static final String LEFTZB_NOTNULL = "签名左边距不能为空";
		//leftzb格式不正确
		public static final String LEFTZB_INCORRECT = "签名左边距格式不正确";
		//leftzb签名左边距超出范围
		public static final String LEFTZB_ULTRA = "签名左边距超出范围";
		//topzb不能为空
		public static final String TOPZB_NOTNULL = "签名上边距不能为空";
		//topzb格式不正确
		public static final String TOPZB_INCORRECT = "签名上边距格式不正确";
		//topzb签名左边距超出范围
		public static final String TOPZB_ULTRA = "签名上边距超出范围";
		//signature上传类型不正确
		public static final String SIGNATURE_NOSTYLE = "签名图片格式不正确";
		//signature不能为空
		public static final String SIGNATURE_NOTNULL = "签章图片不能为空";
		//sign_width不能为空
		public static final String SIGN_WIDTH_NOTNULL = "签章的宽不能为空";
		//sign_width格式不正确
		public static final String SIGN_WIDTH_INCORRECT = "签章的宽格式不正确";
		//sign_height不能为空
		public static final String SIGN_HEIGHT_NOTNULL = "签章的高不能为空";
		//sign_height格式不正确
		public static final String SIGN_HEIGHT_INCORRECT = "签章的高格式不正确";
		//关键字查找签名位置失败
		public static final String KEYWORD_FINDFAILED = "查找关键字签名位置失败";

		//page不能为空
		public static final String PAGE_NOTNULL = "页码不能为空";
		//page格式不正确
		public static final String PAGE_INCORRECT = "页码格式不正确";


	}

}
