package uz.kayo.university.dtos

import uz.kayo.university.entities.Group


data class GroupCreateDto(
    var name: String,
    var facultyId: Long,
    var year: Int,
    )

data class GroupUpdateDto(
    var name: String?,
    var facultyId: Long?,
    var year: Int?,
    )

data class GroupResponseDto(
    var id: Long?,
    var name: String?,
    var year: Int?

    ) {
    companion object {
        fun toDto(g: Group) = g.run {
            GroupResponseDto(id, name,year)
        }
    }
}


