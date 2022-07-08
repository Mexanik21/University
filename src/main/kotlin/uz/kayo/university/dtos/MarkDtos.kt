package uz.kayo.university.dtos

import uz.kayo.university.entities.Mark


data class MarkCreateDto(
    var journalId: Long,
    var subjectId: Long,
    var studentId: Long,
    var mark: Int


)

data class MarkUpdateDto(
    var mark: Int
//    var journalId: Long?,
//    var subjectId: Long?,
//    var studentId: Long?,



)

data class MarkResponseDto(
    var id: Long?,
    var mark: Int
) {
    companion object {
        fun toDto(r: Mark) = r.run {
            MarkResponseDto(id, mark)
        }
    }
}
