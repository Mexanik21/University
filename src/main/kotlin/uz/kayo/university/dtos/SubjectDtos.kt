package uz.kayo.university.dtos

import uz.kayo.university.entities.Subject

data class SubjectCreateDto(
    var name: String,
    var groupId: Long
)

data class SubjectUpdateDto(
    var name: String?,
    var groupId: Long?
)

data class SubjectResponseDto(
    var id: Long?,
    var name: String?,
    ) {
    companion object {
        fun toDto(r: Subject) = r.run {
            SubjectResponseDto(id, name)
        }
    }
}
