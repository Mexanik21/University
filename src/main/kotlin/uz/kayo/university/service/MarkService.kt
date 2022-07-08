package uz.kayo.university.service

import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.MarkCreateDto
import uz.kayo.university.dtos.MarkResponseDto
import uz.kayo.university.dtos.MarkUpdateDto

@Service
interface MarkService {

    fun create(dto: MarkCreateDto): HttpEntity<ApiResponse>
    fun update(id:Long,dto: MarkUpdateDto)
    fun getAll(): List<MarkResponseDto>
    fun getOne(id: Long): MarkResponseDto
    fun delete(id: Long)
}