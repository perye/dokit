package com.perye.dokit.repository;

import com.perye.dokit.entity.Captcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CaptchaRepository extends JpaRepository<Captcha, Long>, JpaSpecificationExecutor<Captcha> {
}
