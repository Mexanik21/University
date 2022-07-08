package uz.kayo.university.service.impl


import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import uz.kayo.university.common.ApiResponse
import uz.kayo.university.dtos.FacultyCreateDto
import uz.kayo.university.dtos.FacultyResponseDto
import uz.kayo.university.dtos.FacultySizeDto
import uz.kayo.university.dtos.FacultyUpdateDto
import uz.kayo.university.entities.Faculty
import uz.kayo.university.entities.Student
import uz.kayo.university.repositories.*
import uz.kayo.university.service.FacultyService


@Service
class FacultyServiceImpl(
    private val facultyRepository: FacultyRepository,
    private val groupRepository: GroupRepository,
    private val studentRepository: StudentRepository,
    private val universityRepository: UniversityRepository,
    private val answerServiceImpl: AnswerServiceImpl
) : FacultyService {




    override fun create(dto: FacultyCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val university = universityRepository.findById(universityId)
                .orElseThrow { Exception("Un not found by id: $universityId") }
            return  answerServiceImpl.saveObject(facultyRepository, Faculty(name, university), true)

        }
    }

    override fun update(id: Long, dto: FacultyUpdateDto) {
        val faculty = facultyRepository.findById(id).orElseThrow { Exception("Faculty not found by id: $id") }
        dto.apply {
            name?.let {
                faculty.name = it
            }

            universityId?.let {
                val university = universityRepository.findById(it).orElseThrow { Exception("District not by id: $id") }
                faculty.university = university
            }
        }
        facultyRepository.save(faculty)

    }

    override fun getAll() = facultyRepository.findAll().map { FacultyResponseDto.toDto(it) }
    override fun getOne(id: Long): ResponseEntity<ApiResponse> {

        val findById = facultyRepository.findById(id)

        if (findById.isPresent) {
        return answerServiceImpl.answer("success",true,findById.get(),HttpStatus.OK)

        }
        return answerServiceImpl.answer("not found",false,null,HttpStatus.NOT_FOUND)



//        return ResponseEntity.status(HttpStatus.OK).body(
//            FacultyResponseDto.toDto(
//                facultyRepository.findById(id).orElseThrow { Exception("Faculty not found by id: $id") })
//        )


    }

    override fun delete(id: Long): HttpEntity<ApiResponse> {
       return answerServiceImpl.deleteObject(facultyRepository,id)
    }

    override fun getAllStudentsAndGroups(id: Long): FacultySizeDto {
        val faculty = facultyRepository.findById(id).orElseThrow()
        val groups = faculty.id?.let { groupRepository.findAllByFacultyId(it) }
        val student =  studentRepository.findAllByGroupIn(groups)
        return FacultySizeDto(groups!!.size, student!!.size)
    }


}