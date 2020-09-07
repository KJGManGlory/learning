package java_02_container.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列：可以存储各种类型元素的容器，遵守先进先出的原则，只能在队首取出元素，只能在队尾插入元素
 * @author lt
 * @date 2019年6月15日
 * @version v1.0
 */
public class Queue_1 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<5; i++){
			q.add(i);
		}
		System.out.println(q);
		for(int i=0; i<6; i++){
			System.out.println(q.poll());
//			System.out.println(q.remove());
			System.out.println(q);
		}
	}
}
