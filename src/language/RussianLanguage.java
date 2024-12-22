
package language;

import java.io.Serializable;

public class RussianLanguage implements LanguageInterface, Serializable {


	

	private static final long serialVersionUID = 707219517502738974L;
	//---------------------------------------------------------------------------------------------------------------
	@Override
	public void newNotifications() {
		System.out.println("----Новое уводомление----");
		
	}
	@Override
	public String handleEventUser(String paper, String journal, String firstName, String lastName) {
		return "Дорогой/Дорогая " + firstName +" "+lastName + " to " + journal + " добавлены новые статьи!\n" + paper;
		
	}

	@Override
	public void news() {
		System.out.println("----Новости----");
		
	}

	@Override
	public void noNews() {
		System.out.println("Нет новости");
		
	}

	@Override
	public void enterTheNumberOfTheNews() {
		System.out.println("Введите номер новости для просмотра или 0 для выхода:");
		
	}

	@Override
	public void selectedNews() {
		System.out.println("----Избранные новости----");
		
	}

	@Override
	public void doYouWantToAddAComment() {
		System.out.println("Хотите добавить комментарий? (+/-)");
		
	}

	@Override
	public void yourDecidedThatNoWant() {
		System.out.println("Вы решили, что не хотите оставлять комментарий");
		
	}

	@Override
	public void noCommentsAvailable() {
		System.out.println("Нет доступных комментариев");
		
	}

	@Override
	public void comments() {
		System.out.println("----Комментарии----");
		
	}

	@Override
	public void enterYourComment() {
		System.out.println("----Введите свой комментарий----");
		
	}

	@Override
	public void commentAddSuccesfully() {
		System.out.println("Комментарий успешно добавлен");
		
	}
//---------------------------------------------------------------------------------------------------------------
	public String studentHeader() {
		return "----Меню Студента----";
	}
	
	@Override
    public String[] studentMenu() {
        return new String[] {
            "Просмотр Транскрипта",
            "Просмотр Оценок по Курсу",
            "Регистрация на Курс",
            "Просмотр Преподавателя по Курсу",
            "Просмотр Всех Курсов",
            "Просмотр подписанных журналов",
            "Оценить Преподавателей",
            "Организация",
            "Просмотр Новостей",
            "Подписаться на журнал",
            "Посмотреть все научные бумаги",
            "Изменить язык",
            "Отписаться от журнала",
            "Выйти"
        };
    }
	
	@Override
	public void viewTranscript() {
		// TODO Auto-generated method stub
		System.out.println("Транскрипт:");
	}

	@Override
	public void courseDoesntHaveMarks() {
		System.out.println("Курс без оценок.");
		
	}

	@Override
	public void studentNotRegisteredForThisCourse() {
		System.out.println("Студент не зарегистрирован на этот курс.");
		
	}
	
	@Override
	public void courseMark(String courseName, String mark) {
		System.out.println("Курс: " + courseName + " Оценки: " + mark);
		
	}

	@Override
	public void courseRegistrationSuccesfully(String courseName) {
		System.out.println("Курс: " + courseName + " регистрация прошла успешно!");
		
	}

	@Override
	public void teacherForCourse(String courseName) {
		System.out.println("Преподаватели на курс " + courseName);
		
	}

	@Override
	public void pleaseSelectTheTeacherYourWantToEvaluate() {
		System.out.println("Пожалуйста, выберите преподавателя, которого хотите оценить:");
		
	}

	@Override
	public void yourAssessmentOfThisTeacher() {
		System.out.println("Ваша оценка этому преподавателю:");
		
	}

	@Override
	public String[] organisationMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"Вступить в организацию",
				"Уйти из организации",
				"Создать организацию",
		};
	}

	@Override
	public void listOfOrganisation() {
		System.out.println("Список организаций:");
		
	}

	@Override
	public void atTheMomentWeDontHaveAnyOrganizations() {
		System.out.println("В данный момент у нас нету организаций");
		
	}

	@Override
	public void nameYourOrganisation() {
		System.out.println("Назовите свою организацию");
		
	}

	@Override
	public void whatDoYouWantToChange() {
		System.out.println("Что вы хотите изменить:");
		
	}
	public String[] studentResearcherMenu() {
        return new String[] {
    		"Просмотр Транскрипта",
            "Просмотр Оценок по Курсу",
            "Регистрация на Курс",
            "Просмотр Преподавателя по Курсу",
            "Просмотр Всех Курсов",
            "Просмотр подписанных журналов",
            "Оценить Преподавателей",
            "Организация",
            "Просмотр Новостей",
            "Подписаться на журнал",
            "Посмотреть все научные бумаги",
            "Изменить язык",
            "Подписаться на журнал",
            "Отписаться от журнала",
            "Выйти",
            "Посмотреть меню исследователя",
        };
    }
//---------------------------------------------------------------------------------------------------------------
	public String teacherHeader() {
		return "----Меню Учителя----";
	}
	
	@Override
	public String[] teacherMenu() {
		return new String[] {
	            "Просмотр курсов",
	            "Просмотр студентов",
	            "Просмотр оценок",
	            "Поставить оценки",
	            "Оценка просмотров",
	            "Просмотреть одну новость",
	            "Отправить заказ",
	            "Отправить запрос",
	            "Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
	            "Выйти"
	        };
		
	}
	
	@Override
	public void courseTaughtBy(String username) {
		System.out.println("Курсы, преподаваемые " +username + ":");
		
		
	}

	@Override
	public void studentsEnrolledIn(String selectedCourseName) {
		System.out.println("Студенты, зачисленные в " + selectedCourseName + ":");
		
	}

	@Override
	public void marksFor(String selectedCourseName) {
		System.out.println("Оценки за " + selectedCourseName+ ":");
		
	}

	@Override
	public void noMarks(String mark, String studentUsername) {
		System.out.println(studentUsername + ": " + (mark!= null) + " No marks");
		
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
		System.out.println("Новые оценки для ученика:" + selectedStudentUsername);
		
	}

	@Override
	public void teachersRating(double rate) {
		System.out.println("Рейтинг учителя:" + rate);
		
	}
	
	@Override
	public void enterTheCourse() {
		System.out.println("Нажмите на курс.");
		
	}

	@Override
	public void noLessonsForThisCourse() {
		System.out.println("Нету уроков для этого курса.");
		
	}

	@Override
	public void selectSCourseToInputMarks() {
		System.out.println("Выберите s курс для ввода оценок.");
		
	}

	@Override
	public void yourAreNotAssignedToAnyCourses() {
		System.out.println("Вам не назначены ни на какие курсы.");
		
	}

	@Override
	public void noLessonsRecordedForTheCourse() {
		System.out.println("Для курса не записано ни одного урока.");
		
	}

	@Override
	public void selectAStudentToInputMarks() {
		System.out.println("Выберите ученика для ввода оценок");
		
	}

	@Override
	public void chooseAStudentOrExit() {
		System.out.println("Выбирайте студента или нажмите 0 чтобы выйти.");
		
	}

	@Override
	public void firstAttestation() {
		System.out.println("Первая аттестация:");
		
	}

	@Override
	public void secondAttestation() {
		System.out.println("Вторая аттестация:");
		
	}

	@Override
	public void finalExam() {
		System.out.println("Финальный экзамен:");
		
	}

	@Override
	public void theMarksHaveBennSubmittedSuccesfully() {
		System.out.println("Оценки успешно отправлены.");
		
	}

	@Override
	public void ErrorPleaseEnterMarksCorrectly() {
		System.out.println("Ошибка: Пожалуйста напишите оценки правильно.");
		
	}

	@Override
	public String[] teacherResearcherMenu() {

		return new String[] {
	            "Просмотр курсов",
	            "Просмотр студентов",
	            "Просмотр оценок",
	            "Поставить оценки",
	            "Оценка просмотров",
	            "Просмотреть одну новость",
	            "Отправить заказ",
	            "Отправить запрос",
	            "Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
	            "Выйти",
	            "Посмотреть меню исследователя"
	        };
	}
//---------------------------------------------------------------------------------------------------------------
	public String adminHeader() {
		return "----Меню Админа----";
	}
	
	@Override
	public String[] adminMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"Создать нового пользователья", 
				"Посмотреть всех пользователей", 
				"Обновить информацию о пользователе", 
				"Удалить пользователья", 
				"Просмотреть файлы журналов",
				"Изменить языка",
				"Выйти"
		};
	}
	@Override
	public String[] addResearcherOptions() {
		// TODO Auto-generated method stub
		return new String[] {
				"Добавить исследователя к существующему пользователю", 
				"Создать исследователя из нового пользователя"
				};
	}
	@Override
	public void whatDoYouWantToDo() {
		// TODO Auto-generated method stub
		System.out.println("Что вы хотите сделать?");
	}

	@Override
	public void chooseUser() {
		// TODO Auto-generated method stub
		System.out.println("Выберите пользователя:");
	}

	@Override
	public void whichUserDoYouWantToCreate() {
		// TODO Auto-generated method stub
		System.out.println("Какого пользователя вы хотите создать?");
	}

	@Override
	public String[] addResearcherOptionsCreate() {
		// TODO Auto-generated method stub
		return new String[] {
				"Студент","Аспирант","Сотрудник","Преподаватель","Руководитель","Специалист техподдержки","Декан"
		};
	}

	@Override
	public String[] createUserOptions() {
		// TODO Auto-generated method stub
		return new String[] {
				"Студент","Аспирант", "Исследователь", "Сотрудник","Преподаватель","Руководитель","Специалист техподдержки","Декан"
		};
	}

	@Override
	public void updateUserWhichUserDoYouWantToChange() {
		// TODO Auto-generated method stub
		System.out.println("Какого пользователя вы хотите изменить? нажмите 0, чтобы вернуться назад");
	}

	@Override
	public void removeUserChooseUserToDelete() {
		// TODO Auto-generated method stub
		System.out.println("Выберите пользователя для удаления:");
	}

	@Override
	public void seeLogFilesChooseUserToSeeLogs() {
		// TODO Auto-generated method stub
		System.out.println("Выберите пользователя для просмотра журналов:");
	}

	@Override
	public void seeLogFilesNoLogsForThisUser() {
		// TODO Auto-generated method stub
		System.out.println("Для этого пользователя нет журналов.");
	}
//---------------------------------------------------------------------------------------------------------------
	public String managerHeader() {
		return "----Меню Менеджера----";
	}
	
	@Override
	public String[] managerMenu() {
		// TODO Auto-generated method stub
		return new String[] { 
				"Создать статистический отчет", 
				"Добавить курс", 
				"Добавить урок учителю", 
				"Создать новость",
				"Просмотр запросов", 
				"Редактировать новость", 
				"Назначить курс учителю", 
				"Просмотр студентов", 
				"Просмотр учителей", 
				"Создать журнал",
				"Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
				"Выйти"
		};
	}
	
	
	@Override
	public void GPAMAX(double gpamax) {
		System.out.println("Количество студентов со средним баллом 4.0:" + gpamax);
		
	}

	@Override
	public void GPAHIGH(double gpahigh) {
		System.out.println("Количество студентов со средним баллом от 3,99 до 3,00:" + gpahigh);
		
	}
	
	@Override
	public void GPAMEDIUM(double gpamedium) {
		System.out.println("Количество студентов со средним баллом от 2,99 до 2,00:" + gpamedium);
		
	}

	@Override
	public void COUNTOTHER(double contother) {
		System.out.println("Количество студентов со средним баллом менее 2,00:" + contother);
		
	}

	@Override
	public void hINDEX(String maxResearcher) {
		System.out.println("The researcher with the highest H-index:" + maxResearcher);
		
	}

	@Override
	public void enterTheNumverOfCreditsOfTheCourse() {
		System.out.println("Введите количество кредитов курса:");
		
	}

	@Override
	public void enterNameOfCourse() {
		System.out.println("Введите название курса:");
		
	}

	@Override
	public void chooseForWhichFacultyIsThisCouse() {
		System.out.println("Выберите, для какого факультета этот курс:");
		
	}

	@Override
	public void chooseTypeOfThisCoursefor(String faculty) {
		System.out.println("Выберите тип этого курса для" + faculty + ":");
		
	}

	@Override
	public void courseAdded(String newCourse) {
		System.out.println("Курс добавлен" + newCourse);
		
	}

	@Override
	public void chooseType() {
		System.out.println("Выберите тип:");
		
	}

	@Override
	public void newTopic() {
		System.out.println("Тема новости:");
		
	}

	@Override
	public void newTitle() {
		System.out.println("Название новости:");
		
	}

	@Override
	public void newText() {
		System.out.println("Текст новости:");
		
	}

	@Override
	public void listOfRequests() {
		System.out.println("Список запросов:");
		
	}

	@Override
	public void whatNewsDoYouWantToChange() {
		System.out.println("Какие новости вы хотите изменить?");
	}

	@Override
	public void whichOfPartDoYouWantToChange() {
		System.out.println("Какую часть вы хотите изменить?" + "\n 1 - Тема" + "\n 2 - Название"
				+ "\n 3 - Текст" + "\n 0 - Выйти");
		
	}

	@Override
	public void enterNewTopic() {
		System.out.println("Введите новую тему:");
		
	}

	@Override
	public void updateNews(String news) {
		System.out.println("Обновление новостей:" + news);
		
	}

	@Override
	public void enterNewTitle() {
		System.out.println("Введите новое название:");
		
	}

	@Override
	public void enterNewText() {
		System.out.println("Введите новый текст:");
		
	}

	@Override
	public void whichCourseYouWantToAssign() {
		System.out.println("Какой курс вы хотите назначить:");
		
	}

	@Override
	public void whichTeacherWouldYouLikeToAssignThe(String courseName) {
		System.out.println("Какому учителю вы бы хотели поручить" + courseName + " конечно?");
		
	}

	@Override
	public void assignedTo(String courseName, String teacherFirstName, String teacherLastName) {
		System.out.println(courseName + "назначен на" + teacherFirstName + " " + teacherLastName);
		
	}

	@Override
	public void whichTeacherWouldYouLikeToAddTheLesson() {
		System.out.println("К какому преподавателю вы бы хотели добавить урок?");
		
	}

	@Override
	public void noCoursesForThisTeacher() {
		System.out.println("Нет курсов для этого преподавателя");
		
	}

	@Override
	public void toWhichCourseOf(String teacherName, String teacherLastName) {
		System.out.println("К какому курсу" + teacherName + " " + teacherLastName + " хотите добавить урок?");
		
	}

	@Override
	public void enterTheTypeOfLesson() {
		System.out.println("Введите тип урока:");
		
	}

	@Override
	public void enterTheDay() {
		System.out.println("Введите день:");
		
	}

	@Override
	public void enterTheLessonStartTime() {
		System.out.println("Введите время начала урока:");
		
	}

	@Override
	public void enterTheRoom() {
		System.out.println("Введите номер кабинета");
		
	}

	@Override
	public void added(String newLesson) {
		System.out.println("Добавлен " + newLesson);
		
	}

	@Override
	public void enterTheName() {
		System.out.println("Введите имя:");
		
	}

	@Override
	public void newJournalCreated(String newJournal) {
		System.out.println("Создан новый журнал " + newJournal);
		
	}

	@Override
	public String[] managerResearcherMenu() {
		// TODO Auto-generated method stub
		return new String[] { 
				"Создать статистический отчет", 
				"Добавить курс", 
				"Добавить урок учителю", 
				"Создать новость",
				"Просмотр запросов", 
				"Редактировать новость", 
				"Назначить курс учителю", 
				"Просмотр студентов", 
				"Просмотр учителей", 
				"Создать журнал",
				"Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
				"Выйти",
				"Посмотреть меню исследователя"
		};
	}
//---------------------------------------------------------------------------------------------------------------
	public String FinanceManagerHeader() {
		return "----FinanceManager Menu----";
	}
	
	@Override
	public String[] FinanceManagerMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"Обновить статус оплаты",
				"Проверить статус оплаты",
				"Распределить стипендию",
				"Распределить зарплату",
				"Просмотреть все статьи",
				"Изменить язык",
				"Подписаться на журнал",
				"Отказаться от подписки на журнал",
				"Выйти"
				};
	}
	@Override
	public void handleCheckFeeStatusTrue() {
		 System.out.println("Взнос уже оплачен");
		
	}
	@Override
	public void handleCheckFeeStatusFalse() {
		System.out.println("Взнос еще не оплачен");
		
	}
	@Override
	public void giveScholarshipd() {
		System.out.println("Стипендия предоставляется студенту ");
	}
	@Override
	public void notGiveScholarshipd() {
		System.out.println("Учащийся недостаточно квалифицирован ");
		
	}
	@Override
	public void distributeSalary() {
		System.out.println("Введите зарплату для сотрудника");
		
	}
	@Override
	public void haveSalary() {
		System.out.println("Распределяется зарплату для сотрудника ");
	}
	@Override
	public void haveNotSalary() {
		System.out.println("Не распределяется зарплата для сотрудника ");
		
	}
	


	@Override
	public String[] FinanceManagerResearcherMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"Обновить статус оплаты",
				"Проверить статус оплаты",
				"Распределить стипендию",
				"Распределить зарплату",
				"Просмотреть все статьи",
				"Изменить язык",
				"Подписаться на журнал",
				"Отказаться от подписки на журнал",
				"Выйти"
				};
	}
//---------------------------------------------------------------------------------------------------------------
	public String deanHeader() {
		return "----Меню Декана----";
	}
	
	@Override
	public String[] deanMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"Просмотр курсов",
	            "Просмотр студентов",
	            "Просмотр оценок",
	            "Поставить оценки",
				"Просмотреть все запросы",
				"Подписать запросы", 
				"Просмотреть одну новость", 
				"Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
				"Выйти"
		};
	}
	
	@Override
	public void chooseFaculty() {
		System.out.println("Выбирайте Факультет:");
		
	}

	@Override
	public void noRequests() {
		System.out.println("Нет запросов");
		
	}

	@Override
	public void emergencyRequests() {
		System.out.println("----Экстренные запросы----");
		
	}

	@Override
	public void enterTheRequestNumberToSign() {
		System.out.println("Введите номер запроса для подписи (или 0 для выхода):");
		
	}

	@Override
	public void deanSignedRequest(String selectedRequest) {
		System.out.println("Декан подписал запрос:" + selectedRequest);
		
	}

	@Override
	public void TheRequestWasSuccesfully() {
		System.out.println("Запрос был успешно подписан и удален.");
		
	}

	@Override
	public String[] deanResearcherMenu() {
		
		return new String[] {
				"Просмотр курсов",
	            "Просмотр студентов",
	            "Просмотр оценок",
	            "Поставить оценки",
				"Просмотреть все запросы",
				"Подписать запросы", 
				"Просмотреть одну новость", 
				"Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
				"Выйти",
				"Посмотреть меню исследователя"
		};
	}
//---------------------------------------------------------------------------------------------------------------
	public String graduateStudentHeader() {
		return "----Меню Аспиранта----";
	}
	
	@Override
	public String[] graduateStudentMenu() {
		// TODO Auto-generated method stub
		return new String[] { 
				"Просмотреть стенограмму", 
				"Просмотр оценок за курс", 
				"Регистрация на курс",
				"Просмотреть учителя курса", 
				"Просмотреть все курсы", 
				"Оцените учителей", 
				"Организация", 
				"Просмотреть одну новость",
				"Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
				"Выйти", 
				"Посмотреть меню исследователя" 
				};
	}
	
	@Override
	public void newGrade(String grade) {
		System.out.println("Новая оценка: " + grade);
		
	}
//---------------------------------------------------------------------------------------------------------------
	public String employeeHeader() {
		return "----Меню Cотрудника----";
	}
	
	@Override
	public String[] employeeMenu() {
		// TODO Auto-generated method stub
		return new String[]{
				"Отправить запрос", 
				"Отправить заказ", 
				"Просмотреть одну новость", 
				"Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
				"Выйти"
				};
	}
	
	@Override
	public void SendingMessageTo(String message, String Username) {
		System.out.println("Отправка сообщения на" + Username + ": " + message);
		
	}

	@Override
	public void noDeans() {
		System.out.println("Нет деканов");
	}

	@Override
	public void chooseTheDean() {
		System.out.println("Выберите декана:");
		
	}

	@Override
	public void enterTheEmergencyLevel() {
		System.out.println("Введите чп уровень:");
		
	}

	@Override
	public void enterTheMessage() {
		System.out.println("Введите сообщение:");
		
	}

	@Override
	public void sentSuccesfully(String newRequest) {
		System.out.println(newRequest + " успешно отправлено");
		
	}

	@Override
	public void noTechSupports() {
		System.out.println("Никакой технической поддержки");
		
	}

	@Override
	public void chooseTheTechSupport() {
		System.out.println("Выберите техподдержку:");
		
	}

	@Override
	public String[] employeeResearcherMenu() {
		
		return new String[]{
				"Отправить запрос", 
				"Отправить заказ", 
				"Просмотреть одну новость",
				"Посмотреть все научные бумаги",
	            "Изменить язык",
	            "Подписаться на журнал",
	            "Отписаться от журнала",
				"Выйти",
				"Просмотреть меню исследователя"
				};
	}
//---------------------------------------------------------------------------------------------------------------
	public String researcherHeader() {
		return "----Меню Исследователя----";
	}
	
	@Override
	public String[] researcherMenu() {
		// TODO Auto-generated method stub
		return new String[] {
				"Просмотр документов", 
				"Создать бумагу", 
				"Просмотр проектов", 
				"Просмотр журналов", 
				"Добавить статью в журнал",
				"Создать проект",
				"Добавить документ в проект",
				"Выйти"
		};
	}
	
	@Override
	public void noPapers() {
		System.out.println("Нет документов");
		
	}

	@Override
	public void noProjects() {
		System.out.println("Нет проектов");
		
	}

	@Override
	public void noJournals() {
		System.out.println("Нет журналов");
		
	}

	@Override
	public void chooseTheJournal() {
		System.out.println("Выберите журнал:");
		
	}

	@Override
	public void choosePaperToAdd() {
		System.out.println("Выберите бумагу для добавления:");
		
	}

	@Override
	public void addedTo(String paper, String journalName) {
		System.out.println(paper + " добавлено в " + journalName);	
	}

	@Override
	public void enterTheNumberOfPages() {
		System.out.println("Введите количество страниц:");
		
	}

	@Override
	public void enterValidNumberOfPages() {
		System.out.println("Введите допустимое количество страниц.");
		
	}

	@Override
	public void enterValidNumber() {
		System.out.println("Введите действительный номер");
		
	}

	@Override
	public void enterTheDoi() {
		System.out.println("Введите дои:");
		
	}

	@Override
	public void newPaperAdded(String newPaper) {
		System.out.println("Добавлен новый документ "+ newPaper);
		
	}
//---------------------------------------------------------------------------------------------------------------
	
	@Override
	public void enterReturnBack() {
		// TODO Auto-generated method stub
		System.out.println("Нажмите 0, чтобы вернуться назад.");
	}


	@Override
	public void noCoursesYet() {
		System.out.println("В данный момент нету курсов.");
		
	}

	@Override
	public void noCourses() {
		System.out.println("Нету курсов.");
		
	}

	@Override
	public void allCourses() {
		System.out.println("Все курсы:");
		
	}

	@Override
	public void enterYourChoice() {
		System.out.println("Нажмите свой выбор:");
		
	}

	@Override
	public void noTeachers() {
		System.out.println("Нету преподователей.");
		
	}

	@Override
	public void courses() {
		System.out.println("Курсы:");
		
	}


	@Override
	public String[] changeInfoOptions() {
		// TODO Auto-generated method stub
		return new String[] {
				"Имя пользователья",
				"Пароль",
				"Имя",
				"Фамиля"
		};
	}

	@Override
	public void enterNewUsername() {
		System.out.println("Введите новое имя пользователья");
		
	}

	@Override
	public void enterNewPassword() {
		System.out.println("Введите новый пароль");
		
	}

	@Override
	public String enterNewFirstName() {
		return "Введите новое имя";
		
	}

	@Override
	public String enterNewLastName() {
		return "Введите новую фамилию";
		
	}
	@Override
	public String paymentFee() {
		return "Взнос оплачен";
	}
	@Override
	public String enterStudentUsername() {
		return "Введите имя пользователя студента:";
	}
	@Override
	public String studentNotFound() {
		return "Студент не найден";
	}
	@Override
	public String employeeNotFound() {
		return "Сотрудник не найден";
	}
	@Override
	public String enterEmployeeUsername() {
		return "Введите имя пользователя сотрудника:";
	}
	@Override
	public void updatePaymentStatus() {
		System.out.println("Для студента была обновлена информация о собранной плате ");
		
	}
	
	
	
	
}
