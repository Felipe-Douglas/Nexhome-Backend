package br.com.filipedouglas.nexhome.domain.properties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "properties")
@Entity(name = "properties")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Propertie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private String description;
    private String image;

    public Propertie(PropertieRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
        this.image = data.image();
        this.description = data.description();
    }

    public void updateFromDTO(PropertieRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
        this.image = data.image();
        this.description = data.description();
    }

}
