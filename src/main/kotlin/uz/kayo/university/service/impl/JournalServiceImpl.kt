package uz.kayo.university.service.impl

import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.JournalCreateDto
import uz.kayo.university.dtos.JournalResponseDto
import uz.kayo.university.dtos.JournalUpdateDto
import uz.kayo.university.entities.Group
import uz.kayo.university.entities.Journal
import uz.kayo.university.repositories.AnswerServiceImpl
import uz.kayo.university.repositories.GroupRepository
import uz.kayo.university.repositories.JournalRepository
import uz.kayo.university.service.JournalService


@Service
class JournalServiceImpl(
    private val journalRepository: JournalRepository,
    private val groupRepository: GroupRepository,
    private val answerServiceImpl: AnswerServiceImpl
) : JournalService {


    override fun create(dto: JournalCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val group = groupRepository.findById(groupId)
                .orElseThrow { Exception("Group not found by id: $groupId") }
            return answerServiceImpl.saveObject(journalRepository, Journal(name, group), true)
        }

    }

    override fun update(id: Long, dto: JournalUpdateDto) {
        val subject = journalRepository.findById(id).orElseThrow { Exception("Journal not found by id: $id") }
        dto.apply {
            name?.let {
                subject.name = it
            }

            groupId?.let {
                val group = groupRepository.findById(it).orElseThrow { Exception("Group not by id: $id") }
                subject.group = group
            }

        }
        journalRepository.save(subject)

    }

    override fun getAll() = journalRepository.findAll().map { JournalResponseDto.toDto(it) }
    override fun getOne(id: Long) = JournalResponseDto.toDto(
        journalRepository.findById(id).orElseThrow { Exception("Journal not found by id: $id") })

    override fun delete(id:Long) = journalRepository.deleteById(id)


}