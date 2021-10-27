package Labs.Lab10;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class Lab10Test {


    @Test
    public void InstanceConstantsCountTest(){
        Fan testFan = new Fan();
        @SuppressWarnings("rawtypes")
        Class c = testFan.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    7, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void ConstantsTest(){
        Fan testFan = new Fan();
        @SuppressWarnings("rawtypes")
        Class c = testFan.getClass();
        try {
            c.getDeclaredField("SLOW");
            c.getDeclaredField("MEDIUM");
            c.getDeclaredField("FAST");

            assertEquals("You must make your constant variables public.", true,
                    Modifier.isPublic(c.getDeclaredField("SLOW").getModifiers()));
            assertEquals("You must make your constant variables public.", true,
                    Modifier.isPublic(c.getDeclaredField("MEDIUM").getModifiers()));
            assertEquals("You must make your constant variables public.", true,
                    Modifier.isPublic(c.getDeclaredField("FAST").getModifiers()));

            assertEquals("Your constant variables must be static.", true,
                    Modifier.isStatic(c.getDeclaredField("SLOW").getModifiers()));
            assertEquals("Your constant variables must be static.", true,
                    Modifier.isStatic(c.getDeclaredField("MEDIUM").getModifiers()));
            assertEquals("Your constant variables must be static.", true,
                    Modifier.isStatic(c.getDeclaredField("FAST").getModifiers()));

            assertEquals("Your constant variables must be final.", true,
                    Modifier.isFinal(c.getDeclaredField("SLOW").getModifiers()));
            assertEquals("Your constant variables must be final.", true,
                    Modifier.isFinal(c.getDeclaredField("MEDIUM").getModifiers()));
            assertEquals("Your constant variables must be final.", true,
                    Modifier.isFinal(c.getDeclaredField("FAST").getModifiers()));

            assertEquals("You must make the SLOW constant variable of type int.", (int.class),
                    c.getDeclaredField("SLOW").getType());
            assertEquals("You must make the MEDIUM constant variable of type int.", (int.class),
                    c.getDeclaredField("MEDIUM").getType());
            assertEquals("You must make the FAST constant variable of type int.", (int.class),
                    c.getDeclaredField("FAST").getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void InstanceVariablesTest(){
        Fan testFan = new Fan();

        instanceVariablePrivate("speed",testFan);
        instanceVariablePrivate("on",testFan);
        instanceVariablePrivate("radius",testFan);
        instanceVariablePrivate("color",testFan);

        instanceVariableStatic("speed",testFan);
        instanceVariableStatic("on",testFan);
        instanceVariableStatic("radius",testFan);
        instanceVariableStatic("color",testFan);

        instanceVariableCorrectType("speed",int.class,testFan);
        instanceVariableCorrectType("on",boolean.class,testFan);
        instanceVariableCorrectType("radius",double.class,testFan);
        instanceVariableCorrectType("color",String.class,testFan);
    }

    @Test
    public void fanDefaultConstructorTest() {
        Fan testFan = new Fan();

        testVariable("speed",testFan,1,"When checking the value of speed we",0);
        testVariable("on",testFan,false,"When checking the value of on we",0);
        testVariable("radius",testFan,5.0,"When checking the value of radius we",0);
        testVariable("color",testFan,"blue","When checking the value of color we",0);
    }

    @Test
    public void parameterizedFanConstructor() {
        Fan testFan = new Fan(3,false,25.0,"Yellow");

        testVariable("speed",testFan,3,"When checking the value of speed we",0);
        testVariable("on",testFan,false,"When checking the value of on we",0);
        testVariable("radius",testFan,25.0,"When checking the value of radius we",0);
        testVariable("color",testFan,"Yellow","When checking the value of color we",0);
    }

    @Test
    public void getSpeedTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        assertEquals("With a Fan object who's speed instance variable is 3, when calling getSpeed we",3,testFan.getSpeed());
    }

    @Test
    public void setSpeedTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        testFan.setSpeed(2);
        testVariable("speed",testFan,2,"After calling Fan's setSpeed method with an argument of 2, for the value of speed we",0);
    }

    @Test
    public void isOnTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        assertEquals("With a Fan object who's on instance variable is false, when calling isOn we",false,testFan.isOn());
    }

    @Test
    public void setOnTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        testFan.setOn(true);
        testVariable("on",testFan,true,"After calling Fan's setOn method with an argument of true, for the value of on we",0);
    }

    @Test
    public void getRadiusTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        assertEquals("With a Fan object who's radius instance variable is 25.0, when calling getRadius we",25.0,testFan.getRadius(),.01);
    }

    @Test
    public void setRadiusTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        testFan.setRadius(15.55);
        testVariable("radius",testFan,15.55,"After calling Fan's setRadius method with an argument of 15.55, for the value of radius we",0);
    }

    @Test
    public void getColorTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        assertEquals("With a Fan object who's color instance variable is Yellow, when calling getColor we","Yellow",testFan.getColor());
    }

    @Test
    public void setColorTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        testFan.setColor("Red");
        testVariable("color",testFan,"Red","After calling Fan's setColor method with an argument of Red, for the value of color we",0);
    }

    @Test
    public void toStringTest() {
        Fan testFan = createFan(3,false,25.0,"Yellow");
        assertEquals("fan is off", testFan.toString());

        testFan = createFan(3,true,25.0,"Yellow");
        assertEquals("fan is 3, Yellow, and size 25.0", testFan.toString());
    }


    private Fan createFan(int aSpeed, boolean isOn, double aRadius, String aColor){
        Fan testFan = new Fan();
        @SuppressWarnings("rawtypes")
        Class c = testFan.getClass();

        try {
            Field speed = c.getDeclaredField("speed");
            speed.setAccessible(true);
            speed.set(testFan, aSpeed);

            Field on = c.getDeclaredField("on");
            on.setAccessible(true);
            on.set(testFan, isOn);

            Field radius = c.getDeclaredField("radius");
            radius.setAccessible(true);
            radius.set(testFan, aRadius);

            Field color = c.getDeclaredField("color");
            color.setAccessible(true);
            color.set(testFan, aColor);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testFan;
    }

    private void instanceVariablePrivate(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
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
        @SuppressWarnings("rawtypes")
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
        @SuppressWarnings("rawtypes")
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
        @SuppressWarnings("rawtypes")
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
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

}
