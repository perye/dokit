package com.perye.dokit.exception;

import com.perye.dokit.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class EntityExistException extends RuntimeException {

    public EntityExistException(Class clazz, String field, String val) {
        super(EntityExistException.generateMessage(clazz.getSimpleName(), toMap(field, val)));
    }

    private static String generateMessage(String entity, Map<Object, Object> saveBodyParams) {
        return StringUtils.capitalize(entity) +
                " 已存在 " +
                saveBodyParams;
    }

    private static Map<Object, Object> toMap(String... entries) {
        return new HashMap<Object, Object>() {{
            put(entries[0], entries[1]);
        }};
    }
}
