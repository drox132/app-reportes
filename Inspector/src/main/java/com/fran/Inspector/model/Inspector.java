package com.fran.Inspector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "inspector")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inspector {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSPECTOR_SEQUENCE")
    @SequenceGenerator(name = "INSPECTOR_SEQUENCE", allocationSize = 1)
    private Integer id;
    private String name;
    private String cel;
    private String email;

}
