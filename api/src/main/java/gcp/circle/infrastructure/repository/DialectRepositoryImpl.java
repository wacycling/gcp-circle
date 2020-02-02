package gcp.circle.infrastructure.repository;

import gcp.circle.application.repository.DialectRepository;
import gcp.circle.domain.model.Dialect;
import gcp.circle.infrastructure.entity.DialectEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 方言リポジトリ
 * 永続化の実装クラス
 */
@Repository
public class DialectRepositoryImpl implements DialectRepository {

    private DialectJpaRepository repository;

    public DialectRepositoryImpl(DialectJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dialect> findAll() {
        return repository.findAll()
                .stream()
                .map(DialectEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Dialect save(Dialect dialect) {
        return repository.save(DialectEntity.fromModel(dialect))
                .toModel();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
