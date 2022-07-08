package uz.kayo.university.entities

import javax.persistence.*

@Entity
data class Student(
    var name:String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    var group: Group,
    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    var mark: List<Mark>? = null
):BaseEntity()