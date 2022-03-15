package sk.stuba.fei.uim.vsa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Publisher implements DomainEntity {

    private static final long serialVersionUID = 5438586895859339503L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Publisher(String name) {
        this.name = name;
    }
}
