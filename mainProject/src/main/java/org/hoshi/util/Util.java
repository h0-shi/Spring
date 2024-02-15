package org.hoshi.util;

import org.springframework.stereotype.Component;

@Component
public class Util {
	public int str2Int(String str) {
		System.out.println("유틸 실행");
		if(str.matches("[0-9]+")&&str!=null) {
			return Integer.parseInt(str);
		} else {
			return 0;
		}
	}
}
