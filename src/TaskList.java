import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskList {
    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String task;
        System.out.println("Представляем вам пустой список для заполнения его задачами!");
        printMenu();
        int choose = -1; //Нужно было проинициализировать, иначе выдаст ошибку
        while (choose != 0){
            try {
                choose = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Ошибка! Вы ввели недопустимое значение!");
                choose = 0;
            }
            switch (choose){
                case 1:
                    scanner.nextLine();
                    System.out.println("Добавьте задачу:");
                    task = scanner.nextLine();
                    taskList.add(task);
                    break;
                case 2:
                    System.out.println("Вот текущий список задач:");
                    printList(taskList);
                    break;
                case 3:
                    System.out.println("Выберите задачу:");
                    printList(taskList);
                    int index = scanner.nextInt();
                    deleteTask(taskList, index);
                    break;
                case 0:
                    continue;
                default:
                    System.err.println("Неверно введены данные!");
                    break;
            }
        }
    }

    public static void printList (ArrayList<String> taskList){
        int i = 1;
        for (String task: taskList) {
            System.out.println(i + ". " + task);
            i++;
        }
    }
    public static void deleteTask (ArrayList<String> taskList, int index){
        System.out.println("Задача " + index + " " + taskList.get(index - 1) + " отмечена выполненной и удалена.");
        taskList.remove(index - 1);
    }

    public static void printMenu(){
        System.out.println("Для выхода из программы введите 0 " +
                "\nДля добавления задачи введите 1" +
                "\nДля отображения списка на консоль введите 2" +
                "\nДля удаления [отметить как выполненное] введите 3"
        );
    }

}
