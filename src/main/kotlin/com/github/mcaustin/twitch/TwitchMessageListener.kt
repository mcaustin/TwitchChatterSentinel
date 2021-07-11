package com.github.mcaustin.twitch

import com.gikk.twirk.Twirk
import com.gikk.twirk.events.TwirkListener
import com.gikk.twirk.types.twitchMessage.TwitchMessage
import com.gikk.twirk.types.users.TwitchUser
import org.apache.logging.log4j.LogManager.getLogger

class TwitchMessageListener(val twirk: Twirk): TwirkListener {

    private val logger = getLogger(TwitchMessageListener::class.java)

    override fun onPrivMsg(sender: TwitchUser?, message: TwitchMessage?) {
        super.onPrivMsg(sender, message)

        //logger.info("${sender?.displayName}: ${message?.content}")
    }

    override fun onNamesList(namesList: MutableCollection<String>?) {
        super.onNamesList(namesList)
        val message = StringBuilder("Users in Chat (${namesList?.count()}):")
        namesList?.forEach {
            message.append("$it, ")
        }
        logger.info(message.toString())
    }

    override fun onJoin(joinedNick: String?) {
        super.onJoin(joinedNick)
        joinedNick?.let {
            logger.info("$it joined.")
        }
    }

    override fun onPart(partedNick: String?) {
        super.onPart(partedNick)
        partedNick?.let {
            logger.info("$it left.")
        }
    }

    override fun onReconnect() {
        super.onReconnect()
        if (twirk.connect()) {
            logger.info("Reconnect Success!")
        } else {
            logger.error("Failed to reconnect to channel")
            twirk.close()
        }
    }
}
