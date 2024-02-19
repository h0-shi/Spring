package org.hoshi.util;

import org.springframework.stereotype.Component;

@Component
public class Util {
	public int str2Int(String str) {
		if(str.matches("[0-9]+")&&str!=null) {
			return Integer.parseInt(str);
		} else {
			return 0;
		}
	}
}
