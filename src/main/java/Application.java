import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //SpeakerServiceImpl service = new SpeakerServiceImpl();
        SpeakerService speakerService = applicationContext.getBean("speakerService",SpeakerService.class);
        System.out.println(speakerService);
        SpeakerService speakerService1 = applicationContext.getBean("speakerService",SpeakerService.class);
        System.out.println(speakerService1);
        System.out.println(speakerService.findAll().get(0).getFirstName());

    }
}
