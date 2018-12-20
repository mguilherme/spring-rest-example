package eu.man.rest.example.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vladmihalcea.hibernate.type.util.ObjectMapperSupplier;

public class CustomObjectMapperSupplier implements ObjectMapperSupplier {

    @Override
    public ObjectMapper get() {
        var objectMapper = new ObjectMapper().findAndRegisterModules();

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, JsonTypeInfo.As.PROPERTY);

//        objectMapper.enableDefaultTyping();

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }

}
