package uz.kayo.university.dtos

import uz.kayo.university.entities.Journal


data class JournalCreateDto(
    var name: String,
    var groupId: Long
)

data class JournalUpdateDto(
    var name: String?,
    var groupId: Long?
)

data class JournalResponseDto(
    var id: Long?,
    var name: String?,
    ) {
    companion object {
        fun toDto(r: Journal) = r.run {
            JournalResponseDto(id, name)
        }
    }
}