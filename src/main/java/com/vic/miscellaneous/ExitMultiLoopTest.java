package com.vic.miscellaneous;

/**
 * 退出多层循环
 * @author Victor
 *
 */
public class ExitMultiLoopTest {
	public static void main(String[] args) {
		// 退出标志
		boolean remark = false;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					// do something
					if(k == 1) {
						remark = true;
						break;
					}
				}
				// 退出当前循环
				if(remark) break;
			}
			// 退出当前循环
			if(remark) break;
		}
	}
}
