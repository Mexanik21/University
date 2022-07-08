package uz.kayo.university.dtos

import uz.kayo.university.entities.Faculty
import uz.kayo.university.entities.University

data class FacultyCreateDto(
    val name:String,
    val universityId:Long
)


data class FacultyUpdateDto(
    val name:String,
    val universityId: Long
)

data class FacultyResponseDto(
    val name: String,
    val universityId: Long
){
    companion object{
        fun toDto(f: Faculty) = f.run {
            FacultyResponseDto(name, university.id!!)
        }
    }
}

data class FacultySizeDto(
    val groupSize:Int,
    val studentSize:Int
)