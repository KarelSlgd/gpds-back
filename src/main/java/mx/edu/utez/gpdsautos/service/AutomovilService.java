package mx.edu.utez.gpdsautos.service;

import mx.edu.utez.gpdsautos.model.Automovil;
import mx.edu.utez.gpdsautos.repository.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutomovilService {

    @Autowired
    private AutomovilRepository automovilRepository;

    public List<Automovil> getAllAutomoviles() {
        return automovilRepository.findAll();
    }

    public Optional<Automovil> getAutomovilById(Long id) {
        return automovilRepository.findById(id);
    }

    public Automovil saveAutomovil(Automovil automovil) {
        return automovilRepository.save(automovil);
    }

    public void deleteAutomovil(Long id) {
        automovilRepository.deleteById(id);
    }
}
