package lpweb.projeto.clinica.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

public class PropriedadesUtil {
    public static String[] obterPropriedadesComNullDe(Object source) {

        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);

        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null
                        || propertyName.equals("id"))
                .toArray(String[]::new);
    }

    public static void copiarPropriedades(Object origem, Object destino) {
        BeanUtils.copyProperties(
            origem,
            destino,
            obterPropriedadesComNullDe(origem)
        );
    }
}
