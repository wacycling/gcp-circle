package gcp.circle.application.repository;

import gcp.circle.domain.model.Dialect;

import java.util.List;

/**
 * 方言リポジトリ
 * インフラ層とのインタフェース

 */
public interface DialectRepository {

    List<Dialect> findAll();
    Dialect save(Dialect dialect);
    void deleteById(Long id);
}
