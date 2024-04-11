package umc.thurstagram.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;
    @OneToMany(mappedBy = "post")
    private Collection<Save> save;

    public Collection<Save> getSave() {
        return save;
    }

    public void setSave(Collection<Save> save) {
        this.save = save;
    }
}
