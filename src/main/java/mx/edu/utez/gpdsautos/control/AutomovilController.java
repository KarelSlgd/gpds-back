package mx.edu.utez.gpdsautos.control;

import mx.edu.utez.gpdsautos.model.Automovil;
import mx.edu.utez.gpdsautos.service.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automoviles")
public class AutomovilController {

    @Autowired
    private AutomovilService automovilService;

    @GetMapping
    public List<Automovil> getAllAutomoviles() {
        return automovilService.getAllAutomoviles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automovil> getAutomovilById(@PathVariable Long id) {
        return automovilService.getAutomovilById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Automovil createAutomovil(@RequestBody Automovil automovil) {
        return automovilService.saveAutomovil(automovil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Automovil> updateAutomovil(@PathVariable Long id, @RequestBody Automovil automovil) {
        return automovilService.getAutomovilById(id)
                .map(existingAutomovil -> {
                    automovil.setId(id);
                    return ResponseEntity.ok(automovilService.saveAutomovil(automovil));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutomovil(@PathVariable Long id) {
        if (automovilService.getAutomovilById(id).isPresent()) {
            automovilService.deleteAutomovil(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
