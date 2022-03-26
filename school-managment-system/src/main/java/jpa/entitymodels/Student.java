package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {

    @Id
    @Column(name = "email", length = 50)
    @NonNull
    private String sEmail;

    @Column(name = "name", length = 50, nullable = false)
    @NonNull
    private String sName;

    @Column(name = "password", length = 50, nullable = false)
    @NonNull
    private String sPass;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "Student_Course",
        joinColumns = { @JoinColumn(name = "student_email") },
        inverseJoinColumns = { @JoinColumn(name = "course_id") })
    @NonNull
    @ToString.Exclude
    private List<Course> sCourses = new ArrayList<>();

}
