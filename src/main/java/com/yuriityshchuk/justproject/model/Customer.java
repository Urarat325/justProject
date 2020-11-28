package com.yuriityshchuk.justproject.model;

import com.yuriityshchuk.justproject.model.enumDB.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity implements UserDetails {

    @Column(name = "first_name")
    @NotBlank(message = "firstname cannot be empty")
    private String firstname;

    @Column(name = "last_name")
    @NotBlank(message = "lastname cannot be empty")
    private String lastname;

    @Column(name = "user_name", unique = true)
    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "password cannot be empty")
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "customers_role", joinColumns = @JoinColumn(name = "customers_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers", orphanRemoval = true)
//    @JoinColumn(name = "messages_id")
    private List<Message> messages;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String username, String password, Set<Role> roles, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
