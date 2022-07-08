package uz.kayo.university.controller

import org.springframework.web.bind.annotation.*
import uz.kayo.university.dtos.GroupCreateDto
import uz.kayo.university.dtos.GroupUpdateDto
import uz.kayo.university.service.GroupService


@RestController
@RequestMapping("group")
class GroupController(
    private val groupService: GroupService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: GroupCreateDto)=groupService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: GroupUpdateDto) = groupService.update(id, dto)

    @GetMapping
    fun getAll() = groupService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = groupService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = groupService.delete(id)
}