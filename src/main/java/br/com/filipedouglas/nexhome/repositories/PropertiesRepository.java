package br.com.filipedouglas.nexhome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filipedouglas.nexhome.domain.properties.Propertie;

public interface PropertiesRepository extends JpaRepository<Propertie, Long> {
    
}
