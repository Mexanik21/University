package uz.kayo.university.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import uz.kayo.university.entities.*
import uz.kayo.university.repositories.*


@Component
class DataLoader(
    private val universityRepository:UniversityRepository,
    private val facultyRepository: FacultyRepository,
    private val groupRepository: GroupRepository,
    private val studentRepository: StudentRepository,
    private val journalRepository: JournalRepository,
    private val subjectRepository: SubjectRepository,
    private val markRepository: MarkRepository,

): CommandLineRunner {



    override fun run(vararg args: String?)  {
        val univer1 = universityRepository.save(University("PDP","Tashkent",2022))
        val univer2 = universityRepository.save(University("MinFin","Tashkent",2020))

        val faculty1 = facultyRepository.save(Faculty("IT",univer1))
        val faculty2 = facultyRepository.save(Faculty("Iqtisod",univer1))
        val faculty3 = facultyRepository.save(Faculty("PED",univer1))
        val faculty4 = facultyRepository.save(Faculty("Iqtisod",univer2))

        val group1 = groupRepository.save(Group("101",faculty1,2018))
        val group2 = groupRepository.save(Group("102",faculty1,2019))
        val group3 = groupRepository.save(Group("104",faculty1,2020))

        val student1 = studentRepository.save(Student("Abdullaziz",group1))
        val student2 = studentRepository.save(Student("Abdulla",group1))
        val student3 = studentRepository.save(Student("Shodiyor",group1))
        val student4 = studentRepository.save(Student("Rustam",group1))
        val student5 = studentRepository.save(Student("Shahzod",group1))
        val student6 = studentRepository.save(Student("laziz",group1))

        val student7 = studentRepository.save(Student("Adxam",group2))
        val student8 = studentRepository.save(Student("Nodir",group3))

        val journal1 = journalRepository.save(Journal("101",group1))
        val journal2 = journalRepository.save(Journal("102",group2))
        val journal3 = journalRepository.save(Journal("104",group3))

        val subject1 = subjectRepository.save(Subject("Math",group1))
        val subject2 = subjectRepository.save(Subject("English",group1))
        val subject3 = subjectRepository.save(Subject("History",group1))
        val subject4 = subjectRepository.save(Subject("Language",group1))
        val subject5 = subjectRepository.save(Subject("Algebra",group1))

        val mark1 = markRepository.save(Mark(100,journal1,subject1,student1))
        val mark2 = markRepository.save(Mark(99,journal1,subject2,student1))
        val mark3 = markRepository.save(Mark(98,journal1,subject3,student1))
        val mark4 = markRepository.save(Mark(100,journal1,subject4,student1))
        val mark5 = markRepository.save(Mark(90,journal1,subject5,student1))

        val mark6 = markRepository.save(Mark(50,journal1,subject1,student2))
        val mark7 = markRepository.save(Mark(80,journal1,subject2,student2))
        val mark8 = markRepository.save(Mark(75,journal1,subject3,student2))
        val mark9 = markRepository.save(Mark(78,journal1,subject4,student2))
        val mark10 = markRepository.save(Mark(99,journal1,subject5,student2))

        val mark11 = markRepository.save(Mark(100,journal1,subject1,student3))
        val mark12 = markRepository.save(Mark(75,journal1,subject2,student3))
        val mark13 = markRepository.save(Mark(100,journal1,subject3,student3))
        val mark14 = markRepository.save(Mark(65,journal1,subject4,student3))
        val mark15 = markRepository.save(Mark(100,journal1,subject5,student3))

        val mark16 = markRepository.save(Mark(100,journal1,subject1,student4))
        val mark17 = markRepository.save(Mark(100,journal1,subject2,student4))
        val mark18 = markRepository.save(Mark(100,journal1,subject3,student4))
        val mark19 = markRepository.save(Mark(100,journal1,subject4,student4))
        val mark20 = markRepository.save(Mark(100,journal1,subject5,student4))

        val mark21 = markRepository.save(Mark(60,journal1,subject1,student5))
        val mark22 = markRepository.save(Mark(100,journal1,subject2,student5))
        val mark23 = markRepository.save(Mark(50,journal1,subject3,student5))
        val mark24 = markRepository.save(Mark(20,journal1,subject4,student5))
        val mark25 = markRepository.save(Mark(100,journal1,subject5,student5))

        val mark26 = markRepository.save(Mark(60,journal1,subject1,student6))
        val mark27 = markRepository.save(Mark(20,journal1,subject2,student6))
        val mark28 = markRepository.save(Mark(50,journal1,subject3,student6))
        val mark29 = markRepository.save(Mark(20,journal1,subject4,student6))
        val mark30 = markRepository.save(Mark(100,journal1,subject5,student6))






    }
}