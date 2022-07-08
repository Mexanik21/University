package uz.kayo.university.entities

import javax.persistence.*

@Entity
@Table(uniqueConstraints = [
    UniqueConstraint(columnNames = ["name", "universityId"])
])
data class Faculty (
    var name:String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "universityId")
    var university: University,
    @OneToMany(mappedBy = "faculty", cascade = [CascadeType.ALL])
    var group: List<Group>? = null
    ):BaseEntity()