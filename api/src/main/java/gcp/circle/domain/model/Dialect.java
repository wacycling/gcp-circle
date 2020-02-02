package gcp.circle.domain.model;

import lombok.Getter;

/**
 * 方言ドメインオブジェクト
 */
@Getter
public class Dialect {

    /** ID */
    private Long id;

    /** 方言 */
    private String word;

    public Dialect(Long id, String word) {
        this.id = id;
        this.word = word;
    }
}
