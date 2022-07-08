package uz.kayo.university.dtos

import uz.kayo.university.entities.Student
import java.awt.font.NumericShaper


data class StudentCreateDto(
    var name: String,
    var groupId: Long


)

data class StudentUpdateDto(
    var name: String?,
    var groupId: Long?


)

data class StudentResponseDto(
    var id: Long?,
    var name: String?,

    ) {
    companion object {
        fun toDto(r: Student) = r.run {
            StudentResponseDto(id, name)
        }
    }
}

data class StudentSearchResultResponseDto(
    var name: String,
    var groupName:String?,
    var facultyName:String?
)

data class ListStudents(
    var student:Student,
    var avg:Long?
)
