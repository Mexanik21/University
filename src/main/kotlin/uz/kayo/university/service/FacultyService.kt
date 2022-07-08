package uz.kayo.university.service

import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.FacultyCreateDto
import uz.kayo.university.dtos.FacultyResponseDto
import uz.kayo.university.dtos.FacultySizeDto
import uz.kayo.university.dtos.FacultyUpdateDto
import uz.kayo.university.entities.Student

@Service
interface FacultyService {

    fun create(dto: FacultyCreateDto): HttpEntity<ApiResponse>
    fun update(id:Long,dto: FacultyUpdateDto)
    fun getAll(): List<FacultyResponseDto>
    fun getOne(id: Long): ResponseEntity<ApiResponse>
    fun delete(id: Long): HttpEntity<ApiResponse>

    fun getAllStudentsAndGroups(id: Long): FacultySizeDto
}