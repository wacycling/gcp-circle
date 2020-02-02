package gcp.circle.infrastructure.entity;

import gcp.circle.domain.model.Dialect;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 方言エンティティ
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "dialect")
public class DialectEntity extends AbstractEntity {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 方言 */
    @Column(columnDefinition = "TEXT")
    private String word;

    public DialectEntity(Long id, String word) {
        this.id = id;
        this.word = word;
    }

    /**
     * ドメインオブジェクトからインスタンスを生成
     * @param dialect
     * @return
     */
    public static DialectEntity fromModel(Dialect dialect) {
        return new DialectEntity(dialect.getId(), dialect.getWord());
    }

    /**
     * ドメインオブジェクトへ変換
     * @return
     */
    public Dialect toModel() {
        return new Dialect(id, word);
    }
}
