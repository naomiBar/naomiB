package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.beans.MyDaoWithAnnotation;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy // tell spring to use proxy where needed
public class AppConfigWithAnnotation {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigWithAnnotation.class);){
			
			MyDaoWithAnnotation dao = ctx.getBean(MyDaoWithAnnotation.class);
			dao.save();
			dao.find(111);
			dao.delete(); 
		}
	}
}
