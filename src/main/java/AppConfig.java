import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name="speakerService")//Bean are singleton by default
    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
    //@Scope(value= BeanDefinition.SCOPE_PROTOTYPE) //Prototype is opposite of singleton it is needed when we need unique bean per request
    public SpeakerService getSpeakerService(){
        //SpeakerServiceImpl speakerService = new SpeakerServiceImpl(getSpeakerRepository());
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
        //speakerService.setRepository(getSpeakerRepository());
        return speakerService;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
