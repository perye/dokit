package com.perye.dokit.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.perye.dokit.utils.EncryptUtils.*;
import static org.junit.Assert.*;

@Slf4j
public class EncryptUtilsTest {

    /**
     * 对称加密
     */
    @Test
    public void testDesEncrypt() {
        try {
            assertEquals("7772841DC6099402",desEncrypt("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对称解密
     */
    @Test
    public void testDesDecrypt() {
        try {
            assertEquals("123456", desDecrypt("7772841DC6099402"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}