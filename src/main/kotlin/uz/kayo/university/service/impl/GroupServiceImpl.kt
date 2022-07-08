package uz.kayo.university.service.impl


import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.GroupCreateDto
import uz.kayo.university.dtos.GroupResponseDto
import uz.kayo.university.dtos.GroupUpdateDto
import uz.kayo.university.entities.Faculty
import uz.kayo.university.entities.Group
import uz.kayo.university.repositories.AnswerServiceImpl
import uz.kayo.university.repositories.FacultyRepository
import uz.kayo.university.repositories.GroupRepository
import uz.kayo.university.service.GroupService


@Service
class GroupServiceImpl(
    private val groupRepository: GroupRepository,
    private val facultyRepository: FacultyRepository,
    private val answerServiceImpl: AnswerServiceImpl
) : GroupService {


    override fun create(dto: GroupCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val faculty = facultyRepository.findById(facultyId).orElseThrow { Exception("Faculty not found by id: $facultyId") }
            return answerServiceImpl.saveObject(groupRepository, Group(name, faculty,year), true)
        }

    }

    override fun update(id: Long, dto: GroupUpdateDto) {
        val group = groupRepository.findById(id).orElseThrow { Exception("Group not found by id: $id") }
        dto.apply {
            name?.let {
                group.name = it
            }

            facultyId?.let {
                val faculty = facultyRepository.findById(it).orElseThrow { Exception("Faculty not by id: $id") }
                group.faculty = faculty
            }

            year?.let {
                group.year = it
            }
        }
        groupRepository.save(group)

    }


    override fun getAll() = groupRepository.findAll().map { GroupResponseDto.toDto(it) }
    override fun getOne(id: Long) = GroupResponseDto.toDto(
        groupRepository.findById(id).orElseThrow { Exception("Group not found by id: $id") })


    override fun delete(id: Long) {
        groupRepository.deleteById(id)
    }


}