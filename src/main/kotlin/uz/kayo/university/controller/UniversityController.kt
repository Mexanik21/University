package uz.kayo.university.controller

import org.springframework.web.bind.annotation.*
import uz.kayo.university.dtos.UniversityCreateDto
import uz.kayo.university.dtos.UniversityUpdateDto
import uz.kayo.university.service.UniversityService


@RestController
@RequestMapping("university")
class UniversityController(
    private val universityService: UniversityService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: UniversityCreateDto)=universityService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: UniversityUpdateDto) = universityService.update(id, dto)

    @GetMapping
    fun getAll() = universityService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = universityService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = universityService.delete(id)
}