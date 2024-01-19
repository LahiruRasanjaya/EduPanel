package lk.ijse.dep11.edupanel;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import lk.ijse.dep11.edupanel.conveter.LecturerTypeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebAppConfig implements WebMvcConfigurer {
    @Bean
    public Bucket defaultBucket() throws IOException {
        InputStream serviceAccount =
                new ClassPathResource("/edu-pannel-70-firebase-adminsdk-sr6cy-9d29648f2f.json").getInputStream();

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("edu-pannel-70.appspot.com")
                .build();

        FirebaseApp.initializeApp(options);
        return StorageClient.getInstance().bucket();
    }
    @Bean
    public StandardServletMultipartResolver multipartResolver(){

        return new StandardServletMultipartResolver();
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new LecturerTypeConverter());
    }
}
