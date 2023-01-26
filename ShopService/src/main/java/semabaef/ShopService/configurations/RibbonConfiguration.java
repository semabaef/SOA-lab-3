package semabaef.ShopService.configurations;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Autowired
    private IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RoundRobinRule();
    }
}
