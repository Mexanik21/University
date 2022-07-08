package uz.kayo.university.service.impl


import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.*
import uz.kayo.university.entities.Student
import uz.kayo.university.entities.Subject
import uz.kayo.university.repositories.*
import uz.kayo.university.service.StudentService


@Service
class StudentServiceImpl(
    private val studentRepository: StudentRepository,
    private val groupRepository: GroupRepository,
    private val subjectRepository: SubjectRepository,
    private val facultyRepository: FacultyRepository,
    private val answerServiceImpl: AnswerServiceImpl
) : StudentService {


    override fun create(dto: StudentCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val group = groupRepository.findById(groupId).orElseThrow { Exception("Group not found by id: $groupId")}
            return answerServiceImpl.saveObject(studentRepository, Student(name,group), true)
            }
        }


    override fun update(id: Long, dto: StudentUpdateDto) {
        val student = studentRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") }
        dto.apply {
            name?.let {
                student.name = it
            }

            groupId?.let {
                val group = groupRepository.findById(it).orElseThrow { Exception("Group not by id: $id") }
                student.group = group
            }

        }
        studentRepository.save(student)

    }

    override fun getAll() = studentRepository.findAll().map { StudentResponseDto.toDto(it) }
    override fun getOne(id: Long) = StudentResponseDto.toDto(
        studentRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") })

    override fun delete(id: Long) = studentRepository.deleteById(id)


    override fun getAllSubjectsStudent(id:Long):List<SubjectResponseDto>?{
        val student = studentRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") }
        return subjectRepository.findByGroupId(student.group.id!!).map { SubjectResponseDto.toDto(it) }
    }

    override fun getStudent(name:String): StudentSearchResultResponseDto {
        val student = studentRepository.findByName(name)
        val group = student.group.id?.let { groupRepository.findById(it).orElseThrow() }
        val faculty = group!!.faculty.id?.let { facultyRepository.findById(it).orElseThrow() }
        return StudentSearchResultResponseDto(student.name,group.name, faculty!!.name)
    }

    override fun getStudentMark(id: Long): List<ListStudentDto> = studentRepository.findStudentMark(id)


}