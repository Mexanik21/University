package uz.kayo.university.entities

import javax.persistence.*

@Entity
data class Mark(
    var mark:Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journalId")
    val journal: Journal,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjectId")
    val subject: Subject,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    val student: Student
):BaseEntity()
