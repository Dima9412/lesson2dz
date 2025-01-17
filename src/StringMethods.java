import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StringMethods {
    public static void main(String[] args) {
        // Получаем класс String через Reflection
        Class<String> stringClass = String.class;

        // Получаем массив методов класса String
        Method[] methods = stringClass.getDeclaredMethods();

        // Перебираем и выводим информацию о каждом методе
        for (Method method : methods) {
            // Получаем модификаторы метода
            String modifiers = Modifier.toString(method.getModifiers());

            // Получаем возвращаемый тип метода
            String returnType = method.getReturnType().getSimpleName();

            // Получаем имя метода
            String methodName = method.getName();

            // Получаем параметры метода
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuilder parameters = new StringBuilder();
            for (int i = 0; i < parameterTypes.length; i++) {
                parameters.append(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    parameters.append(", ");
                }
            }

            // Форматируем и выводим метод
            System.out.printf("%s %s %s(%s)%n", modifiers, returnType, methodName, parameters);
        }
    }
}
