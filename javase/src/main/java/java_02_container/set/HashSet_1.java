package java_02_container.set;

import java.util.HashSet;

/**
 * HashSet原理学习
 * @author lt
 * @date 2019年6月9日
 * @version v1.0
 */
public class HashSet_1 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("Java");
		set.add("Python");
		set.add("JavaScript");
		set.add(null);
		set.add("Java");
		System.out.println(set.toString());
	}
}
