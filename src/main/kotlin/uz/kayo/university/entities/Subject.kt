package uz.kayo.university.entities

import javax.persistence.*


@Entity
@Table(uniqueConstraints = [
    UniqueConstraint(columnNames = ["name", "groupId"])
])
data class Subject(
    var name:String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    var group: Group,
    @OneToMany(mappedBy = "subject", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    var mark: List<Mark>? = null
):BaseEntity()
