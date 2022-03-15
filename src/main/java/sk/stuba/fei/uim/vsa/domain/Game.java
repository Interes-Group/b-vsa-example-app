package sk.stuba.fei.uim.vsa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name = Game.FIND_ALL, query = "select g from Game g")
@NamedQuery(name = Game.FIND_BY_NAME, query = "select g from Game g where g.name = :name")
public class Game implements DomainEntity {

    private static final long serialVersionUID = 2996702055645581511L;

    public static final String FIND_ALL = "Game.findAll";
    public static final String FIND_BY_NAME = "Game.findByName";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    @ManyToMany
    private List<Publisher> publishers;

//    @ManyToOne
//    private Developer developer;


    public Game(String name, Genre... genres) {
        this.name = name;
        this.genres = new HashSet<>(Arrays.asList(genres));
    }
}
