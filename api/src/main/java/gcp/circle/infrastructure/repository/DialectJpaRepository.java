package gcp.circle.infrastructure.repository;

import gcp.circle.infrastructure.entity.DialectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DialectJpaRepository extends JpaRepository<DialectEntity, Long> {}
