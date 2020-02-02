package gcp.circle.presentation.controller;

import gcp.circle.application.service.DialectService;
import gcp.circle.domain.model.Dialect;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 方言API
 */
@RestController
@RequestMapping("/api")
public class DialectController {

    private DialectService service;

    public DialectController(DialectService service) {
        this.service = service;
    }

    /**
     * 一覧
     * @return
     */
    @GetMapping("/dialects")
    ResponseEntity<List<Dialect>> index() {
        return ResponseEntity.ok(service.all());
    }

    /**
     * 登録
     * @param request
     * @return
     */
    @PostMapping("/dialects")
    ResponseEntity<Dialect> post(@RequestBody Dialect request) {
        return ResponseEntity.ok(service.save(request));
    }

    /**
     * 削除
     * @param id
     * @return
     */
    @DeleteMapping("/dialects/{id}")
    ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
