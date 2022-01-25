package myBean.core;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyBean extends Thread{
	
	public int value;
	boolean stop = false;
	
	public MyBean() {
		System.out.println(">>> MyBean CTOR");
	}
	
	@Override
	public void run() {
		while(stop) {
			System.out.println(++value);
			try {
//				Thread.sleep(1000);
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// @PostConstruct and @PreDestroy are not spring annotations. But can be used in Spring:
	// actions to do after bean is constructed
	// a life cycle hook annotation - tells container to call this method after bean is fully constructed
	@PostConstruct
	public void doAfterConsrtuct() {
		System.out.println(">>>doAfterConsrtuct");
		stop = true;
		start();
	}
	
	// actions to do before bean is destroyed
	// a life cycle hook annotation - tells container to call this method before bean is destroyed - container shut down 
	@PreDestroy
	public void doBeforeDestroy() {
		System.out.println(">>>doBeforeDestroy");
		stop = false;
	}
	
	
	/* implements InitializingBean, DisposableBean
	 * InitializingBean, DisposableBean are spring life cycle hook interfaces
	
	@Override
	public void afterPropertiesSet() throws Exception {
		on = true;
		start();
	}
	
	@Override
	public void destroy() {
		on = false;
	} */
}
