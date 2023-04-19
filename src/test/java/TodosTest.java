import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    Todos todos = new Todos();

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям и купить Яйца");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType1() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void queryTestSimpleTask() {

        todos.add(simpleTask);

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryTestSimpleTask2() {

        todos.add(simpleTask);

        boolean expected = false;
        boolean actual = simpleTask.matches("хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryTestMeeting1() {

        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("версии");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryTestMeeting2() {

        todos.add(meeting);

        boolean expected = false;
        boolean actual = meeting.matches("после");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryTestMeeting3() {

        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryEpicTest() {

        todos.add(epic);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void taskTest() {

        todos.add(meeting);


        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void taskTest2() {

        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void twoTasksFound() {

        todos.add(simpleTask);
        todos.add(epic);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Яйца");

        Assertions.assertArrayEquals(expected, actual);
    }
}
