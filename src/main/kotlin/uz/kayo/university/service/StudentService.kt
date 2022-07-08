package uz.kayo.university.service

import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.*
import uz.kayo.university.entities.Subject

@Service
interface StudentService {

    fun create(dto: StudentCreateDto): HttpEntity<ApiResponse>
    fun update(id:Long,dto: StudentUpdateDto)
    fun getAll(): List<StudentResponseDto>
    fun getOne(id: Long): StudentResponseDto
    fun delete(id:Long)
    fun getAllSubjectsStudent(id:Long): List<SubjectResponseDto>?
    fun getStudent(name:String): StudentSearchResultResponseDto
    fun getStudentMark(id: Long): List<ListStudentDto>
}