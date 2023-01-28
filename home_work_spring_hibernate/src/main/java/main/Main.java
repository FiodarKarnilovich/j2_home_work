package main;

import service.JacketService;
import config.DataConfig;
import dao.JacketDaoImpl;
import entity.Jacket;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(
                DataConfig.class,
                JacketDaoImpl.class,
                JacketService.class);

        JacketService service = annotationContext.getBean("jacketService", JacketService.class);
        Jacket jacket = new Jacket(null, "Fjall raven", 100.5);
        System.out.println(jacket);
        service.newJacket(jacket);
        Jacket superManFromDB = service.getJacket(1);
        System.out.println(superManFromDB);
        annotationContext.close();
    }
}
