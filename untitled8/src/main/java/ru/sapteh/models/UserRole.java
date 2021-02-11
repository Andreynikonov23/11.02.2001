package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "date_registration")
    private Date dateRegistration;

    @ManyToOne
    @JoinColumn (name = "role_id", nullable = false)
    @NonNull
    private Role role;

    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false)
    @NonNull
    private User user;

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", dateRegistration=" + dateRegistration +
                '}';
    }
}
