package uz.kayo.university.repositories

import uz.kayo.university.entities.Subject

interface SubjectRepository:BaseRepository<Subject> {
    fun findByGroupId(group_id: Long):List<Subject>
}