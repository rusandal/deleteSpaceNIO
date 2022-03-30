# Удаление пробелов при клиент серверном взаимодействии
# Описание
Программа реализует возможность удаления пробелов Сервером и возращает обратно Клиенту. В репозитории реализованы 2 пары клиент-сервер для IO|NIO.    
1. Клиент бесконечно просит пользователя вводить строки с пробелами
2. Каждая строка передается на сервер
3. Сервер читает все, что ему передали, удаляет пробельные символы и результат отправляет обратно
4. Клиент отображает результат
5. Если пользователь вводит end - клиент завершается  

Вывод клиента:
```
Начните вводить данные...
Солнце светит, жизнь кипит
Server: Солнцесветит,жизнькипит
Начните вводить данные...
```