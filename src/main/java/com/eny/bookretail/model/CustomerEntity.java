package com.eny.bookretail.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @NotBlank
    @Size(max = 40)
    private String firstName;

    @NotBlank
    @Size(max = 40)
    private String lastName;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    @Size(max = 200)
    private String address;

    /**
     * @OneToOne(cascade = CascadeType.ALL)
     * @JoinColumn(name = "address_id", referencedColumnName = "id")
     * private AddressEntity address;
     */

    @OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderEntity> orders = new ArrayList<>();

    public CustomerEntity() {

    }

    public CustomerEntity(String name, String lastName, String username, String email, String password, String address) {
        this.firstName = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}