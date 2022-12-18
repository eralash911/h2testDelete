package com.winter.core.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix = "integrations.cart-service")
@Data
public class CartServiceIntegrationsProperties {
    private String url;
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;
}
