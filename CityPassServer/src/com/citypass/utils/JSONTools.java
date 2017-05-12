package com.citypass.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONTools {
	public static String toJsonString(Object o, String... params) {
		List<String> list = toList(params);
		Object o1 = JSON.parse(JSON.toJSONString(o));
		filterParams(o1, list);
		return o1.toString();
	}

	private static void filterParams(Object object, List<String> list) {
		if (object instanceof JSONArray) {
			JSONArray jsonArray = (JSONArray) object;
			for (int i = 0; i < jsonArray.size(); i++) {
				Object o2 = jsonArray.get(i);
				filterParams(o2, list);
			}
		} else if (object instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject) object;
			Set<Entry<String, Object>> set = jsonObject.entrySet();
			Iterator<Entry<String, Object>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();
				if (list.contains(entry.getKey())) {
					iterator.remove();
				} else {
					Object object2 = entry.getValue();
					filterParams(object2, list);
				}
			}
		}
	}

	public static List<String> toList(String... params) {
		List<String> list = new LinkedList<>();
		for (String str : params) {
			list.add(str);
		}
		return list;
	}
}
