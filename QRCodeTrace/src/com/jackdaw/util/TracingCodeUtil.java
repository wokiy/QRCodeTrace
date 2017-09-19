package com.jackdaw.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jackdaw.entity.Project;

/**
 * 追溯码工具类，帮助生成追溯码（产品ID）。
 * 
 * 代码结构：
 * (01)96901234567892(11)090301
 *—— 01：应用标识符，表示后面的数据项是一个14位的GTIN；
 *—— 9：指示符，表示本单元为变量单元；
 *—— 6901234：厂商识别代码；
 *—— 56789：项目代码，可以表示某种规格的蔬菜；
 *—— 2：校验码；
 *—— 11：应用标识符，表示后面的数据项是一个6位、按YYMMDD格式的生产日期；
 *—— 090301：09年3月1日；
 *
 * @author E-Kunt
 *
 */
public class TracingCodeUtil {
	/**
	 * 应用标识符，表示后面的数据项是一个14位的GTIN；
	 */
	private final String APP_GTIN = "(01)"; 
	
	/**
	 * 指示符，表示本单元为变量单元；
	 */
	private final String INDICATOR = "9";

	/**
	 * 厂商识别代码
	 */
	private final String COMPANY_CODE = "6901234";
	
	/**
	 * 应用标识符，表示后面的数据项是一个6位、按YYMMDD格式的生产日期；
	 * 
	 */
	private final String APP_DATE = "(11)";
	
	/**
	 * 产品项目代码，可以表示某种规格的蔬菜；
	 */
	private String codeId = null;
	
	/**
	 * 计算产品追溯码
	 * @param project
	 * @return
	 */
	public String getTracingCode(Project project) {
		codeId = project.getId();
		StringBuffer sb = new StringBuffer("");
		String tracingCode = sb.append(APP_GTIN)
				.append(INDICATOR)
				.append(COMPANY_CODE)
				.append(codeId)
				.append(getCRC())
				.append(APP_DATE)
				.append(new SimpleDateFormat("yyMMdd").format(new Date()))
				.toString();
		return tracingCode;
	}
	
	/**
	 * 计算EAN13码的校验码
	 * @return
	 */
	public String getCRC() {
		StringBuilder ean13code = new StringBuilder(COMPANY_CODE + codeId + "c");
		char[] ean13codeArray = ean13code.reverse().toString().toCharArray();
		int evenSum = getEvenSum(ean13codeArray);
		int oddSum = getOddSum(ean13codeArray);
		int crc = ((evenSum * 3 + oddSum)/10 + 1) * 10 - (evenSum * 3 + oddSum);
		return String.valueOf(crc);
	}
	
	/**
	 * 计算偶数位数字的和
	 * @param ean13codeArray
	 * @return
	 */
	public int getEvenSum(char[] ean13codeArray) {
		int evenSum = 0;
		for(int i=1; i<=ean13codeArray.length; i++) {
			if(i % 2 == 0) {
				switch (ean13codeArray[i-1]) {
				case '0':
					evenSum += 0;
					break;
				case '1':
					evenSum += 1;
					break;
				case '2':
					evenSum += 2;
					break;
				case '3':
					evenSum += 3;
					break;
				case '4':
					evenSum += 4;
					break;
				case '5':
					evenSum += 5;
					break;
				case '6':
					evenSum += 6;
					break;
				case '7':
					evenSum += 7;
					break;
				case '8':
					evenSum += 8;
					break;
				case '9':
					evenSum += 9;
					break;
				default:
					break;
				}
			}
		}
		return evenSum;
	}
	
	/**
	 * 计算奇数位数字的和
	 * @param ean13codeArray
	 * @return
	 */
	public int getOddSum(char[] ean13codeArray) {
		int oddSum = 0;
		for(int i=3; i<=ean13codeArray.length; i++) {
			if(i % 2 == 1) {
				switch (ean13codeArray[i-1]) {
				case '0':
					oddSum += 0;
					break;
				case '1':
					oddSum += 1;
					break;
				case '2':
					oddSum += 2;
					break;
				case '3':
					oddSum += 3;
					break;
				case '4':
					oddSum += 4;
					break;
				case '5':
					oddSum += 5;
					break;
				case '6':
					oddSum += 6;
					break;
				case '7':
					oddSum += 7;
					break;
				case '8':
					oddSum += 8;
					break;
				case '9':
					oddSum += 9;
					break;
				default:
					break;
				}
			}
		}
		return oddSum;
	}
}
