package uz.kayo.university.repositories

import uz.kayo.university.entities.Group

interface GroupRepository:BaseRepository<Group> {
    fun findAllByFacultyId(faculty_id: Long):List<Group>?

}

//
//
//@Query("select c from Company c where c.employee is not empty and ?1 member c.employee")
//fun findEmployeeCompany(employee: Employee): Company?
//
//@Query("select c.* from company c inner join company_employee ce on ce.company_id = c.id inner join employee e on e.id = ce.employee_id where e.id = ?1;", nativeQuery = true)
//fun findCompany(employeeId: Long): CompanyQueryDto?
//
//fun findAllByEmployeeId(id:Long):List<Company>
//
//
//@Modifying
//@Transactional
//@Query(value = "delete from company_project where company_id = :roleId", nativeQuery = true)
//fun deleteRoleRight(@Param("roleId") roleId: Long?): Int