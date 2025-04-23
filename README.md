# Estonian Weather Bot 🇪🇪

**Estonian Weather Bot** is a Telegram bot that provides up-to-date air temperature information in Estonia.

## 📦 Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/SergeiElesin/estonian_weather_bot.git
   cd estonian_weather_bot
   ```

2. Build the project using Gradle:

   ```bash
   ./gradlew build
   ```

3. Run the bot:

   ```bash
   java -jar build/libs/estonian_weather_bot.jar
   ```

## ⚙️ Configuration

Before starting, you need to configure the following parameters:

- **Telegram API Key**: Obtain it from [BotFather](https://t.me/BotFather) and add it to environment variables or a configuration file.
- **Weather Data Source**: Make sure the bot connects to a valid API to retrieve current air temperature in Estonia.

## 🧪 Usage

After launching the bot in Telegram:

- Send the name of a city, e.g., `Tallinn`
- The bot will reply with the current air temperature in the specified city.

## 🛠 Technologies

- Java
- Gradle
- Telegram Bot API
