package uz.kayo.university.repositories

import org.springframework.data.jpa.repository.Query
import uz.kayo.university.dtos.ListStudentDto
import uz.kayo.university.entities.Group
import uz.kayo.university.entities.Student

interface StudentRepository:BaseRepository<Student> {
    fun findAllByGroupIn(group: List<Group>?):List<Student>?
    fun findByName(name: String):Student

    @Query("select s.name as studentName ,avg(m.mark) as studentMark from student s inner join mark m on m.student_id = s.id where s.group_id = :groupId group by s.name order by  avg(m.mark) desc;", nativeQuery = true)
    fun findStudentMark(groupId: Long):List<ListStudentDto>
}