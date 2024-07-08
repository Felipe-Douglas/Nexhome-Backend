package br.com.filipedouglas.nexhome.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.filipedouglas.nexhome.domain.properties.Propertie;
import br.com.filipedouglas.nexhome.domain.properties.PropertieRequestDTO;
import br.com.filipedouglas.nexhome.domain.properties.PropertieResponseDTO;
import br.com.filipedouglas.nexhome.repositories.PropertiesRepository;

@RestController
@RequestMapping("properties")
public class PropertiesController {
    
    @Autowired
    private PropertiesRepository propertiesRepository;

    @GetMapping
    public List<PropertieResponseDTO> getAll() {
        List<PropertieResponseDTO> propertieList = propertiesRepository.findAll().stream().map(PropertieResponseDTO::new).toList();
        return propertieList;
    }

    @GetMapping("{id}")
    public ResponseEntity<PropertieResponseDTO> getPropertieId(@PathVariable Long id) {
        Optional<Propertie> propertieOptional = propertiesRepository.findById(id);

        if (propertieOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PropertieResponseDTO propertieResponseDTO = new PropertieResponseDTO(propertieOptional.get());
        return ResponseEntity.ok(propertieResponseDTO);
    }

    @PostMapping
    public void savePropertie(@RequestBody PropertieRequestDTO data) {
        Propertie propertieData = new Propertie(data);
        propertiesRepository.save(propertieData);
    }

    @PutMapping("{id}")
    public ResponseEntity<PropertieResponseDTO> updatePropertie(@PathVariable Long id, @RequestBody PropertieRequestDTO data) {
        Optional<Propertie> propertieOptional = propertiesRepository.findById(id);

        if (propertieOptional.isEmpty()) return ResponseEntity.notFound().build();

        Propertie propertieData = propertieOptional.get();
        propertieData.updateFromDTO(data);
        propertiesRepository.save(propertieData);

        PropertieResponseDTO propertieResponseDTO = new PropertieResponseDTO(propertieData);
        return ResponseEntity.ok(propertieResponseDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePropertie(@PathVariable Long id) {
        Optional<Propertie> propertieOptional = propertiesRepository.findById(id);
        if (propertieOptional.isEmpty()) return ResponseEntity.notFound().build();
        propertiesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
