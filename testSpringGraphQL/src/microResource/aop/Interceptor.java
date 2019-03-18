package microResource.aop;

public class Interceptor {
	public void before() {
		System.out.println("-------------before-----------------------");
		// 在这里写拦截。比如是否允许访问某个界面,这里面的方法会在service层方法执行之前执行。
	}

	public void after() {
		System.out.println("after-----------------------");
	}

}
