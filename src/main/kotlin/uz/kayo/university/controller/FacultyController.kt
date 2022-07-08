package uz.kayo.university.controller

import org.springframework.web.bind.annotation.*
import uz.kayo.university.dtos.FacultyCreateDto
import uz.kayo.university.dtos.FacultyUpdateDto
import uz.kayo.university.service.FacultyService


@RestController
@RequestMapping("faculty")
class FacultyController(
    private val facultyService: FacultyService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: FacultyCreateDto)=facultyService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: FacultyUpdateDto) = facultyService.update(id, dto)

    @GetMapping
    fun getAll() = facultyService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = facultyService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Long)=facultyService.delete(id)

    @GetMapping("size/{id}")
    fun getAllStudentsAndGroups(@PathVariable id:Long)=facultyService.getAllStudentsAndGroups(id)
}