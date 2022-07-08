package uz.kayo.university.service

import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.GroupCreateDto
import uz.kayo.university.dtos.GroupResponseDto
import uz.kayo.university.dtos.GroupUpdateDto

@Service
interface GroupService {

    fun create(dto: GroupCreateDto): HttpEntity<ApiResponse>
    fun update(id: Long, dto: GroupUpdateDto)
    fun getAll(): List<GroupResponseDto>
    fun getOne(id: Long): GroupResponseDto
    fun delete(id: Long)
}