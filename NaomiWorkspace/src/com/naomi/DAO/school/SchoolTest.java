package com.naomi.DAO.school;

public class SchoolTest {

	public static void main(String[] args) {

//		String password = "1234";
		String password = "Nbar2000";
		try {
			SchoolDao schoolDao = new SchoolDao(password,true);
			StudentDao studentDao = new StudentDao(password,true);
			for(int i=0; i<3; i++) {
				School school = new School("school " + (i+1), "Jerusalem");
				schoolDao.saveSchool(school);
				System.out.println("save school " + (i+1));
				for(int j=0; j<10; j++) {
					String name = "student " + (j+1);
					Student student = new Student((i+1), name, name + "@gmail.com");
					studentDao.saveStudent(student);
					System.out.println("save student " + (j+1));
				}
			}
			schoolDao.updateSchool(new School(1, "new school", "Tel-Aviv"));
			studentDao.updateStudent(new Student(1, 1, "Naomi Bar", "naomibar9@gmail.com"));
			
			System.out.println("\n\t Schools:");
			System.out.println(schoolDao.readAllSchools());
			System.out.println("\n\t Students:");
			System.out.println(studentDao.readAllStudents());
			
			studentDao.dropTable();
			schoolDao.dropTable();

		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

}
