package uz.kayo.university.entities

import javax.persistence.*

@Entity
data class Journal(
    var name:String,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    var group: Group,
    @ManyToMany
    val subjects:List<Subject>? = null,
    @OneToMany(mappedBy = "journal", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    var mark: List<Mark>? = null
):BaseEntity()