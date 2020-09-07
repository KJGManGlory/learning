package java_02_container.Map.HashMap;

import java.util.HashMap;

/**
 * HashMap源码学习
 * @author lt
 * @date 2019年5月27日
 * @version v1.0
 */
public class Map_1 {

	public static void main(String[] args) {
		HashMap<Integer, Object> map = new HashMap<>(2);
		Object v1 = map.put(1, "1");
		System.out.println(v1);
		Object v2 = map.put(1, "2");
		System.out.println(v2);
		System.out.println(map);
	}
}
