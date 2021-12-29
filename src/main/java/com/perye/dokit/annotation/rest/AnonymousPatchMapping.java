package com.perye.dokit.annotation.rest;

import com.perye.dokit.annotation.AnonymousAccess;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * Annotation for mapping HTTP {@code PATCH} requests onto specific handler
 * methods.
 * * 支持匿名访问    PatchMapping
 *
 * @author liaojinlong
 * @see AnonymousGetMapping
 * @see AnonymousPostMapping
 * @see AnonymousPutMapping
 * @see AnonymousDeleteMapping
 * @see RequestMapping
 */
@AnonymousAccess
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.PATCH)
public @interface AnonymousPatchMapping {

    /**
     * Alias for {@link RequestMapping#name}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String name() default "";

    /**
     * Alias for {@link RequestMapping#value}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String[] value() default {};

    /**
     * Alias for {@link RequestMapping#path}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String[] path() default {};

    /**
     * Alias for {@link RequestMapping#params}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String[] params() default {};

    /**
     * Alias for {@link RequestMapping#headers}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String[] headers() default {};

    /**
     * Alias for {@link RequestMapping#consumes}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String[] consumes() default {};

    /**
     * Alias for {@link RequestMapping#produces}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String[] produces() default {};

}