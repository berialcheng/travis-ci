package org.nirvana.handlers;

import io.paradoxical.common.valuetypes.LongValue;
import io.paradoxical.common.valuetypes.UuidValue;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class ParameterHandlerProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType, final Annotation[] annotations) {
        if (LongValue.class.isAssignableFrom(rawType)) {
            return new LongParameterHandler<>(rawType);
        }

        if (UuidValue.class.isAssignableFrom(rawType)) {
            return new UuidParameterHandler<>(rawType);
        }

        return null;
    }
}
