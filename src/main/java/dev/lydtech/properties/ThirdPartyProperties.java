package dev.lydtech.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.net.URL;

@Configuration
@ConfigurationProperties("thirdparty")
@Getter
@Setter
@Validated
public class ThirdPartyProperties {
    @NotNull
    private URL endpoint;
}
