package inforgeon.inforgeon.service

import inforgeon.entity.RssEntry
import inforgeon.inforgeon.constant.RssTopicName
import inforgeon.inforgeon.entity.UserSettings

/**
 * Контракт по взаимодействию бота с бэкендом. Всю интеграцию с ботом осуществлять только через него
 */
interface BotApiService {

    /**
     * Зарегистрировать пользователя
     */
    fun userRegistration(username: String) : UserSettings

    /**
     * Получить самую новую новость по выбранной теме
     */
    fun getNewestRssEntry(username : String, topicName: RssTopicName) : RssEntry

    /**
     * Получить следующую, более раннюю новость по той же теме по id текущей
     */
    fun getNextRssEntry(username : String, topicName: RssTopicName, rssEntryId : Long) : RssEntry

    /**
     * Дизлайкнуть новость по id (минусятся тэги, подобные новости будут меньше показываться)
     */
    fun dislikeRssEntry(username : String, topicName: RssTopicName, rssEntryId : Long)

    /**
     * Дизлайкнуть ниже порога определенный тэг (новость с таким тэгом, если он есть, не будет показана)
     */
    fun filterTag(username : String, topicName: RssTopicName, filteredTag : String)

    /**
     * Сбросить все дизлайки по выбранной теме
     */
    fun resetAllDislikes(username : String, topicName: RssTopicName)

}