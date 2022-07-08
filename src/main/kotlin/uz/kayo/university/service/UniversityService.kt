package uz.kayo.university.service

import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.UniversityCreateDto
import uz.kayo.university.dtos.UniversityResponseDto
import uz.kayo.university.dtos.UniversityUpdateDto

@Service
interface UniversityService {

    fun create(dto: UniversityCreateDto): HttpEntity<ApiResponse>
    fun update(id:Long,dto: UniversityUpdateDto)
    fun getAll(): List<UniversityResponseDto>
    fun getOne(id: Long): UniversityResponseDto
    fun delete(id: Long)
}