package tests;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static pages.components.DateComponent.dateNow;

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

                        .checkResult("Student Name","Igor Evsin")
                        .checkResult("Student Email","Evsin19@gmail.com")
                        .checkResult("Gender","Male")
                        .checkResult("Mobile","0000000000")
                        .checkResult("Date of Birth","20 October,1998")
                        .checkResult("Subjects","English")
                        .checkResult("Hobbies","Sports, Music")
                        .checkResult("Picture","file.png")
                        .checkResult("Address","Street 999")
                        .checkResult("State and City","NCR Delhi");


    }

    @Test
    void minFormTests() {

        practiceFormPage.openPage()
                        .setFirstName("Igor")
                        .setLastName("Evsin")
                        .setGenterWrapper("Male")
                        .setUserNumber("0000000000")
                        .submit()

                        .checkResult("Student Name", "Igor Evsin")
                        .checkResult("Gender", "Male")
                        .checkResult("Date of Birth", dateNow());
    }

    @Test
    void validationFormTests() {

        practiceFormPage.openPage()
                        .submit()

                        .checkValidation();
    }


}
