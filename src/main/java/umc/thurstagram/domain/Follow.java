package umc.thurstagram.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "follower_id")
    private Member follower; // 팔로잉 거는 사람

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "acceptor_id")
    private Member acceptor; // 팔로잉 받는 사람

}
