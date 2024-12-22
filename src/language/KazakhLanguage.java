
package language;

import java.io.Serializable;

public class KazakhLanguage implements LanguageInterface, Serializable {
	

		private static final long serialVersionUID = -631111173651200334L;
		//---------------------------------------------------------------------------------------------------------------
		@Override
		public void newNotifications() {
			System.out.println("----Жаңа хабарлама----");
			
		}
		@Override
		public String handleEventUser(String paper, String journal, String firstName, String lastName) {
			return "Қымбатты " + firstName +" "+lastName + " to " + journal + " добавлены новые статьи!\n" + paper;
			
		}

		@Override
		public void news() {
			System.out.println("----Жаңалықтар----");
			
		}

		@Override
		public void noNews() {
			System.out.println("Жаңалықтар жоқ");
			
		}

		@Override
		public void enterTheNumberOfTheNews() {
			System.out.println("Көру үшін жаңалықтар нөмірін немесе шығу үшін 0 енгізіңіз:");
			
		}

		@Override
		public void selectedNews() {
			System.out.println("----Таңдаулы жаңалықтар----");
			
		}

		@Override
		public void doYouWantToAddAComment() {
			System.out.println("Пікір қосқыңыз келе ме? (+/-)");
			
		}

		@Override
		public void yourDecidedThatNoWant() {
			System.out.println("Сіз пікір қоспаймын, деп шешім қабылдадыңыз");
			
		}

		@Override
		public void noCommentsAvailable() {
			System.out.println("Пікірлер жоқ");
			
		}

		@Override
		public void comments() {
			System.out.println("----Пікірлер----");
			
		}

		@Override
		public void enterYourComment() {
			System.out.println("----Өзіңіздің пікіріңізді жазыңыз----");
			
		}

		@Override
		public void commentAddSuccesfully() {
			System.out.println("Пікір сәтті енгізілді.");
			
		}
	//---------------------------------------------------------------------------------------------------------------
		public String studentHeader() {
			return "----Студент мәзірі----";
		}
		
		@Override
	    public String[] studentMenu() {
	        return new String[] {
	            "Транскрипті көру",
	            "Курс бойынша бағаларды көру",
	            "Курсқа тіркелу",
	            "Курс бойынша мұғалімдерді көру",
	            "Барлық курстарды көру",
	            "Қол қойылған журналдарды қарау",
	            "Мұғалімді бағалау",
	            "Ұйымдар",
	            "Жаңалықтарды көру",
	            "Журналға жазылу",
	            "Барлық құжаттарды қарау",
	            "Тілді өзгерту",
	            "Журналдан бас тарту",
	            "Шығу"
	        };
	    }
		
		@Override
		public void viewTranscript() {
			// TODO Auto-generated method stub
			System.out.println("Транскрипт:");
		}

		@Override
		public void courseDoesntHaveMarks() {
			System.out.println("Курс бойынша бағалар жоқ.");
			
		}

		@Override
		public void studentNotRegisteredForThisCourse() {
			System.out.println("Студент осы курсқа жазылмаған.");
			
		}
		
		@Override
		public void courseMark(String courseName, String mark) {
			System.out.println("Курс: " + courseName + " Бағалар: " + mark);
			
		}

		@Override
		public void courseRegistrationSuccesfully(String courseName) {
			System.out.println("Курс: " + courseName + " тіркелу сәтті аяқталды!");
			
		}

		@Override
		public void teacherForCourse(String courseName) {
			System.out.println("Курс бойынша мұғалім " + courseName);
			
		}

		@Override
		public void pleaseSelectTheTeacherYourWantToEvaluate() {
			System.out.println("Баға бергіңіз келетін мұғалімді таңдаңыз:");
			
		}

		@Override
		public void yourAssessmentOfThisTeacher() {
			System.out.println("Осы мұғалімді қалай бағалайсыз:");
			
		}

		@Override
		public String[] organisationMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"Ұйымға тіркелу",
					"Ұйымнан кету",
					"Жаңа ұйым құрастыру",
			};
		}

		@Override
		public void listOfOrganisation() {
			System.out.println("Ұйымдар тізімі:");
			
		}

		@Override
		public void atTheMomentWeDontHaveAnyOrganizations() {
			System.out.println("Осы сәтте ұйымдар тіркелмеген");
			
		}

		@Override
		public void nameYourOrganisation() {
			System.out.println("Өзіңіздің ұйымыңыздың атын атаңыз:");
			
		}

		@Override
		public void whatDoYouWantToChange() {
			System.out.println("Нені өзгерткіңіз келеді:");
			
		}
		public String[] studentResearcherMenu() {
	        return new String[] {
        		"Транскрипті көру",
	            "Курс бойынша бағаларды көру",
	            "Курсқа тіркелу",
	            "Курс бойынша мұғалімдерді көру",
	            "Барлық курстарды көру",
	            "Қол қойылған журналдарды қарау",
	            "Мұғалімді бағалау",
	            "Ұйымдар",
	            "Жаңалықтарды көру",
	            "Журналға жазылу",
	            "Барлық құжаттарды қарау",
	            "Тілді өзгерту",
	            "Журналдан бас тарту",
	            "Шығу",
	            "Зерттеуші мәзірін көру"
	        };
	    }
	//---------------------------------------------------------------------------------------------------------------
		
		public String teacherHeader() {
			return "----Мұғалім мәзірі----";
		}
		
		@Override
		public String[] teacherMenu() {
			return new String[] {
		            "Курстарды көру",
		            "Студенттерді көру",
		            "Бағаларды көру",
		            "Баға қою",
		            "Рейтингті қарау",
		            "Бір жаңалықты көру",
		            "Тапсырып беру",
		            "Сұраныс жіберу",
		            "Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
		            "Шығу"
		        };
			
		}
		
		@Override
		public void courseTaughtBy(String username) {
			System.out.println("Оқытылатын курстар " +username + ":");
			
			
		}

		@Override
		public void studentsEnrolledIn(String selectedCourseName) {
			System.out.println("Оқушылар тіркелді " + selectedCourseName + ":");
			
		}

		@Override
		public void marksFor(String selectedCourseName) {
			System.out.println(selectedCourseName+ " бойынша бағалар:");
			
		}

		@Override
		public void noMarks(String mark, String studentUsername) {
			System.out.println(studentUsername + ": " + (mark!= null) + " баға тіркелмеген");
			
		}

		@Override
		public void noStudentEnrolledIn(String selectedCourseName) {
			System.out.println("Ни один студент не записался " + selectedCourseName);
			
		}

		@Override
		public void previousMarksForStudent(String selectedStudentUsername, String mark) {
			System.out.println("Предыдущие оценки ученика:" + selectedStudentUsername + ": " + mark);
			
		}

		@Override
		public void newMarksForStudents(String selectedStudentUsername) {
			System.out.println(selectedStudentUsername + " студент үшін жаңа баға" );
			
		}

		@Override
		public void teachersRating(double rate) {
			System.out.println("Мұғалімнің рейтингі:" + rate);
			
		}
		
		@Override
		public void enterTheCourse() {
			System.out.println("Курсты басыңыз.");
			
		}

		@Override
		public void noLessonsForThisCourse() {
			System.out.println("Осы курс бойынша сабақтар тіркелмеген.");
			
		}

		@Override
		public void selectSCourseToInputMarks() {
			System.out.println("s курс бойынша баға қою.");
			
		}

		@Override
		public void yourAreNotAssignedToAnyCourses() {
			System.out.println("Сіз бұл курсқа тіркелмегенсіз.");
			
		}

		@Override
		public void noLessonsRecordedForTheCourse() {
			System.out.println("Осы курс бойынша ешқандар сабақтар тіркелмеген.");
			
		}

		@Override
		public void selectAStudentToInputMarks() {
			System.out.println("Баға қою үшін студентті белгілеңіз:");
			
		}

		@Override
		public void chooseAStudentOrExit() {
			
			System.out.println("Студентті таңдаңыз немесе 0-ді басып артақ қайтыңыз");
			
		}

		@Override
		public void firstAttestation() {
			System.out.println("Бірінші аттестация:");
			
		}

		@Override
		public void secondAttestation() {
			System.out.println("Екінші аттестация:");
			
		}

		@Override
		public void finalExam() {
			System.out.println("Соңғы экзамен:");
			
		}

		@Override
		public void theMarksHaveBennSubmittedSuccesfully() {
			System.out.println("Бағалар сәтті жіберілді.");
			
		}

		@Override
		public void ErrorPleaseEnterMarksCorrectly() {
			System.out.println("Қате: Бағаларды дұрыс жазуыңызды сұраймыз.");
			
		}

		@Override
		public String[] teacherResearcherMenu() {

			return new String[] {
		            "Курстарды қарау",
		            "Студенттерді қарау",
		            "Бағаларды көру",
		            "Баға қою",
		            "Рейтингі көру",
		            "Бір жаңалықты көру",
		            "Тапсырыс беру",
		            "Сұраныс жіберу",
		            "Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
		            "Шығу",
		            "Зерттеуші мәзірін көру"
		        };
		}
	//---------------------------------------------------------------------------------------------------------------
		public String adminHeader() {
			return "----Админ мәзірі----";
		}
		
		@Override
		public String[] adminMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"Жаңа пайдаланушы жасаңыз", 
					"Посмотреть всех пользователей", 
					"Барлық пайдаланушыларды көру", 
					"Пайдаланушыны жою", 
					"Журнал файлдарын қарау",
					"Тілді өзгерту", 
					"Шығу"
			};
		}
		@Override
		public String[] addResearcherOptions() {
			// TODO Auto-generated method stub
			return new String[] {
					"Бар пайдаланушыға зерттеушіні қосыңыз", 
					"Жаңа пайдаланушыдан зерттеуші жасаңыз"
					};
		}
		@Override
		public void whatDoYouWantToDo() {
			// TODO Auto-generated method stub
			System.out.println("Сіз не істегіңіз келеді?");
		}

		@Override
		public void chooseUser() {
			// TODO Auto-generated method stub
			System.out.println("Пайдаланушыны таңдаңыз:");
		}

		@Override
		public void whichUserDoYouWantToCreate() {
			// TODO Auto-generated method stub
			System.out.println("Сіз қандай пайдаланушы жасағыңыз келеді?");
		}

		@Override
		public String[] addResearcherOptionsCreate() {
			// TODO Auto-generated method stub
			return new String[] {
					"Студент","Аспирант","Қызметкер","Мұғалім","Менеджер","техникалық маман","Декан"
			};
		}

		@Override
		public String[] createUserOptions() {
			// TODO Auto-generated method stub
			return new String[] {
					"Студент","Аспирант", "Зерттеуші", "Қызметкер","Мұғалім","Менеджер","техникалық маман","Декан",
			};
		}

		@Override
		public void updateUserWhichUserDoYouWantToChange() {
			// TODO Auto-generated method stub
			System.out.println("Қай пайдаланушыны өзгерткіңіз келеді? немесе артқа қайту үшін 0-ді басыңыз");
		}

		@Override
		public void removeUserChooseUserToDelete() {
			// TODO Auto-generated method stub
			System.out.println("Жойылатын пайдаланушыны таңдаңыз:");
		}

		@Override
		public void seeLogFilesChooseUserToSeeLogs() {
			// TODO Auto-generated method stub
			System.out.println("Журналдарды көру үшін пайдаланушыны таңдаңыз:");
		}

		@Override
		public void seeLogFilesNoLogsForThisUser() {
			// TODO Auto-generated method stub
			System.out.println("Бұл пайдаланушы үшін журналдар жоқ.");
		}
	//---------------------------------------------------------------------------------------------------------------
		public String managerHeader() {
			return "----Менеджер мәзірі----";
		}
		
		@Override
		public String[] managerMenu() {
			// TODO Auto-generated method stub
			return new String[] { 
					"Статистикалық есепті құру", 
					"Курс қосыңыз", 
					"Мұғалімге сабақ қосу", 
					"Жаңалық жасау",
					"Сұрауларды қарау", 
					"Жаңалықты өңдеу", 
					"Мұғалімге курс тағайындаңыз", 
					"Оқушыларды көру", 
					"Мұғалімдерді көру", 
					"Журнал жасаңыз",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу" 
			};
		}
		
		
		@Override
		public void GPAMAX(double gpamax) {
			System.out.println("4.0 GPA бар студенттер саны:" + gpamax);
			
		}

		@Override
		public void GPAHIGH(double gpahigh) {
			System.out.println("GPA 3,99 мен 3,00 аралығындағы студенттер саны:" + gpahigh);
			
		}
		
		@Override
		public void GPAMEDIUM(double gpamedium) {
			System.out.println("GPA 2,99 мен 2,00 аралығындағы студенттер саны:" + gpamedium);
			
		}

		@Override
		public void COUNTOTHER(double contother) {
			System.out.println("GPA 2.00 төмен студенттер саны:" + contother);
			
		}

		@Override
		public void hINDEX(String maxResearcher) {
			System.out.println("Ең жоғары h-индексі бар зерттеуші:" + maxResearcher);
			
		}

		@Override
		public void enterTheNumverOfCreditsOfTheCourse() {
			System.out.println("Курс кредиттерінің санын енгізіңіз:");
			
		}

		@Override
		public void enterNameOfCourse() {
			System.out.println("Курс атын енгізіңіз:");
			
		}

		@Override
		public void chooseForWhichFacultyIsThisCouse() {
			System.out.println("Бұл курс қай кафедраға арналғанын таңдаңыз:");
			
		}

		@Override
		public void chooseTypeOfThisCoursefor(String faculty) {
			System.out.println("Осы курс түрін таңдаңыз" + faculty + ":");
			
		}

		@Override
		public void courseAdded(String newCourse) {
			System.out.println(newCourse + " курс қосылды.");
			
		}

		@Override
		public void chooseType() {
			System.out.println("Түрді таңдаңыз:");
			
		}

		@Override
		public void newTopic() {
			System.out.println("Жаңалық тақырыбы:");
			
		}

		@Override
		public void newTitle() {
			System.out.println("Жаңалық атауы:");
			
		}

		@Override
		public void newText() {
			System.out.println("Жаңалық мәтіні:");
			
		}

		@Override
		public void listOfRequests() {
			System.out.println("Өтініштер тізімі:");
			
		}

		@Override
		public void whatNewsDoYouWantToChange() {
			System.out.println("Қандай жаңалықты өзгерткіңіз келеді?");
		}

		@Override
		public void whichOfPartDoYouWantToChange() {
			System.out.println("Қай бөлікті өзгерткіңіз келеді?" + "\n 1 - Тақырып" + "\n 2 - Аты"
					+ "\n 3 - Текст" + "\n 0 - Шығу");
			
		}

		@Override
		public void enterNewTopic() {
			System.out.println("Жаңа тақырып енгізіңіз:");
			
		}

		@Override
		public void updateNews(String news) {
			System.out.println("Жаңалықтар жаңартуы:" + news);
			
		}

		@Override
		public void enterNewTitle() {
			System.out.println("Жаңа атау енгізіңіз:");
			
		}

		@Override
		public void enterNewText() {
			System.out.println("Жаңа мәтін енгізіңіз::");
			
		}

		@Override
		public void whichCourseYouWantToAssign() {
			System.out.println("Тіркелгін келетін курстарыңыз:");
			
		}

		@Override
		public void whichTeacherWouldYouLikeToAssignThe(String courseName) {
			System.out.println(courseName + " курсты қай мұғалімге тіркегіңіз келеді?");
			
		}

		@Override
		public void assignedTo(String courseName, String teacherFirstName, String teacherLastName) {
			System.out.println(courseName + " курсы тіркелді: " + teacherFirstName + " " + teacherLastName);
			
		}

		@Override
		public void whichTeacherWouldYouLikeToAddTheLesson() {
			System.out.println("Қай мұғалімге сабақ қосқыңыз келеді?");
			
		}

		@Override
		public void noCoursesForThisTeacher() {
			System.out.println("Бұл мұғалімге арналған курстар жоқ");
			
		}

		@Override
		public void toWhichCourseOf(String teacherName, String teacherLastName) {
			System.out.println("Қайсқы курсқа: " + teacherName + " " + teacherLastName + " сабаққа тіркегіңіз келеді?");
			
		}

		@Override
		public void enterTheTypeOfLesson() {
			System.out.println("Сабақ түрін енгізіңіз:");
			
		}

		@Override
		public void enterTheDay() {
			System.out.println("Күнді енгізіңіз:");
			
		}

		@Override
		public void enterTheLessonStartTime() {
			System.out.println("Сабақтың басталу уақытын енгізіңіз:");
			
		}

		@Override
		public void enterTheRoom() {
			System.out.println("Кабинет нөмірін енгізіңіз:");
			
		}

		@Override
		public void added(String newLesson) {
			System.out.println(newLesson + " қосылды.");
			
		}

		@Override
		public void enterTheName() {
			System.out.println("Есім енгізіңіз:");
			
		}

		@Override
		public void newJournalCreated(String newJournal) {
			System.out.println(newJournal + " атты жаңа журнал жасалды.");
			
		}

		@Override
		public String[] managerResearcherMenu() {
			// TODO Auto-generated method stub
			return new String[] { 
					"Статистикалық есепті құру", 
					"Курс қосыңыз", 
					"Мұғалімге сабақ қосу", 
					"Жаңалық жасау",
					"Сұрауларды қарау", 
					"Жаңалықты өңдеу", 
					"Мұғалімге курс тағайындаңыз", 
					"Оқушыларды көру", 
					"Мұғалімдерді көру", 
					"Журнал жасаңыз",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу",
					"Зерттеуші мәзірін қарау"
			};
		}
	//---------------------------------------------------------------------------------------------------------------
		public String FinanceManagerHeader() {
			return "---- Қаржы менеджер мәзірі----";
		}
		
		@Override
		public String[] FinanceManagerMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"Сұраныстарды қарау",
					"Сұраныстарды қабылдау", 
					"Сұраныстарды қабылдамау",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу" 
					};
		}
		@Override
		public void updatePaymentStatus() {
			System.out.println ("Студенттің төлемі туралы ақпарат жаңартылды");
			
		}
		@Override
		public void handleCheckFeeStatusTrue() {
			 System.out.println ("Жарна төленді");
			
		}
		@Override
		public void handleCheckFeeStatusFalse() {
			System.out.println ("Жарна әлі төленбеген");
			
		}
		@Override
		public void giveScholarshipd() {
			System.out.println ("Студентке стипендия беріледі");
			
		}
		@Override
		public void notGiveScholarshipd() {
			System.out.println ("Студентке стипендия берілмейді");
		}
		@Override
		public void distributeSalary() {
			System.out.println ("Қызметкердің жалақысын енгізіңіз");
			
		}
		@Override
		public void haveSalary() {
			System.out.println ("Қызметкерге жалақы бөлінеді");
			
		}
		@Override
		public void haveNotSalary() {
			System.out.println ("Қызметкерге жалақы бөлінбейді");
			
		}
		

		@Override
		public String[] FinanceManagerResearcherMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"Сұраныстарды қарау",
					"Сұраныстарды қабылдау", 
					"Сұраныстарды қабылдамау",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу",
					"Зерттеуші мәзірін қарау"
					};
		}
	//---------------------------------------------------------------------------------------------------------------
		public String deanHeader() {
			return "----Декан мәзірі----";
		}
		
		@Override
		public String[] deanMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"Курстарды көру",
		            "Студенттерді көру",
		            "Бағаларды көру",
		            "Баға қою",
					"Барлық сұраныстарды қарау",
					"Сұраныстарға қол қою", 
					"Бір жаңалықты қарау",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу"
			};
		}
		
		@Override
		public void chooseFaculty() {
			System.out.println("Факультетті таңдаңыз:");
			
		}

		@Override
		public void noRequests() {
			System.out.println("Сұраныстар жоқ!");
			
		}

		@Override
		public void emergencyRequests() {
			System.out.println("----Төтенше жағдайдағы сұраныстар----");
			
		}

		@Override
		public void enterTheRequestNumberToSign() {
			System.out.println("Қол қою үшін сұрау нөмірін енгізіңіз (немесе шығу үшін 0):");
			
		}

		@Override
		public void deanSignedRequest(String selectedRequest) {
			System.out.println("Декан қол қойды:" + selectedRequest);
			
		}

		@Override
		public void TheRequestWasSuccesfully() {
			System.out.println("Сұрауға сәтті қол қойылды және жойылды.");
			
		}

		@Override
		public String[] deanResearcherMenu() {
			
			return new String[] {
					"Курстарды көру",
		            "Студенттерді көру",
		            "Бағаларды көру",
		            "Баға қою",
					"Барлық сұраныстарды қарау",
					"Сұраныстарға қол қою", 
					"Бір жаңалықты қарау",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
					"Шығу",
					"Зерттеуші мәзірін қарау"
			};
		}
	//---------------------------------------------------------------------------------------------------------------
		public String graduateStudentHeader() {
			return "----Аспирант мәзірі----";
		}
		
		@Override
		public String[] graduateStudentMenu() {
			// TODO Auto-generated method stub
			return new String[] { 
					"Транскрипті көру", 
					"Курс бойынша бағаларды көру", 
					"Курсқа тіркелу",
					"Курс мұғалімдерін қараңыз", 
					"Барлық курстарды көру", 
					"Мұғалімдерді бағалаңыз", 
					"Ұйымдар", 
					"Бір жаңалықты қараңыз",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу", 
					"Зерттеуші мәзірін көру" 
					};
		}
		
		@Override
		public void newGrade(String grade) {
			System.out.println("Жаңа баға: " + grade);
			
		}
	//---------------------------------------------------------------------------------------------------------------
		public String employeeHeader() {
			return "----Қызметкер мәзірі----";
		}
		
		@Override
		public String[] employeeMenu() {
			// TODO Auto-generated method stub
			return new String[]{
					"Сұраныс жіберу", 
					"Тапсырыс беру", 
					"Бір жаңалықты қарау",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу"
					};
		}
		
		@Override
		public void SendingMessageTo(String message, String Username) {
			System.out.println(Username + " хабарлама жіберді: " + message);
			
		}

		@Override
		public void noDeans() {
			System.out.println("Декан жоқ");
		}

		@Override
		public void chooseTheDean() {
			System.out.println("Деканды таңдаңыз:");
			
		}

		@Override
		public void enterTheEmergencyLevel() {
			System.out.println("Төтенше жағдай деңгейін енгізіңіз:");
			
		}

		@Override
		public void enterTheMessage() {
			System.out.println("Хабарламаны енгізіңіз:");
			
		}

		@Override
		public void sentSuccesfully(String newRequest) {
			System.out.println(newRequest + " сәтті жіберілді!");
			
		}

		@Override
		public void noTechSupports() {
			System.out.println("Ешқандай техникалық көмек жоқ");
			
		}

		@Override
		public void chooseTheTechSupport() {
			System.out.println("Техникалық көмекті таңдаңыз:");
			
		}

		@Override
		public String[] employeeResearcherMenu() {
			
			return new String[]{
					"Сұраныс жіберу", 
					"Тапсырыс беру", 
					"Бір жаңалықты қарау",
					"Барлық құжаттарды қарау",
		            "Тілді өзгерту",
		            "Журналға жазылу",
		            "Журналдан бас тарту",
					"Шығу",
					"Зерттеуші мәзірін қарау"
					};
		}
	//---------------------------------------------------------------------------------------------------------------
		public String researcherHeader() {
			return "----Зерттеуші мәзірі----";
		}
		
		@Override
		public String[] researcherMenu() {
			// TODO Auto-generated method stub
			return new String[] {
					"Құжаттарды қарау", 
					"Құжат құрастыру", 
					"Проект көру", 
					"Журналдарды қарау", 
					"Журналға мақала қосыңыз", 
					"Жоба құру",
					"Жобаға қағаз қосу",
					"Шығу"
			};
		}
		
		@Override
		public void noPapers() {
			System.out.println("Құжат жоқ");
			
		}

		@Override
		public void noProjects() {
			System.out.println("Проект жоқ");
			
		}

		@Override
		public void noJournals() {
			System.out.println("Журнал жоқ");
			
		}

		@Override
		public void chooseTheJournal() {
			System.out.println("Журналды таңдаңыз:");
			
		}

		@Override
		public void choosePaperToAdd() {
			System.out.println("Құжатты таңдаңыз:");
			
		}

		@Override
		public void addedTo(String paper, String journalName) {
			System.out.println(paper + " " + journalName + "-ға сәтті қосылды!");	
		}

		@Override
		public void enterTheNumberOfPages() {
			System.out.println("Беттер санын енгізіңіз:");
			
		}

		@Override
		public void enterValidNumberOfPages() {
			System.out.println("Шектеу қойылған беттер санын енгізіңіз.");
			
		}

		@Override
		public void enterValidNumber() {
			System.out.println("Жарамды нөмерді енгізіңіз!");
			
		}

		@Override
		public void enterTheDoi() {
			System.out.println("doi енгізіңіз:");
			
		}

		@Override
		public void newPaperAdded(String newPaper) {
			System.out.println(newPaper + " атты жаңа құжат сәтті қосылды!");
			
		}
	//---------------------------------------------------------------------------------------------------------------
		
		@Override
		public void enterReturnBack() {
			// TODO Auto-generated method stub
			System.out.println("Артқа қайту үшін, 0-ді басыңыз.");
		}


		@Override
		public void noCoursesYet() {
			System.out.println("Қазіргі сәтті курстар жоқ.");
			
		}

		@Override
		public void noCourses() {
			System.out.println("Курстар жоқ.");
			
		}

		@Override
		public void allCourses() {
			System.out.println("Барлық курстар:");
			
		}

		@Override
		public void enterYourChoice() {
			System.out.println("Таңдаңыз:");
			
		}

		@Override
		public void noTeachers() {
			System.out.println("Мұғалімдер жоқ.");
			
		}

		@Override
		public void courses() {
			System.out.println("Курстар:");
			
		}


		@Override
		public String[] changeInfoOptions() {
			// TODO Auto-generated method stub
			return new String[] {
					"Пайдаланушы аты",
					"Құпиясөх",
					"Есімі",
					"Фамилиясы"
			};
		}

		@Override
		public void enterNewUsername() {
			System.out.println("Жаңа пайдаланушы атын енгізіңіз");
			
		}

		@Override
		public void enterNewPassword() {
			System.out.println("Жаңа құпия сөзді енгізіңіз");
			
		}

		@Override
		public String enterNewFirstName() {
			return "Жаңа есім енгізіңіз";
			
		}

		@Override
		public String enterNewLastName() {
			return "Жаңа фамилия енгізіңіз";
			
		}
		@Override
		public String paymentFee() {
			return "Төлем жасалынды";
		}
		@Override
		public String enterStudentUsername() {
			return"Студенттің атын енгізіңіз:";
		}
		@Override
		public String studentNotFound() {
			return "Студент табылмады";
		}
		@Override
		public String employeeNotFound() {
			return "Қызметкер табылмады";
		}
		@Override
		public String enterEmployeeUsername() {
			return "Қызметкердің атын енгізіңіз:";
		}
		
		
}
