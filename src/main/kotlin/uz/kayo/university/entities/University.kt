package uz.kayo.university.entities

import java.time.Year
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany


@Entity
data class University(
    @Column(unique = true)
    var name: String,
    var address:String,
    var openYear:Int,
    @OneToMany(mappedBy = "university", cascade = [CascadeType.ALL])
    var faculty: List<Faculty>? = null
):BaseEntity()