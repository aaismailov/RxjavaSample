## Задание 1

object HomeTask {

   /**
    * 1. Создайте Observable, который будет эмитить числа от 1 до 10
    * 2. Преобразуйте Observable так, чтобы он эмитил только четные числа
    * 3. Преобразуйте Observable так, чтобы он эмитил только числа, которые делятся на 3
    * 4. Преобразуйте Observable так, чтобы он эмитил только числа, которые делятся на 3 и 5
    */
   fun task1(): Observable<Int> {
       TODO("Not implemented yet")
   }

   /**
    * 1. Создайте два Observable из соответсвующих последовательностей
    * 2. Объедините два Observable в один
    * 3. Преобразуйте Observable так, чтобы он эмитил только уникальные элементы
    * 4. Преобразуйте Observable так, чтобы он эмитил только хэш коды элементов
    */
   fun task2(
       items1: List<String>,
       items2: List<String>
   ): Observable<String> {
       TODO("Not implemented yet")
   }
}

## Задание 2

// Создать фрагмент для авторизации состоящий из двух полей ввода loginEditText и passwordEditText, а также кнопки loginButton.
// Кнопка должна быть неактивна, пока пользователь не введет логин и пароль.
// При нажатии на кнопку должен происходить запрос на авторизацию. (замокать ответ)
// Если авторизация прошла успешно, то должен открыться фрагмент с информацией о пользователе.
// Если авторизация не прошла, то должен показаться сообщение об ошибке.
// Все запросы должны быть выполнены с помощью RxJava.
object HomeTask {
    // TODO: implement
}