package cs.personal.ecommerce;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import cs.personal.ecommerce.service.IStorageService;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MainApp implements CommandLineRunner{
	
	@Resource
    IStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);

	}

	@Override
    public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
    }

}
