package com.kdi.onboardinghelper;

import com.kdi.onboardinghelper.config.ApplicationProperties;
import com.kdi.onboardinghelper.domain.Authority;
import com.kdi.onboardinghelper.domain.User;
import com.kdi.onboardinghelper.model.Establishment;
import com.kdi.onboardinghelper.repository.AuthorityRepository;
import com.kdi.onboardinghelper.repository.EstablishmentRepository;
import com.kdi.onboardinghelper.repository.UserRepository;
import com.kdi.onboardinghelper.security.AuthoritiesConstants;

import io.github.jhipster.config.DefaultProfileUtil;
import io.github.jhipster.config.JHipsterConstants;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class, ApplicationProperties.class})
public class OnboardingHelperApp {

    private static final Logger log = LoggerFactory.getLogger(OnboardingHelperApp.class);

    private final Environment env;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EstablishmentRepository establishmentRepository;

    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public OnboardingHelperApp(Environment env, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.env = env;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Initializes OnboardingHelper.
     * <p>
     * Spring profiles can be configured with a program argument
     * --spring.profiles.active=your-active-profile
     * <p>
     * You can find more information on how profiles work with JHipster on
     * <a href="https://www.jhipster.tech/profiles/">https://www.jhipster.tech/profiles/</a>.
     */
    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run "
                    + "with both the 'dev' and 'prod' profiles at the same time.");
        }
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_CLOUD)) {
            log.error("You have misconfigured your application! It should not "
                    + "run with both the 'dev' and 'cloud' profiles at the same time.");
        }
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OnboardingHelperApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n----------------------------------------------------------\n\t"
                + "Application '{}' is running! Access URLs:\n\t"
                + "Local: \t\t{}://localhost:{}{}\n\t"
                + "External: \t{}://{}:{}{}\n\t"
                + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles());
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            // public static final String ADMIN = "ROLE_ADMIN";
            // public static final String USER = "ROLE_USER";
            // public static final String ANONYMOUS = "ROLE_ANONYMOUS";
            String userName = "admin";
            userRepository.findOneByLogin(userName).ifPresent(existingUser -> {
                userRepository.delete(existingUser);
                userRepository.flush();

            });

            User user = new User();
            user.setActivated(true);
            Authority a = new Authority();
            a.setName("ROLE_ADMIN");
            authorityRepository.save(a);
            a = new Authority();
            a.setName("ROLE_USER");
            authorityRepository.save(a);
            Set<Authority> authorities = new HashSet<>();
            authorityRepository.findById(AuthoritiesConstants.ADMIN).ifPresent(authorities::add);
            authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
            user.setAuthorities(authorities);
            user.setEmail("admin@kdi.com");
            user.setLogin("admin");
            user.setFirstName("admin");
            user.setLastName("KDI");
            user.setLangKey("en");
            user.setCreatedDate(Instant.EPOCH);
            user.setPassword(passwordEncoder.encode("admin"));

            userRepository.save(user);

            establishmentRepository.deleteAll();
            Establishment establishment = new Establishment();
            establishment.setName("Kongsberg Digital");
            establishment.setAddress("No 139/26, Solitaire, 1st Floor, Amarjyothi Layout, Domlur, Koramangala Intermediate Ring Road, Bengaluru, Karnataka 560071");
            establishment.setEmployerName("Dharshini");
            establishment.setEmployerAddress("No 139/26, Solitaire, 1st Floor, Amarjyothi Layout, Domlur, Koramangala Intermediate Ring Road, Bengaluru, Karnataka 560071");
            establishmentRepository.save(establishment);
        };
    }
}
