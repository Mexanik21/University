package uz.kayo.university.service.impl

import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.MarkCreateDto
import uz.kayo.university.dtos.MarkResponseDto
import uz.kayo.university.dtos.MarkUpdateDto
import uz.kayo.university.entities.Mark
import uz.kayo.university.entities.Student
import uz.kayo.university.repositories.*
import uz.kayo.university.service.MarkService


@Service
class MarkServiceImpl(
    private val markRepository: MarkRepository,
    private val journalRepository: JournalRepository,
    private val subjectRepository: SubjectRepository,
    private val studentRepository: StudentRepository,
    private val answerServiceImpl: AnswerServiceImpl
) : MarkService {


    override fun create(dto: MarkCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val journal = journalRepository.findById(journalId).orElseThrow{Exception("Journal not found by id: $journalId")}
            val subject = subjectRepository.findById(subjectId).orElseThrow{Exception("Subject not found by id: $subjectId")}
            val student = studentRepository.findById(studentId).orElseThrow{Exception("Student not found by id: $studentId")}
            return answerServiceImpl.saveObject(markRepository, Mark(mark,journal,subject,student), true)

        }

    }

    override fun update(id: Long, dto: MarkUpdateDto) {
        val mark = markRepository.findById(id).orElseThrow { Exception("Mark not found by id: $id") }
        dto.apply {
            mark.let {
                mark.mark = it.mark
            }
            markRepository.save(mark)
        }
    }

    override fun getAll() = markRepository.findAll().map { MarkResponseDto.toDto(it) }
    override fun getOne(id: Long) = MarkResponseDto.toDto(
        markRepository.findById(id).orElseThrow { Exception("Mark not found by id: $id") })

    override fun delete(id: Long) = markRepository.deleteById(id)

}