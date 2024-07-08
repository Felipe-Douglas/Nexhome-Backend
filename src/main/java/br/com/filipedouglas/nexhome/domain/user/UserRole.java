package br.com.filipedouglas.nexhome.domain.user;

public enum UserRole {
    ADMIN("admin"),
    MANAGER("manager"),
    USER("user");

    private String user_role;

    UserRole(String role) {
        this.user_role = role;
    }

    public String getRole() {
        return user_role;
    }
}
