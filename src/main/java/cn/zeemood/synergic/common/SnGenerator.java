package cn.zeemood.synergic.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 单号生成器
 * @author zhang.shushan
 * @date 2017年12月21日
 */
public class SnGenerator {

	private final static char[] NUMS="123456789".toCharArray();
	private final static char[] LETTERS="QWERTYUIPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm".toCharArray();
	private final static char[] MIX_LETTERS_AND_NUM="QWERTYUIPASDFGHJKLZXCVBNMqwertyuipasdfghjklzxcvbnm01234567890".toCharArray();
	
	public final static int MODE_NUM=0;
	public final static int MODE_LOWER_STR=1;
	public final static int MODE_UPPER_STR=2;
	public final static int MODE_STR=3;
	public final static int MODE_MIX=4;
	
	public static String generateFormat(String prefix,String suffix,int count,int mode){
		if(count<=17){
			count=18;
		}
		int prefixLen = 0;
		int suffixLen = 0;
		StringBuilder sb = new StringBuilder();
		if(prefix!=null&&(!"".equals(prefix))){
			prefixLen=prefix.length();
			sb.append(prefix);
		}
		if(suffix!=null&&(!"".equals(suffix))){
			suffixLen = suffix.length();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = sdf.format(new Date());
	
		int len = count-prefixLen-suffixLen-date.length();
		if(len>0){
			switch (mode) {
			case MODE_NUM:
				date=date+randomNums(len);
				break;
			case MODE_LOWER_STR:
				date=date+randomLowerStr(len);
				break;
			case MODE_UPPER_STR:
				date=date+randomUpperStr(len);
				break;
			case MODE_STR:
				date=date+randomStr(len);
				break;
			case MODE_MIX:
				date=date+randomMix(len);
				break;
			default:
				date=date+randomNums(len);
				break;
			}
		}
		sb.append(date.substring(0, count-prefixLen-suffixLen));
		if(suffixLen>0){
			sb.append(suffix);
		}
		
		return sb.toString();
	}
	
	/**
	 * 生成写字母和数字随机字符串
	 * @param count
	 * @return
	 */
	public static String randomMix(int count){
		return generator(count, MIX_LETTERS_AND_NUM);
	}
	
	/**
	 * 生成大小写混合字母随机字符串
	 * @param count
	 * @return
	 */
	public static String randomStr(int count){
		return generator(count, LETTERS);
	}
	
	/**
	 * 生成纯大写字母随机字符串
	 * @param count
	 * @return
	 */
	public static String randomUpperStr(int count){
		return generator(count, LETTERS).toUpperCase();
	}
	
	/**
	 * 生成纯数字随机字符串
	 * @param count
	 * @return
	 */
	public static String randomNums(int count) {
		return generator(count, NUMS);
	}
	
	/**
	 * 生成纯小写字母随机字符串
	 * @param count
	 * @return
	 */
	public static String randomLowerStr(int count){
		return generator(count, LETTERS).toLowerCase();
	}
	
	/**
	 * 生成器
	 * @param count
	 * @param arr
	 * @return
	 */
	private static String generator(int count,char[] arr){
		if(count<=0){
			count=6;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<count;i++){
			double d= Math.random();
			int index = (int) Math.floor(d*arr.length);
			sb.append(arr[index]);
		}
		
		return sb.toString();
	}
	
}
