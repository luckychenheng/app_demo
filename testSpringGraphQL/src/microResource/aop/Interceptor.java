package microResource.aop;

public class Interceptor {
	public void before() {
		System.out.println("-------------before-----------------------");
		// ������д���ء������Ƿ��������ĳ������,������ķ�������service�㷽��ִ��֮ǰִ�С�
	}

	public void after() {
		System.out.println("after-----------------------");
	}

}
