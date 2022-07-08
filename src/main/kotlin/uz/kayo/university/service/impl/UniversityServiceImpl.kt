package uz.kayo.university.service.impl

import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.UniversityCreateDto
import uz.kayo.university.dtos.UniversityResponseDto
import uz.kayo.university.dtos.UniversityUpdateDto
import uz.kayo.university.entities.University
import uz.kayo.university.repositories.AnswerServiceImpl
import uz.kayo.university.repositories.UniversityRepository
import uz.kayo.university.service.UniversityService


@Service
class UniversityServiceImpl(
    private val universityRepository: UniversityRepository,
    private val answerServiceImpl: AnswerServiceImpl
) : UniversityService {
    override fun create(dto: UniversityCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            return answerServiceImpl.saveObject(universityRepository, University(name, address,openYear), true)
        }
    }

    override fun update(id: Long, dto: UniversityUpdateDto) {
        val university = universityRepository.findById(id).orElseThrow { Exception("University not found by id: $id") }
        dto.apply {
            name?.let {
                university.name = it
            }
            address?.let {
                university.address = it
            }
            openYear?.let {
                university.openYear = it
            }

        }
        universityRepository.save(university)

    }

    override fun getAll() = universityRepository.findAll().map {
            UniversityResponseDto.toDto(it)
        }


    override fun getOne(id: Long) = UniversityResponseDto.toDto(
        universityRepository.findById(id).orElseThrow { Exception("University not found by id: $id") })


    override fun delete(id: Long) = universityRepository.deleteById(id)

}