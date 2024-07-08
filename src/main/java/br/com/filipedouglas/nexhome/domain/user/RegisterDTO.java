package br.com.filipedouglas.nexhome.domain.user;

public record RegisterDTO(String name, String email, String pass, UserRole role) {
    
}
