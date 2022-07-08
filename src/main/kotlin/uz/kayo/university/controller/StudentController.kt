package uz.kayo.university.controller

import org.springframework.web.bind.annotation.*
import uz.kayo.university.dtos.StudentCreateDto
import uz.kayo.university.dtos.StudentUpdateDto
import uz.kayo.university.service.StudentService

@RestController
@RequestMapping("student")
class StudentController(
    private val studentService: StudentService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: StudentCreateDto)=studentService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: StudentUpdateDto) = studentService.update(id, dto)

    @GetMapping
    fun getAll() = studentService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = studentService.getOne(id)

    @GetMapping("subject/{id}")
    fun getAllSubjectsStudent(@PathVariable id: Long) = studentService.getAllSubjectsStudent(id)

    @GetMapping("search/{name}")
    fun getStudent(@PathVariable name:String) = studentService.getStudent(name)

    @GetMapping("group/{id}")
    fun getStudentMark(@PathVariable id: Long) = studentService.getStudentMark(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Long)=studentService.delete(id)
}