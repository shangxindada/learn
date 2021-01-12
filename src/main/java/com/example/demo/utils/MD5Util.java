package com.example.demo.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin) {
		String resultString = null;
		try {

			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");

			resultString.trim();

			resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
		} catch (Exception ex) {
		}
		return resultString;
	}
	public static String MD5EncodeUtf8(String sourceStr) {
			String result = "";//通过result返回结果值
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");//1.初始化MessageDigest信息摘要对象,并指定为MD5不分大小写都可以
				md.update(sourceStr.getBytes());//2.传入需要计算的字符串更新摘要信息，传入的为字节数组byte[],将字符串转换为字节数组使用getBytes()方法完成
				byte b[] = md.digest();//3.计算信息摘要digest()方法,返回值为字节数组
				int i;//定义整型
				//声明StringBuffer对象
				StringBuffer buf = new StringBuffer("");
				for (int offset = 0; offset < b.length; offset++) {
					i = b[offset];//将首个元素赋值给i
					if (i < 0)
						i += 256;
					if (i < 16)
						buf.append("0");//前面补0
					buf.append(Integer.toHexString(i));//转换成16进制编码
				}
				result = buf.toString().substring(8, 24);//转换成字符串
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return result;//返回结果
		}
	public static void main(String[] args) {
		String data = "18902288111201111111809sz0000123456789987654321";
		System.out.println(MD5Encode(data));
		String d="";
		String replaceAll = d.replaceAll("4011cab4527f65fa", "");
		byte[] bytes = Base64.decodeBase64(replaceAll);
		byte[] dd={1,2};
		String s = MD5Util.byteArrayToHexString(dd);
		System.out.println(s);
		String s1 = MD5Util.MD5Encode(s);
		System.out.println(s1);

	}
}
