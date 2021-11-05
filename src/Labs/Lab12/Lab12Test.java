package Labs.Lab12;


import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

@SuppressWarnings("rawtypes")
public class Lab12Test {

    //Card Tests

    @Test
    public void Card_instanceCountTest(){
        Card testCard = new Card();
        Class c = testCard.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables in Card we",
                    1, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void Card_instanceVariablesTest(){
        Card testCard = new Card();
        instanceVariablePrivate("name",testCard);

        instanceVariableStatic("name",testCard);

        instanceVariableCorrectType("name",String.class,testCard);
    }

    @Test
    public void Card_DefaultConstructorTest() {
        Card testCard = new Card();
        testVariable("name",testCard,"","When checking the value of name we",0);
    }

    @Test
    public void Card_ParameterizedConstructorTest() {
        Card testCard = new Card("Franklin Pierce");
        testVariable("name",testCard,"Franklin Pierce","When checking the value of name we",0);
    }

    @Test
    public void Card_toStringTest() {
        Card myCard = createCard("Millard Filmore");
        assertEquals("After calling Card's toString method, we", "Card Holder: Millard Filmore",
                myCard.toString());
    }

    //DebitCard Tests

    @Test
    public void DebitCard_superClassTest() {
        DebitCard myDebitCard = new DebitCard();
        assertTrue("When testing if DebitCard extends Card, we", (myDebitCard instanceof Card));
    }

    @Test
    public void DebitCard_instanceCountTest(){
        DebitCard testDebitCard = new DebitCard();
        Class c = testDebitCard.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables in DebitCard we",
                    2, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void DebitCard_instanceVariablesTest(){
        DebitCard testDebitCard = new DebitCard();

        instanceVariablePrivate("cardNumber",testDebitCard);
        instanceVariablePrivate("pin",testDebitCard);

        instanceVariableStatic("cardNumber",testDebitCard);
        instanceVariableStatic("pin",testDebitCard);

        instanceVariableCorrectType("cardNumber",int.class,testDebitCard);
        instanceVariableCorrectType("pin",int.class,testDebitCard);
    }

    @Test
    public void DebitCard_defaultConstructorTest() {
        DebitCard testDebitCard = new DebitCard();

        testVariable("name",testDebitCard,"Jane Doe","When checking the value of name we",1);
        testVariable("cardNumber",testDebitCard,00000000,"When checking the value of cardNumber we",0);
        testVariable("pin",testDebitCard,0,"When checking the value of pin we",0);
    }

    @Test
    public void DebitCard_parameterizedConstructorTest() {
        DebitCard testDebitCard = new DebitCard("Zachary Taylor", 18491850, 1234);

        testVariable("name",testDebitCard,"Zachary Taylor","When checking the value of name we",1);
        testVariable("cardNumber",testDebitCard,18491850,"When checking the value of cardNumber we",0);
        testVariable("pin",testDebitCard,1234,"When checking the value of pin we",0);
    }

    @Test
    public void DebitCard_toStringTest() {
        DebitCard myDebitCard = createDebitCard("James K. Polk", 12345678, 1234);
        assertEquals("After calling the cardToString method, we", "Card Holder: James K. Polk Card Number: 12345678",
                myDebitCard.toString());
    }


    //IDCard Tests

    @Test
    public void IDCard_superClassTest() {
        IDCard myIDCard = new IDCard();
        assertTrue("When testing if IDCard extends Card, we", (myIDCard instanceof Card));
    }

    @Test
    public void IDCard_instanceCountTest(){
        IDCard testIDCard = new IDCard();
        Class c = testIDCard.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables in IDCard we",
                    1, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void IDCard_instanceVariablesTest() {
        IDCard testIDCard = new IDCard();

        instanceVariablePrivate("idNumber",testIDCard);

        instanceVariableStatic("idNumber",testIDCard);

        instanceVariableCorrectType("idNumber",int.class,testIDCard);
    }

    @Test
    public void IDCard_defaultConstructorTest() {
        IDCard testIDCard = new IDCard();

        testVariable("name",testIDCard,"Jane Smith","When checking the value of name we",1);
        testVariable("idNumber",testIDCard,0,"When checking the value of idNumber we",0);
    }

    @Test
    public void IDCard_parameterizedConstructorTest() {
        IDCard testIDCard = new IDCard("John Tyler", 10);

        testVariable("name",testIDCard,"John Tyler","When checking the value of name we",1);
        testVariable("idNumber",testIDCard,10,"When checking the value of idNumber we",0);
    }

    @Test
    public void IDCard_toStringTest() {
        IDCard myIDCard = createIDCard("William Henry Harrison", 9);
        assertEquals("After calling the cardToString method, we", "Card Holder: William Henry Harrison ID Number: 9",
                myIDCard.toString());
    }


    //DriversLicense Tests


    @Test
    public void DriversLicense_superClassTest() {
        DriversLicense myDriversLicense = new DriversLicense();
        assertTrue("When testing if DriversLicense extends IDCard, we", (myDriversLicense instanceof IDCard));
        assertTrue("When testing if DriversLicense indirectly extends Card, we", (myDriversLicense instanceof Card));
    }

    @Test
    public void DriversLicense_instanceCountTest(){
        DriversLicense testDriversLicense = new DriversLicense();
        Class c = testDriversLicense.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables in DriversLicense we",
                    2, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void DriversLicense_instanceVariablesTest() {
        DriversLicense testDriversLicense = new DriversLicense();

        instanceVariablePrivate("expirationYear",testDriversLicense);
        instanceVariablePrivate("expirationMonth",testDriversLicense);

        instanceVariableStatic("expirationYear",testDriversLicense);
        instanceVariableStatic("expirationMonth",testDriversLicense);

        instanceVariableCorrectType("expirationYear",int.class,testDriversLicense);
        instanceVariableCorrectType("expirationMonth", Month.class,testDriversLicense);
    }

    @Test
    public void DriversLicense_defaultConstructorTest() {
        DriversLicense testDriversLicense = new DriversLicense();

        testVariable("name",testDriversLicense,"Jane Smith","When checking the value of name we",2);
        testVariable("idNumber",testDriversLicense,0,"When checking the value of idNumber we",1);
        testVariable("expirationYear",testDriversLicense,1969,"When checking the value of expirationYear we",0);
        testVariable("expirationMonth",testDriversLicense,Month.JANUARY,"When checking the value of expirationMonth we",0);
    }

    @Test
    public void DriversLicense_parameterizedConstructorTest() {
        DriversLicense testDriversLicense = new DriversLicense("Martin Van Buren", 8, 1841, Month.JULY);

        testVariable("name",testDriversLicense,"Martin Van Buren","When checking the value of name we",2);
        testVariable("idNumber",testDriversLicense,8,"When checking the value of idNumber we",1);
        testVariable("expirationYear",testDriversLicense,1841,"When checking the value of expirationYear we",0);
        testVariable("expirationMonth",testDriversLicense,Month.JULY,"When checking the value of expirationMonth we",0);
    }

    @Test
    public void DriversLicense_toStringTest() {
        DriversLicense myDriversLicense = createDriversLicense(Month.JULY, 1861, "James Buchanan", 15);
        assertEquals("For DriverLicense's toString method, we", "Card Holder: James Buchanan ID Number: 15 Expiration Month & Year: JULY 1861",
                myDriversLicense.toString());
    }


    //Month Test

    @Test
    public void Month_enumTest() {
        try {
            Month.valueOf("JANUARY");
            Month.valueOf("FEBRUARY");
            Month.valueOf("MARCH");
            Month.valueOf("APRIL");
            Month.valueOf("MAY");
            Month.valueOf("JUNE");
            Month.valueOf("JULY");
            Month.valueOf("AUGUST");
            Month.valueOf("SEPTEMBER");
            Month.valueOf("OCTOBER");
            Month.valueOf("NOVEMBER");
            Month.valueOf("DECEMBER");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Month enum, we",12,Month.values().length);
    }

    private Card createCard(String aName){
        Card testCard = new Card();
        Class c = testCard.getClass();

        try {
            Field name = c.getDeclaredField("name");
            name.setAccessible(true);
            name.set(testCard, aName);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testCard;
    }

    private DebitCard createDebitCard(String aName, int aCardNumber, int aPin){
        DebitCard myDebitCard = new DebitCard();
        Class c = myDebitCard.getClass();
        Class superC = c.getSuperclass();
        try {
            Field name = superC.getDeclaredField("name");
            name.setAccessible(true);
            name.set(myDebitCard, aName);

            Field cardNumber = c.getDeclaredField("cardNumber");
            cardNumber.setAccessible(true);
            cardNumber.set(myDebitCard, aCardNumber);

            Field pin = c.getDeclaredField("pin");
            pin.setAccessible(true);
            pin.set(myDebitCard, aPin);

        } catch (Exception e) {
            fail(e.toString());
        }
        return myDebitCard;
    }

    private IDCard createIDCard(String aName, int anidNumber) {
        IDCard myIDCard = new IDCard();
        Class c = myIDCard.getClass();
        Class superC = c.getSuperclass();
        try {
            Field name = superC.getDeclaredField("name");
            name.setAccessible(true);
            name.set(myIDCard, aName);

            Field cardNumber = c.getDeclaredField("idNumber");
            cardNumber.setAccessible(true);
            cardNumber.set(myIDCard, anidNumber);
        } catch (Exception e) {
            fail(e.toString());
        }
        return myIDCard;
    }

    private DriversLicense createDriversLicense(Month anExpirationMonth, int anExpirationYear, String aName, int anidNumber) {
        DriversLicense testDriversLicense = new DriversLicense();
        Class c = testDriversLicense.getClass();
        Class superC = c.getSuperclass();
        Class grandparrentC = superC.getSuperclass();
        try {

            Field name = grandparrentC.getDeclaredField("name");
            name.setAccessible(true);
            name.set(testDriversLicense, aName);

            Field cardNumber = superC.getDeclaredField("idNumber");
            cardNumber.setAccessible(true);
            cardNumber.set(testDriversLicense, anidNumber);

            Field expirationYear = c.getDeclaredField("expirationYear");
            expirationYear.setAccessible(true);
            expirationYear.set(testDriversLicense, anExpirationYear);

            Field expirationMonth = c.getDeclaredField("expirationMonth");
            expirationMonth.setAccessible(true);
            expirationMonth.set(testDriversLicense, anExpirationMonth);

        } catch (Exception e) {
            fail(e.toString());
        }
        return testDriversLicense;
    }

    private void instanceVariablePrivate(String aField, Object testObject) {
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertTrue("You must make your instance variables private.", Modifier.isPrivate(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableStatic(String aField, Object testObject) {
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("Your instance variables must NOT be static.", false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("You must make the speed instance variable of type"+ aClass.toString() +".", aClass, c.getDeclaredField(aField).getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void testVariable(String aField, Object testObject, Object expected, String message, int descendantLevel){
        Class c = testObject.getClass();

        for(int i = 0; i < descendantLevel; i++){
            c = c.getSuperclass();
        }

        try {
            Field field = c.getDeclaredField(aField);
            field.setAccessible(true);
            Object fieldValue = field.get(testObject);

            if(expected == null){
                assertNull(message,fieldValue);
            }
            //If class is a double we have a special Junit assert to run
            else if(expected.getClass().equals(Double.class)){
                double doubleFieldValue = (double) fieldValue;
                double doubleExpected = (double) expected;
                assertEquals(message, doubleExpected, doubleFieldValue, .01);
            }
            //Array of some kind yay
            else if(expected.getClass().isArray()){

            }
            else if(expected.getClass().equals(ArrayList.class)){

            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

}
