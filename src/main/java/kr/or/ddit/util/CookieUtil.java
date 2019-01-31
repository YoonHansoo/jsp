package kr.or.ddit.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CookieUtil {
	ArrayList<Map<String, String>> splitStringList;

	public CookieUtil() {
	};

	public CookieUtil(String cookieStirng) {
		
		splitStringList = new ArrayList<>();
		String[] splitString = cookieStirng.split(";");
		for (int i = 0; i < splitString.length; i++) {
			String[] cookiesValue = splitString[i].split("=");

			String key = cookiesValue[0].trim();
			String value = cookiesValue[1].trim();

			Map<String, String> map = new HashMap<>();
			map.put("key", key);
			map.put("value", value);
			splitStringList.add(map);
		}
	}

	public String getCookieValue(String string) {
		Iterator<Map<String, String>> iterator = splitStringList.iterator();
		while(iterator.hasNext()) {
			Map<String, String> map = iterator.next();
			if (string.equals(map.get("key"))) {
				 return map.get("value");
			}
		}
		/*
		for (int i = 0; i < splitStringList.size(); i++) {
			Map<String, String> map = (Map<String, String>) splitStringList.get(i);
			if (string.equals(map.get("key"))) {
				return map.get("value");
			}
		}*/
		
		
		return null;
	}

}

