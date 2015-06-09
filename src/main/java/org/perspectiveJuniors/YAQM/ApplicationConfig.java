package org.perspectiveJuniors.YAQM;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by eljetto on 6/2/15.
 */
@EnableWebMvc
@Configuration
@Import({ SecurityConfig.class })
public class ApplicationConfig {
}
