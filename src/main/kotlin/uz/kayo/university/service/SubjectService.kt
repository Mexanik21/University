package uz.kayo.university.service

import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.SubjectCreateDto
import uz.kayo.university.dtos.SubjectResponseDto
import uz.kayo.university.dtos.SubjectUpdateDto

@Service
interface SubjectService {

    fun create(dto: SubjectCreateDto): HttpEntity<ApiResponse>
    fun update(id:Long,dto: SubjectUpdateDto)
    fun getAll(): List<SubjectResponseDto>
    fun getOne(id: Long): SubjectResponseDto
    fun delete(id:Long)
}