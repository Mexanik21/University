package uz.kayo.university.entities

import javax.persistence.*

@Entity(name = "groups")
@Table(uniqueConstraints = [
    UniqueConstraint(columnNames = ["name", "facultyId"])
])
data class Group (
    var name:String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultyId")
    var faculty: Faculty,
    var year:Int,
    @OneToMany(mappedBy = "group", cascade = [CascadeType.ALL])
    var student: List<Student>? = null,
    @OneToOne(mappedBy = "group", cascade = [CascadeType.ALL])
    var journal: Journal? = null,
    @OneToMany(mappedBy = "group", cascade = [CascadeType.ALL])
    var subject: List<Subject>? = null
        ):BaseEntity()