package com.perye.dokit.annotation;

import java.lang.annotation.*;

/**
 * 用于标记匿名访问方法
 */
@Inherited
@Documented
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnonymousAccess {

}
