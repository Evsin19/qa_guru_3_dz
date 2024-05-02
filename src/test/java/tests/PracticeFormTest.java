package tests;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static components.DateComponent.dateNow;

public class PracticeFormTest extends TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fullFormTests() {

        practiceFormPage.openPage()
                        .setFirstName("Igor")
                        .setLastName("Evsin")
                        .setUserEmail("Evsin19@gmail.com")
                        .setGenterWrapper("Male")
                        .setUserNumber("0000000000")
                        .setDateOfBirth("20", "October", "1998")
                        .setSubjectsContainer("English")
                        .setHobbiesWrapper("Sports")
                        .setHobbiesWrapper("Music")
                        .uploadPicture("file.png")
                        .setCurrentAddress("Street 999")
                        .setState("NCR")
                        .setCity("Delhi")
                        .submit()

                        .tableResult("Student Name","Igor Evsin")
                        .tableResult("Student Email","Evsin19@gmail.com")
                        .tableResult("Gender","Male")
                        .tableResult("Mobile","0000000000")
                        .tableResult("Date of Birth","20 October,1998")
                        .tableResult("Subjects","English")
                        .tableResult("Hobbies","Sports, Music")
                        .tableResult("Picture","file.png")
                        .tableResult("Address","Street 999")
                        .tableResult("State and City","NCR Delhi");


    }

    @Test
    void minFormTests() {

        practiceFormPage.openPage()
                        .setFirstName("Igor")
                        .setLastName("Evsin")
                        .setGenterWrapper("Male")
                        .setUserNumber("0000000000")
                        .submit()

                        .tableResult("Student Name", "Igor Evsin")
                        .tableResult("Gender", "Male")
                        .tableResult("Date of Birth", dateNow());
    }

    @Test
    void validationFormTests() {

        practiceFormPage.openPage()
                        .submit()

                        .formValidation();
    }


}
