package uz.kayo.university.dtos

import uz.kayo.university.entities.University
import java.time.Year

data class UniversityCreateDto(
    val name:String,
    val address:String,
    val openYear: Int
)

data class UniversityUpdateDto(
    val name:String,
    val address:String,
    val openYear: Int
)

data class UniversityResponseDto(
    val name:String,
    val address:String,
    val openYear: Int
){
    companion object{
        fun toDto(u: University) = u.run {

            UniversityResponseDto(name, address, openYear)
        }
    }

}