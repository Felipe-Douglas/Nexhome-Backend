package br.com.filipedouglas.nexhome.domain.properties;

public record PropertieResponseDTO(Long id, String name, Integer price, String description, String image) {
    public PropertieResponseDTO(Propertie propertie) {
        this(propertie.getId(), propertie.getName(), propertie.getPrice(), propertie.getDescription(), propertie.getImage());
    }
} 
