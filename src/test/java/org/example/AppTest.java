package org.example;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void mailPatternTest() {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        //String mailList = "pious.lehna.teddy@singhealth.com.sg,cho.siew.fong@singhealth.com.sg";
        String mailList = "vanessa.soam.s.h@alpshealthcare.com.sg,serene.chew.w.j@alpshealthcare.com.sg,alvin.ong.d.w@alpshealthcare.com.sg,jacelyn.tan.s.y@alpshealthcare.com.sg,priscilla.lim.c.l@alpshealthcare.com.sg,tan.hui.en@alpshealthcare.com.sg";
//        String s = Pattern.quote("}),({");
        String s = Pattern.quote(",");
        System.out.println("Pattern "+s);
        for (String mail : mailList.split(s)) {
            System.out.println("Verifying mail " + mail);
            if (mail.isEmpty() || !pattern.matcher(mail).matches()) {
                System.out.println("Not Valid " + mail);
            } else {
                System.out.println("Valid " + mail);
            }
        }
    }

}
