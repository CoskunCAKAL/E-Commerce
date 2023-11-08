package com.haratres.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Whislist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "whislist", cascade = CascadeType.ALL)
    private Set<WhislistEntry> whislistEntries = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
