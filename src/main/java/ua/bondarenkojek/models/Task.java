package ua.bondarenkojek.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "user")
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @NonNull
    private String description;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean state = false;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

}
