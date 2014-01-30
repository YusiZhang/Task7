package utils;

import java.text.DecimalFormat;

public class dataConversion {

	public static long convertFromStringToTwoDigitLong(String s) {
		if (s.indexOf('.') != -1) {
			String s1 = s.substring(0, s.indexOf('.'));
			String s2 = "";
			if (s.indexOf('.') + 3 <= s.length()) {
				s2 = s.substring(s.indexOf('.') + 1, s.indexOf('.') + 3);
			} else {
				s2 = s.substring(s.indexOf('.') + 1);
			}
			return Long.parseLong(s1 + s2);
		} else {
			StringBuffer sb = new StringBuffer(s);
			sb.append('0');
			sb.append('0');
			return Long.parseLong(sb.toString());
		}
	}

	public static long convertFromStringToThreeDigitLong(String s) {
		if (s.indexOf('.') != -1) {
			String s1 = s.substring(0, s.indexOf('.'));
			String s2 = "";
			if (s.indexOf('.') + 4 <= s.length()) {
				s2 = s.substring(s.indexOf('.') + 1, s.indexOf('.') + 4);
			} else {
				s2 = s.substring(s.indexOf('.') + 1);
			}
			return Long.parseLong(s1 + s2);
		} else {
			StringBuffer sb = new StringBuffer(s);
			sb.append('0');
			sb.append('0');
			sb.append('0');
			return Long.parseLong(sb.toString());
		}
	}

	public static boolean isDate(String s) {
		try {
			java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat(
					"yyyy-mm-dd");
			sf.parse(s);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public static long convertFromDoubleToThreeDigitLong(double share) {
		DecimalFormat df = new DecimalFormat("######0.000");
		df.format(share);
		long l = (long) (share * 1000);
		return l;
	}

	public static long convertFromDoubleToTwoDigitLong(double amount) {
		DecimalFormat df = new DecimalFormat("######0.00");
		df.format(amount);
		long l = (long) (amount * 100);
		return l;
	}

	public static String convertFromLongToThreeDigString(long shares) {
		String p = Long.toString(shares);
		StringBuffer sb = new StringBuffer(p.substring(0, p.length() - 3));
		sb.append('.');
		sb.append(p.substring(p.length() - 3));
		return sb.toString();
	}

	public static String convertFromLongToTwoDigString(long price) {
		String p = Long.toString(price);
		StringBuffer sb = new StringBuffer(p.substring(0, p.length() - 2));
		sb.append('.');
		sb.append(p.substring(p.length() - 2));
		return sb.toString();
	}

	public static boolean validLongMoreThanZero(String price) {
		try {
			long p=Long.parseLong(price);
			if(p<=0){
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean validDoubleMoreThanZero(String price) {
		try {
			double p=Double.parseDouble(price);
			if(p<=0){
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean validDoubleNotNegative(String price) {
		try {
			double p=Double.parseDouble(price);
			if(p<0){
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		System.out.println(validDoubleMoreThanZero("10000000.000"));
	}
}
