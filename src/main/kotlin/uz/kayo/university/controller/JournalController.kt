package uz.kayo.university.controller

import org.springframework.web.bind.annotation.*
import uz.kayo.university.dtos.JournalCreateDto
import uz.kayo.university.dtos.JournalUpdateDto
import uz.kayo.university.service.JournalService


@RestController
@RequestMapping("journal")
class JournalController(
    private val journalService: JournalService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: JournalCreateDto)=journalService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: JournalUpdateDto) = journalService.update(id, dto)

    @GetMapping
    fun getAll() = journalService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = journalService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id:Long)=journalService.delete(id)
}