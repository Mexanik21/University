package uz.kayo.university.service

import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.JournalCreateDto
import uz.kayo.university.dtos.JournalResponseDto
import uz.kayo.university.dtos.JournalUpdateDto

@Service
interface JournalService {

    fun create(dto: JournalCreateDto): HttpEntity<ApiResponse>
    fun update(id:Long,dto: JournalUpdateDto)
    fun getAll(): List<JournalResponseDto>
    fun getOne(id: Long): JournalResponseDto
    fun delete(id:Long)
}