package gcp.circle.application.service;

import gcp.circle.application.repository.DialectRepository;
import gcp.circle.domain.model.Dialect;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 方言APIサービス
 */
@Service
public class DialectService {

    private DialectRepository repository;

    public DialectService(DialectRepository repository) {
        this.repository = repository;
    }

    /**
     * 一覧を取得
     * @return
     */
    public List<Dialect> all() {
        return repository.findAll();
    }

    /**
     * 対象レコードを登録
     * @param dialect
     * @return
     */
    @Transactional
    public Dialect save(Dialect dialect) {
        return repository.save(dialect);
    }

    /**
     * 対象レコードを削除
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
