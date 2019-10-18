package com.perye.dokit.repository;

import com.perye.dokit.entity.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
