# 38module


для запуска склонить проект https://github.com/pvodincov/38module
из репозитория проекта, запустить  

mvn clean

mvn test


в тестах
- equalsLogoUrl  - проверка ссылки после перехода на главную страницу через логотип
- equalsKursAllUrl - проверка url - страницы  Все курсы
- equalFreeEvents - проверка url -  страницы бесплатных курсов
- equalTitelSite - проверка заголовка сайта 
- equalKorporStudUrl - провекра url - страницы корпорат обучение
- equalSotrudnUrl - проверка url - страницы сотрудничество
- equalBlogUrl - проверка url - страницы Блог
- checkTelNumber - проверка номеров телефона на странице



- equalsKursDataScience - проверка ссылки страницы Data Science
- equalKorporStudTextToPage - проверка перехода и  текста на старнице Корпорат. обучения
- equalSotrudnTextOfPage - проверка перехода и теста на странице Корпор. обучения
- equalBlogTextOfBody  - проверка перехода и текста на странице Блог
- checkTelNumber - проверка номеров телефона




получение консультацию по выбору курса
-checkMassageEnterNullData - проверка сообщения ошибки без ввода данных в поля
- MassageEnterRightName - проверка сообщения ошибки после заполнения имени
- MassageEnterRightNameAndRigthEmail - проверка ошибки после заполения имени и правильного email
- MassageEnterRightNameAndFailEmail - проверка ошибки после заполениния имени и неверного email
- MessageEnterRightNameAndRightEmailAndShortNumber - проверка сообщения об ошибке при правильном email, имени и коротком номере телефона
- getKonsulNullData - проверка сообщения - при отправке запроса на консультацию с пустыми полями.


блок получения консультации - заявка на бесплатную консультацию
- getKonsulNullData  - проверка отрытия окна и ошибки при пустых полях
- getKonsulNameNullEmailFailShortNumber - проверка открытия окна и ошибки при неправильном email и коротком номере, пустом имени
- getKonsulNameRightEmailRightNumberRight - проверка открытия окна, Диалог при правильном имени, правильном email, правильном номере (почти всегда срабатывает капча - лучше проверять руками)
- getFreeItFailNotCheckPunkt - проверка при снятии галки, сообщение об ошибке
- getFreeItFailEmail  - проверка ошибки при неправильном email
- getFreeItAllRight - проверка диалога при всех правильных полях (выскакивает капча, лучше проверять руками)


проверка соц. сетей в footer
-  checkFooterSocSiteHabr  - проверка habr
-  checkFooterSocSiteVk - проверка vk
-  checkFooterSocSiteTwitter - проверка твиттер
- checkFooterSocSiteYoutube - проверка ютуб
- checkFooterSocSiteTelegram - проверка телеграм
- checkFooterSocSiteYandex - проверка яндекс дзен
