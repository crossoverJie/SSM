package com.crossoverJie.util;

import java.util.Collection;
import java.util.Map;

/**
 * 参数校验工具类
 */
public class PreconditionUtil {
	private static final String PRI_KEY_ERR = "主键错误";

	private PreconditionUtil() {
	}

	public static void intPriKeyChk(Integer pk) {
		checkArguments(!isNull(pk) && pk > 0, PRI_KEY_ERR);
	}
	
	public static void checkArguments(boolean expression, String errMsg) {
		if (!expression) {
			throw new IllegalArgumentException(errMsg);
		}
	}

	public static boolean isNull(Object o) {
		return null == o;
	}

	public static <T> boolean colIsEmpty(Collection<T> col) {
		return isNull(col) || col.isEmpty();
	}

	public static <T> boolean arrayIsEmpty(T[] ts) {
		return ts == null || ts.length == 0;
	}

	public static boolean mapIsEmpty(Map map) {
		return map == null || map.size() == 0;
	}
	
	public static void main(String[] args) {
		int[] a = {};
	}
}
