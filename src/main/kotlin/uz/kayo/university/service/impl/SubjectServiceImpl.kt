package uz.kayo.university.service.impl

import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.SubjectCreateDto
import uz.kayo.university.dtos.SubjectResponseDto
import uz.kayo.university.dtos.SubjectUpdateDto
import uz.kayo.university.entities.Student
import uz.kayo.university.entities.Subject
import uz.kayo.university.repositories.AnswerServiceImpl
import uz.kayo.university.repositories.GroupRepository
import uz.kayo.university.repositories.SubjectRepository
import uz.kayo.university.service.SubjectService


@Service
class SubjectServiceImpl(
    private val subjectRepository: SubjectRepository,
    private val groupRepository: GroupRepository,
    private val answerServiceImpl: AnswerServiceImpl
) : SubjectService {


    override fun create(dto: SubjectCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val group = groupRepository.findById(groupId)
                .orElseThrow { Exception("Group not found by id: $groupId") }
            return answerServiceImpl.saveObject(
                subjectRepository, Subject(name,group), true)
        }


    }

    override fun update(id: Long, dto: SubjectUpdateDto) {
        val subject = subjectRepository.findById(id).orElseThrow { Exception("Subject not found by id: $id") }
        dto.apply {
            name?.let {
                subject.name = it
            }
            groupId?.let {
                val group = groupRepository.findById(it).orElseThrow { Exception("Group not by id: $id") }
                subject.group = group
            }
        }
        subjectRepository.save(subject)

    }

    override fun getAll() = subjectRepository.findAll().map { SubjectResponseDto.toDto(it) }
    override fun getOne(id: Long) = SubjectResponseDto.toDto(
        subjectRepository.findById(id).orElseThrow { Exception("Subject not found by id: $id") })

    override fun delete(id: Long) = subjectRepository.deleteById(id)




}