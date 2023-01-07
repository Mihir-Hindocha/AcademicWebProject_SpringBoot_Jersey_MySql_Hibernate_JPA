package application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/shubhmangalgreens")
public class JerseyConfig extends ResourceConfig {

    @Autowired
    public JerseyConfig(ObjectMapper objectMapper) {
        // Register Endpoints
        packages("application.endpoint");
        // Register Jackson for JSON
        register(new ObjectMapperContextResolver(objectMapper));
    }

    @Provider
    public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
        private final ObjectMapper mapper;

        public ObjectMapperContextResolver(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        public ObjectMapper getContext(Class<?> type) {
            return mapper;
        }
    }
}
