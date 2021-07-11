# TwitchChatterSentinel

First, create a new Twitch Account for your bot.
To sign up for an account, go to https://www.twitch.tv and select the Sign up button on the top-right portion of the page.

Next, create an oauth token for your bot, the bot will use the as the password to log in, it will be different from the password you created for the account.
https://twitchapps.com/tmi/

Click 'Connect' and sign in with your bot account. 
Generate an OAuth token, and store it somewhere safe. Use it later when running the bot.


#. Build the jar

./gradlew shadowjar

#. Run the jar

java -jar build/libs/TwitchChatterSentinel-1.0-all.jar broadcastername botaccountname oauth:secret

Example:
java -jar build/libs/TwitchChatterSentinel-1.0-all.jar keith_numbers mytwitchchatbot oauth:21313sdad231asddasd21313
