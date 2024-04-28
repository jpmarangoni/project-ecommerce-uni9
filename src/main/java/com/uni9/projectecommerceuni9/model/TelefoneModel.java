package com.uni9.projectecommerceuni9.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_TELEFONE")
@Entity(name = "TB_TELEFONE")
public class TelefoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "telefone")
    String telefone;

}
