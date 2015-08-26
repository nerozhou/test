package design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ShowProxy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stupid s = new Stupid();
		
		System.out.println("Communicating with proxy:");
		Able proxy = (Able)Proxy.newProxyInstance(s.getClass().getClassLoader(), 
				s.getClass().getInterfaces(), new ListenerProxy(s));
		System.out.println(proxy.say("hello"));
		
		System.out.println("Without proxy:");
		System.out.println(s.say("hello"));
	}
	
	public static class ListenerProxy implements InvocationHandler {
		private Object obj;
		
		public ListenerProxy(Object obj) {
			this.obj = obj;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("I'm proxy, i'm listening");
			return method.invoke(obj, args);
		}
		
	}
	
	public static class Stupid implements Able {
		public String say(String something) {
			return "I am stupid " + this + ", i saying: " + something; 
		}
	}
	
	public interface Able {
		public String say(String something);
	}
}
