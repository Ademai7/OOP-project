
package language;


public interface LanguageInterface {
//---------------------------------------------------------------------------------------------------------------
	void newNotifications();
	String handleEventUser(String paper, String journal, String firstName, String lastName);
	void news();
	void noNews();
	void enterTheNumberOfTheNews();
	void selectedNews();
	void doYouWantToAddAComment();
	void yourDecidedThatNoWant();
	void noCommentsAvailable();
	void comments();
	void enterYourComment();
	void commentAddSuccesfully();
	
	
	
//---------------------------------------------------------------------------------------------------------------
	String studentHeader();
    String[] studentMenu();
    void viewTranscript();
    void courseDoesntHaveMarks();
    void courseMark(String courseName, String mark);
    void courseRegistrationSuccesfully(String courseName);
    
    void studentNotRegisteredForThisCourse();
    void teacherForCourse(String courseName);
    
    void pleaseSelectTheTeacherYourWantToEvaluate();
    void yourAssessmentOfThisTeacher();
    String enterStudentUsername();
    String paymentFee();
    String studentNotFound();
    String employeeNotFound();
    String enterEmployeeUsername();
    
    String[] organisationMenu();
    void listOfOrganisation();
    void atTheMomentWeDontHaveAnyOrganizations();
    void nameYourOrganisation();
 
    String[] studentResearcherMenu();

//---------------------------------------------------------------------------------------------------------------  
    
    String teacherHeader();
    String[] teacherMenu();
    
    void courseTaughtBy(String username);
    void studentsEnrolledIn(String selectedCourseName);
    void marksFor(String selectedCourseName);
    void noMarks(String mark,String studentUsername);
    void noStudentEnrolledIn(String selectedCourseName);
    void previousMarksForStudent(String selectedStudentUsername, String mark);
    void newMarksForStudents(String selectedStudentUsername);
    void teachersRating(double rate);
    
    void enterTheCourse();
    void noLessonsForThisCourse();
    void selectSCourseToInputMarks();
    void yourAreNotAssignedToAnyCourses();
    void noLessonsRecordedForTheCourse();
    void selectAStudentToInputMarks();
    void chooseAStudentOrExit();
    
    void firstAttestation();
    void secondAttestation();
    void finalExam();
    
    void theMarksHaveBennSubmittedSuccesfully();
    void ErrorPleaseEnterMarksCorrectly();
    
    String[] teacherResearcherMenu();

//---------------------------------------------------------------------------------------------------------------
    String adminHeader();
    String[] adminMenu();
    
    String[] addResearcherOptions();
    void whatDoYouWantToDo();
    void chooseUser();
    void whichUserDoYouWantToCreate();
    String[] addResearcherOptionsCreate();
    String[] createUserOptions();

    void updateUserWhichUserDoYouWantToChange();
    void removeUserChooseUserToDelete();
    void seeLogFilesChooseUserToSeeLogs();
    void seeLogFilesNoLogsForThisUser();
    
//---------------------------------------------------------------------------------------------------------------    
    String managerHeader();
    String[] managerMenu();
    void GPAMAX(double gpamax);
    void GPAHIGH(double gpahigh);
    void GPAMEDIUM(double gpamedium);
    void COUNTOTHER(double contother);
    void hINDEX(String maxResearcher);
    
    void enterTheNumverOfCreditsOfTheCourse();
    void enterNameOfCourse();
    void chooseForWhichFacultyIsThisCouse();
    void chooseTypeOfThisCoursefor(String faculty);
    void courseAdded(String newCourse);
    void chooseType();
    
    void newTopic();
    void newTitle();
    void newText();
    
    void listOfRequests();
    
    void whatNewsDoYouWantToChange();
    void whichOfPartDoYouWantToChange();
    
    void enterNewTopic();
    void updateNews(String news);
    
    void enterNewTitle();
    //updateNews;
    void enterNewText();
    //UpdateNews;
    
    void whichCourseYouWantToAssign();
    void whichTeacherWouldYouLikeToAssignThe(String courseName);
    void assignedTo(String courseName, String teacherFirstName,String teacherLastName);
    
    void whichTeacherWouldYouLikeToAddTheLesson();
    
    void noCoursesForThisTeacher();
    void toWhichCourseOf(String teacherName,String teacherLastName);
    
    void enterTheTypeOfLesson();
    void enterTheDay();
    void enterTheLessonStartTime();
    void enterTheRoom();
    void added(String newLesson);
    
    void enterTheName();
    void newJournalCreated(String newJournal);
    
    String[] managerResearcherMenu();
    
//---------------------------------------------------------------------------------------------------------------    
    
    String deanHeader();
    String[] deanMenu();
    
    void chooseFaculty();
    void noRequests();
    void emergencyRequests();
    void enterTheRequestNumberToSign();
    void deanSignedRequest(String selectedRequest);
    void TheRequestWasSuccesfully();
    
    String[] deanResearcherMenu();
    
//------------------------------------------------------------------------------------------------------------------
    
    String FinanceManagerHeader();
    String[] FinanceManagerMenu();
    void updatePaymentStatus();
    void handleCheckFeeStatusTrue();
    void handleCheckFeeStatusFalse();
    void giveScholarshipd();
    void notGiveScholarshipd();
    void distributeSalary();
    void haveSalary();
    void haveNotSalary();
    
    String[] FinanceManagerResearcherMenu();
//-----------------------------------------------------------------------------------------------------------------------
    
    String graduateStudentHeader();
    String[] graduateStudentMenu();

    void newGrade(String grade);
//-----------------------------------------------------------------------------------------------------------------------
    String employeeHeader();
    
    String[] employeeMenu();
    
    void SendingMessageTo(String message, String Username);
    void noDeans();
    void chooseTheDean();
    void enterTheEmergencyLevel();
    void enterTheMessage();
    void sentSuccesfully(String newRequest);
    void noTechSupports();
    void chooseTheTechSupport();
    
    
    String[] employeeResearcherMenu();
    
//-----------------------------------------------------------------------------------------------------------------------    
    String researcherHeader();
    
    String[] researcherMenu();
    
    void noPapers();
    void noProjects();
    void noJournals();
    void chooseTheJournal();
    void choosePaperToAdd();
    void addedTo(String paper,String journalName);
    void enterTheNumberOfPages();
    void enterValidNumberOfPages();
    void enterValidNumber();
    void enterTheDoi();
    void newPaperAdded(String newPaper);
    
//---------------------------------------------------------------------------------------------------------------
    void enterReturnBack();
    void noCoursesYet();
    void noCourses();
    void allCourses();
    void enterYourChoice();
    void noTeachers();
    void courses();
    void whatDoYouWantToChange();
    
    String[] changeInfoOptions();
    void enterNewUsername();
    void enterNewPassword();
    String enterNewFirstName();
    String enterNewLastName();
	
}


