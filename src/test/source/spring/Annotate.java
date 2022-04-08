package source.spring;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("annotate")
public class Annotate {

/*    可以看到，虽然ServiceAlias上只有@Service注解，但通过AnnotationUtils.getAnnotation方法可以解析得到@Component，
    而通过AnnotatedElementUtils.getMergedAnnotation方法还可以将@Service#value的值赋给@Component#value。
    该机制在Spring内部实现并不复杂，在java中，注解是使用动态代理类实现，Spring中同理。
    AnnotationUtils#getAnnotation ->　synthesizeAnnotation*/

    public static void main(String[] args) {
        Component component = AnnotationUtils.getAnnotation(Annotate.class, Component.class);
        System.out.println(component);

        Component component2 = AnnotatedElementUtils.getMergedAnnotation(Annotate.class, Component.class);
        System.out.println(component2);

    }
}
